package main.java.src;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * PantheonDataSet: holds the main data
 */
public class PantheonDataSet {

    // The data
    private ArrayList<HistoricalFigure> dataset;

    // The number of records
    private int numberOfRecords;

    /**
     * Constructor if you already have a dataset
     * @param dataset the data to add
     */
    public PantheonDataSet(ArrayList<HistoricalFigure> dataset) {
        this.dataset = dataset;
        this.numberOfRecords = dataset.size();
    }

    /**
     * Reads from a csv with passed filename and loads into new object
     * @param filename the csv file to load
     */
    public PantheonDataSet(String filename) {

        dataset = new ArrayList<>();
        numberOfRecords = 0;
        BufferedReader br = null;
        String line = "";

        // Load all data into object from file
        try {
            br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null) {
                String[] readData = line.split(",");

                if(!readData[0].matches("^-?\\d+$")) readData[0]="0";
                if(!readData[3].matches("^-?\\d+$")) readData[3]="0";
                if(!readData[8].matches("^-?\\d+$")) readData[8]="0";
                if(!readData[9].matches("^-?\\d+$")) readData[9]="0";
                if(!readData[13].matches("^-?\\d+$")) readData[13]="0";
                if(!readData[14].matches("^-?\\d+$")) readData[14]="0";
                if(!readData[15].matches("^-?\\d+$")) readData[15]="0";
                if(!readData[16].matches("^-?\\d+$")) readData[16]="0";

                HistoricalFigure h = new HistoricalFigure.HistoricalFigureBuilder()
                        .article_id(Integer.parseInt(readData[0]))
                        .full_name(readData[1])
                        .sex(readData[2])
                        .birth_year(Integer.parseInt(readData[3]))
                        .city(readData[4])
                        .state(readData[5])
                        .country(readData[6])
                        .continent(readData[7])
                        .latitude(Double.parseDouble(readData[8]))
                        .longitude(Double.parseDouble(readData[9]))
                        .occupation(readData[10])
                        .industry(readData[11])
                        .domain(readData[12])
                        .article_languages(Integer.parseInt(readData[13]))
                        .page_views(Integer.parseInt(readData[14]))
                        .average_views(Integer.parseInt(readData[15]))
                        .historical_popularity_index(Double.parseDouble(readData[16]))
                        .build();
                        //System.out.println("Added " + h.getFull_name());
                dataset.add(h);
            }
            numberOfRecords = dataset.size();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IO Exception." );
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println("IO Exception: EOF");
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * @return number of records this object contains
     */
    public int getNumberOfRecords() {
        return numberOfRecords;
    }


    /**
     * Splits the data randomly into 3/10 and returns the test data.  Removes these records from the object.
     * @return the PantheonDataSet containing all of the randomly selected records.
     */
    public PantheonDataSet splitTestData() {

        Random r = new Random(System.currentTimeMillis());

        ArrayList<HistoricalFigure> testData = new ArrayList<>();

        for(int i = 0; i < dataset.size(); i++) {
            if(r.nextInt(9)>6) {
                testData.add(dataset.get(i));
                dataset.remove(i);
            }
        }
        numberOfRecords = dataset.size();

        return new PantheonDataSet(testData);
    }

    /**
     * Finds historical figure by full_name field
     * @param name the name to search for
     * @return the HistoricalFigure if found or null if not
     */
    public HistoricalFigure find(String name) {
        for (int i = 0; i < dataset.size(); i++) {
            if(dataset.get(i).getFull_name().equals(name)) {
                return dataset.get(i);
            }
        }
        return null;
    }

    PantheonDataSet p;
    FileWriter fw = null;
    CSVPrinter csvp = null;

    private static final Object[] FILE_HEADER =
            {"article_id","full_name","sex","birth_year","city","state",
                    "country", "continent","latitude","longitude","occupation",
                    "industry","domain","article_languages","page_views",
                    "average_views","historical_popularity_index"};


    public void write(String filename) {
        CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator("\n");
        try {
            fw = new FileWriter(filename);
            csvp = new CSVPrinter(fw,csvFileFormat);

            // print header
            csvp.printRecord(FILE_HEADER);

            for(int i = 0; i < dataset.size(); i++) {
                csvp.printRecord(dataset.get(i).getData());
            }
            fw.flush();
            fw.close();
            csvp.close();
        } catch (Exception e) {
            System.out.println("Problem writing to file " + filename);
        }

    }
}


