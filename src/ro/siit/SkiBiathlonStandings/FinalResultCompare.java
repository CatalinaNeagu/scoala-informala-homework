package ro.siit.SkiBiathlonStandings;

import java.util.Comparator;

class FinalResultCompare implements Comparator<BiathlonAthlete> {
    public int compare(BiathlonAthlete b1, BiathlonAthlete b2) {
        if (b1.getFinalResult() > b2.getFinalResult()) return -1;
        if (b1.getFinalResult() < b2.getFinalResult()) return 1;
        else return 0;
    }
}
