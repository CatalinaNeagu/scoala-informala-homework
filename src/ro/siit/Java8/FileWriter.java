package ro.siit.Java8;

import java.io.BufferedWriter;
import java.io.IOException;



public class FileWriter {

    /** This method writes in a file the objects containing only firstName and lastName
     *
     * @param bw BufferedWriter
     * @param person Object from Person.class
     */
    public static void writeToFile(BufferedWriter bw, Person person) {
        try {
            bw.write(String.format("%s,%s%n", person.getFirstName(), person.getLastName()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}

