package com.project.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.entity.Pets;
import com.project.exception.PetsNotFoundException;
import com.project.repository.PetsRepository;
import com.project.service.PetsService;
@Service
public class PetsServiceImpl  implements PetsService{

	@Autowired
	PetsRepository prepo;
	@Override
	public Pets addPetsDetail(Pets pets) {
		// TODO Auto-generated method stub
		return prepo.save(pets);
	}

	@Override
	public Pets getPetsDeatil(Long petID) {
		// TODO Auto-generated method stub
		return prepo.findById(petID).
				orElseThrow(()-> new PetsNotFoundException("pets Info not correct"));
	}

	@Override
	public Pets updatePetsDetail(Pets pets, Long petID) {
		// TODO Auto-generated method stub
		Pets pet = prepo.findById(petID)
                .orElseThrow(() -> new PetsNotFoundException("pets ID " + petID + " not found"));
		
		pet.setAge(pet.getAge());
		pet.setBreed(pet.getBreed());
		pet.setPetID(pet.getPetID());
		pet.setPetName(pet.getPetName());
		pet.setUserID(pet.getUserID());
	
		return prepo.save(pet);
	}

	@Override
	public Pets deletePetsDetail(Long petID) {
		// TODO Auto-generated method stub
		Pets pet = prepo.findById(petID)
                .orElseThrow(() -> new PetsNotFoundException("pet  not found"));
        prepo.delete(pet);
		return pet;	
	}

}
