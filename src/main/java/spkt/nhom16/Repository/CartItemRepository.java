package spkt.nhom16.Repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import spkt.nhom16.Entity.Cart;
import spkt.nhom16.Entity.CartItem;
import spkt.nhom16.Entity.Product;


@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long>{
	List<CartItem> findByProduct(Product product);
	
	List<CartItem> findByCart(Cart cart);
	
	@Modifying
	@Transactional
	@Query(value = "update cart_item set cart_item.count = ?2 where cart_item.cart_item_id = ?1 and cart_item.status is null", nativeQuery = true)
	void update(@Param(value ="cardId") Long id, @Param(value = "count") Integer count);
	
	@Transactional
	@Query(value = "select cart_item_id, count, cart_id, product_id, status from cart_item ci where product_id = ?1 and cart_id = ?2 and status is null", nativeQuery = true)
	Optional<CartItem> checkCartItem(@Param(value = "product_id")Product product, @Param(value = "cart_id") Cart cart);
}