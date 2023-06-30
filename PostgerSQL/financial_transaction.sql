CREATE TABLE financial_transaction(
	id bigint NOT NULL UNIQUE CHECK (id > 0),
	account UUID NOT NULL,
	date timestamptz NOT NULL,
	type boolean NOT NULL,
	sum numeric NOT NULL CHECK (id > 0),
	description varchar(100)
);
