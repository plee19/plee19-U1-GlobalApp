package us.plee19;

import java.util.*;

/**
 * Main class used to demonstrate methods relating the places and stuff files.
 * @author plee19
 * @version 1
 */
public class Main {
    // Try/catch for FileInput does not occur, since the initialization is handled before the main method
    private final static FileInput placesFile = new FileInput("places.csv");
    private final static FileInput stuffFile = new FileInput("stuff.csv");

    public static void main(String[] args) {
        String line;
        String[] fields;
        String[] strings = new String[2];
        ArrayList<String> placesList;
        ArrayList<String> stuffList;

        // Create array of countries from places file, which corresponds to number of cities
        placesList = getCountryListCities(placesFile);
        // Sort array of countries
        Collections.sort(placesList);


        // Create array of countries from stuff file, corresponding to number of stuff
        stuffList = eliminateDuplicates(stuffFile);

        // Set up format
        System.out.println("Country                 Cities   Stuff\n=======                 ======   =====");
        String lastPlace = "";

        // Print one line per country, with output of country, frequency of cities from that country, frequency of stuff from that country
        for (int i = 1; i < placesList.size(); i++) {
            if (!placesList.get(i).equals(lastPlace)) {
                System.out.format("%-22s   %4d   %4d\n", placesList.get(i), Collections.frequency(placesList, placesList.get(i)), Collections.frequency(stuffList, placesList.get(i)));
            }
            lastPlace = placesList.get(i);
        }

        // Close files
        placesFile.fileClose();
        stuffFile.fileClose();
    }

    /**
     * Generate an ArrayList of String countries from a CSV file, for the purpose of counting cities (one country name per city in that country)
     * @param file Input file of country and city CSV
     * @return ArrayList of String values (country names)
     */
    public static ArrayList<String> getCountryListCities(FileInput file) {
        String line;
        String[] fields;
        ArrayList<String> countriesList = new ArrayList<>();

        while ((line = file.fileReadLine()) != null) {
            fields = line.split(",");
            countriesList.add(fields[0]);
        }
        return countriesList;
    }

    /**
     * Generate an ArrayList of String countries from a CSV file, for the purpose of counting stuff (one country name per stuff in that country)
     * @param file Input file of country and stuff CSV
     * @return ArrayList of String values (country names)
     */
    public static ArrayList<String> eliminateDuplicates(FileInput file) {
        String currentStuff = "";
        String line;
        String[] fields;
        ArrayList<String> noDuplicates = new ArrayList<>();

        while ((line = file.fileReadLine()) != null) {
            fields = line.split(",");
            if (!fields[1].equals(currentStuff)) {
                noDuplicates.add(fields[0]);
            }
            currentStuff = fields[1];

        }
        return noDuplicates;
    }

}