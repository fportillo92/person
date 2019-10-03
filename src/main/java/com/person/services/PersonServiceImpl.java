package com.person.services;

import com.person.exceptions.PersonException;
import com.person.model.Person;
import com.person.model.PersonIdentity;
import com.person.repository.PersonRepository;
import com.person.utils.Utils;
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

    @Override
    public void addParent(Long idPersonParent, Long idPerson) {
        Person parent = personRepository.findByIdPerson(idPersonParent);
        Person son = personRepository.findByIdPerson(idPerson);

        if (parent != null && son != null) {
            son.setPerson(parent);
            personRepository.save(son);
        }

    }

    @Override
    public String getRelationship(Long idPerson1, long idPerson2) {
        Person person1 = personRepository.findByIdPerson(idPerson1);
        Person person2 = personRepository.findByIdPerson(idPerson2);

        if (person1 != null && person2 != null) {
            if (isBrotherOrSister(person1, person2)) {
                return "Herman@";
            }
            if (isCousin(person1, person2)) {
                return "Prim@";
            }
            if (isUncleOrAunt(person1, person2)) {
                return "Ti@";
            }
        }

        return "No existe relacion";
    }

    /*
        Si los padres son la misma persona, entonces son herman@s
     */
    private boolean isBrotherOrSister(Person person1, Person person2) {
        Person parent1 = person1.getPerson();
        Person parent2 = person2.getPerson();

        if (Utils.comparePersons(parent1, parent2)) {
            return true;
        } else {
            return false;
        }
    }


    /*
        Si el/la abuel@ de una persona es la misma que el padre/madre de la otra entonces es el/la ti@
     */
    private boolean isUncleOrAunt(Person person1, Person person2) {
        Person parent1 = person1.getPerson();
        Person parent2 = person2.getPerson();
        Person grandParent = parent2.getPerson();

        if (Utils.comparePersons(grandParent, parent1)) {
            return true;
        } else {
            return false;
        }
    }

    /*
        Si los padres de las dos personas son herman@s
     */
    private boolean isCousin(Person person1, Person person2) {
        Person parent1 = person1.getPerson();
        Person parent2 = person2.getPerson();

        if (isBrotherOrSister(parent1, parent2)) {
            return true;
        } else {
            return false;
        }
    }


}
