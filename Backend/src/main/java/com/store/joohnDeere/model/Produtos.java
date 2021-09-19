package com.store.joohnDeere.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table (name= "tb_produtos")
public class Produtos {
	
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull (message= "O atributo Nome é obrigatório!")
	@Size (min=1, max=800, message="O atributo nome deve conter no mínimo 1 caracter e no máximo 800")
	@Column (name = "Nome")
	private String nome;
	
	@NotNull (message= "O atributo Descricao é obrigatório!")
	@Size (min=1, max=2000, message="O atributo descricao deve conter no mínimo 1 caracter e no máximo 2000")
	private String descricao;
	
	@NotNull (message= "O atributo Preço é obrigatório!")
	private Double preco;
	
	@NotNull (message= "O atributo Disponivel é obrigatório!")
	private Boolean disponivel;
	


}
