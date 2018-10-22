create schema if not exists security_03;

CREATE TABLE users(
			user_id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
			user_name varchar(255) NOT NULL,
			pasword varchar(255) NOT NULL,
			enabled tinyint(1) NOT NULL
);

CREATE TABLE user_roles	(
			roles_id int(10) PRIMARY KEY NOT NULL AUTO_INCREMENT,
			user_id int(10) NOT NULL,
			authority varchar(45) NOT NULL,
			CONSTRAINT user_roles_users_user_id_fk FOREIGN KEY (user_id) REFERENCES users (user_id)
);

insert into users (user_id, user_name, pasword, enabled) values
  (1, 'admin', 'admin', TRUE),
  (2, 'user', 'user', TRUE);
COMMIT;

insert into user_roles (roles_id, user_id, authority) values
  (1, 1, 'ROLE_USER'),
  (2, 1, 'ROLE_ADMIN'),
  (3, 2, 'ROLE_USER');
COMMIT;