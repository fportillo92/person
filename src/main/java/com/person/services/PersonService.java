package com.person.services;

import com.person.exceptions.PersonException;
import com.person.model.Person;
import com.person.model.PersonIdentity;

import java.util.List;

public interface PersonService {

    List<Person> findAll();

    Person createPerson(Person person) throws PersonException;

    Person readPerson(PersonIdentity personIdentity) throws PersonException;

    Person updatePerson(PersonIdentity personIdentity, Person person) throws PersonException;

    void deletePerson(PersonIdentity personIdentity) throws PersonException;

    void addParent(Long idPersonParent, Long idPerson);

    String getRelationship(Long idPerson1, long idPerson2);

}
