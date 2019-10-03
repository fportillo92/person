package com.person.controllers;

import com.person.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/api/relaciones")
@RestController
public class RelationshipController {

    @Autowired
    PersonService personService;

    @GetMapping(value = "/{id1}/{id2}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getRelationship(@PathVariable long id1, @PathVariable long id2) {
        return new ResponseEntity<String>(personService.getRelationship(id1, id2), HttpStatus.OK);
    }
}
