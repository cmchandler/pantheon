package main.java.src;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;


/**
 * PantheonDataSet: holds the main data
 */
public class PantheonDataSet {

    private final int NUMBEROFATTR = 10;

    // The data
    public static ArrayList<HistoricalFigure> dataset;

    // The number of records
    private int numberOfRecords;

    /**
     * Constructor if you already have a dataset
     * @param d the data to add
     */
    public PantheonDataSet(ArrayList<HistoricalFigure> d) {
        dataset = d;
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

        Attribute cityAttr = new Attribute();
        Attribute countryAttr = new Attribute();
        Attribute continentAttr = new Attribute();
        Attribute pageViewsAttr = new Attribute();
        Attribute avgViewsAttr = new Attribute();
        Attribute languagesAttr = new Attribute();
        Attribute domainAttr = new Attribute();
        Attribute sexAttr = new Attribute();
        Attribute occupationAttr = new Attribute();
        Attribute industryAttr = new Attribute();

        for(int i = 0; i < dataset.size()-1;i++) {//each person

            String city = dataset.get(i).getCity();
            String country = dataset.get(i).getCountry();
            String continent = dataset.get(i).getContinent();
            String pageViews = Integer.toString(dataset.get(i).getPage_views());
            String avgViews = Integer.toString(dataset.get(i).getAverage_views());
            String langages = Integer.toString(dataset.get(i).getArticle_languages());;
            String domain = dataset.get(i).getDomain();
            String sex = dataset.get(i).getSex();
            String occupation = dataset.get(i).getOccupation();
            String industry = dataset.get(i).getIndustry();

            cityAttr.add(city) ;
            countryAttr.add(country) ;
            continentAttr.add(continent) ;
            pageViewsAttr.add(pageViews) ;
            avgViewsAttr.add(avgViews) ;
            languagesAttr.add(langages) ;
            domainAttr.add(domain) ;
            sexAttr.add(sex) ;
            occupationAttr.add(occupation) ;
            industryAttr.add(industry) ;
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

    // needs how many classes, number in each class

    private int article_id;
    private String full_name;
    private Set<String> sex;//# of classes
    private int birth_year;
    private Set<String> city;
    private Set<String> state;
    private Set<String> country;
    private Set<String> continent;
    private double latitude;
    private double longitude;
    private Set<String> occupation;
    private Set<String> industry;
    private Set<String> domain;
    private int article_languages;
    private int page_views;
    private int average_views;
    private double historical_popularity_index;

    Set<Attribute> attributes;

}


