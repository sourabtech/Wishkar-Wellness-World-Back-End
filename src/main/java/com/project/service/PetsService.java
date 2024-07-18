package com.project.service;

import org.springframework.stereotype.Service;
import com.project.entity.Pets;

@Service
public interface PetsService {

	 Pets addPetsDetail (Pets pets);
		
	 Pets getPetsDeatil(Long petID);
	
	 Pets updatePetsDetail(Pets pets, Long petID);

	 Pets deletePetsDetail(Long petID);
}
