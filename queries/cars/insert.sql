INSERT INTO bodies (name) VALUES ('Body 1'), ('Body 2'), ('Body 3'), ('Body 4');

INSERT INTO engines (name) VALUES ('Engines 1'), ('Engines 2'), ('Engines 3');

INSERT INTO transmissions (name) VALUES ('Transmission 1'), ('Transmission 2'), 
('Transmission 3'), ('Transmission 4');

INSERT INTO cars (name, body_id, engine_id, transmission_id) VALUES ('Car 1', 1, 1, 1),
('Car 2', 2, 2, 2), ('Car 3', 3, 3, 3), ('Car 4', 4, null, 4), ('Car 5', null, null, null);