/**
 * @author romeramatias
 */

package com.Biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Biblioteca.model.Usuario;


public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findByUsername(String username);

}
