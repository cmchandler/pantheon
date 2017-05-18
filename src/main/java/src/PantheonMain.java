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

        System.out.println("********************************");
        System.out.println("*         PANTHEON             *");
        System.out.println("********************************");

        System.out.println("Loading...");
        PantheonDataSet p = new PantheonDataSet("database.csv");
        System.out.println("Loaded " + p.getNumberOfRecords() + " records.");
        System.out.println("Dataset contains " + p.getNumberOfRecords() + " records.");

        Scanner s = new Scanner(System.in);
        HistoricalFigure h;
        String input;
        Boolean choice;

        while(true) {
            System.out.print("Enter name of historical figure: ");
            input = s.nextLine();
            h = p.find(input);
            if (h != null) {
                break;
            } else {
                System.out.println("Not found. Try again: ");
            }
        }
        ID3 test = new ID3(p);

        while(true) {
            System.out.println("From scratch (S) or Weka (W) search?");
            input = s.nextLine();
            if(input.equalsIgnoreCase("S")) {
                choice = true;
            }
        }




    }
}
