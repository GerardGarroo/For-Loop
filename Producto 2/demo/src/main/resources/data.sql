INSERT INTO sedes (id,nombre, ciudad, direccion, telefono) VALUES
(1,'Central', 'Barcelona', 'Carrer Mallorca, 12', '+34 932 000 001'),
(2,'Aeroport El Prat', 'El Prat', 'Terminal T1, Nivell -1', '+34 932 000 002'),
(3,'Area Nord', 'Sabadell', 'Av. de les Bases, 32', '+34 932 000 003');

INSERT INTO vehiculos (id,matricula, marca, modelo, tipo, anio, precio_dia, estado) VALUES
(1,'1234 ABC', 'Toyota', 'Corolla', 'COCHE', 2021, 42.00, 'DISPONIBLE'),
(2,'5839 ASC', 'Honda', 'CB500', 'MOTO', 2020, 28.00, 'DISPONIBLE'),
(3,'5212 JLM', 'Ford', 'Transit', 'FURGONETA', 2022, 65.00, 'ALQUILADO'),
(4,'8801 MNP', 'Seat', 'Ibiza', 'COCHE', 2019, 35.00, 'DISPONIBLE'),
(5,'6621 TUV', 'Mazda', 'CX-5', 'COCHE', 2021, 52.00, 'MANTENIMIENTO');

INSERT INTO clientes (id,nombre, apellidos, dni, email, telefono, direccion, fecha_registro) VALUES
(1,'Carlos', 'Garcia Saez', '41299191K', 'cgarcia@mail.com', '+34654221021', 'Carrer del Consell, 14, Barcelona', '2025-01-12'),
(2,'Maria', 'Aritz Soler', '32187654B', 'maritz@mail.com', '+34612440882', 'Av. Diagonal, 32, Barcelona', '2025-01-28'),
(3,'Andreu', 'Cavaneres Pla', '55034812C', 'andreu.c@mail.com', '+34699103774', 'Carrer Major, 5, Sabadell', '2025-02-03');

INSERT INTO alquileres (fecha_inicio, fecha_fin, precio_total, estado, cliente_id, vehiculo_id, sede_recogida_id, sede_devolucion_id) VALUES
('2026-03-10', '2026-03-12', 84.00, 'ACTIVO', 1, 1, 1, 1),
('2026-02-14', '2026-02-18', 208.00, 'FINALIZADO', 1, 5, 2, 1),
('2026-03-11', '2026-03-17', 252.00, 'PENDIENTE', 2, 2, 3, 2),
('2026-03-01', '2026-03-08', 280.00, 'FINALIZADO', 3, 4, 1, 1),
('2026-03-13', '2026-03-16', 105.00, 'PENDIENTE', 2, 4, 1, 2);