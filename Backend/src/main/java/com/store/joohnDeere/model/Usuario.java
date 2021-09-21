package com.store.joohnDeere.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@Entity
@Table(name = "tb_usuarios")
public class Usuario {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message="O nome é obrigatório!")
	@Size(min=3 , max=300)
	private String nomeUsuario;
	
	@Column(name = "dt_nascimento")
	@JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dataNascimento; 

	
	@NotNull(message="O email é obrigatório!")
	@Size(min=6 , max=100 )
	@Email
	private String email;
	
	@NotNull(message="A senha é obrigatória!")
	@Size(min=4)
	private String senha;

	private String foto;
	
	
	@OneToMany(mappedBy = "usuarios", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuarios")
	private List<Produtos> produtos;
}
