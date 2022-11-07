INSERT INTO devices (name, price) VALUES ('Phone 1', 35000), ('Phone 2', 7200), ('Phone 3', 15400),
('Laptop 1', 69900), ('Laptop 2', 99999), ('Laptop 3', 39999), 
('Tablet 1', 4900), ('Tablet 2', 12690);

INSERT INTO people (name) VALUES ('Person 1'), ('Person 2'), ('Person 3');

INSERT INTO devices_people (people_id, device_id) VALUES (1, 1), (1, 5), (1, 7);
INSERT INTO devices_people (people_id, device_id) VALUES (2, 2), (2, 3), (2, 4);
INSERT INTO devices_people (people_id, device_id) VALUES (3, 1), (3, 6), (3, 8);