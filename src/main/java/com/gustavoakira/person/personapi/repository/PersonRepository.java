package com.gustavoakira.person.personapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gustavoakira.person.personapi.entity.Person;

@Repository
public interface PersonRepository  extends JpaRepository<Person, Long>{
	
}
