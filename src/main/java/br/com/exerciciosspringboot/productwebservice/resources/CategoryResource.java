package br.com.exerciciosspringboot.productwebservice.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
