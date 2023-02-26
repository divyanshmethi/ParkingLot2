package org.parkinglot.utils;

public class IdGenerator {
    private static Integer id = 0;
    public static Integer getID() {
        id++;
        return id;
    }
}
