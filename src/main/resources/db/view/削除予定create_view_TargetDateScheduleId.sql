create view targetDateScheduleID as
    select
        hospital.id
    from
        UserReservations as reserve
    inner join
        HospitalDateSchedules as hospital
    on
        hospital.id = reserve.datetime_id
    where
        hospital.target_date = CURRENT_DATE()
    GROUP BY
        hospital.id;