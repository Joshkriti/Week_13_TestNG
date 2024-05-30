package gov.uk.check.visa.pagespackage;

import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SelectNationalityPage extends Utility {

    public void selectNationality(String nationality) {
        selectByValueFromDropDown(By.className("govuk-select"), "Australia");
    }

    public void clickNextStepButton(){

        WebElement nextStepButton = driver.findElement(By.xpath("//*[@class='gem-c-button govuk-button gem-c-button--bottom-margin']"));
        nextStepButton.click();
    }

}
