create database clone_db CHARACTER SET utf8 COLLATE utf8_general_ci;

USE clone_db;

create table categories(
  id INT(11) NOT NULL AUTO_INCREMENT,
  name varchar(255) not null,
  primary key (id)
);

create table posts(
  id INT(11) NOT NULL AUTO_INCREMENT,
  title TEXT NOT NULL,
  summary TEXT NOT NULL,
  body TEXT NOT NULL,
  categoryid int not null,
  primary key (id)
);

alter table posts add constraint CONSTR_POST_CATEGORY foreign key (categoryid) references categories(id);

