package com.store.joohnDeere.repository;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.joohnDeere.model.Usuario;




@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
		
		public List<Usuario> findAllByEmailContainingIgnoreCase(String email);
		public List<Usuario> findAllByNomeUsuarioContainingIgnoreCase(String nomeUsuario);
		public Optional<Usuario> findByEmail(String email);
		


}
