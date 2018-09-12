package us.plee19.Test;

import junit.framework.TestCase;
import org.junit.*;
import us.plee19.FileInput;

import java.util.ArrayList;

import static us.plee19.Main.*;

public class MainTest extends TestCase {
    FileInput realSortedCities;
    FileInput realSortedStuff;
    FileInput badFile;

    @Before
    public void SetUp() {
        FileInput realSortedCities;
        FileInput realSortedStuff;
    }

    @After
    public void TakeDown() {
        realSortedStuff.fileClose();
        badFile.fileClose();
    }

    @Test
    public void testGetCountryListCities() {
        realSortedCities = new FileInput("realSortedCities.csv");
        ArrayList<String> countriesList;
        countriesList = getCountryListCities(realSortedCities);
        assert(countriesList.size() == 3);
    }

    @Test
    public void testEliminateDuplicates() {
        realSortedStuff = new FileInput("realSortedStuff.csv");
        ArrayList<String> stuffList;
        stuffList = eliminateDuplicates(realSortedStuff);
        assert(stuffList.size() == 2);
    }
}