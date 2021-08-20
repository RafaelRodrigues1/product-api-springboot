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

import br.com.exerciciosspringboot.productwebservice.entities.Category;
import br.com.exerciciosspringboot.productwebservice.services.CategoryService;

@RestController
@RequestMapping("api/categories")
public class CategoryResource {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public ResponseEntity<List<Category>> findAllCategories(){
		List<Category> list = categoryService.findAllCategories();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Category> findCategoryById(@PathVariable int id){
		Category category = categoryService.findCategoryById(id);
		return ResponseEntity.ok().body(category);
	}
	
	@PostMapping
	public ResponseEntity<Category> saveUser(@RequestBody @Valid Category category){
		Category savedCategory = categoryService.saveCategory(category);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedCategory.getId())
				.toUri();
		return ResponseEntity.created(uri).body(savedCategory);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Category> updateUser(@PathVariable int id, 
			@RequestBody @Valid Category category){
		Category updatedCategory = categoryService.updateCategory(id, category);
		return ResponseEntity.ok().body(updatedCategory);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable int id){
		categoryService.deleteCategory(id);
		return ResponseEntity.noContent().build();
	}
}
