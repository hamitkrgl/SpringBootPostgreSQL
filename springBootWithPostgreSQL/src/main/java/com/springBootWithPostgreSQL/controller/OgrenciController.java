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
import com.springBootWithPostgreSQL.model.Ogrenci;
import com.springBootWithPostgreSQL.repository.OgrenciRepository;

@RestController
@RequestMapping("/api/v1/")
public class OgrenciController {

	@Autowired
	private OgrenciRepository ogrenciRepository;

	/**
	 * localhost:8080/api/v1/getogrenciler
	 * 
	 * @return ogrenci list
	 */
	@GetMapping("getogrenciler")
	public List<Ogrenci> getAllKonu() {
		return this.ogrenciRepository.findAll();
	}

	/**
	 * localhost:8080/api/v1/getogrenci/1
	 * 
	 * @param ogrenciid
	 * @return id ile ogrenci getiren fonksiyon
	 * @throws ResourceNotFoundException
	 */
	@GetMapping("getogrenci/{id}")
	public ResponseEntity<Ogrenci> getKonuById(@PathVariable(value = "id") long ogrenciid)
			throws ResourceNotFoundException {
		Ogrenci ogrenci = ogrenciRepository.findById(ogrenciid)
				.orElseThrow(() -> new ResourceNotFoundException("Ogrenci not found this id : :" + ogrenciid));
		return ResponseEntity.ok().body(ogrenci);
	}

	/**
	 * bu method ogrenci nesnelerini veritabanına kaydeder
	 * localhost:8080/api/v1/ogrencikayit
	 * 
	 * @return save
	 */
	@PostMapping("ogrencikayit")
	public Ogrenci createOgrenci(@RequestBody Ogrenci ogrenci) {
		return this.ogrenciRepository.save(ogrenci);
	}

	/**
	 * bu method ogrenci nesnelerini veritabanında günceller
	 * localhost:8080/api/v1/ogrenciupdate/{id}
	 * 
	 * @param ogrenciİd
	 * @param ogrenciDetay
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@PutMapping("ogrenciupdate/{id}")
	public ResponseEntity<Ogrenci> updateOgrenci(@PathVariable(value = "id") Long ogrenciİd,
			@Validated @RequestBody Ogrenci ogrenciDetay) throws ResourceNotFoundException {
		Ogrenci ogrenci = ogrenciRepository.findById(ogrenciİd)
				.orElseThrow(() -> new ResourceNotFoundException("Ogrenci not found this id : :" + ogrenciİd));
		ogrenci.setName(ogrenciDetay.getName());
		ogrenci.setOgr_number(ogrenciDetay.getOgr_number());
		ogrenci.setYear(ogrenciDetay.getYear());
		return ResponseEntity.ok(this.ogrenciRepository.save(ogrenci));
	}

	/**
	 * bu method ogrenci nesnelerini veritabanında siler.
	 * localhost:8080/api/v1/ogrencisil/{id}
	 * 
	 * @param ogrenciİd
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@DeleteMapping("/ogrencisil/{id}")
	public Map<String, Boolean> deleteOgrenci(@PathVariable(value = "id") Long ogrenciİd)
			throws ResourceNotFoundException {
		Ogrenci ogrenci = ogrenciRepository.findById(ogrenciİd)
				.orElseThrow(() -> new ResourceNotFoundException("Ogrenci not found for this id :: " + ogrenciİd));

		ogrenciRepository.delete(ogrenci);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
