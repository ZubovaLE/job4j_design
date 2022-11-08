SELECT p.name AS product, p.price, p.expired_date
FROM products AS p
JOIN types t
ON p.type_id = t.id
ORDER BY t.name ASC;