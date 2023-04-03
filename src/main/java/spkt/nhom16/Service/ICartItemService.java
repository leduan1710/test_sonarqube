package spkt.nhom16.Service;

import java.util.List;

import spkt.nhom16.Entity.Cart;
import spkt.nhom16.Entity.CartItem;
import spkt.nhom16.Entity.Product;

public interface ICartItemService {
	List<CartItem> findAll();

	<S extends CartItem> S save(S entity);

	List<CartItem> findByProduct(Product product);

	List<CartItem> findByCart(Cart cart);

	void update(Long id, Integer count);

	CartItem checkExist(Product product, Cart cart);

	void deleteById(Long id);

}
