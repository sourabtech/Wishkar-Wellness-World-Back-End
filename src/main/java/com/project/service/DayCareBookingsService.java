package com.project.service;

import org.springframework.stereotype.Service;

import com.project.entity.DayCareBookings;

@Service
public interface DayCareBookingsService {
	

	DayCareBookings addDayCareBookingsDetail (DayCareBookings daycarebookings);
	
	DayCareBookings getDayCareBookingsDeatil(Long bookingID);
	
	DayCareBookings updateDayCareBookingsDetail(DayCareBookings daycarebookings, Long bookingID);

	DayCareBookings deleteDayCareBookingsDetail(Long bookingID);

}
