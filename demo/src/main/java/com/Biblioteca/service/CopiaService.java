
package com.Biblioteca.service;

import java.util.List;

import com.Biblioteca.model.Copia;
import com.Biblioteca.model.EstadoCopia;

public interface CopiaService {

	List<Copia> listarCopias();
	
	List<Copia> listarCopiasPorLibro(Long idLibro);
	
	List<Copia> listarCopiasPorEstado(Long idLibro, EstadoCopia estado);

	void eliminarCopiasPorLibro(Long idLibro);

	void guardarCopia(Copia copia);

	void eliminar(Copia copia);

	Copia buscarCopia(Copia copia);
	
	Copia buscarCopiaDisponible(Long idLibro);

}
