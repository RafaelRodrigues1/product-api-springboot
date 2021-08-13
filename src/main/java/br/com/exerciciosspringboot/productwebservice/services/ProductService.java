package br.com.exerciciosspringboot.productwebservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.exerciciosspringboot.productwebservice.entities.Product;
import br.com.exerciciosspringboot.productwebservice.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> findAllProducts() {
		return productRepository.findAll();
	}

	public Product findProductsById(int id) {
		Optional<Product> optional = productRepository.findById(id);
		return optional.get();
	}
}
