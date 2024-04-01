/**
 * @author romeramatias
 */

package com.Biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Biblioteca.model.Prestamo;


public interface IPrestamoRepository extends JpaRepository<Prestamo, Long>{

}
