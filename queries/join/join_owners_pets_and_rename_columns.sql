select o.name as Владелец, p.name as Питомец
from owners as o
join pets as p
on o.pet_id = p.id;