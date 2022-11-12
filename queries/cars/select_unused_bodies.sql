INSERT INTO bodies(name) VALUES('Modern body 1'), ('Modern body 2');

SELECT b.name AS body
FROM bodies b
LEFT JOIN cars c ON b.id = c.body_id
WHERE c.id IS NULL;