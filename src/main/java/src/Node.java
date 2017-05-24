package main.java.src;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents one node in a decision tree
 */
public class Node {

    private Attribute parentAttr;
    private String classOfParent = "";
    private Attribute splitAttribute;
    private ArrayList<Node> children;
    private ArrayList<HistoricalFigure> data;

    public Node(Attribute parentAttribute, String parentClassName, ArrayList<HistoricalFigure> d) {

        setParentAttr(parentAttribute);

        setClassOfParent("empty");

        setChildren(new ArrayList());

        setData(d);

        setSplitAttribute(new Attribute());

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

    public Attribute getParentAttr() {
        return parentAttr;
    }
    public void setParentAttr(Attribute parent) {
        this.parentAttr = parent;
    }

    public void setClassOfParent(String n) {this.classOfParent = n;}
    public String getClassOfParent() { return classOfParent;}

    public void setSplitAttribute(Attribute n) {this.splitAttribute = n;}
    public Attribute getSplitAttribute() { return splitAttribute;}
}
