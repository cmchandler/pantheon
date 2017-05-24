package main.java.src;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Christien
 */
public class ID3Reader {

    Node root;

    public ID3Reader(Node root) {
        this.root = root;
    }

    public String read(HistoricalFigure h) {
        Node tempRoot = root;
        while(tempRoot != null) {

            // list of each child of this node
            ArrayList<Node> childList = new ArrayList<Node>();

            childList.removeAll(Collections.singleton(null));

            if(tempRoot.getChildren() != null)
                childList = tempRoot.getChildren();

            if(childList.size()==0) {
                return tempRoot.getClassOfParent();
            }

            for(int i = 0; i < childList.size(); i++) {

                Node thisChild = childList.get(0);
                System.out.println(thisChild);


                String classofparent = thisChild.getClassOfParent() ;
                String classtotest = h.getCustomClass(thisChild.getParentAttr().getName()) ;



              if(classofparent.equals(classtotest)) {
                  tempRoot = thisChild;
                  break;
                }
            }

            System.out.println("Temp root changed!");
        }

    return "Not found";
    }
}
