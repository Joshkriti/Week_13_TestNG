package gov.uk.check.visa.pagespackage;

import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.By;

public class ReasonForTravelPage extends Utility {

    public void selectReasonForVisit(String reason){

        clickOnElement(By.xpath("//*[@class='govuk-radios']/div[2]/input[1]"));

    }
    public void clickNextStepButton(){

        clickOnElement(By.xpath("//*[@class='gem-c-button govuk-button gem-c-button--bottom-margin']"));

    }
}
