package br.com.exerciciosspringboot.productwebservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.exerciciosspringboot.productwebservice.entities.Order;
import br.com.exerciciosspringboot.productwebservice.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	public List<Order> findAllOrders(){
		return orderRepository.findAll();
	}
	
	public Order findOrderById(int id) {
		Optional<Order> optional = orderRepository.findById(id);
		return optional.get();
	}
}
