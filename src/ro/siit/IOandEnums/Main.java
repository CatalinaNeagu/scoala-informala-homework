package ro.siit.IOandEnums;

/**
 * This program will filter all the female persons whose birthday is today and output a message in the console wishing them a
 * happy birthday containing their name and year when they were born. The console output will be also written to a file. (file3.txt)
 * It contains separate threads for the processing of each file and compares the time it took to process the files in a single thread
 * vs processing the files in separate threads.
 *
 * @author Catalina Neagu
 */

public class Main {
    public static void main(String[] args) {

        //Processing the files in 1 thread
        long time1 = System.currentTimeMillis();
        ReadValues rv1 = new ReadValues(new String[]{"src\\ro\\siit\\IOandEnums\\file1.txt", "src\\ro\\siit\\IOandEnums\\file2.txt"});
        Thread t1 = new Thread(rv1);
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WritingFile.WritingFile();

        System.out.println(String.format("Processing the files in a single thread will take: %s millis", (System.currentTimeMillis() - time1)));


        //Processing the files in 2 threads
        long time2 = System.currentTimeMillis();
        ReadValues rv2 = new ReadValues(new String[]{"src\\ro\\siit\\IOandEnums\\file1.txt"});
        Thread t2 = new Thread(rv2);
        ReadValues rv3 = new ReadValues(new String[]{"src\\ro\\siit\\IOandEnums\\file2.txt"});
        Thread t3 = new Thread(rv3);
        t2.start();
        t3.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WritingFile.WritingFile();

        System.out.println(String.format("Processing the files in two threads will take: %s millis", (System.currentTimeMillis() - time2)));
    }
}

