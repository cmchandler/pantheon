package main.java.src;

//import main.java.src.PantheonDataSet;
//import main.java.src.WekaData;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by chris on 4/19/17.
 */
public class PantheonMain {
    public static void main(String[] args) throws Exception{

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


    }
}
