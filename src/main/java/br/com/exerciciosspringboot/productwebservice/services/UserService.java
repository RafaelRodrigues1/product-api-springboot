package br.com.exerciciosspringboot.productwebservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.exerciciosspringboot.productwebservice.entities.User;
import br.com.exerciciosspringboot.productwebservice.repositories.UserRepository;
import br.com.exerciciosspringboot.productwebservice.services.exceptions.DatabaseException;
import br.com.exerciciosspringboot.productwebservice.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	public User findUserById(int id) {
		return verifyIfExists(id);
	}
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	public User updateUser(int id, User user) {
		verifyIfExists(id);
		user.setId(id);
		return userRepository.save(user);	
	}
	
	public void deleteUser(int id) {
		try {
			userRepository.deleteById(id);
		}catch(EmptyResultDataAccessException exception) {
			throw new ResourceNotFoundException(id);
		}catch(DataIntegrityViolationException exception) {
			throw new DatabaseException(exception.getMessage());
		}
	}
	
	private User verifyIfExists(int id) {
		return userRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException(id));
	}
}
