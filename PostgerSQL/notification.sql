CREATE TABLE notification(
	id UUID NOT NULL UNIQUE,
	status boolean NOT NULL,
	mail varchar(255) NOT NULL
);
