package com.gustavoakira.person.personapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavoakira.person.personapi.dto.MessageResponseDTO;
import com.gustavoakira.person.personapi.entity.Person;
import com.gustavoakira.person.personapi.repository.PersonRepository;

@Service
public class PersonService {
	@Autowired
	private PersonRepository personRepository;
	
	public MessageResponseDTO createPerson(Person person) {
		Person saved = personRepository.save(person);
		return MessageResponseDTO.builder().message("Created person with ID: "+ saved.getId()).build();
	}
}
