INSERT INTO transmissions(name) VALUES('Modern transmission');

SELECT t.name AS engine
FROM transmissions t
LEFT JOIN cars c ON t.id = c.body_id
WHERE c.id IS NULL;