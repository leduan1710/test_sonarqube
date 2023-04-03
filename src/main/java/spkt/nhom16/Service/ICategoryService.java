package spkt.nhom16.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import spkt.nhom16.Entity.Category;

public interface ICategoryService {

	void deleteAll();

	void delete(Category entity);

	void deleteById(Long id);

	long count();

	Optional<Category> findById(Long id);

	List<Category> findAll(Sort sort);

	Page<Category> findAll(Pageable pageable);

	List<Category> findAll();

	<S extends Category> S save(S entity);

	Page<Category> findBynameContaining(String name, Pageable pageable);

	List<Category> findBynameContaining(String name);

	List<Category> findByCategoryId(Long categoryId);

}
