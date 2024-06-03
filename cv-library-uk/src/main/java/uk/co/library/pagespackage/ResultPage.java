package uk.co.library.pagespackage;

import org.openqa.selenium.WebDriver;

public class ResultPage extends HomePage {

    public ResultPage(WebDriver driver) {
        super(driver);
    }

    public String getResultText() {
            return driver.findElement(resultText).getText();

    }

    public void verifyTheResults() {
        // String MyString = "Permanent Designer jobs in Harrow";
        //  String[] arrOfString = MyString.split("Permanet", 6);


            }

}
