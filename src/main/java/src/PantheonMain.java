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

        PantheonDataSet p = new PantheonDataSet("test.csv");
        PantheonDataSet db = new PantheonDataSet("database.csv");

        System.out.println("Loaded " + p.getNumberOfRecords() + " records.");
        System.out.println("Dataset contains " + p.getNumberOfRecords() + " records.");

        Scanner s = new Scanner(System.in);
        HistoricalFigure h;
        String input;
        Boolean choice;

        /*
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
        */

        // Testing figure
        h = db.getDataset().get(3);


        System.out.println("Full name: " + h.getFull_name());


        for(int i = 0; i < p.getAttributes().size();i++) {
            System.out.println("Attributes from main: " + p.getAttributes().get(i).getName());
        }


        // Init new tree
        ID3 test = new ID3(p);

        Attribute rootattr = new Attribute();

        Node root = new Node(rootattr,"",p.getDataset());

        Node training = test.branch(p.getAttributes(),p.getTarget(),root);

        System.out.println("\nTraining finished.");

        ID3Reader iter = new ID3Reader(root);
        String guess = iter.read(h);
        System.out.println("Predicted occupation: " + guess);

        System.out.println("\n\nActual occupation: " + h.getOccupation());


        /*
        while(true) {
            System.out.println("From scratch (S) or Weka (W) search?");
            input = s.nextLine();
            if(input.equalsIgnoreCase("S")) {
                choice = true;
            }
        }
        */



    }
}
