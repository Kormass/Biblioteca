package com.Biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Biblioteca.model.Libro;


public interface ILibroRepository extends JpaRepository<Libro, Long> {

}
