CREATE TABLE departments(
	id SERIAL PRIMARY KEY,
	name VARCHAR(255)
);

CREATE TABLE employees(
	id SERIAL PRIMARY KEY,
	name VARCHAR(255),
	department_id INTEGER REFERENCES departments(id)
);