package com.project.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.entity.DayCareBookings;
import com.project.exception.DayCareBookingsNotFoundException;
import com.project.repository.DayCareBookingsRepository;
import com.project.service.DayCareBookingsService;

@Service
public class DayCareBookingsServiceImpl  implements DayCareBookingsService{

	@Autowired
	DayCareBookingsRepository drepo;
	
	@Override
	public DayCareBookings addDayCareBookingsDetail(DayCareBookings daycarebookings) {
		// TODO Auto-generated method stub
		return drepo.save(daycarebookings);
	}

	@Override
	public DayCareBookings getDayCareBookingsDeatil(Long bookingID) {
		// TODO Auto-generated method stub
		return drepo.findById(bookingID).
				orElseThrow(()-> new DayCareBookingsNotFoundException("day care booking Info not correct"));  
	}

	@Override
	public DayCareBookings updateDayCareBookingsDetail(DayCareBookings daycarebookings, Long bookingID) {
		// TODO Auto-generated method stub
		DayCareBookings dayb = drepo.findById(bookingID)
                .orElseThrow(() -> new DayCareBookingsNotFoundException("day care booking with ID " + bookingID + " not found"));
		
		dayb.setBookingDateTime(dayb.getBookingDateTime());
		dayb.setBookingID(dayb.getBookingID());
		dayb.setDuration(dayb.getDuration());
		dayb.setPetID(dayb.getPetID());
		dayb.setStatus(dayb.getStatus());
		dayb.setUserID(dayb.getUserID());
		return drepo.save(dayb);
		
	}

	@Override
	public DayCareBookings deleteDayCareBookingsDetail(Long bookingID) {
		// TODO Auto-generated method stub
		DayCareBookings dayc = drepo.findById(bookingID)
                .orElseThrow(() -> new DayCareBookingsNotFoundException("day care booking  not found"));
        drepo.delete(dayc);
		return dayc;	
	}

}
