
package com.Biblioteca.service;

import java.util.List;

import com.Biblioteca.model.Copia;
import com.Biblioteca.model.Libro;
import com.Biblioteca.model.Prestamo;
import com.Biblioteca.model.Usuario;



public interface PrestamoService {

	List<Prestamo> listarPrestamos();

	List<Prestamo> prestamosPorUsuario(Long idUsuario);

	List<Prestamo> prestamosActivos();
	
	List<Prestamo> prestamosFinalizados();
	
	Boolean hayPrestamosPorCopia(Long idCopia);
	
	Prestamo buscarPrestamo(Prestamo prestamo);
	
	void guardarPrestamo(Libro libro, Copia copia, Usuario usuario);

	void devolucion(Prestamo prestamo);

	List<Prestamo> prestamosActivosPorUsuario(Long idUsuario);

	void eliminar(Prestamo prestamo);

}
