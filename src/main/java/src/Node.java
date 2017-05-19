package main.java.src;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents one node in a decision tree
 */
public class Node {

    private Attribute parentAttr;
    private String classOfParent;
    private String splitAttribute;
    private ArrayList<Node> children;
    private ArrayList<HistoricalFigure> data;
    private String name;

    public Node(String p, String s, ArrayList<HistoricalFigure> d){
        System.out.println("New node.");
        System.out.println("Node has parent attribute of " + s);
        System.out.println("Node has parent class of " + s);
        setParentAttr(p);
        setClassOfParent(s);
        setChildren(new ArrayList());
        //setSplitAttribute("city");
        setData(d);
        System.out.println("Finished constructing");
    }

    public ArrayList<Node> getChildren() {
        return children;
    }
    public void setChildren(ArrayList<Node> children) {
        this.children = children;
    }

    public void addChild(Node child){children.add(child);}

    public ArrayList<HistoricalFigure> getData() {
        return data;
    }
    public void setData(ArrayList<HistoricalFigure> data) {
        this.data = data;
    }
    public void addData(HistoricalFigure fig){data.add(fig);}

    public String getParentAttr() {
        return parentAttr;
    }
    public void setParentAttr(String parent) {
        this.parentAttr = parent;
    }

    public void setClassOfParent(String n) {this.classOfParent = n;}
    public String getClassOfParent() { return classOfParent;}

    public void setSplitAttribute(String n) {this.splitAttribute = n;}
    public String getSplitAttribute() { return splitAttribute;}
}
