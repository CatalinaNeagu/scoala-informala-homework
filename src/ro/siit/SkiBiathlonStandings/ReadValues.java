package ro.siit.SkiBiathlonStandings;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadValues {
    static List<BiathlonAthlete> athleteList = new ArrayList();

    public static void readingValues() {

        // Create an instance of BufferedReader
        BufferedReader br = null;

        try {
            //Create the file reader
            File file = new File("D:\\Java\\scoala-informala-homework\\src\\ro\\siit\\SkiBiathlonStandings\\file");
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line = null;

        //Reading the values and adding the Objects in athleteList
        while (true) {
            try {
                if (!(((line = br.readLine()) != null) && (!line.isEmpty()))) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            String[] fields = line.split(",");
            String number = fields[0];
            String name = fields[1];
            String countryCode = fields[2];
            String time = fields[3];
            String firstShootingRange = fields[4];
            String secondShootingRange = fields[5];
            String thirdShootingRange = fields[6];

            BiathlonAthlete athlete = new BiathlonAthlete(number, name, countryCode, time, firstShootingRange, secondShootingRange, thirdShootingRange);
            athleteList.add(athlete);
        }
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
