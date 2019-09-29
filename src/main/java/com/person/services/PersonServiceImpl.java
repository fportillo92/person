package com.person.services;

import com.person.exceptions.PersonException;
import com.person.model.Person;
import com.person.model.PersonIdentity;
import com.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("personService")
public class PersonServiceImpl implements PersonService{

    @Autowired
    PersonRepository personRepository;

    @Override
    public List<Person> findAll() {
        return (List<Person>) personRepository.findAll();
    }

    @Override
    public Person createPerson(Person person) throws PersonException {
        return personRepository.save(person);
    }

    @Override
    public Person readPerson(PersonIdentity personIdentity) throws PersonException {
        return personRepository.findById(personIdentity).orElseThrow(() -> new PersonException("Person not found"));
    }

    @Override
    public Person updatePerson(PersonIdentity personIdentity, Person person) throws PersonException {
        return personRepository.findById(personIdentity).map( personToUpdate -> {
            personToUpdate.setAge(person.getAge());
            personToUpdate.setEmail(person.getEmail());
            personToUpdate.setName(person.getName());
            personToUpdate.setPhone(person.getPhone());
            personToUpdate.setSurname(person.getSurname());
            return personRepository.save(personToUpdate);
        }).orElseThrow(() -> new PersonException("Person not found"));
    }

    @Override
    public void deletePerson(PersonIdentity personIdentity) throws PersonException {
        personRepository.deleteById(personIdentity);
    }
}
