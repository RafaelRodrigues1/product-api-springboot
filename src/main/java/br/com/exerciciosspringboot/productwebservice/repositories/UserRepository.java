package br.com.exerciciosspringboot.productwebservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.exerciciosspringboot.productwebservice.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
