package com.company;

import java.io.*;
import java.util.Objects;
import java.util.stream.Collectors;

public class StreamExample {

    public static void main(String[] args) {
        try (Reader reader = new FileReader(new File("people.israel"));
             BufferedReader bufferedReader = new BufferedReader(reader)) {

            bufferedReader.lines()
                    .filter(x -> !x.contains(":"))
                    .map(Person::new)
                    .collect(Collectors.toSet())
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public String toString() {
        return String.format("Name: %s", this.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}