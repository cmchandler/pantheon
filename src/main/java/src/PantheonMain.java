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
        PantheonDataSet p = new PantheonDataSet("training.csv");
        System.out.println("Loaded " + p.getNumberOfRecords() + " records.");
        System.out.println("Dataset contains " + p.getNumberOfRecords() + " records.");
        System.out.println("\n\n====================================");

        ID3 test = new ID3(p);



    }
}
