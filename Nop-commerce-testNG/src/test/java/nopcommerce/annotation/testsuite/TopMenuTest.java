package nopcommerce.annotation.testsuite;

import nopcommerce.annotation.testbase.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TopMenuTest extends TestBase {

    @Test(groups = { "smoke" })
    public void verifyPageNavigation() {
        clickOnElement(By.xpath("//*[@class='top-menu notmobile']/li/a"));
        clickOnElement(By.linkText("Electronics"));
   }

    @Test (groups = { "sanity" })
    public void apparel() {
        clickOnElement(By.linkText("Apparel"));
        clickOnElement(By.linkText("Digital downloads"));
    }

    @Test (groups = { "regression" })
    public void books() {
        clickOnElement(By.linkText("Books"));
        clickOnElement(By.linkText("Jewelry"));
    }

    @Test (groups = { "regression","smoke" })
    public void giftCards(){
        clickOnElement(By.linkText("Gift Cards"));
    }

}