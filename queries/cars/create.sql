CREATE TABLE bodies(
	id SERIAL PRIMARY KEY,
	name VARCHAR(255)
);

CREATE TABLE engines(
	id SERIAL PRIMARY KEY,
	name VARCHAR(255)
);

CREATE TABLE transmissions(
	id SERIAL PRIMARY KEY,
	name VARCHAR(255)
);

CREATE TABLE cars(
	id SERIAL PRIMARY KEY,
	name VARCHAR(255),
	body_id INTEGER REFERENCES bodies(id),
	engine_id INTEGER REFERENCES engines(id),
	transmission_id INTEGER REFERENCES transmissions(id)
);