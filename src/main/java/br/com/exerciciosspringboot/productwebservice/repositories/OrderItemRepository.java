package br.com.exerciciosspringboot.productwebservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.exerciciosspringboot.productwebservice.entities.OrderItem;
import br.com.exerciciosspringboot.productwebservice.entities.pks.OrderItemPk;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPk> {

}
