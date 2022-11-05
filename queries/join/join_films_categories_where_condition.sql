select f.name as Фильм, f.release_date as Дата_выхода, f.for_adults as Для_взрослых, c.name as Категория
from films as f
join categories as c
on f.category_id = c.id
where f.release_date is not null;