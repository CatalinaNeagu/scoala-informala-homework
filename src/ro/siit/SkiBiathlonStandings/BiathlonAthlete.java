package ro.siit.SkiBiathlonStandings;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BiathlonAthlete {
    String number;
    String name;
    String countryCode;
    String time;
    String firstShootingRange;
    String secondShootingRange;
    String thirdShootingRange;

    public BiathlonAthlete(String number, String name, String countryCode, String time, String firstShootingRange, String secondShootingRange, String thirdShootingRange) {
        this.number = number;
        this.name = name;
        this.countryCode = countryCode;
        this.time = time;
        this.firstShootingRange = firstShootingRange;
        this.secondShootingRange = secondShootingRange;
        this.thirdShootingRange = thirdShootingRange;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFirstShootingRange() {
        return firstShootingRange;
    }

    public void setFirstShootingRange(String firstShootingRange) {
        this.firstShootingRange = firstShootingRange;
    }

    public String getSecondShootingRange() {
        return secondShootingRange;
    }

    public void setSecondShootingRange(String secondShootingRange) {
        this.secondShootingRange = secondShootingRange;
    }

    public String getThirdShootingRange() {
        return thirdShootingRange;
    }

    public void setThirdShootingRange(String thirdShootingRange) {
        this.thirdShootingRange = thirdShootingRange;
    }

    //Transform String to mm:ss format and then in seconds
    public long getSeconds() {
        DateFormat dateFormat = new SimpleDateFormat("mm:ss");
        Date reference = null;
        try {
            reference = dateFormat.parse("00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date date = null;
        try {
            date = dateFormat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long seconds = (date.getTime() - reference.getTime()) / 1000;
        return seconds;
    }

    /*
    Creating the method for calculating the final result.
    For every missed shot the athlete obtains a 10 second penalty which affects the final time-result.
     */
    public long getFinalResult() {
        long finalResult = getSeconds();
        String allShooting = firstShootingRange + secondShootingRange + thirdShootingRange;

        //For each "o", the final result will be decreased with 10
        for (int i = 0; i <= (allShooting.length() - 1); i++) {
            if (allShooting.charAt(i) == 'o') {
                finalResult -= 10;
            }
        }
        return finalResult;
    }

    @Override
    public String toString() {
        return "BiathlonAthlete{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", time='" + time + '\'' +
                ", firstShootingRange='" + firstShootingRange + '\'' +
                ", secondShootingRange='" + secondShootingRange + '\'' +
                ", thirdShootingRange='" + thirdShootingRange + '\'' +
                '}';
    }
}