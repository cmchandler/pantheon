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
        PantheonDataSet p = new PantheonDataSet("training.csv");
        System.out.println("Loaded " + p.getNumberOfRecords() + " records.");

        // Split file
        System.out.println("Splitting...");
        PantheonDataSet t = new PantheonDataSet("test.csv");
        System.out.println("Dataset contains " + p.getNumberOfRecords() + " records.");
        System.out.println("Test data set contains " + t.getNumberOfRecords() + " records.");

        // Evaluate
        System.out.println("Evaluating for metric L.");
        WekaData training = new WekaData();
        training.readFile("main/java/training.csv", 10);
        WekaData test = new WekaData();
        test.readFile("main/java/test.csv", 10);

        System.out.println("Running...\n");
        WekaTree mine = new WekaTree(training,test);

       mine.run();
    }

}
