
package com.Biblioteca.service;

import java.util.List;

import com.Biblioteca.model.Libro;

public interface LibroService {

	List<Libro> listarLibros();

	void guardarLibro(Libro libro);

	void eliminar(Libro libro);

	Libro buscarLibro(Libro libro);

	List<Libro> buscarLibros(String nombre);
}
