package main.java;

/**
 * Created by chris on 4/19/17.
 */
public class PantheonMain {
    public static void main(String[] args) {
        System.out.println("Loading...");
        PantheonDataSet p = new PantheonDataSet("database.csv");
        System.out.println("Loaded " + p.getNumberOfRecords() + " records.");
    }
}
