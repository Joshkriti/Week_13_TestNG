package gov.uk.check.visa.testsuite;

import gov.uk.check.visa.testbase.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VisaConfirmationTest extends TestBase {
    /*
    1.anAustralianCominToUKForTourism().
        Click on start button
        Select a Nationality 'Australia'
        Click on Continue button
        Select reason 'Tourism'
        Click on Continue button
        verify result 'You will not need a visa to come to the UK'
     */
    @Test (priority = 1)
    public void anAustralianComingToUKForTourism(){
        clickOnElement(By.xpath("//*[@class='gem-c-button govuk-button govuk-button--start']"));

        selectByVisibleTextFromDropDown(By.className("govuk-select"), "Australia");

        clickOnElement(By.xpath("//*[@class='gem-c-button govuk-button gem-c-button--bottom-margin']"));

        clickOnElement(By.xpath("//*[@class='govuk-radios']/div/input[1]"));

        clickOnElement(By.xpath("//*[@class='gem-c-button govuk-button gem-c-button--bottom-margin']"));

        SoftAssert verify = new SoftAssert();
        String actualOutcome = driver.findElement(By.xpath("//*[@class='govuk-!-margin-bottom-6']/h2")).getText();
        String expectingOutcome = "You will not need a visa to come to the UK";
        verify.assertEquals(actualOutcome,expectingOutcome);
    }
    /*
    2.aChileanComingToTheUKForWorkAndPlansOnStayingForLongerThanSixMonths().
        Click on start button
        Select a Nationality 'Chile'
        Click on Continue button
        Select reason 'Work, academic visit or business'
        Click on Continue button
        Select intendent to stay for 'longer than 6 months'
        Click on Continue button
        Select have planning to work for 'Health and care professional'
        Click on Continue button
        verify result 'You need a visa to work in health and care'
     */

    @Test (priority = 2)
    public void aChileanComingToTheUKForWorkAndPlansOnStayingForLongerThanSixMonths(){
        clickOnElement(By.xpath("//*[@class='gem-c-button govuk-button govuk-button--start']"));

        selectByVisibleTextFromDropDown(By.className("govuk-select"), "Chile");

        clickOnElement(By.xpath("//*[@class='gem-c-button govuk-button gem-c-button--bottom-margin']"));

        clickOnElement(By.xpath("//*[@class='govuk-radios']/div[2]/input[1]"));

        clickOnElement(By.xpath("//*[@class='gem-c-button govuk-button gem-c-button--bottom-margin']"));

        clickOnElement(By.xpath("//*[@class='govuk-radios']/div[2]/input"));

        clickOnElement(By.xpath("//*[@class='gem-c-button govuk-button gem-c-button--bottom-margin']"));

        clickOnElement(By.xpath("//*[@class='govuk-radios']/div/input"));

        clickOnElement(By.xpath("//*[@class='gem-c-button govuk-button gem-c-button--bottom-margin']"));

        SoftAssert verifyText = new SoftAssert();
        String actualText = driver.findElement(By.xpath("//*[@class='govuk-!-margin-bottom-6']/h2")).getText();
        String expectingText = "You need a visa to work in health and care";
        verifyText.assertEquals(actualText,expectingText);
    }
    /*
    3.aColumbianNationalComingToTheUKToJoinAPartnerForALongStayTheyDoHaveAnArticle10Or20Card()
        Click on start button
        Select a Nationality 'Colombia'
        Click on Continue button
        Select reason 'Join partner or family for a long stay'
        Click on Continue button
        Select state My partner of family member have uk immigration status 'yes'
        Click on Continue button
        verify result 'You’ll need a visa to join your family or partner in the UK'
     */
    @Test (priority = 3)
    public void aColumbianNationalComingToTheUKToJoinAPartnerForALongStayTheyDoHaveAnArticle10Or20Card(){
        clickOnElement(By.xpath("//*[@class='gem-c-button govuk-button govuk-button--start']"));

        selectByVisibleTextFromDropDown(By.className("govuk-select"), "Colombia");

        clickOnElement(By.xpath("//*[@class='gem-c-button govuk-button gem-c-button--bottom-margin']"));

        clickOnElement(By.xpath("//*[@class='govuk-radios']/div[5]/input"));

        clickOnElement(By.xpath("//*[@class='gem-c-button govuk-button gem-c-button--bottom-margin']"));





    }
}
