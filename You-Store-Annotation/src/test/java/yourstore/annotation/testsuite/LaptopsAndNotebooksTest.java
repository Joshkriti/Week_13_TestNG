package yourstore.annotation.testsuite;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import yourstore.annotation.testbase.TestBase;

public class LaptopsAndNotebooksTest extends TestBase {

    /*
    2. Test name verifyThatUserPlaceOrderSuccessfully()
        2.1 Mouse hover on Laptops & Notebooks Tab and click
        2.2 Click on “Show All Laptops & Notebooks”
        2.3 Select Sort By "Price (High > Low)"
        2.4 Select Product “MacBook”
        2.5 Verify the text “MacBook”
        2.6 Click on ‘Add To Cart’ button
        2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        2.8 Click on link “shopping cart” display into success message
        2.9 Verify the text "Shopping Cart"
        2.10 Verify the Product name "MacBook"
        2.11 Change Quantity "2"
        2.12 Click on “Update” Tab
        2.13 Verify the message “Success: You have modified your shopping cart!”
        2.14 Verify the Total £737.45
        2.15 Click on “Checkout” button
        2.16 Verify the text “Checkout”
        2.17 Verify the Text “New Customer”
        2.18 Click on “Guest Checkout” radio button
        2.19 Click on “Continue” tab
        2.20 Fill the mandatory fields
        2.21 Click on “Continue” Button
        2.22 Add Comments About your order into text area
        2.23 Check the Terms & Conditions check box
        2.24 Click on “Continue” button
        2.25 Verify the message “Warning: Payment method required!”
     */
    @Test
    public void verifyThatUserPlaceOrderSuccessfully() {

        Actions action = new Actions(driver);
        WebElement laptopAndNotebooks = driver.findElement(By.xpath("//a[text()='Laptops & Notebooks']"));
        WebElement click = driver.findElement(By.xpath("//a[text()='Show AllLaptops & Notebooks']"));
        action.moveToElement(laptopAndNotebooks).moveToElement(click).click().build().perform();

        selectByContainsTextFromDropDown(By.xpath("//*[@class='form-control']"),"Price (High > Low)");

        clickOnElement(By.linkText("MacBook"));

        String actualText = driver.findElement(By.xpath("//*[@id='content']/div/div[2]/h1")).getText();
        String expectingText = "MacBook";
        Assert.assertEquals("MacBook: ", actualText, expectingText);

        clickOnElement(By.id("button-cart"));

        String actualMessage = driver.findElement(By.cssSelector("*[class='alert alert-success alert-dismissible']")).getText();
        System.out.println(actualMessage);
        String expectingMessage = "Success: You have added MacBook to your shopping cart!\n" + "×";
        Assert.assertEquals("Verification message: ", actualMessage, expectingMessage);

        clickOnElement(By.xpath("//a[text()='shopping cart']"));

        SoftAssert shoppingCart = new SoftAssert();
        String actualShoppingCart = driver.findElement(By.xpath("//div[@id='content']/h1[1]")).getText();
        String expectingShoppingCart = "Shopping Cart  (0.00kg)";
        shoppingCart.assertEquals(actualShoppingCart, expectingShoppingCart);

        clearElement(By.xpath("//*[@class='input-group btn-block']/input"));

        driver.findElement(By.xpath("//*[@class='input-group btn-block']/input")).sendKeys("2");

        clickOnElement(By.cssSelector("*[class='fa fa-refresh']"));

        String actualVerifyMessage = driver.findElement(By.cssSelector("*[class='alert alert-success alert-dismissible']")).getText();
        System.out.println(actualVerifyMessage);
        String expectingVerifyMessage = "Success: You have modified your shopping cart!\n" + "×";
        Assert.assertEquals(expectingVerifyMessage, actualVerifyMessage);


        clickOnElement(By.xpath("//*[@class='pull-right']/a"));


    }
}
