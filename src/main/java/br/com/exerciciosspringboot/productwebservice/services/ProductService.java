package br.com.exerciciosspringboot.productwebservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.exerciciosspringboot.productwebservice.entities.Product;
import br.com.exerciciosspringboot.productwebservice.repositories.ProductRepository;
import br.com.exerciciosspringboot.productwebservice.services.exceptions.DatabaseException;
import br.com.exerciciosspringboot.productwebservice.services.exceptions.ResourceNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> findAllProducts() {
		return productRepository.findAll();
	}

	public Product findProductsById(int id) {
		Product product = verifyIfExists(id);
		return product;
	}
	
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	public Product updateProduct(int id, Product product) {
		verifyIfExists(id);
		product.setId(id);
		return productRepository.save(product);
	}
	
	public void deleteProduct(int id) {
		try {
			productRepository.deleteById(id);
		}catch(EmptyResultDataAccessException exception) {
			throw new ResourceNotFoundException(id);
		}catch(DataIntegrityViolationException exception) {
			throw new DatabaseException(exception.getMessage());
		}
	}
	
	private Product verifyIfExists(int id) {
		return productRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException(id));
	}
}
