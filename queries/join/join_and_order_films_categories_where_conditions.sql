SELECT f.name, f.release_date, f.for_adults 
FROM films as f
join categories p
on f.category_id = p.id
WHERE for_adults <> TRUE AND release_date < (SELECT current_date - interval '10 year')
ORDER BY f.name ASC;