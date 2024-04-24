
-- creating the table
create table transactions (
    transaction_id int auto_increment PRIMARY KEY,
    date_of_transaction date,
    transaction_amount decimal(10, 2),
    employee_id int,
    table_number int,
    FOREIGN KEY (employee_id) REFERENCES employee(employee_id)
);


-- inserting some data into the table
insert into transactions (date_of_transaction, transaction_amount, employee_id, table_number)
values
    ('2024-04-01', 252.70, 3, 5),
    ('2024-04-02', 75.50, 2, 7);

