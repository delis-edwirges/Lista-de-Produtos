package com.store.joohnDeere.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


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
	
	@NotNull (message= "O atributo nomeProduto é obrigatório!")
	@Size (min=1, max=800, message="O atributo nomeProduto deve conter no mínimo 1 caracter e no máximo 800")
	@Column (name = "Nome")
	private String nomeProduto;
	
	@NotNull (message= "O atributo Descricao é obrigatório!")
	@Size (min=1, max=2000, message="O atributo descricao deve conter no mínimo 1 caracter e no máximo 2000")
	private String descricao;
	
	@NotNull (message= "O atributo Preço é obrigatório!")
	private Double preco;
	
	@NotNull (message= "O atributo Estoque é obrigatório!")
	@PositiveOrZero
	private long estoque;
	
	@NotNull (message= "O atributo Disponivel é obrigatório!")
	private Boolean disponivel;
	
	@Temporal(TemporalType.TIMESTAMP)         
	private Date data = new java.sql.Date(System.currentTimeMillis());
	
	private String imagem;
	
	@ManyToOne
	@JsonIgnoreProperties ("produtos")
	private Usuario usuarios;
	
	@ManyToOne
	@JsonIgnoreProperties("produtos")
	private Categoria categoria;

	


}
