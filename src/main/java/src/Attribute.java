package main.java.src;

import java.util.*;


/**
 * Attribute: represents one attribute the data
 */
public class Attribute {

    public String name;
    HashMap<String, Integer> classifications;
    int numEntries;

    /**
     * Constructor: Initializes the HashMap
     */
    public Attribute() {
        classifications = new HashMap<String, Integer>();
    }

    /**
     * Returns the number of classes with the passed name
     * @param s the name to lookup
     * @return the number of rows in that class for this attribute
     */
    public Integer getValue(String s){
        return classifications.get(s) ;
    }

    /**
     * Adds an entry to the HashTable, incrementing instead of adding if needed
     * @param s the name of the class to add
     */
    public void add(String s){
       if(classifications.containsKey(s)){
            Integer temp = classifications.get(s) ;
           classifications.put(s, temp+1) ;
       }
       else{
           classifications.put(s, 1);
       }
    }

    /**
     * Returns the total entropy of the attribute in the dataset
     * @param totalPeople the number of rows in the dataset
     * @return the entropy of this attribute
     */
    public double getEntropy(int totalPeople){
        double result = 0.0;

        for(Map.Entry<String, Integer> entry : classifications.entrySet()){
            String kei = (String) entry.getKey() ;
            Integer numberInClass = (Integer) entry.getValue();

           // System.out.println("Key: " + kei);
           // System.out.println("Val: " + numberInClass);

            double num = numberInClass.doubleValue();

            double ratio = num / (double) totalPeople;
            //System.out.println("Ratio: " + ratio);
            //System.out.println("Total people: ");

            double log2 = Math.log10(ratio)/Math.log10(2);
            //System.out.println("Log2: " + log2);

            result += ((-1) * (ratio) * (log2));

            //System.out.println("Number of instances in this class: " + num);
            //System.out.println("Total people: " + (double) totalPeople);
            //System.out.println("Result: " + result);
        }
        //System.out.println(result);
        return result;
    }

    /**
     * Calculates information gain
     */
    public double getInfoGain() {
        return 0.0;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    //#########################################################################################################
    //# This needs to return a list of nodes that contain the Historical Figures with the same classification #
    //#########################################################################################################
    public ArrayList<Node> split(ArrayList<HistoricalFigure> data) {
        ArrayList<Node> retNodes = new ArrayList<>();
        for(int i = 0; i < data.size(); i++) {

        }
        return null;
    }

}


