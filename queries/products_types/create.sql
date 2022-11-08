CREATE TABLE types (
	id SERIAL PRIMARY KEY,
	name VARCHAR(255)
);

CREATE TABLE products (
	id SERIAL PRIMARY KEY,
	name VARCHAR(255),
	expired_date TIMESTAMP,
	price FLOAT,
	type_id INTEGER REFERENCES  types
);