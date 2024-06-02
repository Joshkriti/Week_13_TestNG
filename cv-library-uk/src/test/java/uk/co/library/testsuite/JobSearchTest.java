package uk.co.library.testsuite;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import uk.co.library.pagespackage.HomePage;

public class JobSearchTest extends DataSet {


    @Test (dataProvider = "jobSearchData", dataProviderClass = JobSearchTest.class)
    public void verifyJobSearchResultUsingDifferentDataSet(
            String jobTitle,
            String location,
            String distance,
            String salaryMin,
            String salaryMax,
            String salaryType,
            String jobType,
            String result) {

        HomePage homepage = new HomePage(driver);

        driver.switchTo().frame("gdpr-consent-notice");
        driver.findElement(By.xpath("//*[text()='Accept All']")).click();
        driver.switchTo().defaultContent();

        homepage.enterJobTitle(jobTitle);
        homepage.enterLocation(location);
        homepage.selectDistance(distance);
        homepage.clickMoreSearchOptions();
        homepage.enterSalaryMin(salaryMin);
        homepage.enterSalaryMax(salaryMax);
        homepage.selectSalaryType(salaryType);
        homepage.selectJobType(jobType);
        homepage.clickFindJobsButton();


    }



    }




