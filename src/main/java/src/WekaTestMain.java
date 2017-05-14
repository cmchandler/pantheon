package main.java.src;

import java.util.Scanner;


/**
 * Created by chris on 5/13/2017.
 */
public class WekaTestMain {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // Load file
        System.out.println("Loading...");
        PantheonDataSet p = new PantheonDataSet("database.csv");
        System.out.println("Loaded " + p.getNumberOfRecords() + " records.");

        // Split file
        System.out.println("Splitting...");
        PantheonDataSet t = p.splitTestData();
        System.out.println("Dataset contains " + p.getNumberOfRecords() + " records.");
        System.out.println("Test data set contains " + t.getNumberOfRecords() + " records.");
        System.out.println("Writing Training set to file...");
        p.write("training.csv");
        System.out.println("Writing Test set to file...");
        t.write("test.csv");

        // Evaluate
        System.out.println("Evaluating for metric L.");
        WekaData training = new WekaData();
        training.readFile("training.csv", 13);
        WekaData test = new WekaData();
        test.readFile("test.csv", 13);

        System.out.println("Running...\n");
        WekaTree mine = new WekaTree(training,test);

       mine.run();
    }

}
