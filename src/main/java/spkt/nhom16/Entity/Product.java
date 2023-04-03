package spkt.nhom16.Entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "Product")
public class Product implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productId")
	private Long productId;
	
	@Column(name = "name", columnDefinition = "nvarchar(100) not null")
	private String name;
	@Column(name = "urlImage", columnDefinition = "nvarchar(500)")
	private String urlImage;

	@Column(name = "price", columnDefinition = "int not null")
	private long price;
	@ManyToOne
	@JoinColumn(name = "categoryId")
	private Category category;
	
	@Column(name = "quantity", columnDefinition = "int not null")
	private long quantity;
	
	@ManyToOne
	@JoinColumn(name = "storeId")
	private Store store;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private Set<CartItem> cartItem;
	
}