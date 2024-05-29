package nop.commerce.testsuite;

import nop.commerce.testbase.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Random;

public class Login_Register_Page extends TestBase {
    public Random randomGenerator = new Random();
    char[] password= generatePassword(8);
    String loginPassword = new String(password);
    String emailId=generateRandomEmail();

    @Test (priority = 2)
    public void validCredentials() {
        /*
         2. userShouldLoginSuccessfullyWithValidCredentials
              * click on the ‘Login’ link
              * Enter valid username
              * Enter valid password
              * Click on ‘LOGIN’ button
              * Verify the ‘Log out’ text is display
          */
        clickOnElement(By.linkText("Log in"));

        driver.findElement(By.id("Email")).sendKeys(emailId);

        driver.findElement(By.name("Password")).sendKeys(loginPassword);

        clickOnElement(By.xpath("//button[contains(@class,'button-1 login-button')]"));

        String actualText = driver.findElement(By.xpath("//a[@class='ico-logout']")).getText();
        String expectingText = "Log out";
        Assert.assertEquals(actualText, expectingText);
    }




    @Test (priority = 1)
    public void register(){
        /*
        1. UserShouldNavigateToRegisterPageSuccessfully
            * click on the ‘Register’ link
            * Verify the text ‘Register’
         */
        clickOnElement(By.linkText("Register"));

        String actualRegister = driver.findElement(By.xpath("//div[@class='header-links-wrapper']/div[1]/ul[1]/li[1]/a[1]")).getText();
        String expectingRegister = "Register";
        Assert.assertEquals("Register", actualRegister,expectingRegister);
        /*
        2. userSholdRegisterAccountSuccessfully * click on the ‘Register’ link
            * Select gender radio button
            * Enter First name
            * Enter Last name
            * Enter Email address
            * Enter Password
            * Enter Confirm password
            * Click on REGISTER button
            * Verify the text 'Your registration completed’
         */
        clickOnElement(By.className("female"));

        driver.findElement(By.id("FirstName")).sendKeys("Komal");

        driver.findElement(By.name("LastName")).sendKeys("Kanji");

        driver.findElement(By.id("Email")).sendKeys(emailId);

        driver.findElement(By.id("Password")).sendKeys(loginPassword);

        driver.findElement(By.name("ConfirmPassword")).sendKeys(loginPassword);

        clickOnElement(By.id("register-button"));

        SoftAssert register = new SoftAssert();
        String actualRegisterSuccessful = driver.findElement(By.xpath("//div[@class='page-body']/div[1]")).getText();
        String expectingRegisterSuccessful = "Your registration completed";
        register.assertEquals(actualRegisterSuccessful,expectingRegisterSuccessful);
        register.assertAll();

            }
}
