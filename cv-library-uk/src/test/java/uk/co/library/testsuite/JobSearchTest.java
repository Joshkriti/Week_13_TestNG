package uk.co.library.testsuite;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import uk.co.library.testbase.TestBase;

public class JobSearchTest extends TestBase {

    @Test
    public void verifyJobSearchResultUsingDifferentDataSet(
            String jobTitle,
            String location,
            String distance,
            String salaryMin,
            String salaryMax,
            String salaryType,
            String jobType,
            String result){

        driver.findElement(By.className("form__input")).sendKeys("Tester");

    }
}
