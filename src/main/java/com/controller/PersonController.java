package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/getallperson")
	public ResponseEntity<CustomResponse<List<PersonEntity>>> getAllPersonn()
	{
		CustomResponse<List<PersonEntity>> resp = new CustomResponse<>();
		List<PersonEntity> personEntity = personRepo.findAll();
		
		resp.setData(personEntity);
		resp.setMsg("All data Fatched Successsfully");
		return ResponseEntity.ok(resp);
	}
	
	@DeleteMapping("/deletepersonbyid/{pid}")
	public ResponseEntity<CustomResponse<PersonEntity>> deletePersonByIdd(@PathVariable("pid") Integer pid)
	{
		CustomResponse<PersonEntity> resp = new CustomResponse<>();
		
		PersonEntity person = personRepo.findById(pid).get();
		personRepo.deleteById(pid);
		
		resp.setMsg("person Deleted Successfully");
		return ResponseEntity.ok(resp);
	}
	
	@PutMapping("/updateperson")
	public ResponseEntity<CustomResponse<PersonEntity>> updatPersonn(@RequestBody PersonEntity personEntity)
	{
		CustomResponse<PersonEntity> resp = new CustomResponse<>();
		
		personRepo.save(personEntity);
		resp.setData(personEntity);
		resp.setMsg("Person Update Successfully");
		return ResponseEntity.ok(resp);
	}
}
