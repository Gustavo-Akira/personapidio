package com.gustavoakira.person.personapi.utils;

import java.time.LocalDate;
import java.util.Collections;

import com.gustavoakira.person.personapi.dto.request.PersonDTO;
import com.gustavoakira.person.personapi.entity.Person;

public class PersonUtil {
	private static final String FIRST_NAME = "Rodrigo";
    private static final String LAST_NAME = "Peleias";
    private static final String CPF_NUMBER = "369.333.878-79";
    private static final long PERSON_ID = 1L;
    public static final LocalDate BIRTH_DATE = LocalDate.of(2010, 10, 1);

    public static PersonDTO createFakeDTO() {
        return PersonDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthdate("04-04-2010")
                .phones(Collections.singletonList(PhoneUtil.createFakeDTO()))
                .build();
    }

    public static Person createFakeEntity() {
        return Person.builder()
                .id(PERSON_ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthdate(BIRTH_DATE)
                .phones(Collections.singletonList(PhoneUtil.createFakeEntity()))
                .build();
    }
}
