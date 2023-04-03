package spkt.nhom16.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spkt.nhom16.Entity.Cart;
import spkt.nhom16.Entity.Users;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{
	List<Cart> findByUser(Users user);
}