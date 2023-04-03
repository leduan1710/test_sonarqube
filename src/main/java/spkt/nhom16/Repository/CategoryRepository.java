package spkt.nhom16.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spkt.nhom16.Entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
	List<Category> findBynameContaining(String name);
	Page<Category> findBynameContaining(String name, Pageable pageable);
	List<Category> findByCategoryId(Long categoryId);

}
