package spkt.nhom16.Service.Ipml;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import spkt.nhom16.Entity.*;
import spkt.nhom16.Repository.*;
import spkt.nhom16.Service.*;

import org.springframework.stereotype.Service;
@Service
public class CategoryServiceImpl implements ICategoryService{
	@Autowired
	CategoryRepository categoryRepository;
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	@Override
	public List<Category> findBynameContaining(String name) {
		return categoryRepository.findBynameContaining(name);
	}

	@Override
	public Page<Category> findBynameContaining(String name, Pageable pageable) {
		return categoryRepository.findBynameContaining(name, pageable);
	}

	@Override
	public <S extends Category> S save(S entity) {
		return categoryRepository.save(entity);
	}

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Page<Category> findAll(Pageable pageable) {
		return categoryRepository.findAll(pageable);
	}

	@Override
	public List<Category> findAll(Sort sort) {
		return categoryRepository.findAll(sort);
	}

	@Override
	public Optional<Category> findById(Long id) {
		return categoryRepository.findById(id);
	}

	@Override
	public long count() {
		return categoryRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		categoryRepository.deleteById(id);
	}

	@Override
	public void delete(Category entity) {
		categoryRepository.delete(entity);
	}

	@Override
	public void deleteAll() {
		categoryRepository.deleteAll();
	}
	@Override
	public List<Category> findByCategoryId(Long categoryId) {
		return categoryRepository.findByCategoryId(categoryId);
	}
	
	
}
