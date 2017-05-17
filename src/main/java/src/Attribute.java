package main.java.src;

import java.util.*;

import static main.java.src.PantheonDataSet.dataset;

/**
 * Created by chris on 5/16/2017.
 */
public class Attribute {

    public String name;
    HashMap<String, Integer> classifications;
    int numEntries;

    public Attribute() {
        classifications = new HashMap<String, Integer>();
    }

    public Integer getValue(String s){
        return classifications.get(s) ;
    }

    public void add(String s){
       if(classifications.containsKey(s)){
            Integer temp = classifications.get(s) ;
           classifications.put(s, temp+1) ;
       }
       else{
           classifications.put(s, 1);
       }
    }

    public double getEntropy(int totalPeople){
        double result = 0.0;

        for(Map.Entry<String, Integer> entry : classifications.entrySet()){
            String kei = (String) entry.getKey() ;
            Integer numberInClass = (Integer) entry.getValue();

            System.out.println("Key: " + kei);
            System.out.println("Val: " + numberInClass);

            double num = numberInClass.doubleValue();

            double ratio = num / (double) totalPeople;
            System.out.println("Ratio: " + ratio);
            System.out.println("Total people: ");

            double log2 = Math.log10(ratio)/Math.log10(2);
            System.out.println("Log2: " + log2);

            result += ((-1) * (ratio) * (log2));

            System.out.println("Number of instances in this class: " + num);
            System.out.println("Total people: " + (double) totalPeople);
            System.out.println("Result: " + result);
        }
        return result;
    }
}


