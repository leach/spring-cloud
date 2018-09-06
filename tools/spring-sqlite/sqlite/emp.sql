PRAGMA foreign_keys=OFF;
BEGIN TRANSACTION;
CREATE TABLE employee(
id bigint primary key,
name text not null,
salary real,
remark text);
INSERT INTO employee VALUES(1,'test',200.0,NULL);
COMMIT;
