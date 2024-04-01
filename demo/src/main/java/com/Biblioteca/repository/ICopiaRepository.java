package com.Biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Biblioteca.model.Copia;



public interface ICopiaRepository extends JpaRepository<Copia, Long> {

}
