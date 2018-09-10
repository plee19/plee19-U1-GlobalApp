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
        realSortedCities = new FileInput("realSortedCities.csv");
        realSortedStuff = new FileInput("realSortedStuff.csv");
    }

    @After
    public void TakeDown() {
        realSortedStuff.fileClose();
        badFile.fileClose();
    }

    //NullPointerException issues for these tests?
    @Test
    public void testGetCountryListCities() {
        ArrayList<String> countriesList;
        countriesList = getCountryListCities(realSortedCities);
        assert(countriesList.size() == 3);
    }

    @Test
    public void testEliminateDuplicates() {
        ArrayList<String> stuffList;
        stuffList = eliminateDuplicates(realSortedStuff);
        assert(stuffList.size() == 2);
    }

    @Test (expected = NullPointerException.class)
    public void testEmptyFile() {
        badFile = new FileInput("badFile.csv");
        System.out.println(getCountryListCities(badFile));
    }

}