create table items(
	id serial primary key,
	name varchar(255),
	user_id int references users(id),
	state int references states(id),
	category int references categories(id)
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

create table states(
	id serial primary key,
	name varchar(255)
);

create table categories(
	id serial primary key,
	name varchar(255)
);