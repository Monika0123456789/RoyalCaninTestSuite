package AutomateRoyalCanin.PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import AutomateRoyalCanin.AbstractComponent.AbstractComponent;

public class ProductListPage extends AbstractComponent {

	 private String appliedFoodLabel; // Variable to store the applied filter label
	 private String appliedFoodCount; // Variable to store the applied filter count
    private String appliedAgeLabel; // Variable to store the applied filter label
    private String appliedAgeCount; // Variable to store the applied filter count
    
    public WebDriver driver;

    // Constructor
    public ProductListPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    // WebElement for filter container
    @FindBy(css = ".ProductList-module_filter__J70Q3")
    WebElement filterContainer;
    
    // WebElement for Wet Food label
    @FindBy(css = "label[for='wet']")
    WebElement wetFood;
    
    // WebElement for Wet Food count (span)
    @FindBy(css = "label[for='wet'] span")
    WebElement wetFoodCount;
    
    @FindBy(css = "label[for='adult'] span")
    WebElement adultAgeCount;
    
    // WebElement for total product count displayed
    @FindBy(css = "span.ProductListTopSection-module_total-products-count__qfv55")
    WebElement totalProductCount;
    
    @FindBy(css = "label[for='adult']")
    WebElement AdultAge;
    
    @FindBy(xpath = "//div[@class='sc-a0fd81a-0 bcTpob']//li[1]//a[1]")
    WebElement FirstElement;
    
    // Method to verify if filter container is displayed
    public Boolean isFilterContainerDisplayed() {
        return filterContainer.isDisplayed();
    }
    
    public String applyFoodTextureFilter() {
        scrollToElement(wetFood);
        waitForWebElementToClickabel(wetFood);  // Ensure element is clickable

        try {
            wetFood.click();
        } catch (ElementClickInterceptedException e) {
            // Fallback to JS click if intercepted
            clickElementViaJS(wetFood);
        }

        waitForWebElementToAppear(totalProductCount);
        
        appliedFoodLabel = wetFood.getText().replaceAll("\\(.*\\)", "").trim();
        appliedFoodCount = wetFoodCount.getText().replaceAll("[^0-9]", "");

        return "Filter applied: " + appliedFoodLabel + " " + appliedFoodCount;
    }

    public Boolean verifyAppliedFoodFilter() {
        WebElement filterTag = driver.findElement(By.cssSelector(".FilterTags-module_product-filter-tag-label__WUV5q"));
        
        if (filterTag.isDisplayed()) {
            String filterTagText = filterTag.getText().trim();
            System.out.println("Filter Tag Text: " + filterTagText);
            System.out.println("Applied Food Label: " + appliedFoodLabel.trim());
            return filterTagText.equals(appliedFoodLabel.trim());
        } else {
            return false;
        }
    }

 // Method to verify if the food count matches the total product count displayed on the page
    public Boolean verifyProductCountMatches1() {
        // Wait for the total product count to match the applied count (up to 10 seconds)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for the text of the total product count to change and become equal to the appliedFoodCount
        wait.until(ExpectedConditions.textToBePresentInElement(totalProductCount, appliedFoodCount));

        // Get the displayed product count text after waiting for it to update
        String displayedProductCount = totalProductCount.getText().replaceAll("[^0-9]", "").trim();

        System.out.println("Displayed Product Count: " + displayedProductCount);
        System.out.println("Applied Food Count: " + appliedFoodCount.trim());

        // Return if the applied food count matches the displayed product count
        return appliedFoodCount.trim().equals(displayedProductCount);
    }
    
 // Method to apply the "Wet Food" filter, extract label and count
    public String applyAgeFilter() {
        // Scroll to the filter section
    	scrollToElement(AdultAge);
    
    
        waitForWebElementToClickabel(AdultAge);  // Ensure element is clickable

        try {
        	AdultAge.click();
        } catch (ElementClickInterceptedException e) {
            // Fallback to JS click if intercepted
            clickElementViaJS(AdultAge);
        }

        
        waitForWebElementToAppear(totalProductCount);

        // Extract the label text (e.g., "Wet Food") without the count
        appliedAgeLabel = AdultAge.getText().replaceAll("\\(.*\\)", "").trim(); // Remove anything in parentheses and trim spaces

        // Extract the count (e.g., "34") separately
        appliedAgeCount = adultAgeCount.getText().replaceAll("[^0-9]", ""); // Remove non-numeric characters

        // Return a combined string of label and count
        return "Filter applied: " + appliedAgeLabel + " " + appliedAgeCount;
    }
    
    public Boolean verifyAppliedAgeFilter() {
        WebElement filterTag = driver.findElement(By.xpath("//span[normalize-space()='Adult (1-7 years)']"));
        
        if (filterTag.isDisplayed()) {
            String filterTagText = filterTag.getText().trim();
            System.out.println("Filter Tag Text: " + filterTagText);
            System.out.println("Applied Age Label: " + appliedAgeLabel.trim());  // Correctly reference the age label
            return filterTagText.equals(appliedAgeLabel.trim());
        } else {
            return false;
        }
    }

    
    public Boolean verifyProductCountMatches2() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.textToBePresentInElement(totalProductCount, appliedAgeCount));  // Ensure it's checking against the age count

        String displayedProductCount = totalProductCount.getText().replaceAll("[^0-9]", "").trim();

        System.out.println("Displayed Product Count: " + displayedProductCount);
        System.out.println("Applied Age Count: " + appliedAgeCount.trim());  // Use the age count for comparison

        return appliedAgeCount.trim().equals(displayedProductCount);
    }
    
    public ProductDetailsPage goToProductDetailsPage() {
    	 clickElementViaJS(FirstElement);
//    	FirstElement.click();
    	return new ProductDetailsPage(driver);
    }
    
    public ProductDetailsPage goToProductDetailsPageWithoutFilters() {
        // Directly click on the first product in the list
        FirstElement.click();

        // Confirm that you're navigating to the Product Details Page (PDP)
        System.out.println("Navigated to PDP. Current URL: " + driver.getCurrentUrl());

        // Return ProductDetailsPage object
        return new ProductDetailsPage(driver);
    }


}
