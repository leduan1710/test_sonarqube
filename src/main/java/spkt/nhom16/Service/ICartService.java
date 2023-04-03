package spkt.nhom16.Service;

import spkt.nhom16.Entity.Cart;
import spkt.nhom16.Entity.Users;

public interface ICartService {

	<S extends Cart> S save(S entity);

	Cart findByUser(Users user);

}
