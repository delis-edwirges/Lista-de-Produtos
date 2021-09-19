package com.store.joohnDeere.service;

import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.store.joohnDeere.model.Usuario;
import com.store.joohnDeere.model.UsuarioLogin;
import com.store.joohnDeere.repository.UsuarioRepository;




@Service
public class UsuarioService {
	

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Optional<Usuario> cadastrarUsuario(Usuario email) {
		
		if(usuarioRepository.findByEmail(email.getEmail()).isPresent())
			throw new ResponseStatusException(
			          	HttpStatus.BAD_REQUEST, "Usuário já existe!", null);
	
		int datanascimento = Period.between(email.getDataNascimento(), LocalDate.now()).getYears();
		
		if(datanascimento < 18)
			throw new ResponseStatusException(
						HttpStatus.BAD_REQUEST, "Usuário menor de 18 anos", null);
			
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		String senhaEncoder = encoder.encode(email.getSenha());
		email.setSenha(senhaEncoder);

		return Optional.of(usuarioRepository.save(email));
	}

	
	public Optional<Usuario> atualizarUsuario(Usuario email){
		
		if(usuarioRepository.findById(email.getId()).isPresent()) {
			
			int datanascimento = Period.between(email.getDataNascimento(), LocalDate.now()).getYears();
			
			if(datanascimento < 18)
				throw new ResponseStatusException(
							HttpStatus.BAD_REQUEST, "Usuário menor de 18 anos", null);
			
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			
			String senhaEncoder = encoder.encode(email.getSenha());
			email.setSenha(senhaEncoder);
			
			return Optional.of(usuarioRepository.save(email));
		
		}else {
			
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND, "Usuário não encontrado!", null);
			
		}
		
	}
	
	public Optional<UsuarioLogin> logarUsuario(Optional<UsuarioLogin> usuarioLogin) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Usuario> email = usuarioRepository.findByEmail(usuarioLogin.get().getEmail());

		if (email.isPresent()) {
			if (encoder.matches(usuarioLogin.get().getSenha(), email.get().getSenha())) {

				String auth = usuarioLogin.get().getEmail() + ":" + usuarioLogin.get().getSenha();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);

				usuarioLogin.get().setToken(authHeader);				
				usuarioLogin.get().setNomeUsuario(email.get().getNomeUsuario());
				usuarioLogin.get().setId(email.get().getId());
				usuarioLogin.get().setFoto(email.get().getFoto());
				usuarioLogin.get().setEmail(email.get().getEmail());
				usuarioLogin.get().setTipoUsuario(email.get().getTipoUsuario());
				
				

				
				return usuarioLogin;

			}
		}

		throw new ResponseStatusException(
				HttpStatus.UNAUTHORIZED, "Usuário ou senha inválidos!", null);
	}
	
	

}
