package parabank.annotation.testsuite;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import parabank.annotation.testbase.TestBase;

public class Verify extends TestBase {
    /*
   2.verifyTheErrorMessage
       * Enter invalid username
       * Enter invalid password
       * Click on Login button
       * Verify the error message ‘The username and password could not be verified.’
    */
    @Test
    public void verifyTheErrorMessage() {

        driver.findElement(By.name("username")).sendKeys("kri11");

        driver.findElement(By.name("password")).sendKeys("Kom34");

        clickOnElement(By.cssSelector("*[value='Log In']"));

        SoftAssert errorMessage = new SoftAssert();
        String actualErrorMessage = driver.findElement(By.cssSelector("*[class='error']")).getText();
        String expectingErrorMessage = "The username and password could not be verified.";
        errorMessage.assertEquals("Error Message: ", actualErrorMessage, expectingErrorMessage);
    }

    /*
    3.userShouldLogOutSuccessfully
        * Enter valid username
        * Enter valid password
        * Click on ‘LOGIN’ button
        * Click on ‘Log Out’ link
        * Verify the text ‘Customer Login’
     */
    @Test
    public void userShouldLogOutSuccessfully() {

        driver.findElement(By.name("username")).sendKeys("Kriti");

        driver.findElement(By.name("password")).sendKeys("Kom123456");

        driver.findElement(By.cssSelector("*[value='Log In']")).click();

        driver.findElement(By.xpath("//*[@id='leftPanel']/ul/li[8]/a")).click();

        SoftAssert logOut = new SoftAssert();
        String actualCustomerLogin = driver.findElement(By.cssSelector("*[id='leftPanel']>h2")).getText();
        String expectingCustomerLogin = "Customer Login";
        logOut.assertEquals("Customer Login: ", actualCustomerLogin, expectingCustomerLogin);

    }
}