package com.person.controllers;

import com.person.model.StadisticReport;
import com.person.services.PersonService;
import com.person.services.StadisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/estadisticas")
public class StadisticController {

    @Autowired
    PersonService personService;

    @Autowired
    StadisticService stadisticService;

    private StadisticReport stadisticReport;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getReport() {
        return new ResponseEntity<>(stadisticReport, HttpStatus.OK);
    }

    @Scheduled(fixedRate = 10000)
    public void getUpdates(){
        this.stadisticReport = stadisticService.doReport(personService.findAll());
    }
}
