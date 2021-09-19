package com.store.joohnDeere.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.joohnDeere.model.Produtos;
import com.store.joohnDeere.repository.ProdutosRepository;

@RestController
@RequestMapping ("/produtos")
@CrossOrigin (origins = "*", allowedHeaders = "*")
public class ProdutosController {
	
	@Autowired
	private ProdutosRepository produtosRepository;
	
	//Gets
	
	@GetMapping
	public ResponseEntity<List<Produtos>> GetAll (){
		return ResponseEntity.ok(produtosRepository.findAll()); 
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<Produtos> GetId (@PathVariable Long id){
	return produtosRepository.findById(id)
				.map(resp -> ResponseEntity.ok (resp))
				.orElse(ResponseEntity.notFound().build()); 
		}
	

	@GetMapping ("/produtos/{nome}")              
	public ResponseEntity<List<Produtos>> GetByNomeProduto(@PathVariable String nomeProduto){                   
		return ResponseEntity.ok(produtosRepository.findAllByNomeProdutoContainingIgnoreCase(nomeProduto));
	}
	
	//post
	
	@PostMapping
	public ResponseEntity<Produtos> postProduto (@RequestBody Produtos produto){
		return ResponseEntity.status(HttpStatus.CREATED).body(produtosRepository.save(produto));
	
	}
	
	@PutMapping
	public ResponseEntity<Produtos> putProduto(@RequestBody Produtos produto){
		return ResponseEntity.status(HttpStatus.OK).body(produtosRepository.save(produto));
	
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduto (@PathVariable Long id) {
		produtosRepository.deleteById(id);
	}
	
	

}
