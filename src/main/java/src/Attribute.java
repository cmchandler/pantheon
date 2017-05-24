package main.java.src;

import weka.core.pmml.Array;

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
    public double getInfoGain(double targetEntropy, int totalPeople) {
        double result = 0.0;
        double temp = this.getEntropy(totalPeople);
        result = temp - targetEntropy ;
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public String getHistFigureClass(HistoricalFigure data){
        String n = this.getName() ;
        if(n == null) {
            n = "";
        }

        if (n.equals("city")) {
            return data.getCity() ;
        }
        else if(n.equals("country")){
            return data.getCountry() ;
        }
        else if(n.equals("continent")){
            return data.getContinent() ;
        }
        else if(n.equals("page_views")){
            return Integer.toString(data.getPage_views()) ;
        }
        else if(n.equals("avg_views")){
            return Integer.toString(data.getAverage_views()) ;
        }
        else if(n.equals("languages")){
            return Integer.toString(data.getArticle_languages()) ;
        }
        else if(n.equals("domain")){
            return data.getDomain() ;
        }
        else if(n.equals("sex")){
            return data.getSex() ;
        }
        else if(n.equals("occupation")){
            return data.getOccupation() ;
        }
        else if(n.equals("industry")){
            return data.getIndustry() ;
        }
        else{
            return "";
        }
    }

    //#########################################################################################################
    //# This needs to return a list of nodes that contain the Historical Figures with the same classification #
    //#########################################################################################################
    public ArrayList<Node> split(ArrayList<HistoricalFigure> data) {

        if(data==null) return new ArrayList<>();
        if(this.name==null) return new ArrayList<>();

        System.out.print("\nSplit on " + name);
        System.out.print("\t");

        int size = data.size();


        ArrayList<Node> retNodes = new ArrayList<>();

        for(Map.Entry<String, Integer> entry : classifications.entrySet()) {
            ArrayList<HistoricalFigure> newList = new ArrayList<>() ;
            String key = entry.getKey() ;
            Node temp = new Node(this, key, newList) ;
            System.out.println("Key: " + key);
            if(key != null){
                retNodes.add(temp) ;
            }
        }

        for(int i = 0; i < size; i++) {
            for(int j=0; j<retNodes.size(); j++){
                String temp = getHistFigureClass(data.get(i)) ;
                if(temp.equals(retNodes.get(j).getClassOfParent())){
                    retNodes.get(j).addData(data.get(i));
                }
            }
        }

        return retNodes;
    }

}


