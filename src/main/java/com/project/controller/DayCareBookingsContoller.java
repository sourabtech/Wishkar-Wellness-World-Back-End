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
import com.project.entity.DayCareBookings;
import com.project.service.DayCareBookingsService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class DayCareBookingsContoller {

	@Autowired
	private DayCareBookingsService dserv;
	
	@PostMapping("/DayCareBookings/addDayCareBookings")
	public ResponseEntity<DayCareBookings> saveDayCareBookings(@Valid @RequestBody DayCareBookings daycarebookings)    // response is give record to postman
	{
		return new ResponseEntity<DayCareBookings>(dserv.addDayCareBookingsDetail(daycarebookings),HttpStatus.CREATED);
	}
	
	@GetMapping("/DayCareBookings/get/{bookingID}")
	public ResponseEntity<DayCareBookings> getDayCareBookings(@PathVariable("bookingID")  Long bookingID)    // response is give record to postman
	{
		return new ResponseEntity<DayCareBookings>(dserv.getDayCareBookingsDeatil(bookingID),HttpStatus.OK);
	}
	
	@DeleteMapping("/DayCareBookings/remove/{bookingID}")
	public ResponseEntity<String> deleteDayCareBookings(@PathVariable("bookingID")  Long bookingID)    // response is give record to postman
	{
		dserv.deleteDayCareBookingsDetail(bookingID);
		
		return new ResponseEntity<String>("Delete succefull..", HttpStatus.OK);
	}
	@PutMapping("/DayCareBookings/update/{bookingID}")
	public ResponseEntity<String> updatedContactInfo(@PathVariable("bookingID")  Long bookingID,@Valid @RequestBody DayCareBookings daycarebookings)    // response is give record to postman
	{
		dserv.updateDayCareBookingsDetail(daycarebookings, bookingID);
		
		return new ResponseEntity<String>("update succesfully..", HttpStatus.OK);
	}


}
