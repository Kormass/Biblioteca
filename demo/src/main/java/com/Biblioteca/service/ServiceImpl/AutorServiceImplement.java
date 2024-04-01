
package com.Biblioteca.service.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Biblioteca.model.Author;
import com.Biblioteca.repository.IAutorRepository;
import com.Biblioteca.service.AutorService;




@Service
public class AutorServiceImplement implements AutorService {

	@Autowired
	IAutorRepository autoresRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Author> listarAutores() {
		return this.autoresRepository.findAll();
	}

}
