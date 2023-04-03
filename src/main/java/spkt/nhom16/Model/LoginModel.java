package spkt.nhom16.Model;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginModel {
	@NotEmpty
	private String username;
	@NotEmpty
	private String password;
	
	private Boolean rememberMe = false;
}
