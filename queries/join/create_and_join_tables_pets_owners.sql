create table pets(
    id serial primary key,
    name varchar(255)
);

create table owners(
    id serial primary key,
    name varchar(255),
    pet_id int references pets(id)
);

insert into pets (name) values ('cat'), ('dog'), ('turtle'), ('mouse');
insert into owners (name, pet_id) values('Ben', 1), ('Emily', 1), ('John', 1), ('Chloe', 2), 
('Peter', 3), ('Sam', 4);
insert into owners (name) values ('Anna');

select o.name, p.name
from owners as o
join pets as p
on o.pet_id = p.id;