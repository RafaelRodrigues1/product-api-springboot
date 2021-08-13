package br.com.exerciciosspringboot.productwebservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.exerciciosspringboot.productwebservice.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{

}
