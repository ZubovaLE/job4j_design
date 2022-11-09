create table members(
	id serial primary key,
	name varchar,
	age integer,
	isMarried boolean,
	address text
);
insert into members(name, age, isMarried, address) values ('Alex', 30, FALSE, '5 Big street');
insert into members(name, age, isMarried, address) values ('Emily', 28, FALSE, '17 Brooklyn street');
insert into members(name, age, isMarried, address) values ('Sam', 24, FALSE, '2 Great street');
update members set isMarried = TRUE;
select * from members;