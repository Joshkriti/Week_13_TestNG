package gov.uk.check.visa.pagespackage;

import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.By;

public class FamilyImmigrationStatusPage extends Utility {

    public void selectImmigrationStatus(String status){

    }
    public void clickNextStepButton(){

        clickOnElement(By.xpath("//*[@class='gem-c-button govuk-button gem-c-button--bottom-margin']"));

    }

}
