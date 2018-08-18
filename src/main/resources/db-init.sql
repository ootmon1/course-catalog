DROP DATABASE IF EXISTS course_api;

CREATE DATABASE course_api;

USE course_api;

CREATE TABLE topics (
	id BIGINT(20) NOT NULL AUTO_INCREMENT,
	name VARCHAR(25) DEFAULT NULL,
	description VARCHAR(100) DEFAULT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE courses (
	id BIGINT(20) NOT NULL AUTO_INCREMENT,
	name VARCHAR(25) DEFAULT NULL,
	description VARCHAR(100) DEFAULT NULL,
	topic_id BIGINT(20) NOT NULL,
	PRIMARY KEY (id),
	KEY (topic_id),
	CONSTRAINT FOREIGN KEY (topic_id) REFERENCES topics (id)
);

CREATE TABLE roles (
	id BIGINT(20) NOT NULL AUTO_INCREMENT,
	name VARCHAR(60) DEFAULT NULL,
	PRIMARY KEY (id),
	UNIQUE KEY (name)
);

CREATE TABLE users (
	id BIGINT(20) NOT NULL AUTO_INCREMENT,
	username VARCHAR(25) DEFAULT NULL,
	password VARCHAR(100) DEFAULT NULL,
	PRIMARY KEY (id),
	UNIQUE KEY (username)
);

CREATE TABLE user_roles (
	user_id BIGINT(20) NOT NULL,
	role_id BIGINT(20) NOT NULL,
	PRIMARY KEY (user_id, role_id),
	KEY (role_id),
	CONSTRAINT FOREIGN KEY (role_id) REFERENCES roles (id),
	CONTRAINT FOREIGN KEY (user_id) REFERENCES users (id)
);

INSERT INTO topics (name, description) VALUES
('English', 'English Description');
	
SELECT @last := LAST_INSERT_ID();
	
INSERT INTO courses (name, description, topic_id) VALUES
('Literature', 'Literature Description', @last),
('Writing', 'Writing Description', @last);

INSERT INTO topics (name, description) VALUES
('History', 'History Description');
	
SELECT @last := LAST_INSERT_ID();
	
INSERT INTO courses (name, description, topic_id) VALUES
('Revolution', 'Revolution Description', @last),
('Civil', 'Civil Description', @last);

INSERT INTO topics (name, description) VALUES
('Math', 'Math Description');
	
SELECT @last := LAST_INSERT_ID();
	
INSERT INTO courses (name, description, topic_id) VALUES
('Algebra', 'Algebra Description', @last),
('Geometry', 'Geometry Description', @last);

INSERT INTO topics (name, description) VALUES
('Science', 'Science Description');
	
SELECT @last := LAST_INSERT_ID();
	
INSERT INTO courses (name, description, topic_id) VALUES
('Physics', 'Physics Description', @last),
('Biology', 'Biology Description', @last);








































CREATE TABLE topics(
  id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(25) NOT NULL,
  description VARCHAR(100) NOT NULL
);

CREATE TABLE courses(
  id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(25) NOT NULL,
  description VARCHAR(100) NOT NULL,
  topic_id BIGINT DEFAULT NULL
);

CREATE TABLE users(
	id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	username VARCHAR(25) DEFAULT NULL UNIQUE KEY,
	password VARCHAR(100) DEFAULT NULL
);

CREATE TABLE roles(
	id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(60) DEFAULT NULL UNIQUE KEY	
);

CREATE TABLE user_roles(
	
);

INSERT INTO topics VALUES
	(NULL, 'English', 'English Description'),
	(NULL, 'History', 'History Description'),
	(NULL, 'Math', 'Math Description'),
	(NULL, 'Science', 'Science Description');

INSERT INTO courses VALUES
	(NULL, 'Writing', 'Writing Description', 1),
	(NULL, 'Reading', 'Reading Description', 1),
	(NULL, 'Revolution', 'Revolution Description', 2),
	(NULL, 'Civil War', 'Civil War Description', 2),
	(NULL, 'Algebra', 'Algebra Description', 3),
	(NULL, 'Calculus', 'Calculus Description', 3),
	(NULL, 'Chemistry', 'Chemistry Description', 4),
	(NULL, 'Physics', 'Physics Description', 4);
	
INSERT INTO roles VALUES
	(NULL, 'ROLE_USER'),
	(NULL, 'ROLE_ADMIN');
	
INSERT INTO users VALUES
	(NULL, 'user', 'password'),
	(NULL, 'admin', 'password')
	