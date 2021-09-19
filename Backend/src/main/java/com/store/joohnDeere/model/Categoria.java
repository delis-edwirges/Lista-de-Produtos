package com.store.joohnDeere.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@Data
@Entity
@Table (name= "tb_categorias")
public class Categoria {
	
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull (message= "O atributo Categoria é obrigatório!")
	@Size (min=1, max=400, message="O atributo categoria deve conter no mínimo 1 caracter e no máximo 400")
	@Column (name = "Categoria")
	private String categoria;
	
	@NotNull (message= "O atributo Sobre é obrigatório!")
	@Size (min=1, max=2000, message="O atributo sobre deve conter no mínimo 1 caracter e no máximo 2000")
	private String sobre;
	
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("categoria")
	private List<Produtos> produtos;
	




}
