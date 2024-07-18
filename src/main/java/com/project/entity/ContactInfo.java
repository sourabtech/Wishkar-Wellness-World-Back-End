package com.project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name="contactinfo")
public class ContactInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="Contactid")
	private Long contactID;
	
	@Column(name="Phonenumber",length = 10,nullable = false)
	private String phoneNumber; 
	
	@Column(name="Email",length = 30,nullable = false)
	private String email;
	
	
	@Column(name="Address",length = 70,nullable = false)
	private String address;
}
