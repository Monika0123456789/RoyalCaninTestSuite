package AutomateRoyalCanin.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

import AutomateRoyalCanin.AbstractComponent.AbstractComponent;

public class WhereToBuyPage extends AbstractComponent {

    public WebDriver driver;

    public WhereToBuyPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locate all stockist items in the list
    @FindBy(xpath = "//li[@class='rc-stockist-list__list-item rc-bg-colour--brand3']")
    List<WebElement> stockistListItems;

    // Locate the iframe
    @FindBy(xpath = "//iframe[@src='https://www.royalcanin.com/if/where-to-buy-rebuild']")
    WebElement iframeElement;
    
    // First stockist location
    @FindBy(xpath = "//ul[@class='rc-stockist-list']//li[1]")
    WebElement firstLocation;

    // Method to switch to iframe, print stockist names, and click first location
    public void printAndClickStockist() {
        driver.switchTo().frame(iframeElement);

        // Ensure the list of stockists is loaded before clicking
        waitForWebElementToAppear(firstLocation);  // Wait until the first location is visible
        
        // Print debugging information
        System.out.println("First stockist location text: " + firstLocation.getText());

        // Scroll into view if needed (ensure it's visible in the viewport)
        scrollToElement(firstLocation);
        
        // Attempt to click the first location via JS in case of issues
        clickElementViaJS(firstLocation);
        
        // Switch back to the default content
        driver.switchTo().defaultContent();
    }
 // Locate the "Get directions" button inside the first stockist item
    @FindBy(xpath = "//ul[@class='rc-stockist-list']//li[1]//a[contains(text(), 'Get directions')]")
    WebElement getDirectionsButton;
    
    // Method to switch to iframe and click the "Get directions" button
    public void clickGetDirectionsForFirstStockist() {
        // Switch to the iframe
        driver.switchTo().frame(iframeElement);

        // Ensure the "Get directions" button is visible and interactable
        waitForWebElementToAppear(getDirectionsButton);

        // Print the href attribute of the Get Directions button (for debugging)
        System.out.println("Get Directions link: " + getDirectionsButton.getAttribute("href"));

        // Scroll into view if needed
        scrollToElement(getDirectionsButton);

        // Click the "Get directions" button using JavaScript to avoid any interception issues
        clickElementViaJS(getDirectionsButton);

        // Switch back to the default content
        driver.switchTo().defaultContent();
    }
}
