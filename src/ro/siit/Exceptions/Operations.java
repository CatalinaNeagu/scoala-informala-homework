package ro.siit.Exceptions;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.*;

import static ro.siit.Exceptions.Main.studentList;

public class Operations {

    //Adding Student in studentList
    public static void addStudent() throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the information regarding the student");
        System.out.println("Type the first name");
        String firstName = sc.nextLine();

        //Verifying if the first name is empty
        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("First name should not be empty");
        }
        System.out.println("Type the last name");
        String lastName = sc.nextLine();

        ////Verifying if the last name is empty
        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("Last name should not be empty");
        }
        System.out.println("Type the gender of the person: male or female or M or F");
        String gender = sc.nextLine();

        //Verifying if the gender is correctly written
        if ((!gender.equalsIgnoreCase("male")) && (!gender.equalsIgnoreCase("female")) && (!gender.equalsIgnoreCase("M")) && (!gender.equalsIgnoreCase("F"))) {
            throw new IllegalArgumentException("The gender should be either male or female or M or F");
        }
        System.out.println("Type the date of birth");
        String date = sc.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = sdf.parse(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);

        //Verifying if the date of birth is between 1990 and current year
        if (calendar.get(Calendar.YEAR) < 1990 || calendar.get(Calendar.YEAR) > Year.now().getValue()) {
            throw new IllegalArgumentException("Date of birth is not between 1900 and current year");
        }

        //CNP input
        System.out.println("Type CNP");
        String cnp = sc.nextLine();


        //Creating a new Student and adding it in student list
        Student s = new Student(firstName, lastName, date, gender, cnp);
        studentList.add(s);
    }

    //Deleting Student from studentList
    public static void deleteStudent() throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please type the CNP of the person that you want to delete");
        String checkingcnp = sc.nextLine();

        //Verifying if typed CNP is empty
        if (checkingcnp == null || checkingcnp.isEmpty()) {
            throw new IllegalArgumentException("CNP should not be empty");
        }
        
        boolean a = true;
        for (int i = 0; i < studentList.size(); i++) {
            if (checkingcnp.equals(studentList.get(i).getCnp())) {
                studentList.remove(i);
                a = false;
            }
        }

        //Verifying if the student does not exist
        if (a == true) {
            throw new FileNotFoundException("This student does not exist");
        }

    }

    public static void retrieveStudent() throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please type the age of the students that you want to retrieve");
        int age = Integer.parseInt(sc.nextLine());

        //Verifying if the introduced age is negative
        if (age < 0) {
            throw new NumberFormatException("The introduced age is negative");
        }

        //Checking if the age of each Student from studentList is the same with the input from the user
        for (Student s : studentList) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date d = sdf.parse(s.getBirthDate());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(d);
            Calendar today = Calendar.getInstance();
            if (age == (today.get(Calendar.YEAR) - calendar.get(Calendar.YEAR))) {
                System.out.println(s);
            }

        }
    }

}
