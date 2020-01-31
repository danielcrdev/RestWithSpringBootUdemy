package br.com.danielcrdev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.danielcrdev.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}