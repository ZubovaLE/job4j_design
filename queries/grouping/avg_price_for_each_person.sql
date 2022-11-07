SELECT p.name, AVG(d.price)
FROM devices_people AS dp
JOIN people p
ON dp.people_id = p.id
JOIN devices d
ON dp.device_id = d.id
GROUP BY p.name