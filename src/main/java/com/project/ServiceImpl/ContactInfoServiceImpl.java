package com.project.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.entity.ContactInfo;
import com.project.exception.ContactInfoNotFoundException;
import com.project.repository.ContactInfoRepository;
import com.project.service.ContactInfoService;

@Service
public class ContactInfoServiceImpl implements ContactInfoService {

	@Autowired
	ContactInfoRepository crepo;
	
	@Override
	public ContactInfo addContactInfoDetail(ContactInfo contactinfo) {
		// TODO Auto-generated method stub
		return crepo.save(contactinfo);
	}

	@Override
	public ContactInfo getContactInfoDeatil(Long contactID) {
		// TODO Auto-generated method stub
		return crepo.findById(contactID).
				orElseThrow(()-> new ContactInfoNotFoundException("contact Info not correct"));  
		}

	@Override
	public ContactInfo updateContactInfoDetail(ContactInfo contactinfo, Long contactID) {
		// TODO Auto-generated method stub
		ContactInfo ct = crepo.findById(contactID)
                .orElseThrow(() -> new ContactInfoNotFoundException("contact with ID " + contactID + " not found"));
		
		ct.setAddress(ct.getAddress());
		ct.setContactID(ct.getContactID());
		ct.setEmail(ct.getEmail());
		ct.setPhoneNumber(ct.getPhoneNumber());
		return crepo.save(ct);
	}

	@Override
	public ContactInfo deleteContactInfoDetail(Long contactID) {
		// TODO Auto-generated method stub
		ContactInfo ct = crepo.findById(contactID)
                .orElseThrow(() -> new ContactInfoNotFoundException("contact Info not found"));
        crepo.delete(ct);
		return ct;	
	}

}
