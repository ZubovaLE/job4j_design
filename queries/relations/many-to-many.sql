create table books(
	id serial primary key,
	name varchar(255)
);

create table readers(
	id serial primary key,
	name varchar(255)
);

create table readers_books(
	id serial primary key,
	reader_id int references readers(id),
	book_id int references books(id)
);

insert into books (name) values ('Name 1'), ('Name 2'), ('Name 3'), ('Name 4'), ('Name 5');
insert into readers (name) values ('Alex'), ('Emily'), ('John'), ('Kate'), ('Peter');
insert into readers_books (reader_id, book_id) values (1, 2), (1, 4), (2, 1), (2, 3), (2, 5), 
(3, 2), (4, 2), (4, 5), (5, 1);

select * from readers_books;