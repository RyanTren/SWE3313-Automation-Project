# This is an example - update with correct definition when that's defined
DROP TABLE if exists User;
create table if not exists User
(
    id       int auto_increment
        primary key,
    name     varchar(500) charset utf8mb3 not null,
    dob      date,
    password varchar(100) charset utf8mb3 not null
);

insert into User value (1000, 'John Doe', '1883-01-01', 'super-secrete');
