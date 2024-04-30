DROP TABLE IF EXISTS jrestaurant_orders;

create table jrestaurant_orders
(
    id             int AUTO_INCREMENT PRIMARY KEY,
    items          json not null,
    transaction_id int,
    FOREIGN KEY
        (transaction_id) REFERENCES jrestaurant_transactions
        (transaction_id)
);
