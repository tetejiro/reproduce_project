use product;
create table UserReservationFrame (
    user_id int NOT NULL,
    datetime_id int NOT NULL,
    type enum("200", "400"),
    created_date TIMESTAMP NOT NULL default CURRENT_TIMESTAMP,
    PRIMARY KEY (user_id, datetime_id),
    FOREIGN KEY (user_id) REFERENCES Users(id),
    FOREIGN KEY (datetime_id) REFERENCES ReservationFrames(id)
);