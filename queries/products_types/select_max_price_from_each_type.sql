SELECT t.name, MAX(p.price)
FROM products AS p
JOIN types t
ON p.type_id = t.id
GROUP BY t.name
ORDER BY MAX(p.price) DESC;