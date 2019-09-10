package ro.siit.Java8;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

import static ro.siit.Java8.FileReader.personList;

/**
 * This application loads from a file a structure like (first name, last name, date of birth) and then returns in another file
 * ordered alphabetically all the matches which have the birthday on a month indicated.
 * The input of the month was made using a scanner.
 *
 * @author Catalina Neagu
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Type the month and the programm will show you all the people were born in that month");
        Scanner sc = new Scanner(System.in);
        int month = Integer.parseInt(sc.next());
        FileReader.readFile();
        BufferedWriter bw = new BufferedWriter(new java.io.FileWriter("src\\ro\\siit\\Java8\\text2.txt"));

        /**
         * The arrayList is filtered considering the indicated month.
         * Then,it is alphabetically sorted.
         * In the end, each object is written in a File using writeToFile method from FileWrited.class.
         */
        personList.stream()
                .filter(person -> month == (person.getMonth()))
                .sorted((person1, person2) -> person1.getFirstName().compareTo(person2.getFirstName()))
                .forEach(person -> FileWriter.writeToFile(bw, person));
        bw.close();


    }
}
