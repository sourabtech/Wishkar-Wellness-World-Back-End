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

import com.project.entity.Appointments;
import com.project.entity.Product;
import com.project.service.AppointmentsService;

import jakarta.validation.Valid;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v2/")
public class AppointmentsController {
	
	
	@Autowired
	private AppointmentsService aserv;
	
	 @GetMapping("/appointment")
	    public List<Appointments> getAllAppointment() {
	        return aserv.getAllAppointment();
	    }
	
	@PostMapping("/appointment")
	public ResponseEntity<Appointments> saveAppointments(@Valid @RequestBody Appointments appointments)    // response is give record to postman
	{
		return new ResponseEntity<Appointments>(aserv.addAppointmentsDetail(appointments),HttpStatus.CREATED);
	}
	
	@GetMapping("/appointment/{appointmentID}")
	public ResponseEntity<Appointments> getAppointmentsById(@PathVariable("appointmentID")  Long appointmentID)    // response is give record to postman
	{
		return new ResponseEntity<Appointments>(aserv.getAppointmentsById(appointmentID),HttpStatus.OK);
	}
	
	@DeleteMapping("/appointment/{appointmentID}")
	public ResponseEntity<String> deleteAppointments(@PathVariable("appointmentID")  Long appointmentID)    // response is give record to postman
	{
		aserv.deleteAppointmentsDetail(appointmentID);
		
		return new ResponseEntity<String>("Delete succefull..", HttpStatus.OK);
	}
	@PutMapping("/appointment/{appointmentID}")
	public ResponseEntity<String> updatedAppointments(@PathVariable("appointmentID")  Long appointmentID,@Valid @RequestBody Appointments appointments)    // response is give record to postman
	{
		aserv.updateAppointmentsDetail(appointments, appointmentID);
		
		return new ResponseEntity<String>("update succesfully..", HttpStatus.OK);
	}
	
	
	

}
