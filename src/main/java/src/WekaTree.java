package main.java.src;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.meta.FilteredClassifier;
import weka.classifiers.trees.M5P;
import weka.classifiers.trees.REPTree;
import weka.filters.unsupervised.attribute.Remove;

/**
 * Created by chris on 5/13/2017.
 */
public class WekaTree {

    String results = "";

    public WekaTree(WekaData training, WekaData test) {

        // Command line options for tree
        String OPTIONS = "-M 2 -V 0.001 -N 3 -S 1 -L -1 -I 0.0";
        //String OPTIONS = "-M 4.0";
        int[] removeme = {0,1,1,0,0,1,1,0,0,0,0,0,0,0,0,1,1,1};

        boolean first = false;

        try {

            Remove rm = new Remove();

            for(int i = 0; i < removeme.length; i++) {
                if(removeme[i] != 0) {
                    rm.setAttributeIndices(Integer.toString(removeme[i]));
                }
            }


            String[] options = weka.core.Utils.splitOptions(OPTIONS);

            REPTree cls = new REPTree();
           // M5P cls = new M5P();
           // cls.setOptions(options);

            FilteredClassifier fc = new FilteredClassifier();
            fc.setFilter(rm);
            fc.setClassifier(cls);

            fc.buildClassifier(training.getData());

            Evaluation eval = new Evaluation(test.getData());
            eval.evaluateModel(cls, training.getData());
            results = eval.toSummaryString("\nResults\n====\n", false);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void run() {
        System.out.println(results);

    }
}
