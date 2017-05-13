package main.java;

/**
 * Created by chris on 4/19/17.
 */
public class PantheonMain {
    public static void main(String[] args) {
        System.out.println("Loading...");
        PantheonDataSet p = new PantheonDataSet("database.csv");
        System.out.println("Loaded " + p.getNumberOfRecords() + " records.");
        System.out.println("Splitting...");
        PantheonDataSet t = p.splitTestData();
        System.out.println("Dataset contains " + p.getNumberOfRecords() + " records.");
        System.out.println("Test data set contains " + t.getNumberOfRecords() + " records.");
    }
}
