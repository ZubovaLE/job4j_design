create table position(
    id serial primary key,
    name varchar(255)
);
create table employees(
    id serial primary key,
    name varchar(255),
    position_id int references position(id)
);
insert into position(name) values ('programmer'), ('project manager'), ('director');
insert into employees(name, position_id) values('Boris', 1), ('Ivan', 1), ('Kiril', 1), ('Marina', 2), 
('Pers', 3);
insert into employees(name) values ('Alexander');

select * from employees 
join position p 
on employees.position_id = p.id;