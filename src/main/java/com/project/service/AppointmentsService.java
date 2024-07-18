package com.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.entity.Appointments;
import com.project.entity.Product;

@Service
public interface AppointmentsService {


	Appointments addAppointmentsDetail (Appointments appointments);
	
	Appointments getAppointmentsById(Long appointmentID);
	
	Appointments updateAppointmentsDetail(Appointments appointments, Long appointmentID);

	//deactive changes for delete
	Appointments deleteAppointmentsDetail(Long appointmentID);
	
	List<Appointments> getAllAppointment();

}
