package main.java;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * PantheonDataSet: holds the main data
 */
public class PantheonDataSet {

    private ArrayList<HistoricalFigure> dataset;
    private int numberOfRecords = 0;

    public PantheonDataSet(String filename) {

        dataset = new ArrayList<>();
        BufferedReader br = null;
        String line = "";

        try {
            br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null) {
                String[] readData = line.split(",");
                numberOfRecords++;

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
                        System.out.println("Added " + h.getFull_name());
            }
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

    public int getNumberOfRecords() {
        return numberOfRecords;
    }
}
