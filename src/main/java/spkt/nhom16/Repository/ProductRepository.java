package spkt.nhom16.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spkt.nhom16.Entity.Category;
import spkt.nhom16.Entity.Product;
import spkt.nhom16.Entity.Store;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	
	List<Product> findByCategory(Category category);
	Page<Product> findBynameContaining(String name, Pageable pageable);

	List<Product> findByNameContaining(String name);
	//vendor
	List<Product> findByStore(Store store);

	Optional<Product> findById(Long id);

	void deleteById(Long id) ;
	
}
