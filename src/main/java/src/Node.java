package main.java.src;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents one node in a decision tree
 */
public class Node {

    // The node's parent
    Node parent;

    // The node's children
    private ArrayList<Node> children;

    // The node's data set
    private ArrayList<HistoricalFigure> data;

    // The attribute value
    private Attribute value;

    private String name;

    // The features of the data set to compare, MAY NOT NEED
    private ArrayList<Attribute> attributes;

    public Node(String s){
        setName(s);
    }

    public ArrayList<Node> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Node> children) {
        this.children = children;
    }

    public void addChild(Node child){ children.add(child);}

    public ArrayList<HistoricalFigure> getData() {
        return data;
    }

    public void setData(ArrayList<HistoricalFigure> data) {
        this.data = data;
    }

    public void addData(HistoricalFigure fig){data.add(fig);}

    public ArrayList<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(ArrayList<Attribute> attributes) {
        this.attributes = attributes;
    }

    public Attribute getValue() {
        return value;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void setValue(Attribute a) {
        value = a;
    }

    public void setName(String n) {this.name = n;}

    public String getName() { return name;}
}
