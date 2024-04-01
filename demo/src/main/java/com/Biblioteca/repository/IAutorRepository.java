package com.Biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Biblioteca.model.Author;


public interface IAutorRepository extends JpaRepository<Author, Long> {

}
