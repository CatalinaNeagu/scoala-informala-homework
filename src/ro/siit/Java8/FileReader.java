package ro.siit.Java8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FileReader {
    static List<Person> personList = new ArrayList();
    static BufferedReader br;

    public static void readFile() {
        {
            try {
                br = new BufferedReader(new java.io.FileReader("src\\ro\\siit\\Java8\\text.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        //For each row, it assigns the values to the correct field
        String line = null;
        while (true) {
            try {
                if (!(((line = br.readLine()) != null) && (!line.isEmpty()))) break;
            } catch (IOException e) {
                e.printStackTrace();
            }

            String[] fields = line.split(",");

            String firstName = fields[0];
            String lastName = fields[1];
            String date = fields[2];
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date birthDate = null;
            try {
                birthDate = formatter.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            //A new Person object is created and added in personList

            Person p = new Person(firstName, lastName, birthDate);
            personList.add(p);

        }
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}