package ro.siit.Java8;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class Java8Test {

    //This test will check if the path is wrong, the software will throw FileNotFoundException
    @Test(expected = FileNotFoundException.class)
    public void wrongPath() throws FileNotFoundException {
        File file = new File("src\\ro\\siit\\Java8\\tex.text");
        BufferedReader br = new BufferedReader(new FileReader(file));
    }

    //This test will verify if ".filter" function works correctly
    @Test
    public void filterFunction() throws ParseException {
        Person p1 = new Person("Ion", "Gheorghe", new SimpleDateFormat("yyyy-MM-dd").parse("1990-02-07"));
        Person p2 = new Person("Ion", "Gheorghe", new SimpleDateFormat("yyyy-MM-dd").parse("1990-12-07"));
        List<Person> personList = Arrays.asList(p1, p2);
        int month = 12;
        List<Person> personList1 = personList.stream()
                .filter(person -> month == (person.getMonth()))
                .collect(Collectors.toList());
        assertTrue(personList1.contains(p2));
    }

    //This test will verify if ".sort" function works correctly
    @Test
    public void sortFunction() throws ParseException {
        Person p1 = new Person("Vlad", "Gheorghe", new SimpleDateFormat("yyyy-MM-dd").parse("1990-02-07"));
        Person p2 = new Person("Teodor", "Gheorghe", new SimpleDateFormat("yyyy-MM-dd").parse("1990-12-07"));
        List<Person> personList = Arrays.asList(p1, p2);
        List<Person> personList1 = personList.stream()
                .sorted((person1, person2) -> person1.getFirstName().compareTo(person2.getFirstName()))
                .collect(Collectors.toList());
        assertTrue(personList1.indexOf(p2) == 0);
    }


    //This test will verify if the month is correctly calculated
    @Test
    public void monthCalculation() throws ParseException {
        Person p1 = new Person("Vlad", "Gheorghe", new SimpleDateFormat("yyyy-MM-dd").parse("1990-02-07"));
        assertEquals(2, p1.getMonth());
    }
}
