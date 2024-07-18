package com.project.controller;

import java.util.List;

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
import com.project.entity.Admins;
import com.project.service.AdminsService;
import com.wakefit.ecommerce.entity.Admin;

import jakarta.validation.Valid;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class AdminsController {
		
	@Autowired
	private AdminsService aserv;
	
	@PostMapping("/Admins/addAdmins")
	public ResponseEntity<Admins> saveAdmins(@Valid @RequestBody Admins admin)    // response is give record to postman
	{
		return new ResponseEntity<Admins>(aserv.addAdminsDetail(admin),HttpStatus.CREATED);
	}
	
	@GetMapping("/Admins/get/{adminID}")
	public ResponseEntity<Admins> getAdmins(@PathVariable("adminID")  Long adminID)    // response is give record to postman
	{
		return new ResponseEntity<Admins>(aserv.getAdminsDeatil(adminID),HttpStatus.OK);
	}
	
	@DeleteMapping("/Admins/remove/{adminID}")
	public ResponseEntity<String> deleteAdmins(@PathVariable("adminID")  Long adminID)    // response is give record to postman
	{
		aserv.deleteAdminsDetail(adminID);
		
		return new ResponseEntity<String>("Delete succefull..", HttpStatus.OK);
	}
	@PutMapping("/Admins/update/{adminID}")
	public ResponseEntity<String> updatedAdmins(@PathVariable("adminID")  Long adminID,@Valid @RequestBody Admins admin)    // response is give record to postman
	{
		aserv.updateAdminsDetail(admin, adminID);
		
		return new ResponseEntity<String>("update succesfully..", HttpStatus.OK);
	}
	 @GetMapping("/Admin/getAllAdmins")
	    public ResponseEntity<List<Admins>> getAllAdmins() {
	        List<Admins> admins = aserv.getAllAdmins();
	        return new ResponseEntity<>(admins, HttpStatus.OK);
	
	 }
}
