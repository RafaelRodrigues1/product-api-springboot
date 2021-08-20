package br.com.exerciciosspringboot.productwebservice.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping
	public ResponseEntity<Product> saveProduct(@RequestBody @Valid Product product){
		Product savedProduct = productService.saveProduct(product);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedProduct.getId())
				.toUri();
		return ResponseEntity.created(uri).body(savedProduct);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable int id, 
			@RequestBody @Valid Product product){
		Product updatedProduct = productService.updateProduct(id, product);
		return ResponseEntity.ok().body(updatedProduct);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable int id){
		productService.deleteProduct(id);
		return ResponseEntity.noContent().build();
	}
}
