use product;
create table Hospitals (
    id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name varchar(20) NOT NULL,
    is_active boolean default true
);