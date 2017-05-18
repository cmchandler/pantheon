package main.java.src;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chris on 5/16/2017.
 */
public class ID3 {

    ArrayList<HistoricalFigure> trainingData;
    ArrayList<Attribute> attributesToConsider;
    Attribute attributeToGuess;

    public ID3(PantheonDataSet p) {

        trainingData = p.getDataset();
        attributesToConsider = p.getAttributes();
        attributeToGuess = p.getTarget();

    }


    public Node branch(ArrayList<Attribute> attributes, Attribute target, ArrayList<HistoricalFigure> data ){

        // if attributes is empty, return null
        if (attributes.isEmpty()) {
            return new Node();
        }

        //################### HARDCODING OCCUPATION ###########################
        // if all members of data have the same value for target attribute, return new node with that value

        Boolean same = false;
        String occupation = data.get(0).getOccupation();

        for (int i = 0; i < data.size(); i++) {
            if(data.get(i).getOccupation().equals(occupation)) {

            }
        }


        // if attributes is empty, return a node with the value of the most frequent value of target in data
    return null;
    }

    /**
     *
     * @param a the attribute to test
     * @param t the attribute to target
     * @param n the number of records passed
     * @return the information gain
     */
    public static double getGain(Attribute a, Attribute t, Integer n) {
        return t.getEntropy(n) - a.getEntropy(n);
    }

}
