package com.springBootWithPostgreSQL.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBootWithPostgreSQL.exception.ResourceNotFoundException;
import com.springBootWithPostgreSQL.model.Konu;
import com.springBootWithPostgreSQL.repository.KonuRepository;

@RestController
@RequestMapping("/api/v1/")
public class KonuController {

	@Autowired
	private KonuRepository konuRepository;

	/**
	 * localhost:8080/api/v1/getkonular
	 * 
	 * @return konu list
	 */
	// get konu
	@GetMapping("getkonular")
	public List<Konu> getAllKonu() {
		return this.konuRepository.findAll();
	}

	/**
	 * localhost:8080/api/v1/getkonu/1
	 * 
	 * @param konuİd
	 * @return id ile konu
	 * @throws ResourceNotFoundException
	 */
	@GetMapping("getkonu/{id}")
	public ResponseEntity<Konu> getKonuById(@PathVariable(value = "id") long konuİd) throws ResourceNotFoundException {
		Konu konu = konuRepository.findById(konuİd)
				.orElseThrow(() -> new ResourceNotFoundException("Konu not found this id : :" + konuİd));
		return ResponseEntity.ok().body(konu);

	}

	/**
	 * bu method konu nesnelerini veritabanına kaydeder
	 * localhost:8080/api/v1/konukayit
	 * 
	 * @return save
	 */
	@PostMapping("konukayit")
	public Konu createKonu(@RequestBody Konu konu) {
		return this.konuRepository.save(konu);
	}

	/**
	 * bu method konu nesnelerini veritabanında günceller
	 * localhost:8080/api/v1/konuupdate/{id}
	 * 
	 * @param konuİd
	 * @param konuDetay
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@PutMapping("konuupdate/{id}")
	public ResponseEntity<Konu> updateKonu(@PathVariable(value = "id") Long konuİd,
			@Validated @RequestBody Konu konuDetay) throws ResourceNotFoundException {
		Konu konu = konuRepository.findById(konuİd)
				.orElseThrow(() -> new ResourceNotFoundException("Konu not found this id : :" + konuİd));
		konu.setName(konuDetay.getName());
		return ResponseEntity.ok(this.konuRepository.save(konu));
	}

	/**
	 * bu method konu nesnelerini veritabanında siler.
	 * localhost:8080/api/v1/konusil/{id}
	 * 
	 * @param konuİd
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@DeleteMapping("/konusil/{id}")
	public Map<String, Boolean> deleteKonu(@PathVariable(value = "id") Long konuİd) throws ResourceNotFoundException {
		Konu konu = konuRepository.findById(konuİd)
				.orElseThrow(() -> new ResourceNotFoundException("Konu not found for this id :: " + konuİd));

		konuRepository.delete(konu);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
