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

<<<<<<< HEAD


=======
    public double getEntropy(int totalPeople){
        double result = 0.0;
        Iterator it = classifications.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            double ratio = (double) pair.getValue() / (double) totalPeople;
            double log2 = Math.log10(ratio)/Math.log10(2);
            result += (-1) * (ratio) * (log2);
        }
        return result;
    }
>>>>>>> origin/master
}


