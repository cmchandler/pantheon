package main.java.src;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;
import java.util.jar.Attributes;


/**
 * PantheonDataSet: holds the main data
 */
public class PantheonDataSet {

    private final int NUMBEROFATTR = 10;
    PantheonDataSet p;
    FileWriter fw = null;
    CSVPrinter csvp = null;

    // The data
    public ArrayList<HistoricalFigure> dataset;

    // The number of records
    private int numberOfRecords;

    ArrayList<Attribute> attributeList;
    public static Attribute target;
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

        ArrayList<Integer> toRemove = new ArrayList<>();

        for(int i = 0; i < dataset.size();i++) {//each person

            String city = dataset.get(i).getCity();
            String country = dataset.get(i).getCountry();
            String continent = dataset.get(i).getContinent();

            //String pageViews = Integer.toString(dataset.get(i).getPage_views());
            //String avgViews = Integer.toString(dataset.get(i).getAverage_views());
            //String langages = Integer.toString(dataset.get(i).getArticle_languages());;

            // Make values discrete by hand

            String pageViews;
            if(dataset.get(i).getPage_views() > 1000000) {
                pageViews = "high";
            }

            else if(dataset.get(i).getPage_views() > 1000000) {
                pageViews = "medium";
            }
            else {
                pageViews = "low";
            }

            String avgViews;
            if(dataset.get(i).getAverage_views() > 1000000) {
                avgViews = "high";
            }
            else if(dataset.get(i).getAverage_views() > 1000000) {
                avgViews = "medium";
            }
            else {
                avgViews = "low";
            }

            String langages;
            if(dataset.get(i).getArticle_languages() > 90) {
                langages = "high";
            }
            else if(dataset.get(i).getArticle_languages() > 50) {
                langages = "medium";
            }
            else {
                langages = "low";
            }

            String domain = dataset.get(i).getDomain();
            String sex = dataset.get(i).getSex();
            String occupation = dataset.get(i).getOccupation();
            String industry = dataset.get(i).getIndustry();

            // check for emptystrings or nulls
            if(city.equals("") || city.equals(null)) toRemove.add(i);
            else if(country.equals("") || country.equals(null)) toRemove.add(i);
            else if(continent.equals("") || continent.equals(null)) toRemove.add(i);
            else if(pageViews.equals("") || pageViews.equals(null)) toRemove.add(i);
            else if(avgViews.equals("") || avgViews.equals(null)) toRemove.add(i);
            else if(langages.equals("") || langages.equals(null)) toRemove.add(i);
            else if(domain.equals("") || domain.equals(null)) toRemove.add(i);
            else if(sex.equals("") || sex.equals(null)) toRemove.add(i);
            else if(occupation.equals("") || occupation.equals(null)) toRemove.add(i);
            else if(industry.equals("") || industry.equals(null)) toRemove.add(i);

            cityAttr.add(city) ;
            cityAttr.setName("city");
            countryAttr.add(country) ;
            countryAttr.setName("country");
            continentAttr.add(continent) ;
            continentAttr.setName("continent");
      //      pageViewsAttr.add(pageViews) ;
      //      pageViewsAttr.setName("page_views");
      //      avgViewsAttr.add(avgViews) ;
      //      avgViewsAttr.setName("avg_views");
      //      languagesAttr.add(langages) ;
      //      languagesAttr.setName("languages");
            domainAttr.add(domain) ;
            domainAttr.setName("domain");
            sexAttr.add(sex) ;
            sexAttr.add("sex");
            occupationAttr.add(occupation) ;
            occupationAttr.setName("occupation");
            industryAttr.add(industry) ;
            industryAttr.setName("industry");
        }

        for(int i = toRemove.size()-1; i >=0; i--) {
            dataset.remove(toRemove.get(i));
        }

        attributeList = new ArrayList<>();
        attributeList.add(cityAttr);
        attributeList.add(countryAttr);
        attributeList.add(continentAttr);
       // attributeList.add(pageViewsAttr);
       // attributeList.add(avgViewsAttr);
       // attributeList.add(languagesAttr);
        attributeList.add(domainAttr);
    //    attributeList.add(sexAttr);
       // attributeList.add(occupationAttr);
        attributeList.add(industryAttr);

        for(int i = 0; i < attributeList.size();i++) {
            System.out.println("Attributes from data set class: " + attributeList.get(i).getName());
        }

        //industryAttr.getEntropy(dataset.size());

        //#####################################################################################
        target = occupationAttr;
        //#####################################################################################
        /*
        for(int i = 0; i < attributeList.size()-1;i++) {
          //  System.out.print("Info gain from ");
           // System.out.print(attributeList.get(i).getName());
            //System.out.println(": ");
            //double test = ID3.getGain(attributeList.get(i),occupationAttr,dataset.size());
           System.out.print(test);
           System.out.print("\n");
        }
        */
    }

    /**
     *
     */
    public Attribute getTarget() {
        return target;
    }

    /**
     * @return number of records this object contains
     */
    public int getNumberOfRecords() {
        return numberOfRecords;
    }

    /**
     *
     */
    public ArrayList<Attribute> getAttributes() {
        return attributeList;
    }

    /**
     * Finds historical figure by full_name field
     * @param name the name to search for
     * @return the HistoricalFigure if found or null if not
     */
    public HistoricalFigure find(String name) {
        for (int i = 0; i < dataset.size(); i++) {
            if(dataset.get(i).getFull_name().equalsIgnoreCase(name)) {
                return dataset.get(i);
            }
        }
        return null;
    }


    /**
     * Returns an array for a header for printing to a csv
     */
    private static final Object[] FILE_HEADER =
            {"article_id","full_name","sex","birth_year","city","state",
                    "country", "continent","latitude","longitude","occupation",
                    "industry","domain","article_languages","page_views",
                    "average_views","historical_popularity_index"};

    /**
     * Writes data in dataset to new csv file
     * @param filename the name of the file to generate
     */
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

    public ArrayList<HistoricalFigure> getDataset() {
        return dataset;
    }


}


