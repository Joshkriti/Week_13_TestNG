package yourstore.annotation.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import yourstore.annotation.managedriver.ManageDriver;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Utility extends ManageDriver {
    public void clickOnElement(By by) {
        WebElement loginLink = driver.findElement(by);
        loginLink.click();
    }

    public void clearElement(By by){
        WebElement clearLink = driver.findElement(by);
        clearLink.clear();
    }
    public void selectMenu(String menu) {
        driver.findElement(By.xpath("//a[text()='Show AllDesktops']")).getText();
        driver.findElement(By.xpath("//a[text()='Show AllLaptops & Notebooks']")).getText();
        driver.findElement(By.xpath("//a[text()='Show AllComponents']")).getText();
    }
    public void selectMyAccountRegister(String option) {
        WebElement dropDown = driver.findElement(By.xpath("//a[@title='My Account']/span[1]"));
        dropDown.click();
        List<WebElement> optionsAccount = driver.findElements(By.xpath("//*[@id='top-links']/ul/li[2]/ul/li[1]/a"));
        for (WebElement options : optionsAccount) {
            if (options.getText().equalsIgnoreCase("Register")) {
                System.out.println(options.getText());
                options.click();
            }
        }
    }

    public void selectMyAccountLogin(String option) {
        WebElement dropDown1 = driver.findElement(By.xpath("//a[@title='My Account']/span[1]"));
        dropDown1.click();
        List<WebElement> optionsAccount1 = driver.findElements(By.xpath("//*[@id='top-links']/ul/li[2]/ul/li[2]/a"));
        for (WebElement options1 : optionsAccount1) {
            if (options1.getText().equalsIgnoreCase("Login")) {
                System.out.println(options1.getText());
                options1.click();
            }
        }
    }

    public void selectMyAccountLogout(String option) {
        WebElement dropdown2 = driver.findElement(By.xpath("//a[@title='My Account']/span[1]"));
        dropdown2.click();
        List<WebElement> logoutOption = driver.findElements(By.xpath("//*[@class='dropdown-menu dropdown-menu-right']/li[5]/a"));
        for (WebElement logout : logoutOption) {
            if (logout.getText().equalsIgnoreCase("Logout")) {
                System.out.println(logout.getText());
                logout.click();
            }
        }
    }
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    public void selectByValueFromDropDown(By by, String value) {
        new Select(driver.findElement(by)).selectByValue(value);
    }

    public void selectByIndexFromDropDown(By by, int index) {
        new Select(driver.findElement(by)).selectByIndex(index);
    }

    public void selectByContainsTextFromDropDown(By by, String text) {
        List<WebElement> allOptions = new Select(driver.findElement(by)).getOptions();
        for (WebElement options : allOptions) {
            if (options.getText().contains(text)) {
                options.click();
            }
        }
    }

    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().build().perform();
    }

    public WebElement waitUntilVisibilityOfElementLocated(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }


    public static String getUniqueId() {
        return String.format("%s_%s", UUID.randomUUID().toString().substring(0, 5), System.currentTimeMillis() / 1000);
    }
    public static String generateRandomEmail() {
        return String.format("%s@%s", getUniqueId(), "yourHostName.com");
    }
    public static char[] generatePassword(int length) {
        String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String specialCharacters = "!@#$";
        String numbers = "1234567890";
        String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
        Random random = new Random();
        char[] password = new char[length];

        password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
        password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
        password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
        password[3] = numbers.charAt(random.nextInt(numbers.length()));

        for(int i = 4; i< length ; i++) {
            password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
        }
        return password;
    }

}
