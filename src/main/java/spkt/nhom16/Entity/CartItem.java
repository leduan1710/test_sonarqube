package spkt.nhom16.Entity;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.DynamicUpdate;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DynamicUpdate
@Table(name = "CartItem")
public class CartItem implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cartItemId")
	private Long cartItemId;
	
	@ManyToOne
	@JoinColumn(name = "cartId")
	private Cart cart;
	
	@ManyToOne
	@JoinColumn(name = "productId")
	private Product product;
	
	private Integer count;
	
	private String status;
}