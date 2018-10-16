create schema if not exists task_manager;

CREATE TABLE project(
			project_id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
			name varchar(255) NOT NULL
);

CREATE TABLE task(
			task_id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
			name varchar(255) NOT NULL,
			project_id int NOT NULL,
			CONSTRAINT task_project_project_id_fk FOREIGN KEY (project_id) REFERENCES project (project_id)
);

CREATE TABLE user(
			user_id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
			name varchar(255) NOT NULL,
			email varchar(255) NOT NULL
);

CREATE TABLE users_tasks(
			user_id int NOT NULL,
			task_id int NOT NULL,
			CONSTRAINT users_tasks_user_user_id_fk FOREIGN KEY (user_id) REFERENCES user (user_id),
			CONSTRAINT users_tasks_task_task_id_fk FOREIGN KEY (task_id) REFERENCES task (task_id)
);

INSERT INTO `project` (`PROJECT_ID`, `NAME`) VALUES
  (19,'Project One'),
  (20,'Project Two'),
  (21,'Project Three');
COMMIT;

INSERT INTO `task` (`TASK_ID`, `NAME`, `PROJECT_ID`) VALUES
  (8,'Task11',19),
  (9,'Task12',19),
  (10,'Task21',20),
  (11,'Task22',20),
  (12,'Task31',21),
  (13,'Task32',21);
COMMIT;

INSERT INTO `user` (`USER_ID`, `EMAIL`, `NAME`) VALUES
  (58,'alturner@gmail.com','Alex Turner'),
  (59,'jpiterson@gmail.com','Jordan Piterson'),
  (60,'jrogan@gmail.com','Joe Rogan');
COMMIT;

INSERT INTO `users_tasks` (`USER_ID`, `TASK_ID`) VALUES
  (60,9),
  (58,8),
  (59,8),
  (58,10),
  (60,10),
  (59,11),
  (60,11),
  (59,12),
  (60,12),
  (58,13),
  (59,13),
  (60,13);
COMMIT;