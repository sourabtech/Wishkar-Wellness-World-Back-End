package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.ContactInfo;

public interface ContactInfoRepository extends JpaRepository<ContactInfo, Long>{

}
