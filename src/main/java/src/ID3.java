package main.java.src;

import java.util.*;

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

        if(root == null) System.out.println("ROOT IS NULL");;

        //if n has no child, return String occupation BASE CASE
        if(root != null)
            if(root.getChildren().isEmpty()){
                if(root.getClassOfParent() != null)
                     return root.getClassOfParent();
            }

        //Get root's splitting attribute sA
        //get f's classification c for sA

        ArrayList<Node> goodChildren = new ArrayList<>();

        for(int i=0; i<root.getChildren().size(); i++) {
            if(root.getChildren().get(i) != null) goodChildren.add(root.getChildren().get(i));
        }

        root.setChildren(goodChildren);

        for(int i=0; i<root.getChildren().size(); i++){

            Node currentNode = root.getChildren().get(i);

            if(currentNode == null) currentNode = new Node(new Attribute(),"",new ArrayList<>());

            String classOfParent = "django";
            String classOfQuery = "vincent";

            classOfParent = root.getChildren().get(i).getClassOfParent();
            classOfQuery = f.getCustomClass(root.getChildren().get(i).getParentAttr().getName());

            if(classOfParent.equals(classOfQuery)) {
                //get node for c, ni
                System.out.println("I'm here");
                root = root.getChildren().get(i);
                System.out.println(classOfParent);
                return query(root, f) ;
            }
        }
        //Shouldn't get here
        return "Not found.";
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
        if (attributes.size() == 0) {
            return null;
            //return new Node(root.getSplitAttribute(), findMostCommon(root.getData()), null) ;
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
                System.out.println("Get i :" + attributes.get(i).getName());
                bestGain = temp;
                index = i;
            }
        }
        System.out.println("Attributes:  ");
        for(int i = 0; i < attributes.size(); i++) {
            System.out.println(attributes.get(i).getName());
        }

        //System.out.println("Past the check");

        //System.out.println("Data going to split size" + root.getData().size());
        ArrayList<Node> children = bestGainAttr.split(root.getData());

        children.removeAll(Collections.singleton(null));

        for(int i = 0; i < children.size(); i++) {
            if(children.get(i) == null) children.remove(i);
        }

        //System.out.println("Setting gain attr with name " + bestGainAttr.getName());
        if(bestGainAttr.getName()==null) bestGainAttr.setName("");

        root.setSplitAttribute(bestGainAttr);
        if(bestGainAttr==null) root.setSplitAttribute(new Attribute());

        System.out.println("Setting split attr to " + bestGainAttr.getName());
        root.setSplitAttribute(bestGainAttr);

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
