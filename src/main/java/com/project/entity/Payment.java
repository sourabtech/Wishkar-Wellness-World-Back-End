package com.project.entity;




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
@Table(name="payment")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="Paymentid")
	private Long paymentID;
	
	@Column(name="Userid")
	private Long userID ;
	
	@Column(name="Amount",length = 10,nullable = false)
	private Long amount;
	
	@Column(name="Paymentdatetime",length = 20,nullable = false)
	private String paymentDateTime;
	
	@Column(name="Paymentmethod",length = 10,nullable = false)
	private String paymentMethod;
	
	 @ManyToOne
	    @JoinColumn(name = "user_id")
	    private Users users;
	
}
