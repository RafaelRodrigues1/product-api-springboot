package br.com.exerciciosspringboot.productwebservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.exerciciosspringboot.productwebservice.entities.Category;
import br.com.exerciciosspringboot.productwebservice.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> findAllCategories(){
		return categoryRepository.findAll();
	}
	
	public Category findCategoryById(int id) {
		Optional<Category> optional = categoryRepository.findById(id);
		return optional.get();
	}
}
