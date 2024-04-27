DROP TABLE IF EXISTS jrestaurant_transactions;
-- creating the table
create table jrestaurant_transactions
(
    transaction_id      int
        auto_increment PRIMARY KEY,
    date_of_transaction date,
    transaction_amount  decimal(10, 2),
    employee_id         int,
    table_number        int,
    FOREIGN KEY
        (employee_id) REFERENCES jrestaurant_employees
        (id)
);


-- inserting some data into the table
insert into jrestaurant_transactions
    (date_of_transaction, transaction_amount, employee_id, table_number)
values ('2024-04-01', 252.70, 3, 5),
       ('2024-04-02', 75.50, 2, 7);
