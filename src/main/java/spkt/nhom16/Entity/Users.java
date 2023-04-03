package spkt.nhom16.Entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.Size;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "Users")
@Entity
public class Users implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId")
	private Long userId;
	
	@Size(max = 24, min = 6)
	@Column(name = "userName", columnDefinition = "char(30) not null", unique = true)
	private String userName;
	
	@Size(min = 6, max = 24)
	@Column(name = "passWord", columnDefinition = "char(30) not null")
	private String passWord;
	
	@Column(name = "fullName", columnDefinition = "nvarchar(100)")
	private String fullName;
	
	@Column(name = "email", columnDefinition = "char(100)")
	private String email;
	
	@Column(name = "phone", columnDefinition = "char(20)")
	private String phone;
	
	@Column(name = "role", columnDefinition = "char(10) not null")
	private Integer role;
	
	@Column(name = "addresses", columnDefinition = "nvarchar(200)")
	private String addresses;
	
	@OneToOne(mappedBy = "user")
	private Cart cart;
	
	@OneToOne(mappedBy = "userStore", cascade = CascadeType.ALL)
	private Store store;
}