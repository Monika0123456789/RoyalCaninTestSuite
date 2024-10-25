package AutomateRoyalCanin.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import AutomateRoyalCanin.AbstractComponent.AbstractComponent;

import java.time.Duration;

public class ProductDetailsPage extends AbstractComponent {

    public WebDriver driver;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "button[name='Increase quantity'] svg")
    WebElement PlusBtn;

    @FindBy(css = "input[name='quantity-selector-input']")
    WebElement quantityInput;

    @FindBy(css = "span[data-qa='quantity-selector-status']")
    WebElement quantityStatus;

    @FindBy(xpath = "//button[normalize-space()='Add to cart']")
    WebElement addToCartBtn;

    @FindBy(css = ".rc-d2c__cart-product-card__header__title-button--lctCGG3W")
    WebElement productNameElement;  // Locator for product name in <a> tag

    @FindBy(xpath = "//div[contains(@class, 'rc-d2c__rc-message--warning')]")
    WebElement warningMessage;  // Locator for the warning message

    @FindBy(xpath = "//button[@data-testid='cart-product-card-remove-button']")
    List<WebElement> removeButtons;  // Locator for the remove buttons

    @FindBy(xpath = "//button[normalize-space()='Remove this product']")
    WebElement RemoveBtn;
    
    @FindBy(xpath = "//button[@data-testid='cart-panel-view-cart']")
    WebElement ViewCartBtn;
    

    // Method to get the page title
    public void verifyProductDetailsPage() {
        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);
    }

    public void increaseQuantityByOne() {
        scrollToElement(PlusBtn);
        waitForWebElementToClickabel(PlusBtn);

        try {
            PlusBtn.click();
        } catch (ElementClickInterceptedException e) {
            waitForWebElementToClickabel(PlusBtn);
            clickElementViaJS(PlusBtn);
        }
    }

    public String getQuantity() {
        return quantityInput.getAttribute("value");
    }

    public void verifyQuantityAfterIncrease(int expectedQuantity) {
        String quantity = getQuantity();
        if (Integer.parseInt(quantity) == expectedQuantity) {
            System.out.println("Quantity verified successfully: " + quantity);
        } else {
            System.out.println("Quantity verification failed. Expected: " + expectedQuantity + ", but found: " + quantity);
        }
    }

    // Method to handle the warning message and remove items from the cart
    public void handleCartWarningAndDeleteProducts() {
        // Check if warning message is displayed
        if (isWarningMessageDisplayed()) {
            System.out.println("Warning message displayed: Total number of products in your cart cannot exceed 10.");
            
            // Delete all products in the cart
            deleteAllProductsFromCart();
        }

        // After deleting the products, click on Add to Cart button
        addToCart();
    }

    // Method to check if the warning message is displayed
    public boolean isWarningMessageDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            
            // Wait for the element to be present in the DOM
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'rc-d2c__rc-message--warning')]")));
            
            // Now check if the element is displayed
            return warningMessage.isDisplayed();
            
        } catch (NoSuchElementException e) {
            System.out.println("Warning message not found.");
            return false;
        } catch (TimeoutException e) {
            System.out.println("Warning message did not appear within the expected time.");
            return false;
        }
    }

    // Method to delete all products from the cart
    public void deleteAllProductsFromCart() {
        for (WebElement removeButton : removeButtons) {
            try {
                removeButton.click();
                RemoveBtn.click();
            } catch (ElementClickInterceptedException e) {
                clickElementViaJS(removeButton);  // Fallback to JS click if intercepted
                clickElementViaJS(RemoveBtn);
            }
        }
        System.out.println("All products have been removed from the cart.");
    }

    public void addToCart() {
        scrollToElement(addToCartBtn);
        waitForWebElementToClickabel(addToCartBtn);

        try {
            addToCartBtn.click();
        } catch (ElementClickInterceptedException e) {
            waitForWebElementToClickabel(addToCartBtn);
            clickElementViaJS(addToCartBtn);
        }
    }

    // Method to compare product name and page title
    public void verifyProductNameWithTitle() {
        waitForWebElementToAppear(productNameElement);
        String productName = productNameElement.getText();
        String pageTitle = driver.getTitle();  // Get page title here after driver is initialized

        if (pageTitle.contains(productName)) {
            System.out.println("Product name matches the page title: " + productName);
        } else {
            System.out.println("Product name does NOT match the page title. Product: " + productName + ", Page Title: " + pageTitle);
        }
    }
    
    public void goToCartPage() {
        try {
            // Wait for the button to be clickable
            scrollToElement(ViewCartBtn);
            waitForWebElementToClickabel(ViewCartBtn);

            // Attempt to click the button
            ViewCartBtn.click();
        } catch (ElementClickInterceptedException e) {
            // If click is intercepted, use JavaScript click as a fallback
            System.out.println("Click intercepted, trying with JavaScript.");
            clickElementViaJS(ViewCartBtn);
        }

        System.out.println("Successfully navigated to Cart Page.");
    }
    
    @FindBy(css = ".sc-fHjqPf.fccksB")
    WebElement reviewContainer;

    @FindBy(css = "[aria-label$='Rating is 4 (out of 5 stars).']")
    WebElement ratingStar;

    public void goToReviewSection() {
        // Scroll to the review section
        scrollToElement(reviewContainer);
        
        // Wait for the reviewContainer element to be visible
        waitForElementVisibility(reviewContainer);
        
        // Use JavaScriptExecutor to access the shadow root
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Get the shadow root using JavaScript
        Object shadowRoot = js.executeScript("return arguments[0].shadowRoot", reviewContainer);
        
        // Now you need to use JavaScript to find the 4th star since shadowRoot is not a WebElement
        WebElement fourthStar = (WebElement) js.executeScript(
            "return arguments[0].querySelectorAll('div[role=\"button\"]')[3];", shadowRoot);

        // Click the 4th star element
        if (fourthStar != null) {
            fourthStar.click();
        } else {
            throw new NoSuchElementException("Fourth star element not found.");
        }
    }


}
