package us.plee19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    private final static FileInput placesFile = new FileInput("places.csv");
    private final static FileInput stuffFile = new FileInput("stuff.csv");

    public static void main(String[] args) {
        String line;
        String[] fields;
        ArrayList<String> countriesList = new ArrayList<>();
        countriesList = genArrayList(placesFile);
        Collections.sort(countriesList);
        System.out.println(Collections.frequency(countriesList, "India"));

        // Attempt at two file match WIP
        while ((line = placesFile.fileReadLine()) != null) {
            fields = line.split(",");

        }
    }

    public static ArrayList<String> genArrayList(FileInput file) {
        String line;
        String[] fields;
        ArrayList<String> countriesList = new ArrayList<>();

        while ((line = file.fileReadLine()) != null) {
            fields = line.split(",");
            countriesList.add(fields[0]);
        }
        return countriesList;
    }


}


