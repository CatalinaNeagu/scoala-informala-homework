package ro.siit.SkiBiathlonStandings;

import java.util.*;

import static ro.siit.SkiBiathlonStandings.ReadValues.athleteList;
import static ro.siit.SkiBiathlonStandings.ReadValues.readingValues;

/**
 * This software allows us to take as an input a CSV file where every entry represents the results of a biathlon athlete.
 * Based on the entries it identifies the first 3 places (Winner, Runner-up and Third Place).
 * Each athlete has a time-results for the entire skiing session, and 3 shooting range results.
 * Each shooting range has 5 shot results. For every missed shot the athlete obtains a 10 second penalty which affects the final time-result.
 * Final standings are based on the time-results that have been updated with the shooting range results.
 *
 * @author Catalina Neagu
 */
public class Main {
    public static void main(String[] args) {
        readingValues();

        Collections.sort(athleteList, new FinalResultCompare());
        System.out.println(athleteList);
    }
}

