package br.com.exerciciosspringboot.productwebservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.exerciciosspringboot.productwebservice.entities.Category;
import br.com.exerciciosspringboot.productwebservice.repositories.CategoryRepository;
import br.com.exerciciosspringboot.productwebservice.services.exceptions.DatabaseException;
import br.com.exerciciosspringboot.productwebservice.services.exceptions.ResourceNotFoundException;

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
	
	public Category saveCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	public Category updateCategory(int id, Category category) {
		verifyIfExists(id);
		category.setId(id);
		return categoryRepository.save(category);	
	}
	
	public void deleteCategory(int id) {
		try {
			categoryRepository.deleteById(id);
		}catch(EmptyResultDataAccessException exception) {
			throw new ResourceNotFoundException(id);
		}catch(DataIntegrityViolationException exception) {
			throw new DatabaseException(exception.getMessage());
		}
	}
	
	private Category verifyIfExists(int id) {
		return categoryRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException(id));
	}
}
