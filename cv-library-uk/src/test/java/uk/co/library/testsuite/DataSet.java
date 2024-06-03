package uk.co.library.testsuite;

import org.testng.annotations.DataProvider;
import uk.co.library.testbase.TestBase;

public class DataSet extends TestBase {

    @DataProvider(name = "jobSearchData")
    public Object[][] getData() {
        return new Object[][]{
                {"Tester", "Harrow, Greater London", "5 miles", "30000", "50000", "Per annum", "Permanent", "Permanent Tester jobs in Harrow"},
                {"Engineer", "Wembley, Greater London", "15 miles", "20000", "60000", "Per annum", "part time", "Part Time Engineer jobs in Wembley"},
            //    {"Developer", "Harrow, Greater London", "10 miles", "30000", "50000", "Per annum", "Permanent", "Permanent Developer jobs in Harrow"},
               // {"Retail", "Harrow, Greater London", "5 miles", "20000", "70000", "Per annum", "Permanent", "Permanent Retail jobs in Harrow"},
             //   {"Manager", "Harrow, Greater London", "10 miles", "40000", "50000", "Per annum", "Permanent", "Permanent Manager jobs in Harrow"},
             //   {"Designer", "Harrow, Greater London", "20 miles", "30000", "60000", "Per annum", "Permanent", "Permanent Designer jobs in Harrow"}

        };



    }
}
