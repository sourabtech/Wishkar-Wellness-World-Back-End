package com.project.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="pets")
public class Pets {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="Petid")
	private Long petID;
	
	@Column(name="Userid")
	private Long userID;
	
	@Column(name="Petname",length = 10,nullable = false)
	private String petName;
	
	@Column(name="Breed",length = 10,nullable = false)
	private String	breed;
	
	@Column(name="Age",length = 10,nullable = false)
	private Long age;
	
	 @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "user_id")
	    private Users users;
}