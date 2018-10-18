DROP DATABASE IF EXISTS user_table;
CREATE DATABASE user_table;


CREATE TABLE user_table(
			userId int PRIMARY KEY NOT NULL AUTO_INCREMENT,
			email varchar(255) NOT NULL,
			password varchar(255) NOT NULL,
			login varchar(255) NOT NULL
);

INSERT INTO user_table (userId, email, password, login) VALUES
  (1, 'alturner@am.com','505','Alex'),
  (2, 'jordanpitersen@mail.com','78322','JordanP'),
  (3, 'talabot@hdisc.com','finnn','JohnTalabot');

COMMIT;