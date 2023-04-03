package spkt.nhom16.Service.Ipml;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spkt.nhom16.Entity.Cart;
import spkt.nhom16.Entity.CartItem;
import spkt.nhom16.Entity.Product;
import spkt.nhom16.Repository.CartItemRepository;
import spkt.nhom16.Service.*;
@Service
public class CartItemServiceImpl implements ICartItemService{
	@Autowired
	CartItemRepository cartItemRepository;
	@Override
	public List<CartItem> findAll() {
		return cartItemRepository.findAll();
	}
	
	@Override
	public <S extends CartItem> S save(S entity) {
		return cartItemRepository.save(entity);
	}

	@Override
	public List<CartItem> findByCart(Cart cart) {
		return cartItemRepository.findByCart(cart);
	}

	@Override
	public List<CartItem> findByProduct(Product product) {
		return cartItemRepository.findByProduct(product);
	}

	@Override
	public void update(Long id, Integer count) {
		cartItemRepository.update(id, count);
	}
	
	@Override
	public void deleteById(Long id) {
		cartItemRepository.deleteById(id);
	}

	@Override
	public CartItem checkExist(Product product, Cart cart) {
		Optional<CartItem> optCart = cartItemRepository.checkCartItem(product, cart);
		if(optCart.isPresent()) {
			return optCart.get();
		}
		return null;
	}
}
