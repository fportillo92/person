package com.person.repository;

import com.person.model.Person;
import com.person.model.PersonIdentity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, PersonIdentity> {
}
