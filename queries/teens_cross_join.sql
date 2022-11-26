CREATE TABLE teens(
	id SERIAL PRIMARY KEY,
	name VARCHAR(255),
	gender BOOLEAN
);

INSERT INTO teens(name, gender) VALUES('Teen 1', TRUE), ('Teen 2', FALSE), ('Teen 3', TRUE),
('Teen 4', FALSE), ('Teen 5', TRUE);

SELECT t1.name AS t1, t2.name AS t2 FROM teens t1 CROSS JOIN teens t2 WHERE t1.gender != t2.gender;