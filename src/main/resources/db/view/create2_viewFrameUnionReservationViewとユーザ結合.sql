create view AllReservationInfoView as
    select
        frameInfo.id, frameInfo.hospital_id, frameInfo.target_date, frameInfo.target_time,
        Users.id as user_id, Users.name, Users.gender, Users.birthday
    from
        FrameUnionReservationView as frameInfo
    inner join
        Users
    on
        frameInfo.user_id = Users.id;
