CREATE TABLE users(
	id UUID PRIMARY KEY,
	firstname varchar(50) NOT NULL,
	lastname varchar(50) NOT NULL,
	surname varchar(50) NOT NULL,
	email varchar(50) NOT NULL,
	username varchar(20) NOT NULL,
	password varchar(150) NOT NULL
);
CREATE TABLE admins(
id UUID REFERENCES users (id)
);
