package com.gustavoakira.person.personapi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavoakira.person.personapi.dto.request.PersonDTO;
import com.gustavoakira.person.personapi.dto.response.MessageResponseDTO;
import com.gustavoakira.person.personapi.entity.Person;
import com.gustavoakira.person.personapi.exception.PersonNotFoundException;
import com.gustavoakira.person.personapi.mapper.PersonMapper;
import com.gustavoakira.person.personapi.repository.PersonRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

	private final PersonMapper personMapper = PersonMapper.INSTANCE;
	
	private PersonRepository personRepository;
	
	public MessageResponseDTO createPerson(PersonDTO personDTO) {
		Person toSave = personMapper.toModel(personDTO);
		Person saved = personRepository.save(toSave);
		return createMessageResponse(saved.getId(), "Created person with Id: ");
	}
	
	public List<PersonDTO> listAll(){
		List<Person> all = personRepository.findAll();
		return all.stream().map(personMapper::toDTO).collect(Collectors.toList());
	}
	
	public PersonDTO findById(Long id) throws PersonNotFoundException {
		Person person = verifyExistenceOfPerson(id);
		return personMapper.toDTO(person);
	}

	public void deleteById(Long id) throws PersonNotFoundException {
		verifyExistenceOfPerson(id);
		personRepository.deleteById(id);
	}
	
	public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
		verifyExistenceOfPerson(id);
		Person toSave = personMapper.toModel(personDTO);
		Person saved = personRepository.save(toSave);
		return createMessageResponse(saved.getId(), "Updated person with Id: ");
	}
	
	private Person verifyExistenceOfPerson(Long id) throws PersonNotFoundException {
		return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
	}

	private MessageResponseDTO createMessageResponse(Long id,String s) {
		return MessageResponseDTO.builder().message(s + id).build();
	}
}
