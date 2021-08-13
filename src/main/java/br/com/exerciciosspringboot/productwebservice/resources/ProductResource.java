package br.com.exerciciosspringboot.productwebservice.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.exerciciosspringboot.productwebservice.entities.Product;
import br.com.exerciciosspringboot.productwebservice.services.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductResource {

	@Autowired
	private ProductService productService;

	@GetMapping
	public ResponseEntity<List<Product>> findAllProducts() {
		List<Product> list = productService.findAllProducts();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> findProductById(@PathVariable int id) {
		Product product = productService.findProductsById(id);
		return ResponseEntity.ok().body(product);
	}
}
