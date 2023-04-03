package spkt.nhom16.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import spkt.nhom16.Entity.Category;
import spkt.nhom16.Entity.Product;
import spkt.nhom16.Entity.Store;

public interface IProductService {

	List<Product> findAll();
	List<Product> findByCategory(Category category);
	Optional<Product> findById(Long id);
	List<Product> findByNameContaining(String name);
	List<Product> findByStore(Store store);
	<S extends Product> S save(S entity);
	void deleteById(Long id);
	long count();
	List<Product> findAll(Sort sort);
	Page<Product> findAll(Pageable pageable);
	Page<Product> findBynameContaining(String name, Pageable pageable);
}