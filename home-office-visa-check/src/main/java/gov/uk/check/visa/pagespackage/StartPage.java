package gov.uk.check.visa.pagespackage;

import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class StartPage extends Utility {

    //1.StartPage - startNowButton locatores and create method 'void clickStartNow()'

    public void clickStartNow() {
        WebElement startNowButton = driver.findElement(By.xpath("//*[@class='gem-c-button govuk-button govuk-button--start']/span"));
        startNowButton.click();
    }
}
