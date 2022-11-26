CREATE TABLE departments(
	id SERIAL PRIMARY KEY,
	name VARCHAR(255)
);

CREATE TABLE employees(
	id SERIAL PRIMARY KEY,
	name VARCHAR(255),
	department_id INTEGER REFERENCES departments(id)
);

INSERT INTO departments(name) VALUES ('Department 1'), ('Department 2'), ('Department 3'), ('Department 4');

INSERT INTO employees(name, department_id) VALUES('Employee 1', 1), ('Employee 2', 2), ('Employee 3', 3),
('Employee 4', 1), ('Employee 5', 2), ('Employee 6', NULL);

SELECT * FROM employees e LEFT JOIN departments d on e.department_id = d.id;
SELECT * FROM employees e RIGHT JOIN departments d on e.department_id = d.id;
SELECT * FROM employees e FULL JOIN departments d on e.department_id = d.id;
SELECT * FROM employees CROSS JOIN departments ;

SELECT * FROM departments d LEFT JOIN employees e on e.department_id = d.id WHERE e.id IS NULL;

SELECT * FROM employees e LEFT JOIN departments d on e.department_id = d.id WHERE d.id IS NOT NULL;
SELECT * FROM employees e RIGHT JOIN departments d on e.department_id = d.id WHERE e.id IS NOT NULL;