package spkt.nhom16.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
	private Long userId;
	private String userName;
	private String passWord;
	private String fullName;
	private String email;
	private String phone;
	private Integer role;
	private String addresses;
}
