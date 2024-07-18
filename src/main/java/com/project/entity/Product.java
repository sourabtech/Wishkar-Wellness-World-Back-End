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
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="Productid")
	private Long productID;
	
	@Column(name="Productname",length = 10,nullable = false)
	private String productName;
	
	@Column(name="Description",length = 10,nullable = false)
	private String	description;
	
	@Column(name="Price",length = 10,nullable = false)
	private Long price;
	
	@Column(name="Quanityavailable",length = 10,nullable = false)
	private Long quantityAvailable;
	
	@Column(name="Category",length = 10,nullable = false)
	private String category;
	
	//many to one cart relation & admin 
	 @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "cart")
	    private Cart cart;
	  
	  @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "user_id")
	    private Users users;
	 
}
