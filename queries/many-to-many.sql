create table subjects(
	id serial primary key,
	name varchar(255)
);

create table pupils(
	id serial primary key,
	name varchar(255)
);

create table grades(
	id serial primary key,
	symbol character(1),
	description varchar(255)
);

create table pupils_grades(
	id serial primary key,
	pupil int references pupils (id),
	subject int references subjects (id),
	grade int references grades (id) 
);

insert into subjects (name) values ('Maths'), ('Chemistry'), ('History');
insert into grades (symbol, description) values ('E', 'Excellent'), ('S', 'Satisfactory'), 
('N', 'Needs improvement'), ('U', 'Unsatisfactory');
insert into pupils (name) values ('Alex'), ('Chloe'), ('Emily'), ('John');
insert into pupils_grades (pupil, subject, grade) values (1, 1, 1), (1, 2, 1), (1, 3, 2),
(2, 1, 3), (2, 2, 2), (2, 3, 3),
(3, 1, 1), (3, 2, 1), (3, 3, 1),
(4, 1, 4), (4, 2, 3), (4, 3, 4);

select * from pupils_grades;