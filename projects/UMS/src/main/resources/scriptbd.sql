create schema if not exists UMS;

CREATE TABLE users(
			user_id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
			user_first_name varchar(255) NOT NULL,
			user_last_name varchar(255) NOT NULL,
			user_name varchar(255) NOT NULL,
			--TODO: pswd should be stored in unreadable format
			pasword varchar(255) NOT NULL,
			email varchar(255) NOT NULL,
			birthday date NOT NULL,
			--TODO: default null
			is_active tinyint(1) default null,
			created_stamp timestamp(8) NOT NULL,
			last_updated_stamp timestamp(8)NOT NULL,
			adress varchar(255) NOT NULL
);

CREATE TABLE user_roles	(
			roles_id int(10) PRIMARY KEY NOT NULL AUTO_INCREMENT,
			user_id int(10) NOT NULL,
			authority varchar(45) NOT NULL,
			CONSTRAINT user_roles_users_user_id_fk FOREIGN KEY (user_id) REFERENCES users (user_id)
);

insert into users (user_id, user_name, pasword, enabled) values
  ('Alex', 'Turner', 'badassMFK', 'lololo', 'alexturner@mail.com', '1986-01-06', TRUE , current_timestamp , current_timestamp , 'Sheffield, arctic st., 21, 8'),
  ('Math', 'Halders', 'nucaDrummer', 'kekk', 'halders@gmail.com', '1986-05-07', TRUE , '2016-05-12 16:55:15' , current_timestamp , 'Sheffield, monkeys st., 45, 8'),
  ('Jordan', 'Peterson', 'beard', '1233d3', 'jordanbpeteson@mail.com', '1962-06-12', TRUE , '2017-02-23 12:43:14' , current_timestamp , 'Boston, judas st., 34, 9'),
  ('Joe', 'Rogan', 'jreexp', 'qwer12', 'jre@mail.com', '1967-08-11', TRUE , '2018-04-27 12:43:14' , current_timestamp , 'NY, fight st., 13, 8');
COMMIT;

insert into user_roles (roles_id, user_id, authority) values
  (1, 'ROLE_USER'),
  (1, 'ROLE_ADMIN'),
  (2, 'ROLE_USER'),
  (3, 'ROLE_ADMIN'),
  (2, 'ROLE_USER');
COMMIT;