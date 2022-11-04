create table food_categories(
	id serial primary key,
	name varchar(255)
);

create table food(
	id serial primary key,
	name varchar(255),
	category int references food_categories(id)
);

insert into food_categories(name) values('Vegetables'), ('Fruits'), ('Grains, legumes, nuts and seeds'), 
('Meat and poultry'), ('Fish and seafood'), ('Dairy foods'), ('Eggs');
insert into food(name, category) values('Cabbage', 1), ('Apple', 2), ('Almond', 3), ('Chicken', 4), 
('Crab', 5), ('Milk', 6), ('Quail eggs', 7), ('Potato', 1), ('Banana', 2), ('Wheat', 3), ('Duck', 4),
('Shellfish', 5), ('Cheese', 6), ('Chicken eggs', 7);

select * from food where category = 5;