package com.project.service;

import org.springframework.stereotype.Service;
import com.project.entity.ContactInfo;

@Service
public interface ContactInfoService {
	

	ContactInfo addContactInfoDetail (ContactInfo contactinfo);
	
	ContactInfo getContactInfoDeatil(Long contactID);
	
	ContactInfo updateContactInfoDetail(ContactInfo contactinfo, Long contactID);


	ContactInfo deleteContactInfoDetail(Long contactID);

}
