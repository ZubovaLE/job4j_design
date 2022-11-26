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

INSERT INTO bodies (name) VALUES ('Body 1'), ('Body 2'), ('Body 3'), ('Body 4');

INSERT INTO engines (name) VALUES ('Engines 1'), ('Engines 2'), ('Engines 3');

INSERT INTO transmissions (name) VALUES ('Transmission 1'), ('Transmission 2'), 
('Transmission 3'), ('Transmission 4');

INSERT INTO cars (name, body_id, engine_id, transmission_id) VALUES ('Car 1', 1, 1, 1),
('Car 2', 2, 2, 2), ('Car 3', 3, 3, 3), ('Car 4', 4, null, 4), ('Car 5', null, null, null);

INSERT INTO bodies(name) VALUES('Modern body 1'), ('Modern body 2');
INSERT INTO transmissions(name) VALUES('Modern transmission');
INSERT INTO engines(name) VALUES('Modern engine');

SELECT c.name AS car, b.name AS body,  e.name as engine, t.name AS transmission
FROM cars c
LEFT JOIN bodies b ON b.id = c.body_id
LEFT JOIN engines e ON e.id = c.engine_id
LEFT JOIN transmissions t ON t.id = c.transmission_id;

SELECT b.name AS body
FROM bodies b
LEFT JOIN cars c ON b.id = c.body_id
WHERE c.body_id IS NULL;

SELECT e.name AS engine
FROM engines e
LEFT JOIN cars c ON e.id = c.engine_id
WHERE c.engine_id IS NULL;

SELECT t.name AS engine
FROM transmissions t
LEFT JOIN cars c ON t.id = c.transmission_id
WHERE c.transmission_id IS NULL;