CREATE TABLE users(
	id UUID PRIMARY KEY,
	firstname varchar(50) NOT NULL,
	lastname varchar(50) NOT NULL,
	surname varchar(50) NOT NULL,
	email varchar(50) NOT NULL,
	username varchar(20) NOT NULL,
	password varchar(150) NOT NULL
);
CREATE TABLE roles(
id int PRIMARY KEY,
name varchar(20) NOT NULL UNIQUE
);
CREATE TABLE user_roles(
user_id UUID REFERENCES users (id),
role_id int REFERENCES roles (id)
);
INSERT INTO roles(id, name) VALUES(0, 'ROLE_USER');
INSERT INTO roles(id, name) VALUES(1, 'ROLE_MODERATOR');
INSERT INTO roles(id, name) VALUES(2, 'ROLE_ADMIN');
