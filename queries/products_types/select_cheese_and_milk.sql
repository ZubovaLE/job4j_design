SELECT p.name AS product, t.name AS type
FROM products AS p
JOIN types t
ON p.type_id = t.id
WHERE t.name = 'Cheese' OR t.name = 'Milk'
ORDER BY t.name ASC;