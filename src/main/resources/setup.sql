CREATE DATABASE IF NOT EXISTS wenancechallenge;

-- create the users for each database
CREATE USER 'root'@'%' IDENTIFIED BY 'pass';
GRANT CREATE, ALTER, INDEX, LOCK TABLES, REFERENCES, UPDATE, DELETE, DROP, SELECT, INSERT ON 'wenancechallenge'.* TO 'root'@'%';

FLUSH PRIVILEGES;