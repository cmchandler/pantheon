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

    // The features of the data set to compare, MAY NOT NEED
    private ArrayList<Attribute> attributes;

    public ArrayList<Node> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Node> children) {
        this.children = children;
    }

    public ArrayList<HistoricalFigure> getData() {
        return data;
    }

    public void setData(ArrayList<HistoricalFigure> data) {
        this.data = data;
    }

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
}
