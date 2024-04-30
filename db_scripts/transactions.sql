DROP TABLE IF EXISTS jrestaurant_transactions;
-- creating the table
create table jrestaurant_transactions
(
    transaction_id      int
        auto_increment PRIMARY KEY,
    date_of_transaction datetime default current_timestamp,
    transaction_amount  decimal(10, 2) not null,
    employee_id         int            not null,
    table_number        int            not null,
    FOREIGN KEY (employee_id) REFERENCES jrestaurant_employees (id),
    FOREIGN KEY (table_number) REFERENCES jsrestaurant.jrestaurant_tables (id)
);


-- inserting some data into the table
insert into jrestaurant_transactions
    (transaction_amount, employee_id, table_number)
values (252.70, 3, 5),
       (75.50, 2, 7);
