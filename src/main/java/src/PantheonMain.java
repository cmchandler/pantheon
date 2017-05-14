package main.java.src;

import java.util.Scanner;

/**
 * Created by chris on 4/19/17.
 */
public class PantheonMain {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.println("Loading...");
        PantheonDataSet p = new PantheonDataSet("database.csv");
        System.out.println("Loaded " + p.getNumberOfRecords() + " records.");

        System.out.println("Splitting...");
        PantheonDataSet t = p.splitTestData();
        System.out.println("Dataset contains " + p.getNumberOfRecords() + " records.");
        System.out.println("Test data set contains " + t.getNumberOfRecords() + " records.");
        System.out.println("Writing Training set to file...");
        p.write("training.csv");
        System.out.println("Writing Test set to file...");
        t.write("test.csv");

        System.out.println("Attempting to start Weka instance...");
        WekaData pw = new WekaData();
        System.out.print("Filename to load: ");
        String input = s.nextLine();
        pw.readFile(input,2);
        System.out.println("Done.");
    }
}
