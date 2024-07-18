package com.project.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Admins;
import com.project.exception.AdminNotFoundException;
import com.project.repository.AdminsRepository;
import com.project.service.AdminsService;

@Service
public class AdminsServiceImpl  implements AdminsService{

	@Autowired
	AdminsRepository arepo;
	
	@Override
	public Admins addAdminsDetail(Admins admin) {
		// TODO Auto-generated method stub
		return arepo.save(admin);
	}

	@Override
	public Admins getAdminsDeatil(Long adminID) {
		// TODO Auto-generated method stub
		return arepo.findById(adminID).
				orElseThrow(()-> new AdminNotFoundException("admins Id not correct"));   
	}
	@Override
	public Admins updateAdminsDetail(Admins admin, Long adminID) {
		// TODO Auto-generated method stub

        Admins adminup = arepo.findById(adminID)
                .orElseThrow(() -> new AdminNotFoundException("Admin with ID " + adminID + " not found"));
       
        adminup.setAdminID(adminup.getAdminID());

        adminup.setPassword(adminup.getPassword());
        
        return arepo.save(adminup);
	
	}

	@Override
	public Admins deleteAdminsDetail(Long adminID) {
		// TODO Auto-generated method stub
		  Admins admin = arepo.findById(adminID)
	                .orElseThrow(() -> new AdminNotFoundException("admin Id not found"));
	        arepo.delete(admin);
			return admin;
	    }

	@Override
	public List<Admins> getAllAdmins() {
		// TODO Auto-generated method stub
		return arepo.findAll();
	}


}
