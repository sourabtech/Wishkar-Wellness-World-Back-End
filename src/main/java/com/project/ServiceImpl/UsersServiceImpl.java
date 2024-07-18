package com.project.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.entity.Users;
import com.project.exception.UsersNotFoundException;
import com.project.repository.UsersRepository;
import com.project.service.UsersService;
import com.wakefit.ecommerce.entity.User;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	UsersRepository urepo;
	@Override
	public Users CreatUsersDetail(Users users) {
		// TODO Auto-generated method stub
		return urepo.save(users);
	}

	@Override
	public Users getUsersDeatil(Long userID) {
		// TODO Auto-generated method stub
		return urepo.findById(userID).
				orElseThrow(()-> new UsersNotFoundException("users Info not correct"));
	}

	@Override
	public Users updateUsersDetail(Users users, Long userID) {
		// TODO Auto-generated method stub
		
		Users user = urepo.findById(userID)
                .orElseThrow(() -> new UsersNotFoundException("user ID " + userID + " not found"));
		
		user.setEmail(user.getEmail());
		user.setPassword(user.getPassword());
		user.setRegistrationdate(user.getRegistrationdate());
		user.setUserID(user.getUserID());
		user.setUsername(user.getUsername());
		return urepo.save(user);
	}

	@Override
	public Users deleteUsersDetail(Long userID) {
		// TODO Auto-generated method stub
		Users user = urepo.findById(userID)
                .orElseThrow(() -> new UsersNotFoundException("users  not found"));
        urepo.delete(user);
		return user;	
	}

	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return urepo.findAll();
	}

}
