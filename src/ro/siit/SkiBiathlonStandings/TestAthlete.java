package ro.siit.SkiBiathlonStandings;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static org.junit.Assert.assertEquals;

public class TestAthlete {

    //This test will check if the path is wrong, the software will throw FileNotFoundException
    @Test(expected = FileNotFoundException.class)
    public void wrongPath() throws FileNotFoundException {
        File file = new File("D:\\Java\\scoala-informala-homework\\src\\ro\\siit\\SkiBiathlonStandings\\files");
        BufferedReader br = new BufferedReader(new FileReader(file));
    }

    //This test will verify if the finalResult is correctly calculated.
    @Test
    public void finalResultCalculation() {
        BiathlonAthlete b1 = new BiathlonAthlete("2", "Ion", "RO", "30:10", "xooxx", "xxxxxx", "xxxxx");
        assertEquals(1790, b1.getFinalResult());
    }

    //This test will verify if the seconds are correctly calculated.
    @Test
    public void secondsCalculation() {
        BiathlonAthlete b1 = new BiathlonAthlete("2", "Ion", "RO", "30:10", "xxxxx", "xxxxxx", "xxxxx");
        assertEquals(1810, b1.getSeconds());
    }


}
