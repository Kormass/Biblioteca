
	package com.Biblioteca.Controller;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.GetMapping;

	import com.Biblioteca.model.Copia;
	import com.Biblioteca.model.EstadoCopia;
	import com.Biblioteca.model.Libro;
	import com.Biblioteca.service.CopiaService;
	import com.Biblioteca.service.LibroService;
	import com.Biblioteca.service.PrestamoService;

	import lombok.extern.slf4j.Slf4j;


	@Controller
	@Slf4j
	public class ControladorCopias {

		@Autowired
		CopiaService copiasService;

		@Autowired
		LibroService librosService;

		@Autowired
		PrestamoService prestamosService;

		@GetMapping("/libros/{idLibro}/copias")
		public String inicio(Libro libro, Model model) {
			log.info("Inicio - Copias Controller");

			var copias = this.copiasService.listarCopiasPorLibro(libro.getIdLibro());
			libro = this.librosService.buscarLibro(libro);
			var copiasBiblioteca = this.copiasService.listarCopiasPorEstado(libro.getIdLibro(), EstadoCopia.BIBLIOTECA)
					.size();
			var copiasPrestadas = this.copiasService.listarCopiasPorEstado(libro.getIdLibro(), EstadoCopia.PRESTADO).size();

			model.addAttribute("copiasBiblioteca", copiasBiblioteca);
			model.addAttribute("copiasPrestadas", copiasPrestadas);
			model.addAttribute("libro", libro);
			model.addAttribute("libro", libro);
			model.addAttribute("copias", copias);
			model.addAttribute("prestamosService", prestamosService);

			return "copias/copias";
		}

		@GetMapping("/libros/{idLibro}/copias/{idCopia}/eliminar")
		public String eliminar(Copia copia) {
			log.info("Eliminar + ID Path - Persona Controller");
			log.info(copia.toString());
			copia = this.copiasService.buscarCopia(copia);
			this.copiasService.eliminar(copia);
			return "redirect:/libros/{idLibro}/copias/";
		}

		@GetMapping("/libros/{idLibro}/copias/agregar")
		public String agregar(Copia copia, Model model) {
			this.copiasService.guardarCopia(copia);
			return "redirect:/libros/{idLibro}/copias/";
		}

	}
