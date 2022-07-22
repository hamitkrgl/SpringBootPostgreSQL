package com.springBootWithPostgreSQL.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBootWithPostgreSQL.exception.ResourceNotFoundException;
import com.springBootWithPostgreSQL.model.Ders;
import com.springBootWithPostgreSQL.repository.DersRepository;

@RestController
@RequestMapping("/api/v1/")
public class DersController {
	@Autowired
	private DersRepository dersRepository;

	/**
	 * localhost:8080/api/v1/getdersler
	 * 
	 * @return Ders list
	 */
	// get konu
	@GetMapping("getdersler")
	public List<Ders> getAllKonu() {
		return this.dersRepository.findAll();
	}

	/**
	 * localhost:8080/api/v1/getders/1
	 * 
	 * @param dersİd
	 * @return id ile ders
	 * @throws ResourceNotFoundException
	 */
	@GetMapping("getders/{id}")
	public ResponseEntity<Ders> getDersById(@PathVariable(value = "id") long dersİd) throws ResourceNotFoundException {
		Ders ders = dersRepository.findById(dersİd)
				.orElseThrow(() -> new ResourceNotFoundException("Ders not found this id : :" + dersİd));
		return ResponseEntity.ok().body(ders);
	}

	/**
	 * localhost:8080/api/v1/derskayit
	 * 
	 * @param ders
	 * @return
	 */
	@PostMapping("derskayit")
	public Ders createDers(@RequestBody Ders ders) {
		return this.dersRepository.save(ders);
	}

	@DeleteMapping("/derssil/{id}")
	public Map<String, Boolean> deleteDers(@PathVariable(value = "id") Long dersİd) throws ResourceNotFoundException {
		Ders ders = dersRepository.findById(dersİd)
				.orElseThrow(() -> new ResourceNotFoundException("Ders not found for this id :: " + dersİd));

		dersRepository.delete(ders);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
