create view reserveInfo as
select
    id, name, gender, birthday, UserReservations.type, UserReservations.datetime_id
from
    Users
inner Join
    UserReservations
on
    Users.id = UserReservations.user_id;