package nop.commerce.testsuite;

import nop.commerce.testbase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Random;

public class Computer extends TestBase {
    public Random randomGenerator = new Random();
    char[] password= generatePassword(8);
    String loginPassword = new String(password);
    String emailId=generateRandomEmail();

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 Click on Computer Menu.
        clickOnElement(By.xpath("//a[text()='Computers ']"));

        //2.2 Click on Desktop
        clickOnElement(By.xpath("//div[@class='sub-category-item']/h2/a"));

        //2.3 Select Sort By position "Name: A to Z"
        selectByContainsTextFromDropDown(By.xpath("//*[@id='products-orderby']"),"Name: A to Z");

        //2.4 Click on "Add To Cart"
        WebElement button= driver.findElement(By.xpath("//div[@class='item-grid']/div[1]/div/div[2]/div[3]/div[2]/button[1]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(button));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='item-grid']/div[1]/div/div[2]/div[3]/div[2]/button[1]")).click();

        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByVisibleTextFromDropDown(By.id("product_attribute_1"),"2.2 GHz Intel Pentium Dual-Core E2200");

        //2.7.Select "8GB [+$60.00]" using Select class.
        selectByVisibleTextFromDropDown(By.name("product_attribute_2"),"8GB [+$60.00]");

        //2.8 Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.xpath("//*[@for='product_attribute_3_7']"));

        //2.9 Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.xpath("//*[@for='product_attribute_4_9']"));

        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"

        clickOnElement(By.xpath("//*[@id='product_attribute_input_5']/ul/li[3]/label"));

        //2.12 Click on "ADD TO CARD" Button.
        clickOnElement(By.xpath("//*[@class='button-1 add-to-cart-button']"));

        //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String actualMessage = driver.findElement(By.xpath("//p[@class='content']")).getText();
        System.out.println(actualMessage);
        String expectingMessage = "The product has been added to your shopping cart";
        Assert.assertEquals("The product has been added to your shopping cart", actualMessage,expectingMessage);

        driver.findElement(By.xpath("//*[@class='close']")).click();

        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        Actions action = new Actions(driver);
        WebElement shoppingCart = driver.findElement(By.cssSelector("*[class='cart-label']"));
        WebElement goToCart = driver.findElement(By.xpath("//*[@id='flyout-cart']/div/div[4]/button"));
        Thread.sleep(2000);
        action.moveToElement(shoppingCart).moveToElement(goToCart).click().build().perform();

        //2.15 Verify the message "Shopping cart"
        SoftAssert message = new SoftAssert();
        String actualShoppingCart = driver.findElement(By.xpath("//h1[text()='Shopping cart']")).getText();
        String expectingShoppingCart = "Shopping cart";
        message.assertEquals( actualShoppingCart ,expectingShoppingCart);

        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        clickOnElement(By.cssSelector("*[class='quantity up']"));

        //2.17 Verify the Total"$2,950.00"
        SoftAssert total = new SoftAssert();
        String actualVerifyPrice = driver.findElement(By.xpath("//*[@class='product-subtotal']")).getText();
        String expectingVerifyPrice = "$2,950.00";
        total.assertEquals(actualVerifyPrice ,expectingVerifyPrice);

        //2.18 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//div[@class='terms-of-service']/label"));

        Thread.sleep(2000);

        //2.19 Click on “CHECKOUT”
        driver.findElement(By.xpath("//button[@class='button-1 checkout-button']")).click();

        //2.21Click on “CHECKOUT AS GUEST” Tab
        driver.findElement(By.xpath("//button[@class='button-1 checkout-as-guest-button']")).click();

        //2.22 Fill the all mandatory field
        driver.findElement(By.id("BillingNewAddress_FirstName")).sendKeys("Kriya");
        driver.findElement(By.id("BillingNewAddress_LastName")).sendKeys("Josh");
        driver.findElement(By.id("BillingNewAddress_Email")).sendKeys(emailId);

        selectByVisibleTextFromDropDown(By.id("BillingNewAddress_CountryId"),"United Kingdom");

        driver.findElement(By.id("BillingNewAddress_City")).sendKeys("London");
        driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("1 Wembley park");
        driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("HA1 1SF");
        driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("9916243569");

        Thread.sleep(2000);

        //2.23 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[text()='Continue']"));


        // 2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.id("shippingoption_1"));

        // 2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//*[@class='button-1 shipping-method-next-step-button']"));

        //2.26 Select Radio Button “Credit Card”
        clickOnElement(By.id("paymentmethod_1"));

        clickOnElement(By.xpath("//*[@id='payment-method-buttons-container']/button"));

        //2.27 Select “Master card” From Select credit card dropdown
        selectByVisibleTextFromDropDown(By.id("CreditCardType"),"Master card");

        //2.28 Fill all the details
        driver.findElement(By.name("CardholderName")).sendKeys("K Josh");
        driver.findElement(By.id("CardNumber")).sendKeys("5555 5555 5555 4444");

        selectByIndexFromDropDown(By.id("ExpireYear"),07);

        WebElement sortYear = driver.findElement(By.id("ExpireYear"));
        Select selectYear = new Select(sortYear);
        selectYear.selectByVisibleText("2026");

        driver.findElement(By.id("CardCode")).sendKeys("123");

        Thread.sleep(2000);

        //2.29 Click on “CONTINUE”
        clickOnElement(By.xpath("//*[@id='payment-info-buttons-container']/button"));

        //2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//*[@id='confirm-order-buttons-container']/button"));

        //2.35 Verify the Text “Thank You”
        SoftAssert thankYou = new SoftAssert();
        String actualVerifyText = driver.findElement(By.xpath("//*[@class='page checkout-page order-completed-page']/div[1]/h1")).getText();
        String expectingVerifyText= "Thank you";
        thankYou.assertEquals(actualVerifyText,expectingVerifyText);

        //2.36 Verify the message “Your order has been successfully processed!”
        SoftAssert successfulProcess = new SoftAssert();
        String actualVerifyMessage = driver.findElement(By.xpath("//*[@class='section order-completed']/div[1]/strong")).getText();
        String expectingVerifyMessage= "Your order has been successfully processed!";
        successfulProcess.assertEquals(actualVerifyMessage,expectingVerifyMessage);

        Thread.sleep(2000);

        //2.37 Click on “CONTINUE”
        clickOnElement(By.xpath("//*[@class='section order-completed']/div[3]/button"));

        //2.37 Verify the text “Welcome to our store”
        SoftAssert welcome = new SoftAssert();
        String actualVerifyText1 = driver.findElement(By.xpath("//*[@class='topic-block']/div[1]/h2")).getText();
        String expectingVerifyText1= "Welcome to our store";
        welcome.assertEquals(actualVerifyText1,expectingVerifyText1);
    }
}
