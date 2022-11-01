create table fauna (
	id serial primary key,
    name text,
    avg_age int,
    discovery_date date
);

insert into fauna (name, avg_age, discovery_date) values ('fish one', 30, '10.09.1985'), 
('bird one', 50, '15.03.1974'), ('animal one', 40, '03.04.1945'), ('fish two', 12, '04.08.1954'),
('bird two', 34, '23.09.1923'), ('animal two', 27, '17.02.1984'), ('fish three', 5, '23.03.1983'),
('bird three', 13, '14.06.1994'), ('animal three', 10, '21.06.1933');

select * from fauna where name like '%fish%'
