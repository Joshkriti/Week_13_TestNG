package gov.uk.check.visa.pagespackage;

import gov.uk.check.visa.managedriver.ManageDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PagesPackage extends ManageDriver {
    public void clickStartNow(By by) {
        WebElement loginLink = driver.findElement(by);
        loginLink.click();
    }

    public void selectJobType(By by) {
        WebElement jobType = driver.findElement(by);
        jobType.click();
    }

    public void selectNationality(By by ,String nationality) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(nationality);
    }

    public void selectReasonForVisit(By by){
        WebElement reason = driver.findElement(by);
        reason.click();
    }
    public void selectImmigrationStatus(By by){
        WebElement status = driver.findElement(by);
        status.click();
    }
    public void selectLengthOfStay(By by){
        WebElement loginLink = driver.findElement(by);
        loginLink.click();
    }

    public void clickNextStepButton(By by) {
        WebElement nextStepButton = driver.findElement(by);
        nextStepButton.click();

    }
    public void getResultMessage() {

    }

    public void confirmResultMessage(String expectedMessage) {

    }
}
