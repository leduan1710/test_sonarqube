package spkt.nhom16.Entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name = "Cart")
public class Cart implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cartId")
	@ToString.Exclude
	private Long cartId;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	private Users user;
	
	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
	private Set<CartItem> cartItem;
}
