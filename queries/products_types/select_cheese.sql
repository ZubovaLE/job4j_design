SELECT p.name, t.name
FROM products AS p
JOIN types AS t
ON p.type_id = t.id
WHERE t.name = 'Cheese';