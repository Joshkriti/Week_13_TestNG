package gov.uk.check.visa;

import gov.uk.check.visa.managedriver.ManageDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PagesPackage extends ManageDriver {
    public void clickStartNow() {
        WebElement startNowButton = driver.findElement(By.xpath("//*[@class='gem-c-button govuk-button govuk-button--start']/span"));
        startNowButton.click();
    }


}
