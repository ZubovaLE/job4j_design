create table passport(
	id serial primary key,
	seria int,
	number int
);

create table people(
	id serial primary key,
	name varchar(255),
	passport_id int references passport(id) unique
);

create table passport_people(
    id serial primary key,
    passport_id int references passport(id) unique,
    people_id int references people(id) unique
);

insert into passport(seria, number) values (1, 123);
insert into passport(seria, number) values (2, 321);
insert into passport(seria, number) values (1, 432);

insert into people(name, passport_id) values ('Ivan', 3);
insert into people(name, passport_id) values ('Ben', 2);
insert into people(name, passport_id) values ('Alex', 1);

insert into passport_people(passport_id, people_id) values (1, 3);
insert into passport_people(passport_id, people_id) values (2, 2);
insert into passport_people(passport_id, people_id) values (3, 1);

select * from passport_people;
select * from passport where id in(select id from passport_people);