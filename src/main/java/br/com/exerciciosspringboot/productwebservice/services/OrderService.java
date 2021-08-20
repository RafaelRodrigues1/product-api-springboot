package br.com.exerciciosspringboot.productwebservice.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.exerciciosspringboot.productwebservice.entities.Order;
import br.com.exerciciosspringboot.productwebservice.repositories.OrderRepository;
import br.com.exerciciosspringboot.productwebservice.services.exceptions.DatabaseException;
import br.com.exerciciosspringboot.productwebservice.services.exceptions.ResourceNotFoundException;

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

	public Order saveOrder(@Valid Order order) {
		return orderRepository.save(order);
	}

	public Order updateOrder(int id, @Valid Order order) {
		verifyIfExist(id);
		order.setId(id);
		return orderRepository.save(order);
	}

	public void deleteOrder(int id) {
		try {
			orderRepository.deleteById(id);
		}catch(EmptyResultDataAccessException exception) {
			throw new ResourceNotFoundException(id);
		}catch(DataIntegrityViolationException exception) {
			throw new DatabaseException(exception.getMessage());
		}
	}
	
	private Order verifyIfExist(int id) {
		return orderRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException(id));
	}
}
