package com.store.joohnDeere.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
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

import com.store.joohnDeere.model.Categoria;
import com.store.joohnDeere.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {

	@Autowired
	private CategoriaRepository repository;

	@GetMapping
	public HttpEntity<List<Categoria>> GetAll() {
		return ResponseEntity.ok(repository.findAll()); 
	} 

	@GetMapping("/{id}")
	public ResponseEntity<Categoria> GetById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());

	}

	@GetMapping("/categorias/{categoria}")
	public ResponseEntity<List<Categoria>> GetByCategoria(@PathVariable String nomeCategoria) {
		return ResponseEntity.ok(repository.findAllByNomeCategoriaContainingIgnoreCase(nomeCategoria));
	}
	

	@PostMapping
	public ResponseEntity<Categoria> postCategoria(@RequestBody Categoria nomeCategoria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(nomeCategoria));

	}

	@PutMapping
	public ResponseEntity<Categoria> putCategoria(@RequestBody Categoria nomeCategoria) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(nomeCategoria));

	}

	@DeleteMapping("/{id}")
	public void deleteCategoria(@PathVariable long id) {
		repository.deleteById(id);

	}
}
