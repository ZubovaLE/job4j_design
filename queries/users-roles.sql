create table roles(
	id serial primary key,
	name varchar(255)
);

create table users(
	id serial primary key,
	name varchar(255),
	role int references roles(id)
);

create table rules(
	id serial primary key,
	name varchar(255)
);

create table roles_rules(
	id serial primary key,
	role int references roles(id),
	rule int references rules(id)
);
