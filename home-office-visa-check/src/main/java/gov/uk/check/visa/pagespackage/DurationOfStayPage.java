package gov.uk.check.visa.pagespackage;

import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.By;

public class DurationOfStayPage extends Utility {

    public void selectLengthOfStay(String moreOrLess){

        clickOnElement(By.xpath("//*[@class='govuk-radios']/div/input"));

    }
    public void clickNextStepButton(){

        clickOnElement(By.xpath("//*[@class='gem-c-button govuk-button gem-c-button--bottom-margin']"));

    }
}
