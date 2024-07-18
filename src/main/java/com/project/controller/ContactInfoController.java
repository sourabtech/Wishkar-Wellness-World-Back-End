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
import com.project.entity.ContactInfo;
import com.project.service.ContactInfoService;
import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class ContactInfoController {
	
	@Autowired
	private ContactInfoService cserv;
	
	@PostMapping("/ContactInfo/addContactInfo")
	public ResponseEntity<ContactInfo> saveContactInfo(@Valid @RequestBody ContactInfo contactinfo)    // response is give record to postman
	{
		return new ResponseEntity<ContactInfo>(cserv.addContactInfoDetail(contactinfo),HttpStatus.CREATED);
	}
	
	@GetMapping("/ContactInfo/get/{contactID}")
	public ResponseEntity<ContactInfo> getContactInfo(@PathVariable("contactID")  Long contactID)    // response is give record to postman
	{
		return new ResponseEntity<ContactInfo>(cserv.getContactInfoDeatil(contactID),HttpStatus.OK);
	}
	
	@DeleteMapping("/ContactInfo/remove/{contactID}")
	public ResponseEntity<String> deleteContactInfo(@PathVariable("contactID")  Long contactID)    // response is give record to postman
	{
		cserv.deleteContactInfoDetail(contactID);
		
		return new ResponseEntity<String>("Delete succefull..", HttpStatus.OK);
	}
	@PutMapping("/ContactInfo/update/{contactID}")
	public ResponseEntity<String> updatedContactInfo(@PathVariable("contactID")  Long contactID,@Valid @RequestBody ContactInfo contactinfo)    // response is give record to postman
	{
		cserv.updateContactInfoDetail(contactinfo, contactID);
		
		return new ResponseEntity<String>("update succesfully..", HttpStatus.OK);
	}


}
