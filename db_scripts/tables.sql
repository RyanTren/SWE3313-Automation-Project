DROP TABLE IF EXISTS jrestaurant_tables;

create table jrestaurant_tables
(
    id     int AUTO_INCREMENT PRIMARY KEY,
    status nvarchar(25) not null,
    clean  boolean      not null
);

DROP PROCEDURE IF EXISTS create_tables_while;

DELIMITER //
CREATE PROCEDURE create_tables_while()
BEGIN
    DECLARE i INT DEFAULT 0;
    WHILE i < 30
        DO
            INSERT INTO `jrestaurant_tables` (status, clean) values ('available', true);
            SET i = i + 1;
        END WHILE;
END;
//

CALL create_tables_while();
