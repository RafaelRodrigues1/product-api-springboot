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

import br.com.exerciciosspringboot.productwebservice.entities.Order;
import br.com.exerciciosspringboot.productwebservice.services.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderResource {

	@Autowired
	private OrderService orderService;
	
	@GetMapping
	public ResponseEntity<List<Order>> findAllOrders(){
		List<Order> list = orderService.findAllOrders();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Order> findOrderById(@PathVariable int id){
		Order order = orderService.findOrderById(id);
		return ResponseEntity.ok().body(order);
	}
	
	@PostMapping
	public ResponseEntity<Order> saveUser(@RequestBody @Valid Order order){
		Order savedOrder = orderService.saveOrder(order);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedOrder.getId())
				.toUri();
		return ResponseEntity.created(uri).body(savedOrder);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Order> updateUser(@PathVariable int id, 
			@RequestBody @Valid Order order){
		Order updatedOrder = orderService.updateOrder(id, order);
		return ResponseEntity.ok().body(updatedOrder);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable int id){
		orderService.deleteOrder(id);
		return ResponseEntity.noContent().build();
	}
}
