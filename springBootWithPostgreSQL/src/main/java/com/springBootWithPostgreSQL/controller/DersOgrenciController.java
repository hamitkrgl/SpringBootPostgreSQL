package com.springBootWithPostgreSQL.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBootWithPostgreSQL.exception.ResourceNotFoundException;
import com.springBootWithPostgreSQL.model.DersOgrenci;
import com.springBootWithPostgreSQL.repository.DersOgrenciRepository;

@RestController
@RequestMapping("/api/v1/")
public class DersOgrenciController {
	@Autowired
	private DersOgrenciRepository dersOgrenciRepository;

	/**
	 * localhost:8080/api/v1/getdersogrenci
	 * 
	 * @return DersOgrenci list
	 */
	@GetMapping("getdersogrenci")
	public List<DersOgrenci> getAllKonu() {
		return this.dersOgrenciRepository.findAll();
	}

	/**
	 * 
	 * @param dersOgrenciİd
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@GetMapping("getdersogr/{id}")
	public ResponseEntity<DersOgrenci> getDersById(@PathVariable(value = "id") long dersOgrenciİd)
			throws ResourceNotFoundException {
		DersOgrenci dersOgrenci = dersOgrenciRepository.findById(dersOgrenciİd)
				.orElseThrow(() -> new ResourceNotFoundException("Ders not found this id : :" + dersOgrenciİd));
		return ResponseEntity.ok().body(dersOgrenci);
	}
}
