INSERT INTO engines(name) VALUES('Modern engine');

SELECT e.name AS engine
FROM engines e
LEFT JOIN cars c ON e.id = c.body_id
WHERE c.id IS NULL;