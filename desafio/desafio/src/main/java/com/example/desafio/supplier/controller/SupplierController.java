package com.example.desafio.supplier.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.desafio.supplier.dto.SupplierDTO;
import com.example.desafio.supplier.service.SupplierService;

@RestController
@RequestMapping("/supplier")
@CrossOrigin(origins = "*")
public class SupplierController {

	@Autowired
	private SupplierService service;

	@GetMapping
	public List<SupplierDTO> getAll() {
		return this.service.getAll();
	}

	@PostMapping("/create")
	public SupplierDTO create(@RequestBody SupplierDTO dto) {
		return this.service.create(dto);
	}

	@PutMapping("/update/{id}")
	public SupplierDTO update(@PathVariable Long id, @RequestBody SupplierDTO dto) {
		return this.service.update(id, dto);
	}

	@DeleteMapping("/delete")
	public void delete(@RequestParam("ids") List<Long> ids) {
		this.service.delete(ids);
	}

	@PostMapping("/favorite/{id}")
	public void favorite(@PathVariable Long id) {
		this.service.favorite(id);
	}
	
	@GetMapping("/find-by-id/{id}")
	public SupplierDTO getFornecedorById(@PathVariable Long id) {
	    return this.service.getFornecedorById(id);
	}
}