package com.store.joohnDeere.model;

import java.time.LocalDate;



import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsuarioLogin {
	
	private long id;

	private String nomeUsuario; 
	private LocalDate dataNascimento;
	private String tipoUsuario;
	private String email; 
	private String senha; 
	private String foto; 
	private String token; 


}
