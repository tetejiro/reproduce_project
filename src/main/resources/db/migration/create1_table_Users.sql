use product;
create table Users(
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name varchar(20) NOT NULL,
    gender enum("man", "woman") NOT NULL,
    birthday date NOT NULL
);