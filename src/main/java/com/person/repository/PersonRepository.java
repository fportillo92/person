package com.person.repository;

import com.person.model.Person;
import com.person.model.PersonIdentity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, PersonIdentity> {
    @Query("SELECT p FROM Person p WHERE p.id = ?1")
    Person findByIdPerson(Long idPerson);
}
