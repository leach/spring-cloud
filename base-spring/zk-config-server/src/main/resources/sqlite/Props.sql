--项目表
DROP TABLE profile;
create table profile(
   id   INTEGER PRIMARY KEY AUTOINCREMENT,
   project CHAR(50) NOT NULL,
   profile CHAR(50) NOT NULL,
   remark  CHAR(50),
   UNIQUE (project, profile)
);
--配置表
create table properties(
   id   INTEGER PRIMARY KEY AUTOINCREMENT,
   profileId INT NOT NULL,
   key CHAR(200) NOT NULL,
   value  CHAR(200) NOT NULL
);

--测试数据
insert into profile(project, profile, remark) values ('zi-config-server', 'dev', '测试项目dev');