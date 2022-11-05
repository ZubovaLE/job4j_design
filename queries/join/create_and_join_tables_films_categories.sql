create table categories(
  id serial primary key,
  name varchar(255)
);

create table films(
	id serial primary key,
	name varchar(255),
	author text,
	release_date timestamp,
	for_adults boolean,
	category_id int references categories
);

insert into categories (name) values ('Adventure'), ('Cartoon'), ('Comedy'), ('Drama'), ('Fantasy'), ('Horror'), 
('Science fiction'), ('Sport');

insert into films (name, author, release_date, for_adults, category_id) values ('Film 1', 'Author 1', date '01.10.2004', true, 6),
('Film 2', 'Author 2', date '01.02.1997', false, 2),
('Film 3', 'Author 3', date '10.07.2023', true, 5),
('Film 4', 'Author 4', date '15.05.2007', true, 4),
('Film 5', 'Author 5', date '13.04.2004', false, 1),
('Film 6', 'Author 6', date '01.10.2004', true, 4),
('Film 7', 'Author 7', date '12.03.2007', true, 3),
('Film 8', 'Author 8', date '05.01.1993', false, 7),
('Film 9', 'Author 9', date '23.09.2017', false, 8);
insert into films (name, author, category_id) values ('Film 10', 'Author 10', 5),
('Film 11', 'Author 11', 4);

select f.name as Фильм, f.release_date as Дата_выхода, f.for_adults as Для_взрослых, c.name as Категория
from films as f
join categories as c
on f.category_id = c.id;