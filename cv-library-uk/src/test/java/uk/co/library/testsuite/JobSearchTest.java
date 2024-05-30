package uk.co.library.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
            String result) {
        clickOnElement(By.xpath("//input[@class='form__input']"));
        WebElement jobTitle1 = driver.findElement(By.xpath("//input[@class='form__input']"));
        jobTitle1.sendKeys(jobTitle);

    }

    public void jobTitle(String jobTitle) {
        clickOnElement(By.xpath("//input[@class='form__input']"));
    }

    @Test
    public void verifyJobSearchResult() {
      /*  jobTitle("Tester");
        driver.findElement(By.xpath("//input[@class='form__input']")).sendKeys("Tester");*/
    }
}



