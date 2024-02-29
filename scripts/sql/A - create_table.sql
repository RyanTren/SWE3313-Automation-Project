# This is an example - update with correct definition when that's defined
DROP TABLE IF EXISTS User;
CREATE TABLE IF NOT EXISTS User (
    id       INT AUTO_INCREMENT PRIMARY KEY,
    name     VARCHAR(500) CHARACTER SET utf8mb3 NOT NULL,
    dob      DATE,
    password VARCHAR(100) CHARACTER SET utf8mb3 NOT NULL
);

INSERT INTO User VALUES (1, 'Manager', '1883-01-01', 'Manager');
INSERT INTO User VALUES (2, 'WaiterOne', '1883-01-01', 'WaiterOne');
INSERT INTO User VALUES (3, 'WaiterTwo', '1883-01-01', 'WaiterTwo');
INSERT INTO User VALUES (4, 'WaiterThree', '1883-01-01', 'WaiterThree');


