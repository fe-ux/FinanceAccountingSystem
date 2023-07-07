CREATE TABLE account(
	id UUID NOT NULL UNIQUE,
	firstname varchar(32) NOT NULL,
	lastname varchar(32) NOT NULL,
	surname varchar(32) NOT NULL,
	mail varchar(255) NOT NULL,
	login varchar(32) NOT NULL,
	password varchar(32) NOT NULL
);
