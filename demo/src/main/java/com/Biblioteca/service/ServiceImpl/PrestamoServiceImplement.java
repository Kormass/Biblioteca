package com.Biblioteca.service.ServiceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Biblioteca.model.Copia;
import com.Biblioteca.model.EstadoCopia;
import com.Biblioteca.model.Libro;
import com.Biblioteca.model.Prestamo;
import com.Biblioteca.model.Usuario;
import com.Biblioteca.repository.IPrestamoRepository;
import com.Biblioteca.service.PrestamoService;

;

@Service
public class PrestamoServiceImplement implements PrestamoService {

	@Autowired
	IPrestamoRepository prestamosRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Prestamo> listarPrestamos() {
		return this.prestamosRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Prestamo> prestamosPorUsuario(Long idUsuario) {
		var allPrestamos = this.listarPrestamos();
		List<Prestamo> prestamos = new ArrayList<>();

		for (Prestamo prestamo : allPrestamos) {
			if (prestamo.getUsuario().getIdUsuario().equals(idUsuario)) {
				prestamos.add(prestamo);
			}
		}

		return prestamos;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Prestamo> prestamosActivosPorUsuario(Long idUsuario) {
		var userPrestamos = this.prestamosPorUsuario(idUsuario);
		List<Prestamo> prestamos = new ArrayList<>();

		for (Prestamo prestamo : userPrestamos) {
			if (prestamo.getFechaFin() == null) {
				prestamos.add(prestamo);
			}
		}

		return prestamos;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Prestamo> prestamosActivos() {
		var allPrestamos = this.listarPrestamos();
		List<Prestamo> prestamos = new ArrayList<>();

		for (Prestamo prestamo : allPrestamos) {
			if (prestamo.getFechaFin() == null) {
				prestamos.add(prestamo);
			}
		}

		return prestamos;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Prestamo> prestamosFinalizados() {
		var allPrestamos = this.listarPrestamos();
		List<Prestamo> prestamos = new ArrayList<>();

		for (Prestamo prestamo : allPrestamos) {
			if (prestamo.getFechaFin() != null) {
				prestamos.add(prestamo);
			}
		}

		return prestamos;
	}

	@Override
	public void guardarPrestamo(Libro libro, Copia copia, Usuario usuario) {
		Prestamo prestamo = new Prestamo();
		prestamo.setLibro(libro);
		prestamo.setCopia(copia);
		prestamo.setUsuario(usuario);
		prestamo.setFechaInicio(LocalDate.now());
		copia.setEstado(EstadoCopia.PRESTADO);

		this.prestamosRepository.save(prestamo);
	}

	@Override
	@Transactional(readOnly = true)
	public Prestamo buscarPrestamo(Prestamo prestamo) {
		return this.prestamosRepository.findById(prestamo.getIdPrestamo()).orElse(null);
	}

	@Override
	@Transactional
	public void devolucion(Prestamo prestamo) {
		prestamo.setFechaFin(LocalDate.now());
		prestamo.getCopia().setEstado(EstadoCopia.BIBLIOTECA);
	}

	@Override
	@Transactional(readOnly = true)
	public Boolean hayPrestamosPorCopia(Long idCopia) {
		var allPrestamos = this.listarPrestamos();
		var index = 0;
		boolean tienePrestamos = false;

		while (index < allPrestamos.size() && !tienePrestamos) {
			if (allPrestamos.get(index).getCopia().getIdCopia().equals(idCopia)) {
				tienePrestamos = true;
			}
			index++;
		}

		return tienePrestamos;
	}

	@Override
	@Transactional
	public void eliminar(Prestamo prestamo) {
		this.prestamosRepository.delete(prestamo);
	}

}
