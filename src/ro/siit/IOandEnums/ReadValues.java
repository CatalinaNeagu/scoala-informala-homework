package ro.siit.IOandEnums;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


import static ro.siit.IOandEnums.WritingFile.messageList;


public class ReadValues implements Runnable {

    public String[] fileName;

    //Constructor
    public ReadValues(String[] fileName) {
        this.fileName = fileName;
    }

    BufferedReader br;


    @Override
    public void run() {

        //Reading each file
        for (String strFile : fileName) {

            try {
                br = new BufferedReader(new FileReader(strFile));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            String line = null;

            //For each row, it assigns the values to the correct field
            while (true) {
                try {
                    if (!(((line = br.readLine()) != null) && (!line.isEmpty()))) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }

                String[] fields = line.split(",");

                String name = fields[0];

                String birthDate = fields[1];
                Calendar cal = Calendar.getInstance();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    cal.setTime(formatter.parse(birthDate));
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                String sex = fields[2];
                Person.Sex s = Person.Sex.fromString(sex);

                //It verifies if the sex is female and if the person is born in the same day and month as today.
                //If so, it returns a message and add it in a messageList.
                if (s == Person.Sex.FEMALE) {
                    Calendar today = Calendar.getInstance();
                    if ((cal.get(Calendar.MONTH) == today.get(Calendar.MONTH)) && (cal.get(Calendar.DAY_OF_MONTH)) == today.get(Calendar.DAY_OF_MONTH)) {
                        String message = (String.format("Happy birthday %s(%s)!%n", name, cal.get(Calendar.YEAR)));
                        messageList.add(message);

                    }
                }
            }
        }
    }
}












