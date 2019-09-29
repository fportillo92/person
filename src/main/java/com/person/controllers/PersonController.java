package com.person.controllers;

import com.person.exceptions.PersonException;
import com.person.model.Gender;
import com.person.model.Person;
import com.person.model.PersonIdentity;
import com.person.services.PersonServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonController {

    private static final Logger logger = LogManager.getLogger(PersonController.class);

    @Autowired
    PersonServiceImpl personService;

    @GetMapping(value = "/persons", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Person>> findAll() {
        return new ResponseEntity<>(personService.findAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/persons", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createPerson(@Valid @RequestBody final Person person) {
        try {
            return new ResponseEntity<>((personService.createPerson(person)), HttpStatus.CREATED);
        } catch (PersonException e) {
            logger.error("Error creating person" + e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping(value = "/persons", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updatePerson(@Valid @RequestBody final Person person) {
        try {
            return new ResponseEntity<>(personService.updatePerson(person.getPersonIdentity(), person), HttpStatus.OK);
        } catch (PersonException e) {
            logger.error("Error updating person" + e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping(value = "/persons/personIdentity", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity readPerson(@RequestParam(value = "docType") String docType,
                                     @RequestParam(value = "docNumber") String docNumber,
                                     @RequestParam(value = "country") String country,
                                     @RequestParam(value = "gender") Gender gender) {
        PersonIdentity personIdentity = new PersonIdentity(docType, docNumber, country, gender);
        try {
            return new ResponseEntity<>(personService.readPerson(personIdentity), HttpStatus.OK);
        } catch (PersonException e) {
            logger.error("Error getting person" + e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


}
