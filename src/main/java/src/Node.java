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

    // The features of the data set to compare, MAY NOT NEED
    private ArrayList<Attribute> attributes;

    // The attribute value
    private Attribute value;

    /**
     * The constructor for the Node
     * @param parent the parent of the Node in the tree
     * @param data
     */
    public Node(Node parent, ArrayList<HistoricalFigure> data) {
        this.parent = parent;
        this.data = data;
    }

    public Node(Attribute value) {
        this.value = value;
    }

    public void setValue(Attribute a) {
        value = a;
    }
}
