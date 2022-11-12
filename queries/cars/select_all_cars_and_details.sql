SELECT c.name AS car, b.name AS body,  e.name as engine, t.name AS transmission
FROM cars c
LEFT JOIN bodies b ON b.id = c.body_id
LEFT JOIN engines e ON e.id = c.engine_id
LEFT JOIN transmissions t ON t.id = c.transmission_id;