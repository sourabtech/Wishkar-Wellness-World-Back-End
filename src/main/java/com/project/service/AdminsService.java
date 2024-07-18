package com.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.entity.Admins;
import com.wakefit.ecommerce.entity.Admin;

@Service
public interface AdminsService {

	
		Admins addAdminsDetail (Admins admin);
		
		Admins getAdminsDeatil(Long adminID);
		
		Admins updateAdminsDetail(Admins admin, Long adminID);


		Admins deleteAdminsDetail(Long adminID);
	    List<Admins> getAllAdmins();

}
