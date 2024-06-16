package com.example.demo.presentation.controller;

import ch.qos.logback.classic.Logger;
import com.example.demo.logic.entity.AllReservationInfoEntity;
import com.example.demo.logic.service.ReservationInfoService;
import com.example.demo.presentation.validator.HospitalInfoForm;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ReservationInfoService service;
    private static final Logger log = (Logger) LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/")
    // ModelAttribute は名前を変えても型の lowerCamel にしなければならない。
    // ModelAttribute の対象のHospitalInfoForm は Getter, Setter 相当のメソッドがないとエラーになる。
    public String showIndex(@ModelAttribute HospitalInfoForm form) {
        return "index";
    }

    @PostMapping("/calendar")
    // TODO: getでのやり取りに書き換える。
    // https://qiita.com/shohe05/items/e18df97e821d207e642d
    // https://qiita.com/d-yosh/items/3d4abd6b8ecab0c3f808　第一候補。出来そうな気がする。
    public String showCalendar(@Validated HospitalInfoForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            // form の情報の中にエラーの内容が入っているからここで引数に form を引数に入れなければならない ?
            return showIndex(form);
        }

        form.setDateTodayIfNull();
        model.addAttribute("targetDate", form.date);
        model.addAttribute("hospitalName", service.getHospitalName(form.hospital_id));

        Map<LocalTime, List<AllReservationInfoEntity>> reserveInfos = service.getReserveInfo(form.date);
        model.addAttribute("reserveInfos", reserveInfos);
        model.addAttribute("timeList", service.getTimeList(reserveInfos));

        // ここリダイレクトしようとしてエラー吐いてた。POST しかハンドラーがないからだった。
        return "calendar";
    }
}
