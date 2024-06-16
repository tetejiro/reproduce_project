create view AllReserveInfo as
select
    datetime_id,
    reserveInfo.id as user_id,
    name,
    gender,
    birthday,
    HospitalDateSchedules.hospital_id,
    HospitalDateSchedules.target_date,
    HospitalDateSchedules.target_time,
from
    reserveInfo
inner join
    HospitalDateSchedules
on
    reserveInfo.datetime_id = HospitalDateSchedules.id;

--mysql> select * from allReserveInfo where target_date = "2024-6-14";
--+-------------+---------+-----------+--------+------------+-------------+-------------+-------------+----------+
--| datetime_id | user_id | name      | gender | birthday   | hospital_id | target_date | target_time | capacity |
--+-------------+---------+-----------+--------+------------+-------------+-------------+-------------+----------+
--|           9 |       1 | 東 由樹   | woman  | 1995-12-05 |           3 | 2024-06-14  | 11:30:00    |       30 |
--|           9 |       2 | 加藤 大樹 | man    | 1996-09-01 |           3 | 2024-06-14  | 11:30:00    |       30 |
--|           9 |       3 | 清水明美  | woman  | 1994-11-03 |           3 | 2024-06-14  | 11:30:00    |       30 |
--|           9 |       4 | 佐藤 太   | man    | 1995-05-05 |           3 | 2024-06-14  | 11:30:00    |       30 |
--|          11 |       1 | 東 由樹   | woman  | 1995-12-05 |           4 | 2024-06-14  | 10:30:00    |       15 |
--|          11 |       2 | 加藤 大樹 | man    | 1996-09-01 |           4 | 2024-06-14  | 10:30:00    |       15 |
--+-------------+---------+-----------+--------+------------+-------------+-------------+-------------+----------+