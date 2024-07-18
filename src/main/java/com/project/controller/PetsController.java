package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.project.entity.Pets;
import com.project.service.PetsService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class PetsController {

	@Autowired
	private PetsService pserv;
	
	@PostMapping("/Pets/addPetst")
	public ResponseEntity<Pets> savePets(@Valid @RequestBody Pets pets)    // response is give record to postman
	{
		return new ResponseEntity<Pets>(pserv.addPetsDetail(pets),HttpStatus.CREATED);
	}
	
	@GetMapping("/Pets/get/{petID}")
	public ResponseEntity<Pets> getPets(@PathVariable("petID")  Long petID)    // response is give record to postman
	{
		return new ResponseEntity<Pets>(pserv.getPetsDeatil(petID),HttpStatus.OK);
	}
	
	@DeleteMapping("/Pets/remove/{petID}")
	public ResponseEntity<String> deletePets(@PathVariable("petID")  Long petID)    // response is give record to postman
	{
		pserv.deletePetsDetail(petID);
		
		return new ResponseEntity<String>("Delete succefull..", HttpStatus.OK);
	}
	@PutMapping("/Pets/update/{petID}")
	public ResponseEntity<String> updatedPets(@PathVariable("petID")  Long petID,@Valid @RequestBody Pets pets)    // response is give record to postman
	{
		pserv.updatePetsDetail(pets, petID);
		
		return new ResponseEntity<String>("update succesfully..", HttpStatus.OK);
	}


}
