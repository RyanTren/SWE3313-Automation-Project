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

insert into User value (1, 'Manager', '1883-01-01', 'Manager');
insert into User value (2, 'WaiterOne', '1883-01-01', 'WaiterOne');
insert into User value (2, 'WaiterTwo', '1883-01-01', 'WaiterTwo');
insert into User value (2, 'WaiterThree', '1883-01-01', 'WaiterThree');


