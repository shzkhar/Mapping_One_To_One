package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.CustomResponse;
import com.entity.PersonEntity;
import com.repo.AddressRepo;
import com.repo.PersonRepo;

@RestController
public class PersonController {

	@Autowired
	PersonRepo personRepo;
	
	@Autowired
	AddressRepo addressrepo;
	
	@PostMapping("/addperson")
	public ResponseEntity<CustomResponse<PersonEntity>> addPersonn(@RequestBody PersonEntity personEntity)
	{
		CustomResponse<PersonEntity> resp = new CustomResponse<>();
		
		addressrepo.save(personEntity.getAddressEntity());
		personRepo.save(personEntity);
		
		resp.setData(personEntity);
		resp.setMsg("Person Added Successfully");
		
		return ResponseEntity.ok(resp);
		
	}
}
