package ro.siit.Exceptions;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.*;

/**
 * This code is used for adding, deleting or retrieving a Student in/ from a list named studentList.
 * For all the validations, the corresponding exception(s) are thrown when a Student is created with
 * data which breaks the validation constraint.
 * This code also list students order by Last Name.
 * @author Catalina Neagu
 */

public class Main {
    static List<Student> studentList = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Student s1 = new Student("Radu", "Andrei", "1990-02-02", "M", "1900202297346");
        Student s2 = new Student("Gheorghe", "Laurentiu", "1989-02-02", "M", "1890202297346");
        Student s3 = new Student("Toader", "Ana", "1987-09-07", "F", "2870907297890");
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        Operations.addStudent();
        Operations.deleteStudent();
        Operations.retrieveStudent();


        TreeSet<Student> studentComp = new TreeSet<Student>(new MyNameComp());
        studentComp.add(s1);
        studentComp.add(s2);
        studentComp.add(s3);
        for (Student s : studentComp) {
            System.out.println(s);
        }
    }

    static class MyNameComp implements Comparator<Student> {

        @Override
        public int compare(Student s1, Student s2) {
            return s1.getLastName().compareTo(s2.getLastName());
        }
    }
}


