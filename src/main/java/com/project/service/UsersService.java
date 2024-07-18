package com.project.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.project.entity.Users;
import com.wakefit.ecommerce.entity.User;

@Service
public interface UsersService {

	 Users CreatUsersDetail (Users users);
		
	 Users getUsersDeatil(Long userID);
	
	 Users updateUsersDetail(Users users, Long userID);

	 Users deleteUsersDetail(Long userID);
	 
	 List<Users> getAllUsers();
	

}
