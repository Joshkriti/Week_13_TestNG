package yourstore.annotation.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import yourstore.annotation.testbase.TestBase;

public class DesktopsTest extends TestBase {

    /*
    2. Test name verifyProductAddedToShoppingCartSuccessFully()
        2.1 Mouse hover on Desktops Tab. and click --> 2.2 Click on “Show All Desktops”
        2.3 Select Sort By position "Name: A to Z" --> 2.4 Select product “HP LP3065”
        2.5 Verify the Text "HP LP3065" --> 2.6 Select Delivery Date "2022-11-30"
        2.7.Enter Qty "1” using Select class. --> 2.8 Click on “Add to Cart” button
        2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        2.10 Click on link “shopping cart” display into success message
        2.11 Verify the text "Shopping Cart" --> 2.12 Verify the Product name "HP LP3065"
        2.13 Verify the Delivery Date "2022-11-30" --> 2.14 Verify the Model "Product21"
        2.15 Verify the Todat "£74.73"
     */
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() {

        Actions action = new Actions(driver);
        WebElement desktop = driver.findElement(By.xpath("//a[text()='Desktops']"));
        WebElement click = driver.findElement(By.xpath("//a[text()='Show AllDesktops']"));
        action.moveToElement(desktop).moveToElement(click).click().build().perform();

        selectMenu("Show All Desktops");

        selectByVisibleTextFromDropDown(By.cssSelector("*[id='input-sort']"),"Name (A - Z)");

        clickOnElement(By.xpath("//*[text()='HP LP3065']"));

        clearElement(By.name("option[225]"));

        driver.findElement(By.name("option[225]")).sendKeys("2022-11-30");

        clearElement(By.cssSelector("*[id='input-quantity']"));

        driver.findElement(By.cssSelector("*[id='input-quantity']")).sendKeys("1");

        clickOnElement(By.cssSelector("*[id='button-cart']"));

        /*String actualMessage = driver.findElement(By.cssSelector("*[class='alert alert-success alert-dismissible']")).getText();
        System.out.println(actualMessage);
        String expectingMessage = "Success: You have added HP LP3065 to your shopping cart!\n" + "×";
        Assert.assertEquals("Message to add into card successfully ", actualMessage, expectingMessage);*/

        clickOnElement(By.xpath("//a[text()='shopping cart']"));

        SoftAssert deliveryDate = new SoftAssert();
        String actualDeliveryDate = driver.findElement(By.xpath("//*[@id='content']/form/div/table/tbody/tr/td[2]/small")).getText();
        String expectingDeliveryDate = "Delivery Date:2022-11-30";
        deliveryDate.assertEquals( actualDeliveryDate, expectingDeliveryDate);

        SoftAssert model = new SoftAssert();
        String actualModel = driver.findElement(By.xpath("//*[@id='content']/form/div/table/tbody/tr/td[3]")).getText();
        String expectingModel = "Product 21";
        model.assertEquals(actualModel, expectingModel);

        SoftAssert total = new SoftAssert();
        String actualTotal = driver.findElement(By.xpath("//*[@id='content']/form/div/table/tbody/tr/td[6]")).getText();
        String expectingTotal = "$122.00";
        total.assertEquals( actualTotal, expectingTotal);
    }

}

