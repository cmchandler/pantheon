package main.java.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static main.java.src.PantheonDataSet.dataset;

/**
 * Created by chris on 5/16/2017.
 */
public class Attribute {

    public String name;
    HashMap<String, Integer> classifications;

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
}


