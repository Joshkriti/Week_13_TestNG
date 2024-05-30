package gov.uk.check.visa.pagespackage;

import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.By;

public class WorkTypePage extends Utility {
    //2.WorkTypePage - nextStepButton, selectJobtypeList locators and create methods 'void
    //selectJobType(String job)'

    public void selectJobType(String job){

    }

    public void clickNextStepButton(){

        clickOnElement(By.xpath("//*[@class='gem-c-button govuk-button gem-c-button--bottom-margin']"));

    }
}
