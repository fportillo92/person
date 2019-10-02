package com.person.utils;

public class Utils {

    public static float calculatePercent(int total, int cant) {
        if(total != 0) {
            return (cant * 100)/total;
        } else {
            return 0;
        }
    }
}
