package nop.commerce.testsuite;

import nop.commerce.testbase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Random;

public class Electronic extends TestBase {
    public Random randomGenerator = new Random();
    char[] password= generatePassword(8);
    String loginPassword = new String(password);
    String emailId=generateRandomEmail();

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement electronic = driver.findElement(By.xpath("//div[@class='header-menu']/ul[1]/li[2]/a"));
        WebElement cellPhones = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]/ul[1]/li[2]/a"));
        action.moveToElement(electronic).moveToElement(cellPhones).click().build().perform();

       /*mouseHoverToElementAndClick(By.xpath("//div[@class='header-menu']/ul[1]/li[2]/a"));{
            Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]/ul/li[2]/a"))).click().build().perform();

        }*/
        //2.4 Click on List View Tab
        clickOnElement(By.xpath("//div[@class='product-viewmode']/a[2]"));

        //2.5 Click on product name “Nokia Lumia 1020” link
        WebElement button = driver.findElement(By.xpath("//*[text()='Nokia Lumia 1020']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(button));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//*[text()='Nokia Lumia 1020']"));

        //2.6 Verify the text “Nokia Lumia 1020”
        SoftAssert text = new SoftAssert();
        String actualText = driver.findElement(By.cssSelector("div[class='overview']>div>h1")).getText();
        String expectingText = "Nokia Lumia 1020";
        text.assertEquals(actualText,expectingText);

        //2.7 Verify the price “$349.00”
        SoftAssert price = new SoftAssert();
        String actualPrice = driver.findElement(By.cssSelector("div[class='prices']>div>span")).getText();
        String expectingPrice = "$349.00";
        price.assertEquals(actualPrice,expectingPrice);

        driver.findElement(By.id("product_enteredQuantity_20")).clear();

        //2.8 Change quantity to 2
        driver.findElement(By.id("product_enteredQuantity_20")).sendKeys("2");

        //2.9 Click on “ADD TO CART” tab
        clickOnElement(By.cssSelector("div[class='add-to-cart-panel']>button"));

        Thread.sleep(2000);

        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        SoftAssert message = new SoftAssert();
        String actualMessage = driver.findElement(By.cssSelector("div[class='bar-notification success']>p")).getText();
        String expectingMessage = "The product has been added to your shopping cart";
        message.assertEquals(actualMessage,expectingMessage);

        //After that close the bar clicking on the cross button.
        clickOnElement(By.cssSelector("span[class='close']"));

        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        Actions action1 = new Actions(driver);
        WebElement shoppingCart = driver.findElement(By.cssSelector("*[class='cart-label']"));
        WebElement goToCart = driver.findElement(By.xpath("//*[@id='flyout-cart']/div/div[4]/button"));
        Thread.sleep(2000);
        action1.moveToElement(shoppingCart).moveToElement(goToCart).click().build().perform();

        //2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.cssSelector("div[class='terms-of-service']>label"));

        //2.16 Click on “CHECKOUT”
        clickOnElement(By.cssSelector("div[class='checkout-buttons']>button"));

        //2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[@class='button-1 register-button']"));

        //2.19 Verify the text “Register”
        SoftAssert register = new SoftAssert();
        String actualRegisterSuccessful = driver.findElement(By.xpath("//div[@class='page-body']/div[1]")).getText();
        String expectingRegisterSuccessful = "Your registration completed";
        register.assertEquals(actualRegisterSuccessful,expectingRegisterSuccessful);

        //2.20 Fill the mandatory fields
        clickOnElement(By.className("female"));

        driver.findElement(By.id("FirstName")).sendKeys("Komal");

        driver.findElement(By.name("LastName")).sendKeys("Kanji");

        selectByIndexFromDropDown(By.name("DateOfBirthDay"),13);

        selectByVisibleTextFromDropDown(By.name("DateOfBirthMonth"),"September");

        WebElement sortYear = driver.findElement(By.name("DateOfBirthYear"));
        Select selectYear= new Select(sortYear);
        selectYear.selectByVisibleText("1998");

        driver.findElement(By.id("Email")).sendKeys(emailId);

        Thread.sleep(2000);

        driver.findElement(By.id("Password")).sendKeys(loginPassword);

        driver.findElement(By.name("ConfirmPassword")).sendKeys(loginPassword);

        //2.21 Click on “REGISTER” Button
        driver.findElement(By.id("register-button")).click();

        //2.22 Verify the message “Your registration completed”
        SoftAssert verify = new SoftAssert();
        String actualSuccessful = driver.findElement(By.xpath("//div[@class='page-body']/div[1]")).getText();
        String expectingSuccessful = "Your registration completed";
        verify.assertEquals(actualSuccessful,expectingSuccessful);

        //2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//*[@class='page-body']/div[2]/a"));

        //2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.cssSelector("div[class='terms-of-service']>label"));

        //2.26 Click on “CHECKOUT”
        clickOnElement(By.cssSelector("div[class='checkout-buttons']>button"));

        //2.27 Fill the Mandatory fields
        driver.findElement(By.id("BillingNewAddress_FirstName")).sendKeys("");
        driver.findElement(By.id("BillingNewAddress_LastName")).sendKeys("");
        driver.findElement(By.id("BillingNewAddress_Email")).sendKeys("");

        selectByVisibleTextFromDropDown(By.id("BillingNewAddress_CountryId"),"United Kingdom");

        driver.findElement(By.id("BillingNewAddress_City")).sendKeys("London");
        driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("1 Wembley park");
        driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("HA1 1SF");
        driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("9916243569");

        Thread.sleep(2000);

        //2.28 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[text()='Continue']"));

        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.id("shippingoption_1"));

        //2.30 Click on “CONTINUE”
        clickOnElement(By.xpath("//*[@class='button-1 shipping-method-next-step-button']"));

        //2.31 Select Radio Button “Credit Card”
        clickOnElement(By.id("paymentmethod_1"));

        clickOnElement(By.xpath("//*[@id='payment-method-buttons-container']/button"));


        //2.32 Select “Visa” From Select credit card dropdown
        selectByVisibleTextFromDropDown(By.id("CreditCardType"), "Visa");

        //2.33 Fill all the details
        driver.findElement(By.name("CardholderName")).sendKeys("K Josh");
        driver.findElement(By.id("CardNumber")).sendKeys("4242 4242 4242 4242");

        selectByIndexFromDropDown(By.id("ExpireMonth"),07);

        WebElement sortExpireYear = driver.findElement(By.id("ExpireYear"));
        Select selectExpireYear = new Select(sortExpireYear);
        selectExpireYear.selectByVisibleText("2025");
        //selectByIndexFromDropDown(By.id("ExpireYear"),2025);

        driver.findElement(By.id("CardCode")).sendKeys("321");

        Thread.sleep(2000);

        //2.34 Click on “CONTINUE”
        clickOnElement(By.xpath("//*[@id='payment-info-buttons-container']/button"));



    }






}
