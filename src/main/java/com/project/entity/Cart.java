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
@Table(name="cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="Cartid")
	private Long cartID;
	
	@Column(name="Userid")
	private Long userID;
	
	@Column(name="Productid")
	private Long productID; 
	
	@Column(name="Quantity",length = 20,nullable = false)
	private Long quantity;
	
	@Column(name="Totalprice",length = 20,nullable = false)
	private Long totalPrice;
	
	 @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "user_id")
	    private Users users;
	 
	 @OneToMany(fetch = FetchType.LAZY, mappedBy = "cart", cascade = CascadeType.ALL)
	    private List<Product> productlist;

	 

}
