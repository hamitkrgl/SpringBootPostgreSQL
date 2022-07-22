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
import com.springBootWithPostgreSQL.model.Ogretmen;
import com.springBootWithPostgreSQL.repository.OgretmenRepository;

@RestController
@RequestMapping("/api/v1/")
public class OgretmenController {
	@Autowired
	private OgretmenRepository ogretmenRepository;

	/**
	 * localhost:8080/api/v1/getogretmenler
	 * 
	 * @return ogretmen list
	 */
	@GetMapping("getogretmenler")
	public List<Ogretmen> getAllKonu() {
		return this.ogretmenRepository.findAll();
	}

	/**
	 * localhost:8080/api/v1/getogretmen/1
	 * 
	 * @param ogretmenid
	 * @return id ile ogretmen getiren fonksiyon
	 * @throws ResourceNotFoundException
	 */
	@GetMapping("getogretmen/{id}")
	public ResponseEntity<Ogretmen> getKonuById(@PathVariable(value = "id") long ogretmenid)
			throws ResourceNotFoundException {
		Ogretmen ogretmen = ogretmenRepository.findById(ogretmenid)
				.orElseThrow(() -> new ResourceNotFoundException("Ogretmen not found this id : :" + ogretmenid));
		return ResponseEntity.ok().body(ogretmen);
	}

	/**
	 * bu method ogretmen nesnelerini veritabanına kaydeder
	 * localhost:8080/api/v1/ogretmenkayit
	 * 
	 * @return save
	 */
	@PostMapping("ogretmenkayit")
	public Ogretmen createOgretmen(@RequestBody Ogretmen ogretmen) {
		return this.ogretmenRepository.save(ogretmen);
	}

	/**
	 * bu method ogretmen nesnelerini veritabanında günceller
	 * localhost:8080/api/v1/ogretmenupdate/{id}
	 * 
	 * @param ogretmenİd
	 * @param ogretmenDetay
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@PutMapping("ogretmenupdate/{id}")
	public ResponseEntity<Ogretmen> updateOgretmen(@PathVariable(value = "id") Long ogretmenİd,
			@Validated @RequestBody Ogretmen ogretmenDetay) throws ResourceNotFoundException {
		Ogretmen ogretmen = ogretmenRepository.findById(ogretmenİd)
				.orElseThrow(() -> new ResourceNotFoundException("Ogretmen not found this id : :" + ogretmenİd));
		ogretmen.setName(ogretmenDetay.getName());
		ogretmen.setIs_gıcık(ogretmenDetay.isIs_gıcık());
		return ResponseEntity.ok(this.ogretmenRepository.save(ogretmen));
	}

	/**
	 * bu method ogretmen nesnelerini veritabanında siler.
	 * localhost:8080/api/v1/ogretmensil/{id}
	 * 
	 * @param ogretmenİd
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@DeleteMapping("/ogretmensil/{id}")
	public Map<String, Boolean> deleteOgretmen(@PathVariable(value = "id") Long ogretmenİd)
			throws ResourceNotFoundException {
		Ogretmen ogretmen = ogretmenRepository.findById(ogretmenİd)
				.orElseThrow(() -> new ResourceNotFoundException("Ogretmen not found for this id :: " + ogretmenİd));

		ogretmenRepository.delete(ogretmen);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
