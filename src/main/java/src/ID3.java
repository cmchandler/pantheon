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
        //if n has no child, return String occupation BASE CASE
        if(root.getChildren().isEmpty()){
            return root.getClassOfParent();
        }
        //Get root's splitting attribute sA
        //get f's classification c for sA
        System.out.println("Size: " + root.getChildren().size());
        for(int i=0; i<root.getChildren().size(); i++){
            if(root.getChildren().get(i).getClassOfParent().equals(f.getCustomClass(root.getChildren().get(i).getClassOfParent()))){
                //get node for c, ni
                root = root.getChildren().get(i);
                return query(root, f) ;
            }
        }
        //recursively call query on node
        return query(root, f) ;
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

        System.out.println("Init. node");
        /////////Base cases

        //if attributes is empty, return null
        if (attributes.size() == 1) {
            System.out.println("Bail case 1");
            System.out.println("Split attribute passed: " + root.getSplitAttribute());
           return new Node(root.getSplitAttribute(), findMostCommon(root.getData()), null) ;
        }

        if(target.getEntropy(root.getData().size())==0) {
            System.out.println("Bail case 2: ");
            return new Node(root.getSplitAttribute(), root.getData().get(0).getOccupation(), null);
        }
        System.out.println("Past the ifs");
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

        //System.out.println("Past the check");

        //System.out.println("Data going to split size" + root.getData().size());
        ArrayList<Node> children = bestGainAttr.split(root.getData());

        for(int i = 0; i < children.size(); i++) {
            if(children.get(i) == null) children.remove(i);
        }

        //System.out.println("Setting gain attr with name " + bestGainAttr.getName());
        if(bestGainAttr.getName()==null) bestGainAttr.setName("");
        root.setSplitAttribute(bestGainAttr.getName());

        attributes.remove(index);

        //System.out.println("Past the split");

        for(int i = 0; i < children.size(); i++) {
            System.out.println("Start recursion: ");
            System.out.println("Attributes :" + attributes.size());
            System.out.println("Target: " + target.getName());
            System.out.println("Children: " + children.get(i).getSplitAttribute());
            root.addChild(branch(attributes,target,children.get(i)));
            //root.addChild(children.get(i));
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
