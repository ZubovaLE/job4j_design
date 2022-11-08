SELECT t.name as type, COUNT(p.name)
FROM products AS p
JOIN types t
ON p.type_id = t.id
GROUP BY t.name
ORDER BY MAX(t.name) ASC;