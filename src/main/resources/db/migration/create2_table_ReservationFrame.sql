use product;
create table ReservationFrames(
    id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    hospital_id int NOT NULL,
    target_date date NOT NULL,
    target_time time NOT NULL,
    FOREIGN KEY (hospital_id) REFERENCES Hospitals(id)
);