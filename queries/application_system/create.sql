create table roles(
	id serial primary key,
	name varchar(255)
);

create table users(
	id serial primary key,
	name varchar(255),
	role_id int references roles(id)
);

create table rules(
	id serial primary key,
	name varchar(255)
);

create table roles_rules(
	id serial primary key,
	role_id int references roles(id),
	rule_id int references rules(id)
);

create table states(
	id serial primary key,
	name varchar(255)
);

create table categories(
	id serial primary key,
	name varchar(255)
);

create table items(
	id serial primary key,
	name varchar(255),
	state_id int references states(id),
	category_id int references categories(id),
	user_id int references users(id)
);

create table comments(
	id serial primary key,
	name varchar(255),
	item_id int references items(id)
);

create table attachs(
	id serial primary key,
	name varchar(255),
	item_id int references items(id)
);