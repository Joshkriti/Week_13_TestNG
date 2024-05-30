package yourstore.annotation.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import yourstore.annotation.testbase.TestBase;

public class TopMenuTest extends TestBase {
    public void selectMenu(String menu) {
        driver.findElement(By.xpath("//a[text()='Show AllDesktops']")).getText();
        driver.findElement(By.xpath("//a[text()='Show AllLaptops & Notebooks']")).getText();
        driver.findElement(By.xpath("//a[text()='Show AllComponents']")).getText();
    }


    /*
    1. verifyUserShouldNavigateToDesktopsPageSuccessfully()
        1.1 Mouse hover on “Desktops” Tab and click
        1.2 call selectMenu method and pass the menu = “Show All Desktops”
        1.3 Verify the text ‘Desktops’
     */
    @Test (priority = 1)
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){

        Actions action = new Actions(driver);
        WebElement desktop = driver.findElement(By.xpath("//a[text()='Desktops']"));
        WebElement click = driver.findElement(By.xpath("//a[text()='Show AllDesktops']"));
        action.moveToElement(desktop).moveToElement(click).click().build().perform();

        selectMenu("Show All Desktops");

        SoftAssert desktop1 = new SoftAssert();
        String actualText = driver.findElement(By.xpath("//h2[text()='Desktops']")).getText();
        String expectingText = "Desktops";
        desktop1.assertEquals(actualText,expectingText);
    }
    /*
    2. verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully()
        2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        2.3 Verify the text ‘Laptops & Notebooks’
     */
    @Test (priority = 2)
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){
        Actions action = new Actions(driver);
        WebElement laptopAndNotebooks = driver.findElement(By.xpath("//a[text()='Laptops & Notebooks']"));
        WebElement click = driver.findElement(By.xpath("//a[text()='Show AllLaptops & Notebooks']"));
        action.moveToElement(laptopAndNotebooks).moveToElement(click).click().build().perform();

        selectMenu("Show All Laptops & Notebooks");

        SoftAssert laptops = new SoftAssert();
        String actualOutcome = driver.findElement(By.linkText("Laptops & Notebooks")).getText();
        String expectingOutcome = "Laptops & Notebooks";
        laptops.assertEquals("Laptops & Notebooks: ", actualOutcome,expectingOutcome);
    }
    /*
    3. verifyUserShouldNavigateToComponentsPageSuccessfully()
        3.1 Mouse hover on “Components” Tab and click
        3.2 call selectMenu method and pass the menu = “Show All Components”
        3.3 Verify the text ‘Components’
     */
    @Test (priority = 3)
    public void verifyUserShouldNavigateToComponentsPageSuccessfully(){
        Actions action = new Actions(driver);
        WebElement components = driver.findElement(By.xpath("//a[text()='Components']"));
        WebElement click = driver.findElement(By.xpath("//a[text()='Show AllComponents']"));
        action.moveToElement(components).moveToElement(click).click().build().perform();

        selectMenu("Show AllComponents");

        SoftAssert allComponents = new SoftAssert();
        String actualText = driver.findElement(By.xpath("//h2[text()='Components']")).getText();
        String expectingText = "Components";
        allComponents.assertEquals("Components: ",actualText,expectingText);
    }






}
