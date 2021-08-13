package br.com.exerciciosspringboot.productwebservice.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
