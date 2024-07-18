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
@Table(name="daycarebookings")
public class DayCareBookings {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="Bookingid")
	private Long bookingID; 
	
	@Column(name="Userid")
	private Long userID; 
	
	@Column(name="Petid")
	private Long petID; 
	
	@Column(name="Bookingdatetime",length = 10,nullable = false)
	private String bookingDateTime; 
	
	@Column(name="Duration",length = 10,nullable = false)
	private String	duration;
	
	@Column(name="Status",length = 10,nullable = false)
	private String status; 
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Users users;
}
