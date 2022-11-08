INSERT INTO products (type_id, name, expired_date, price) VALUES (2, 'Ice cream 4', '10.12.2022', 75), (2, 'Ice cream 5', '14.04.2023', 37), 
(5, 'Water 4', '02.11.2023', 94), (5, 'Water 5', '12.05.2022', 82); 

SELECT t.name AS type, COUNT(p.name)
FROM products AS p
JOIN types t
ON p.type_id = t.id
GROUP BY t.name
HAVING COUNT(p.name) < 5
ORDER BY t.name ASC;