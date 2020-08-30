package com.gustavoakira.person.personapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gustavoakira.person.personapi.dto.request.PersonDTO;
import com.gustavoakira.person.personapi.dto.response.MessageResponseDTO;
import com.gustavoakira.person.personapi.exception.PersonNotFoundException;
import com.gustavoakira.person.personapi.service.PersonService;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO savePerson(@RequestBody @Valid PersonDTO person) {
		return personService.createPerson(person);
	}
	
	@GetMapping
	public List<PersonDTO> getPeople(){
		return personService.listAll();
	}
	
	@GetMapping("/{id}")
	public PersonDTO getPerson(@PathVariable("id") Long id) throws PersonNotFoundException {
		return personService.findById(id);	
	}
	@PutMapping("/{id}")
	public MessageResponseDTO updateById(@PathVariable("id") Long id, @RequestBody PersonDTO personDTO) throws PersonNotFoundException {
		return personService.updateById(id, personDTO);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletePerson(@PathVariable("id") Long id) throws PersonNotFoundException {
		personService.deleteById(id);
	}
}
