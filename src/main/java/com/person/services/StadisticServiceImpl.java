package com.person.services;

import com.person.model.Gender;
import com.person.model.Person;
import com.person.model.StadisticReport;
import com.person.utils.Utils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("stadisticService")
public class StadisticServiceImpl implements StadisticService {

    @Override
    public StadisticReport doReport(List<Person> persons) {
        StadisticReport stadisticReport = new StadisticReport();

        List<Person> men = persons.stream().filter(person -> person.getPersonIdentity().getGender().equals(Gender.M)).collect(Collectors.toList());
        List<Person> women = persons.stream().filter(person -> person.getPersonIdentity().getGender().equals(Gender.F)).collect(Collectors.toList());
        List<Person> argentinians = persons.stream().filter(StadisticServiceImpl::isArgentinian).collect(Collectors.toList());

        stadisticReport.setNumberOfMen(men.size());
        stadisticReport.setNumberofWomen(women.size());
        stadisticReport.setArgentiniansPercent(Utils.calculatePercent(persons.size(), argentinians.size()));

        return stadisticReport;
    }

    private static boolean isArgentinian(Person person) {
        return person.getPersonIdentity().getCountry().equalsIgnoreCase("argentina");
    }
}
