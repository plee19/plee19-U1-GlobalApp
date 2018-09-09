package us.plee19;

import java.util.*;

public class Main {

    private final static FileInput placesFile = new FileInput("places.csv");
    private final static FileInput stuffFile = new FileInput("stuff.csv");

    public static void main(String[] args) {
        String line;
        String[] fields;
        ArrayList<String> placesList;
        ArrayList<String> stuffList;
        // Create array of countries from places file, which corresponds to number of cities
        placesList = genCountryList(placesFile);
        // Create array of countries from stuff file, which corresponds to number of stuff (WITH DUPLICATES)
        stuffList = genCountryList(stuffFile);
        // Print number of cities for given country
        System.out.println(Collections.frequency(placesList, "India"));
        // Print number of stuff for given country (WITH DUPLICATES)
        System.out.println(Collections.frequency(stuffList, "India"));
        // Attempt at two file match WIP
        /*while ((line = placesFile.fileReadLine()) != null) {
            fields = line.split(",");

        }*/
    }

    public static ArrayList<String> genCountryList(FileInput file) {
        String line;
        String[] fields;
        ArrayList<String> countriesList = new ArrayList<>();

        while ((line = file.fileReadLine()) != null) {
            fields = line.split(",");
            countriesList.add(fields[0]);
        }
        return countriesList;
    }

    // WIP
    public static Set<String[]> genStuffList(FileInput file) {
        String line;
        String[] fields;
        String[] subArray = new String[2];
        List<String[]> stuffList = new ArrayList<>();

        while ((line = file.fileReadLine()) != null) {
            fields = line.split(",");
            subArray[0] = fields[0];
            subArray[1] = fields[1];
            stuffList.add(subArray);
        }
        System.out.println(subArray);
        Set<String[]> hs = new HashSet<>();
        hs.addAll(stuffList);
        stuffList.clear();
        stuffList.addAll(hs);

        return hs;
    }

}