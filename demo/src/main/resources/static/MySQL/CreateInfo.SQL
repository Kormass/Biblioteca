-- Datos para tabla autor
INSERT INTO autor (nombre) VALUES
('Gabriel García Márquez'),
('Haruki Murakami'),
('J.K. Rowling'),
('Stephen King'),
('Jane Austen'),
('Ernest Hemingway'),
('Fyodor Dostoevsky'),
('George Orwell'),
('Leo Tolstoy'),
('Mark Twain');

-- Datos para tabla libro
INSERT INTO libro (titulo, id_autor, genero, anio_publicacion, cantidad_disponible) VALUES
('Cien años de soledad', 1, 'Realismo mágico', 1967, 5),
('Norwegian Wood', 2, 'Ficción contemporánea', 1987, 8),
('Harry Potter y la piedra filosofal', 3, 'Fantasía', 1997, 10),
('It', 4, 'Terror', 1986, 6),
('Orgullo y prejuicio', 5, 'Novela romántica', 1813, 7),
('El viejo y el mar', 6, 'Novela corta', 1952, 4),
('Crime and Punishment', 7, 'Novela psicológica', 1866, 3),
('1984', 8, 'Distopía', 1949, 9),
('Guerra y paz', 9, 'Novela histórica', 1869, 5),
('Las aventuras de Tom Sawyer', 10, 'Ficción juvenil', 1876, 8);

-- Datos para tabla copia
INSERT INTO copia (id_libro, estado) VALUES
(1, 'DISPONIBLE'),
(1, 'DISPONIBLE'),
(1, 'PRESTADO'),
(2, 'DISPONIBLE'),
(2, 'DISPONIBLE'),
(3, 'PRESTADO'),
(3, 'DISPONIBLE'),
(4, 'PRESTADO'),
(5, 'DISPONIBLE'),
(6, 'DISPONIBLE');

-- Datos para tabla prestamo
INSERT INTO prestamo (id_usuario, id_copia, fecha_prestamo, fecha_devolucion_prevista, estado) VALUES
(1, 3, '2024-03-01', '2024-03-15', 'PRESTADO'),
(2, 6, '2024-03-05', '2024-03-20', 'PRESTADO'),
(3, 7, '2024-03-08', '2024-03-23', 'PRESTADO'),
(4, 8, '2024-03-10', '2024-03-25', 'PRESTADO'),
(5, 9, '2024-03-12', '2024-03-27', 'PRESTADO'),
(6, 10, '2024-03-15', '2024-03-30', 'PRESTADO'),
(7, 11, '2024-03-18', '2024-04-02', 'PRESTADO'),
(8, 12, '2024-03-20', '2024-04-04', 'PRESTADO'),
(9, 13, '2024-03-22', '2024-04-06', 'PRESTADO'),
(10, 14, '2024-03-25', '2024-04-08', 'PRESTADO');

-- Datos para tabla usuario
INSERT INTO usuario (nombre_usuario, contrasena, id_rol) VALUES
('admin', 'admin123', 1),
('bibliotecario', 'bibliotecario123', 2),
('usuario1', 'usuario1123', 3),
('usuario2', 'usuario2123', 3),
('usuario3', 'usuario3123', 3),
('usuario4', 'usuario4123', 3),
('usuario5', 'usuario5123', 3),
('usuario6', 'usuario6123', 3),
('usuario7', 'usuario7123', 3),
('usuario8', 'usuario8123', 3);
