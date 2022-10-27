create table diplomas(
	id serial primary key,
	theme varchar(255)
);

create table authors(
	id serial primary key,
	name varchar(255)
);

create table diplomas_authors(
	id serial primary key,
	author int references authors(id) unique,
	dimploma int references diplomas(id) unique
);

insert into diplomas(theme) values ('Theme 1'), ('Theme 2'), ('Theme 3'), ('Theme 4'), ('Theme 5');
insert into authors(name) values ('Alex'), ('Ben'), ('Chloe'), ('John'), ('Kate');
insert into diplomas_authors(author, dimploma) values (1, 3), (2, 1), (3, 5), (4, 2), (5, 4);

select * from diplomas_authors;