package com.example.commons.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.commons.exceptions.NotFoundException;
import com.example.commons.service.CommonService;

import jakarta.validation.Valid;


public class CommonController<E, S extends CommonService<E>> {

	@Autowired
	protected S service;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id) {
	    E entidad = service.findById(id)
	    		.orElseThrow(() -> new NotFoundException("Recurso con ID " + id + " no encontrado."));
	    
	    return ResponseEntity.ok(entidad);
	}

	
	@PostMapping
	public ResponseEntity<?> crear(@Valid @RequestBody E entity, BindingResult result) {
		if(result.hasErrors()) {
			return this.validar(result);
		}

		E entityDb = service.save(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(entityDb);
	}

	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {
		E entity = service.findById(id)
				.orElseThrow(() -> new NotFoundException("Recurso con ID " + id + " no encontrado"));
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	
	protected ResponseEntity<?> validar(BindingResult result){
		Map<String, Object> errores = new HashMap<>();
		result.getFieldErrors().forEach(err -> {
			errores.put(err.getField() , "El campo " + err.getField() + " " +  err.getDefaultMessage());
		});
		
		return ResponseEntity.badRequest().body(errores);
	}
}









