package yourstore.annotation.testsuite;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import yourstore.annotation.testbase.TestBase;

import java.util.Random;

public class MyAccountTest extends TestBase {
    public Random randomGenerator = new Random();
    char[] password= generatePassword(8);
    String loginPassword = new String(password);
    String emailId=generateRandomEmail();


    //3. Test name verifyThatUserRegisterAccountSuccessfully()
    @Test (priority = 1)
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
        //3.1 Click on My Account Link.
        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountRegister("Register");

        //3.3 Enter First Name
        driver.findElement(By.name("firstname")).sendKeys("Kriti");

        //3.4 Enter Last Name
        driver.findElement(By.name("lastname")).sendKeys("Josh");

        //3.5 Enter Email
        driver.findElement(By.name("email")).sendKeys(emailId);

        //3.6 Enter Telephone
        driver.findElement(By.name("telephone")).sendKeys("07715297848");

        //3.7 Enter Password
        driver.findElement(By.name("password")).sendKeys(loginPassword);

        //3.8 Enter Password Confirm
        driver.findElement(By.name("confirm")).sendKeys(loginPassword);

        //3.9 Select Subscribe Yes radio button
        clickOnElement(By.xpath("//*[@class='form-group']/div[1]/label[1]/input"));

        //3.10 Click on Privacy Policy check box
        clickOnElement(By.xpath("//*[@name='agree']"));

        //3.11 Click on Continue button
        clickOnElement(By.xpath("//*[@class='btn btn-primary']"));

        Thread.sleep(2000);

        //3.12 Verify the message “Your Account Has Been Created!”
        SoftAssert verifyMessage = new SoftAssert();
        String actualVerifyMessage = driver.findElement(By.xpath("//*[@id='content']/h1")).getText();
        String expectingVerifyMessage = "Your Account Has Been Created!";
        verifyMessage.assertEquals(actualVerifyMessage, expectingVerifyMessage);

        //3.13 Click on Continue button
        clickOnElement(By.xpath("//*[@class='pull-right']/a"));

        //3.14 Click on My Account Link.
        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountLogout("Logout");

        //3.16 Verify the text “Account Logout”
        SoftAssert logout = new SoftAssert();
        String actualLogout = driver.findElement(By.cssSelector("div[id='content']>h1")).getText();
        String expectingLogout = "Account Logout";
        logout.assertEquals(actualLogout, expectingLogout);

        Thread.sleep(2000);

        //3.17 Click on Continue button
        clickOnElement(By.xpath("//*[@id='content']/div/div/a"));
    }

    //4. Test name verifyThatUserShouldLoginAndLogoutSuccessfully()
    @Test (priority = 2)
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException {
        //4.1 Click on My Account Link.
        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyAccountLogin("Login");

        //4.3 Enter Email address
        driver.findElement(By.id("input-email")).sendKeys(emailId);

        //4.4 Enter Password
        driver.findElement(By.id("input-password")).sendKeys(loginPassword);

        //4.5 Click on Login button
        clickOnElement(By.cssSelector("input[value='Login']"));

        Thread.sleep(2000);

        //4.6 Verify text “My Account”
        SoftAssert myAccount = new SoftAssert();
        String actualMyAccount = driver.findElement(By.xpath("//*[@id='content']/h2[1]")).getText();
        String expectingMyAccount = "My Account";
        myAccount.assertEquals(actualMyAccount, expectingMyAccount);

        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountLogout("Logout");

        //4.10 Verify the text “Account Logout”
        SoftAssert accountLogout = new SoftAssert();
        String actualLogout = driver.findElement(By.cssSelector("div[id='content']>h1")).getText();
        String expectingLogout = "Account Logout";
        accountLogout.assertEquals(actualLogout, expectingLogout);

        //4.11 Click on Continue button
        clickOnElement(By.xpath("//*[@id='content']/div/div/a"));
    }
}
