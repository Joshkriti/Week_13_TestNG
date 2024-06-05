package parabank.annotation.testsuite;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import parabank.annotation.testbase.TestBase;

public class RegisterAndLoginTest extends TestBase {
    /*
    1.userShouldLoginSuccessfullyWithValidCredentials
*       Enter valid username
*       Enter valid password
*       Click on ‘LOGIN’ button
*       Verify the ‘Accounts Overview’ text is display
     */
    @Test (priority = 2)
    public void userShouldLoginSuccessfullyWithValidCredentials(){

        driver.findElement(By.name("username")).sendKeys("Kriti");

        driver.findElement(By.name("password")).sendKeys("Kom123456");

        clickOnElement(By.cssSelector("*[value='Log In']"));

        SoftAssert logIn = new SoftAssert();
        String actualAccount = driver.findElement(By.cssSelector("*[id='showOverview']>h1")).getText();
        String expectingAccount = "Accounts Overview";
        logIn.assertEquals("Account Overview result: ",actualAccount,expectingAccount);

    }

    /*1.userShouldRegisterAccountSuccessfully
     * click on the ‘Register’ link  * Enter First name * Enter Last name
     * Enter Address * Enter City * Enter State * Enter Zip Code
     * Enter Phone * Enter SSN * Enter Username * Enter Password
     * Enter Confirm * Click on REGISTER button
     * Verify the text 'Your account was created successfully. You are now logged in.’
     */
    @Test (priority = 1)
     public void userShouldRegisterAccountSuccessfully(){
        clickOnElement(By.xpath("//a[text()='Register']"));

        driver.findElement(By.id("customer.firstName")).sendKeys("Kriti");

        driver.findElement(By.id("customer.lastName")).sendKeys("Josh");

        driver.findElement(By.id("customer.address.street")).sendKeys("1 Bristol Street");

        driver.findElement(By.id("customer.address.city")).sendKeys("Bristol");

        driver.findElement(By.id("customer.address.state")).sendKeys("SouthWest");

        driver.findElement(By.id("customer.address.zipCode")).sendKeys("NH10 1HJ");

        driver.findElement(By.id("customer.phoneNumber")).sendKeys("9426698352");

        driver.findElement(By.id("customer.ssn")).sendKeys("252624298");

        driver.findElement(By.id("customer.username")).sendKeys("Kriti");

        driver.findElement(By.id("customer.password")).sendKeys("Kom123456");

        driver.findElement(By.id("repeatedPassword")).sendKeys("Kom123456");

        driver.findElement(By.xpath("//input[@value='Register']")).click();

        SoftAssert register = new SoftAssert();
        String actualOutcome = driver.findElement(By.xpath("//p[text()='Your account was created successfully. You are now logged in.']")).getText();
        String expectingOutcome = "Your account was created successfully. You are now logged in.";
        register.assertEquals(actualOutcome,expectingOutcome);


    }




}
