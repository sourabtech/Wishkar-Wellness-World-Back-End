package com.project.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.entity.Appointments;
import com.project.exception.AppointmentNotFoundException;
import com.project.repository.AppointmentRepository;
import com.project.service.AppointmentsService;

@Service
public class AppointmentsServiceImpl implements AppointmentsService {

	@Autowired
	private AppointmentRepository arepo;
	
	@Override
	public Appointments addAppointmentsDetail(Appointments appointments) {
		// TODO Auto-generated method stub
		return arepo.save(appointments);
	}

	@Override
	public Appointments getAppointmentsById(Long appointmentID) {
		// TODO Auto-generated method stub
		return arepo.findById(appointmentID).
				orElseThrow(()-> new AppointmentNotFoundException("appointment Id not correct"));  
	}

	@Override
	public Appointments updateAppointmentsDetail(Appointments appointments, Long appointmentID) {
		// TODO Auto-generated method stub
		Appointments app = arepo.findById(appointmentID)
	                .orElseThrow(() -> new AppointmentNotFoundException("appointment with ID " + appointmentID + " not found"));
		app.setAppointmentDateTime(app.getAppointmentDateTime());
		app.setAppointmentID(app.getAppointmentID());
		app.setStatus(app.getStatus());
		app.setUserID(app.getUserID());
		return arepo.save(app);
	}

	@Override
	public Appointments deleteAppointmentsDetail(Long appointmentID) {
		// TODO Auto-generated method stub
		Appointments app = arepo.findById(appointmentID)
                .orElseThrow(() -> new AppointmentNotFoundException("appointment Id not found"));
        arepo.delete(app);
		return app;
	}

	@Override
	public List<Appointments> getAllAppointment() {
		// TODO Auto-generated method stub
		return arepo.findAll();
	}

}
