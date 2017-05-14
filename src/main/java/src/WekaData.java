package main.java.src;

import weka.core.Instances;
import java.io.BufferedReader;
import java.io.FileReader;
import weka.core.converters.ConverterUtils.DataSource;

/**
 * Created by chris on 5/13/2017.
 */
public class WekaData {

    Instances data;

    /**
     * Reads a file to load into instance
     * @param filename
     * @param classIndex
     */
    public void readFile(String filename, int classIndex) {

        try{
            DataSource source = new DataSource(filename);
            data = source.getDataSet();

            if (data.classIndex() == -1) {
                data.setClassIndex(classIndex);
            }
            System.out.println("Found " + data.numInstances() + " items with " +
                    data.numAttributes() + " attributes.");

        } catch (Exception e) {
            System.out.println("Can't read file " + filename);
        }
    }

    public Instances getData() {
        return data;
    }
}