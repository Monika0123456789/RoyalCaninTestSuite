package AutomateRoyalCanin.TestComponent;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import AutomateRoyalCanin.BaseTest.BaseTest;
import AutomateRoyalCanin.PageObjects.WhereToBuyPage;

public class WhereToBuyPageTest extends BaseTest {

    private WhereToBuyPage whereToBuyPage;

    // This method will initialize the page objects before each test
    @BeforeMethod
    public void setup() {
        // Initialize the WhereToBuyPage with the WebDriver instance from BaseTest
        whereToBuyPage = new WhereToBuyPage(driver);
    }

    @Test
    public void verifyWhereToBuyLocationAndDirections() throws InterruptedException {
        // Print the stockist name and click the first location
        whereToBuyPage.printAndClickStockist();

        // Click on the "Get Directions" button for the first stockist
        whereToBuyPage.clickGetDirectionsForFirstStockist();
    }
}
