package org.example;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StudentDbWithHashMapTest {


    @Test
    void checkIfAddedStudentIsInHashMap() {
        Map<Integer, Student> testStudentMap = new HashMap<>();
        StudentDbWithHashMap studentDbWithHashMap = new StudentDbWithHashMap(testStudentMap);
        Student max = new Student("Max", 1);
        studentDbWithHashMap.addStudent(max);
        Map<Integer, Student> studentMap = studentDbWithHashMap.getAllStudentsAsHashMap();
        assertTrue(studentMap.containsKey(max.getId()));
    }

    @Test
    void CheckIfRemovesStudentDoesNotExistInHashMap() {
        Map<Integer, Student> testStudentMap = new HashMap<>();
        StudentDbWithHashMap studentDbWithHashMap = new StudentDbWithHashMap(testStudentMap);
        Student max = new Student("Max", 1);
        studentDbWithHashMap.addStudent(max);
        Student studentToDelete = new Student("Max", 1);
        studentDbWithHashMap.removeStudent(studentToDelete);
        Map<Integer, Student> studentMap = studentDbWithHashMap.getAllStudentsAsHashMap();
        assertFalse(studentMap.containsKey(studentToDelete.getId()));
    }

    @Test
    void findStudentById() throws StudentIdNotFoundException {
        Map<Integer, Student> testStudentMap = new HashMap<>();
        StudentDbWithHashMap studentDbWithHashMap = new StudentDbWithHashMap(testStudentMap);
        Student max = new Student("Max", 1);
        studentDbWithHashMap.addStudent(max);
        Student student = studentDbWithHashMap.findById(1);
        assertEquals(max, student);
    }

    @Test
    void findStudentByIdThrowsException() {
        Map<Integer, Student> testStudentMap = new HashMap<>();
        StudentDbWithHashMap studentDbWithHashMap = new StudentDbWithHashMap(testStudentMap);
        Student max = new Student("Max", 1);
        studentDbWithHashMap.addStudent(max);
        assertThrows(StudentIdNotFoundException.class, () -> studentDbWithHashMap.findById(2));
    }


}