-- dropping the table means to avoid the issue of " (table name) table already exists"
DROP TABLE IF EXISTS jrestaurant_employees;


create table jrestaurant_employees
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    name        varchar(100) NOT NULL,
    role        varchar(100) NOT NULL,
    username    varchar(100) NOT NULL,
    password    varchar(100) NOT NULL,
    hoursWorked float
);

-- here we insert values for each employee
-- managers
insert into jrestaurant_employees(name, role, username, password, hoursWorked)
values ('Jeff', 'manager', 'm1user', 'm1password', 40);

-- waiters
insert into jrestaurant_employees(name, role, username, password, hoursWorked)
values ('Sarah', 'waiter', 'w1user', 'w1password', 8.25),
       ('Josh', 'waiter', 'w2user', 'w2password', 8),
       ('Mike', 'waiter', 'w3user', 'w3password', 11);

-- busboys
insert into jrestaurant_employees(name, role, username, password, hoursWorked)
values ('Cameron', 'busboy', 'b1user', 'b1password', 6.5);

-- cooks
insert into jrestaurant_employees (name, role, username, password, hoursWorked)
values ('Lily', 'cook', 'c1user', 'c1password', 7),
       ('Charlotte', 'cook', 'c2user', 'c2password', 10);


-- hosts
insert into jrestaurant_employees(name, role, username, password, hoursWorked)
values ('Dean', 'host', 'h1user', 'h1password', 4);
