
package com.Biblioteca.service;

import java.util.List;

import com.Biblioteca.model.Usuario;




public interface UsuarioService {

	List<Usuario> listarUsuarios();

	Usuario buscarUsuario(String username);

}
