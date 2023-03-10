package org.example;

import java.util.Objects;

public class Student {

    //Aufgabe 2 = Die Klasse Student hat zwei Attribute: name und id
    private String name;
    private int id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Aufgabe 4 = Die toString() Methode gibt alle Studenten als String zurück

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    // Damit wir bei der HashMap auf die ID des Student zugreifen können, erstellen wir hier einen Getter für die ID
    public int getId() {
        return id;
    }
}
