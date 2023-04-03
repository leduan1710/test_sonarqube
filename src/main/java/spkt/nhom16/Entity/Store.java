package spkt.nhom16.Entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name = "Store")
public class Store implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "storeId")
	private Long storeId;
	
	@Column(name = "name", columnDefinition = "nvarchar(100) not null", unique = true)
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "address", columnDefinition = "nvarchar(100) ", unique = true)
	private String address;
	
	@Column(name = "phone", columnDefinition = "nvarchar(100) ", unique = true)
	private String phone;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	private Users userStore;
	 	 	
	@OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
	private Set<Product> product;
}
