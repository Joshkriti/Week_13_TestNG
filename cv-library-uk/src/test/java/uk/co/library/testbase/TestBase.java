package uk.co.library.testbase;

import org.junit.After;
import org.junit.Before;
import uk.co.library.propertyreader.PropertyReader;
import uk.co.library.utility.Utility;

public class TestBase extends Utility {
    public String browser = PropertyReader.getInstance().getProperty("browser");

    @Before
    public void setupTest() {
        selectBrowser(browser);
    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}

