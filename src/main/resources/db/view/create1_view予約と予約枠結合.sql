create view FrameUnionReservationView as
    select
        frame.id, frame.hospital_id, frame.target_date, frame.target_time, reserve.user_id
    from
        UserReservationFrame as reserve
    inner join
        ReservationFrames as frame
    on
        frame.id = reserve.datetime_id;
