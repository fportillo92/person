package com.person.utils;

import com.person.model.Person;

public class Utils {

    public static float calculatePercent(int total, int cant) {
        if(total != 0) {
            return (cant * 100)/total;
        } else {
            return 0;
        }
    }

    public static boolean comparePersons(Person person1, Person person2) {
        if (person1 != null && person2 != null) {
            if (person1.equals(person2)) {
                return true;
            } else {
                return false;
            }
        } else return false;
    }
}
