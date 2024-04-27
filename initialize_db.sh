#!/usr/bin/env bash

# Shell script to specify order DB tables should
# be created in. Especially import for FK relationships
DB_SCRIPTS="/docker-entrypoint-initdb.d/db_scripts"
mysqlsh --password="$MYSQL_ROOT_PASSWORD" -u "$MYSQL_ROOT_USER" --database jsrestaurant -f "$DB_SCRIPTS/employees.sql"
mysqlsh --password="$MYSQL_ROOT_PASSWORD" -u "$MYSQL_ROOT_USER" --database jsrestaurant -f "$DB_SCRIPTS/orders.sql"
mysqlsh --password="$MYSQL_ROOT_PASSWORD" -u "$MYSQL_ROOT_USER" --database jsrestaurant -f "$DB_SCRIPTS/transactions.sql"
mysqlsh --password="$MYSQL_ROOT_PASSWORD" -u "$MYSQL_ROOT_USER" --database jsrestaurant -f "$DB_SCRIPTS/tables.sql"
