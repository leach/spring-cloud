--项目表
DROP TABLE profile;
create table profile(
   id   INTEGER PRIMARY KEY AUTOINCREMENT,
   project CHAR(50) NOT NULL,
   name CHAR(50) NOT NULL,
   remark  CHAR(50),
   UNIQUE (project, name)
);
--配置表
DROP TABLE properties;
create table properties(
   id   INTEGER PRIMARY KEY AUTOINCREMENT,
   profileId INT NOT NULL,
   key CHAR(200) NOT NULL,
   value  CHAR(200) NOT NULL,
   status INT NOT NULL,
   remark CHAR(200) NOT NULL,
   UNIQUE (profileId, key)
);

--测试数据
insert into profile(project, name, remark) values ('zi-config-server', 'dev', '测试项目dev');

insert into properties(profileId, "key", "value", status, remark) values (1, 'app', 'test', 10, '测试')