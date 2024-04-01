-- Tabla autor
CREATE TABLE autor (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL
);

-- Tabla libro
CREATE TABLE libro (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    id_autor INT,
    genero VARCHAR(100),
    anio_publicacion INT,
    cantidad_disponible INT,
    FOREIGN KEY (id_autor) REFERENCES autor(id)
);

-- Tabla copia
CREATE TABLE copia (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_libro INT,
    estado ENUM('DISPONIBLE', 'PRESTADO') NOT NULL,
    FOREIGN KEY (id_libro) REFERENCES libro(id)
);

-- Tabla prestamo
CREATE TABLE prestamo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT,
    id_copia INT,
    fecha_prestamo DATE,
    fecha_devolucion_prevista DATE,
    estado ENUM('PRESTADO', 'DEVUELTO') NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id),
    FOREIGN KEY (id_copia) REFERENCES copia(id)
);

-- Tabla rol
CREATE TABLE rol (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre ENUM('ADMINISTRADOR', 'BIBLIOTECARIO', 'USUARIO') NOT NULL
);

-- Tabla usuario
CREATE TABLE usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre_usuario VARCHAR(255) UNIQUE NOT NULL,
    contrasena VARCHAR(255) NOT NULL,
    id_rol INT,
    FOREIGN KEY (id_rol) REFERENCES rol(id)
);
