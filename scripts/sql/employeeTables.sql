
-- dropping the table means to avoid the issue of " (table name) table already exists"
DROP TABLE IF EXISTS jrestaurant_waiters;
DROP TABLE IF EXISTS jrestaurant_busboys;
DROP TABLE IF EXISTS jrestaurant_cooks;
DROP TABLE IF EXISTS jrestaurant_hosts;
DROP TABLE IF EXISTS jrestaurant_managers;



-- here we create a table for each different employee role

-- managers
create table jrestaurant_managers(

    id INT AUTO_INCREMENT PRIMARY KEY,
    name varchar(50) NOT NULL,
    role varchar(50),
    manager_username varchar(50),
    manager_password varchar(50)
);



-- waiters 
create table jrestaurant_waiters(

-- 'auto increment' means that it will increase by +1 

    id INT AUTO_INCREMENT PRIMARY KEY,
    name varchar(100) NOT NULL,
    role varchar(50),
    waiter_username varchar(50),
    waiter_password varchar(50)
    
);



-- busboys
create table jrestaurant_busboys(

    id INT AUTO_INCREMENT PRIMARY KEY,
    name varchar(100) NOT NULL,
    role varchar(50),
    busboy_username varchar(50),
    busboy_password varchar(50)
);


-- cooks
create table jrestaurant_cooks(

    id INT AUTO_INCREMENT PRIMARY KEY,
    name varchar(100) NOT NULL,
    role varchar(50),
    cook_username varchar(50),
    cook_password varchar(50)
);



-- hosts
create table jrestaurant_hosts(

    id INT AUTO_INCREMENT PRIMARY KEY,
    name varchar(100) NOT NULL,
    role varchar(50),
    host_username varchar(50),
    host_password varchar(50)
);



-- here we insert values for each employee

-- managers
insert into jrestaurant_managers(name, role, manager_username, manager_password)
values ('Jeff', 'manager', 'm1user', 'm1password');



-- waiters
insert into jrestaurant_waiters(name, role, waiter_username, waiter_password)
values ('Sarah', 'waiter', 'w1user', 'w1password'),
       ('Josh', 'waiter', 'w2user', 'w2password'),
       ('Mike', 'waiter', 'w3user', 'w3password');



-- busboys
insert into jrestaurant_busboys(name, role, busboy_username, busboy_password)
values ('Cameron', 'busboy', 'b1user', 'b1password');




-- cooks
insert into jrestaurant_cooks (name, role, cook_username, cook_password)
values ('Lily', 'cook', 'cuser1', 'c1password'),
    ('Charlotte', 'cook', 'c2user', 'c2password');



-- hosts
insert into jrestaurant_hosts(name, role, host_username, host_password)
values ('Dean', 'host', 'huser1', 'h1password');






-- here we combine the data from ALL the employee tables
-- 'union all' means to combine 


select * 
from jrestaurant_managers
UNION ALL

select * 
from jrestaurant_waiters
UNION ALL

select * 
from jrestaurant_busboys
UNION ALL


select * 
from jrestaurant_cooks
UNION ALL


select *
from jrestaurant_hosts;


