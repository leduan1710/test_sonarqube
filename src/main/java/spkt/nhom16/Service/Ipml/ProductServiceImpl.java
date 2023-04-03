package spkt.nhom16.Service.Ipml;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import spkt.nhom16.Entity.Category;
import spkt.nhom16.Entity.Product;
import spkt.nhom16.Entity.Store;
import spkt.nhom16.Repository.*;
import spkt.nhom16.Service.IProductService;

@Service
public class ProductServiceImpl implements IProductService{
	@Autowired
	ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}
	
	
	@Override
	public Page<Product> findBynameContaining(String name, Pageable pageable) {
		return productRepository.findBynameContaining(name, pageable);
	}

	@Override
	public Page<Product> findAll(Pageable pageable) {
		return productRepository.findAll(pageable);
	}

	@Override
	public List<Product> findAll(Sort sort) {
		return productRepository.findAll(sort);
	}

	@Override
	public long count() {
		return productRepository.count();
	}

	@Override
	public Optional<Product> findById(Long id) {
		return productRepository.findById(id);
	}

	@Override
	public List<Product> findByCategory(Category category) {
		return productRepository.findByCategory(category);
	}

	@Override
	public List<Product> findByNameContaining(String name) {
		return productRepository.findByNameContaining(name);
	}
	
	@Override
	public List<Product> findByStore(Store store) {
		return productRepository.findByStore(store);
	}
	
	@Override
	public <S extends Product> S save(S entity) {
		return productRepository.save(entity);
	}

	@Override
	public void deleteById(Long id) {
		productRepository.deleteById(id);
		
	}
}
