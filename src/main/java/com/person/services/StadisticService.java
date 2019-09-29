package com.person.services;

import com.person.model.Person;
import com.person.model.StadisticReport;

import java.util.List;

public interface StadisticService {

    StadisticReport doReport(List<Person> persons);
}
