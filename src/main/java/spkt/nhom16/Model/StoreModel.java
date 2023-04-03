package spkt.nhom16.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spkt.nhom16.Entity.Users;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreModel {
	private Long storeId;
	private String name;
	private String address;
	private String phone;
	private Users user;
}
