package spkt.nhom16.Service.Ipml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spkt.nhom16.Entity.Cart;
import spkt.nhom16.Entity.Users;
import spkt.nhom16.Repository.CartRepository;
import spkt.nhom16.Service.ICartService;

@Service
public class CartServiceImpl implements ICartService{
	@Autowired
	CartRepository cartRepository;

	@Override
	public <S extends Cart> S save(S entity) {
		return cartRepository.save(entity);
	}

	@Override
	public Cart findByUser(Users user) {
		if(cartRepository.findByUser(user).isEmpty()) {
			return null;
		}
		return cartRepository.findByUser(user).get(0);
	}

}