package main.java.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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



    public String query(Node root,HistoricalFigure f) {
        Node newRoot = root.getChildren().get(0);
        //if n has no child, return String occupation BASE CASE
        if(root.getChildren() == null){
            return root.getClassOfParent();
        }
        //Get root's splitting attribute sA
        //get f's classification c for sA
        for(int i=0; i<root.getChildren().size(); i++){
            if(root.getChildren().get(i).getClassOfParent().equals(f.getCustomClass(root.getChildren().get(i).getClassOfParent()))){
                //get node for c, ni
                newRoot = root.getChildren().get(i);
                i = root.getChildren().size() + 1 ;
            }
        }
        //recursively call query on node
        return query(newRoot, f) ;
    }

    /**
     * Recursive branching method to deconstruct dataset
     * @param attributes the list of attributes to still consider
     * @param target the attribute we're looking for
     * @param root the root node
     * @return a node containing single
     */
    public Node branch(ArrayList<Attribute> attributes, Attribute target, Node root){

        double targetEntropy = target.getEntropy(root.getData().size());

        /////////Base cases

        //if attributes is empty, return null
        if (attributes.isEmpty()) {
           return new Node(root.getSplitAttribute(), findMostCommon(root.getData()), null) ;
        }

        if(target.getEntropy(root.getData().size())==0) {
            return new Node(root.getSplitAttribute(), root.getData().get(0).getOccupation(), null);
        }

        ////////Recursive

        Attribute bestGainAttr = attributes.get(0);

        double bestGain = -5.0;
        double temp;
        int index = 0;

        for(int i = 0; i < attributes.size(); i++){
            temp = attributes.get(i).getInfoGain(targetEntropy,root.getData().size());
            if(temp > bestGain) {
                bestGain = temp;
                bestGainAttr = attributes.get(i);
                index = i;
            }
        }

        ArrayList<Node> children = bestGainAttr.split(root.getData());
        root.setSplitAttribute(bestGainAttr.getName());
        attributes.remove(index);

        for(int i = 0; i < children.size(); i++) {
            root.addChild(branch(attributes,target,children.get(i)));
        }

        return root;
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

    public String findMostCommon(ArrayList<HistoricalFigure> a){
        String retVal = "";
        for(int i = 0;i<a.size();i++) {
            HashMap<String,Integer> map = new HashMap<>();
            if(!map.containsValue(a.get(i))) {
                map.put(a.get(i).getOccupation(),1);
            }
            else {
                Integer temp = map.get(a.get(i).getOccupation());
                map.put(a.get(i).getOccupation(),temp+1);
            }

            int max = 0;

            for(Map.Entry<String, Integer> entry : map.entrySet()){
                int temp = entry.getValue();
                if(temp>max){
                    max = temp;
                    retVal = entry.getKey();
                }
            }

        }
        return retVal;
    }

}
