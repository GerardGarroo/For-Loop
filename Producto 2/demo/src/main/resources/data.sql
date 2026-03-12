INSERT INTO sedes (nombre, ciudad, direccion, telefono) VALUES
('Central', 'Barcelona', 'Carrer Mallorca, 12', '+34 932 000 001'),
('Aeroport El Prat', 'El Prat', 'Terminal T1, Nivell -1', '+34 932 000 002'),
('Area Nord', 'Sabadell', 'Av. de les Bases, 32', '+34 932 000 003');

INSERT INTO vehiculos (matricula, marca, modelo, tipo, anio, precio_dia, estado) VALUES
('1234 ABC', 'Toyota', 'Corolla', 'COCHE', 2021, 42.00, 'DISPONIBLE'),
('5839 ASC', 'Honda', 'CB500', 'MOTO', 2020, 28.00, 'DISPONIBLE'),
('5212 JLM', 'Ford', 'Transit', 'FURGONETA', 2022, 65.00, 'ALQUILADO'),
('8801 MNP', 'Seat', 'Ibiza', 'COCHE', 2019, 35.00, 'DISPONIBLE'),
('6621 TUV', 'Mazda', 'CX-5', 'COCHE', 2021, 52.00, 'MANTENIMIENTO');

INSERT INTO clientes (nombre, apellidos, dni, email, telefono, direccion, fecha_registro) VALUES
('Carlos', 'Garcia Saez', '41299191K', 'cgarcia@mail.com', '+34654221021', 'Carrer del Consell, 14, Barcelona', '2025-01-12'),
('Maria', 'Aritz Soler', '32187654B', 'maritz@mail.com', '+34612440882', 'Av. Diagonal, 32, Barcelona', '2025-01-28'),
('Andreu', 'Cavaneres Pla', '55034812C', 'andreu.c@mail.com', '+34699103774', 'Carrer Major, 5, Sabadell', '2025-02-03');