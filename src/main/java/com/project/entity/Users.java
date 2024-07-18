package com.project.entity;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name="users")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  
	@Column(name="Userid")
	private Long userID;
	
	@Column(name="Username",length = 10,nullable = false)
   private String username;
	
	@Column(name="Email",length = 10,nullable = false)
   private String email;
	
	@Column(name="Password",length = 10,nullable = false)
	private String password;
	
	@Column(name="Registrationdate",length = 10,nullable = false)
	private String registrationdate;
	
	
	 @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "user_id")
	    private Admins admins;
	 
	 @OneToMany(fetch = FetchType.LAZY, mappedBy = "users", cascade = CascadeType.ALL)
	    private List<Appointments> appointmentlist;
	 
	
	 
	 @OneToMany(fetch = FetchType.LAZY, mappedBy = "users", cascade = CascadeType.ALL)
	    private List<Cart> cartlist;
	 
	 @OneToMany(fetch = FetchType.LAZY, mappedBy = "users", cascade = CascadeType.ALL)
	    private List<DayCareBookings> daycarebookingslist;
	 
	 @OneToMany(fetch = FetchType.LAZY, mappedBy = "users", cascade = CascadeType.ALL)
	    private List<Pets> petslist;
	 
	 @OneToMany(fetch = FetchType.LAZY, mappedBy = "users", cascade = CascadeType.ALL)
	    private List<Product> productlist;
	 
	 @OneToMany(fetch = FetchType.LAZY, mappedBy = "users", cascade = CascadeType.ALL)
	    private List<Payment> paymentlist;
	 
}








