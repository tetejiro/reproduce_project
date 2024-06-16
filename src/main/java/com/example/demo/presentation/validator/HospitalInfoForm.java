package com.example.demo.presentation.validator;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDate;

@Getter
@Setter
public class HospitalInfoForm {
    @NotNull
    @Range(min = 1, max = 50)
    public int hospital_id;

    public LocalDate date;

    public LocalDate setDateTodayIfNull() {
        if (this.date == null) {
            this.date = LocalDate.now();
        }
        return date;
    }
}
