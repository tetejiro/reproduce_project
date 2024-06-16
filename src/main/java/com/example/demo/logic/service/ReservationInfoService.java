package com.example.demo.logic.service;

import ch.qos.logback.classic.Logger;
import com.example.demo.logic.entity.AllReservationInfoEntity;
import com.example.demo.presentation.controller.HomeController;
import com.example.demo.repository.ReservationInfoRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class ReservationInfoService {

    private static final Logger log = (Logger) LoggerFactory.getLogger(HomeController.class);
    private final ReservationInfoRepository repository;

    @Transactional
    public String getHospitalName(int id) {
        return repository.getHospitalName(id);
    }

    @Transactional
    public List<LocalTime> getSortedDistinctTargetTime(LocalDate date) {
        return repository.getSortedDistinctTargetTime(date);
    }

    @Transactional
    public Map<LocalTime, List<AllReservationInfoEntity>> getReserveInfo(LocalDate date) {
        Map<LocalTime, List<AllReservationInfoEntity>> allInfoMap = new LinkedHashMap<>();

        List<LocalTime> sortedDistinctTargetTime = getSortedDistinctTargetTime(date);

        for (LocalTime frameTime : sortedDistinctTargetTime) {
            allInfoMap.put(frameTime, repository.getReserveInfo(frameTime));
        }

        return allInfoMap;
    }

    public List<LocalTime> getTimeList(Map<LocalTime, List<AllReservationInfoEntity>> reserveInfo) {
        List<LocalTime> keyList = new ArrayList<>();
        for (LocalTime time : reserveInfo.keySet()) {
            keyList.add(time);
        }
        return keyList;
    }
}
