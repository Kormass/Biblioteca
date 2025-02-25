
package com.Biblioteca.service.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Biblioteca.model.Copia;
import com.Biblioteca.model.EstadoCopia;
import com.Biblioteca.repository.ICopiaRepository;
import com.Biblioteca.service.CopiaService;

@Service
public class CopiaServiceImplement implements CopiaService {

	@Autowired
	ICopiaRepository copiasRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Copia> listarCopiasPorLibro(Long idLibro) {
		var allCopias = this.copiasRepository.findAll();
		List<Copia> copias = new ArrayList<>();

		for (Copia copia : allCopias) {
			if (copia.getIdLibro() == idLibro) {
				copias.add(copia);
			}
		}

		return copias;
	}

	@Override
	@Transactional
	public void eliminar(Copia copia) {
		this.copiasRepository.delete(copia);
	}

	@Override
	@Transactional(readOnly = true)
	public Copia buscarCopia(Copia copia) {
		return this.copiasRepository.findById(copia.getIdCopia()).orElse(null);
	}

	@Override
	@Transactional
	public void guardarCopia(Copia copia) {
		copia.setEstado(EstadoCopia.BIBLIOTECA);
		this.copiasRepository.save(copia);
	}

	@Override
	@Transactional
	public void eliminarCopiasPorLibro(Long idLibro) {
		var copiasLibro = listarCopiasPorLibro(idLibro);

		for (Copia copia : copiasLibro) {
			this.eliminar(copia);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<Copia> listarCopias() {
		return this.copiasRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Copia> listarCopiasPorEstado(Long idLibro, EstadoCopia estado) {
		var allCopias = this.listarCopiasPorLibro(idLibro);
		List<Copia> copias = new ArrayList<>();

		for (Copia copia : allCopias) {
			if (copia.getEstado().equals(estado)) {
				copias.add(copia);
			}
		}

		return copias;
	}

	@Override
	@Transactional
	public Copia buscarCopiaDisponible(Long idLibro) {
		var allCopias = this.listarCopiasPorLibro(idLibro);
		Copia copiaDisponible = null;
		Copia auxiliar;
		int index = 0;

		while (copiaDisponible == null && index < allCopias.size()) {
			auxiliar = allCopias.get(index);
			if (auxiliar.getEstado() == EstadoCopia.BIBLIOTECA) {
				copiaDisponible = auxiliar;
				// Esto lo deberia hacer en la pagina de confirm prestamo
				// copiaDisponible.setEstado(EstadoCopia.PRESTADO);
			}
			index++;
		}
		return copiaDisponible;
	}

}
