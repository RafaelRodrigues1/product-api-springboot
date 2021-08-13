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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.exerciciosspringboot.productwebservice.entities.User;
import br.com.exerciciosspringboot.productwebservice.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserResource {

	@Autowired
	private UserService userService;
	
	@GetMapping
	public @ResponseBody ResponseEntity<List<User>> findAllUsers(){
		List<User> list = userService.findAllUsers();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<User> findUserById(@PathVariable int id){
		User user = userService.findUserById(id);
		return ResponseEntity.ok().body(user);
	}
	
	@PostMapping
//	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<User> saveUser(@RequestBody @Valid User user){
		User savedUser = userService.saveUser(user);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(uri).body(savedUser);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(
			@PathVariable int id, 
			@RequestBody @Valid User user){
		User updatedUser = userService.updateUser(id, user);
		return ResponseEntity.ok().body(updatedUser);
	}
	
	@DeleteMapping("/{id}")
//	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> deleteUser(@PathVariable int id){
		userService.deleteUser(id);
		return ResponseEntity.noContent().build();
	}
}
