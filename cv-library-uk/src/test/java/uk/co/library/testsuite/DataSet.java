package uk.co.library.testsuite;

import org.testng.annotations.DataProvider;
import uk.co.library.testbase.TestBase;

public class DataSet extends TestBase {

    @DataProvider(name = "jobSearchData")
    public Object[][] getData() {
        return new Object[][]{
                {"Tester", "Harrow, Greater London", "5 miles", "30000", "50000", "Per annum", "Permanent", "Permanent Tester jobs in Harrow"},
                {"Engineer", "Wembley, Greater London", "15 miles", "20000", "60000", "Per annum", "part time", "Part Time Engineer jobs in Wembley"},
                {"Developer", "Bristol, City of Bristol", "10 miles", "30000", "50000", "Per annum", "contracted", "Contract Developer jobs in Bristol"},
                {"Retail", "Birmingham, Greater London", "5 miles", "20000", "70000", "Per annum", "Permanent", "Permanent Retail jobs in Birmingham"},
                {"Manager", "Edinburgh, City of Edinburgh", "10 miles", "40000", "50000", "Per annum", "part time", "Part Time Manager jobs in Edinburgh"},
                {"Designer", "London", "20 miles", "30000", "60000", "Per annum", "Permanent", "Permanent Designer jobs in London"}

        };



    }
}
