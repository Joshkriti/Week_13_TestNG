package yourstore.annotation.testbase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import yourstore.annotation.propertyreader.PropertyReader;
import yourstore.annotation.utility.Utility;

public class TestBase extends Utility {

    public String browser = PropertyReader.getInstance().getProperty("browser");

    @BeforeMethod(alwaysRun = true)
    public void setupTest() {
        selectBrowser(browser);
    }

    @AfterMethod
    public void tearDown(){
        closeBrowser();
    }
}

