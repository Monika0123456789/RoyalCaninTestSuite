package AutomateRoyalCanin.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import AutomateRoyalCanin.AbstractComponent.AbstractComponent;

public class HomePage extends AbstractComponent {

    public WebDriver driver;

    @FindBy(xpath = "//a[@class='brefName']")
    WebElement userIcon;

    @FindBy(xpath = "//a[@class='sc-a295d4eb-1 gUlcKp']")
    WebElement logoIcon;
    
    @FindBy(xpath = "//div[@class= 'rc-loader__spinner']")
    WebElement loader;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to verify if the letter "M" is present after login
    public void verifyLogin() {
    
//    	waitForWebElementToDisappear(loader);
    	waitForWebElementToAppear(userIcon);
    	userIcon.isDisplayed();
    	
        String actualInitial = userIcon.getText();
        Assert.assertEquals(actualInitial, "M", "The user initial after login is not as expected.");
    }


	// Method to verify if the logo is displayed
    public void verifyLogo() {
        // Verify if the logo is displayed on the page
        boolean isLogoDisplayed = logoIcon.isDisplayed();
        Assert.assertTrue(isLogoDisplayed, "The logo is not displayed on the homepage.");
        logoIcon.click();
        waitForWebElementToAppear(deleteCookieBtn);
        deleteCookieBtn.click();
    }
    
    @FindBy(xpath = "(//a[@title='Get the tailored product'])[1]")
    WebElement GetProductBtn;
    
    public GetFoodForPetPage goToPetFoodFinderPage() {
        GetProductBtn.click();
        return new GetFoodForPetPage(driver);
    }
    
    
   @FindBy (css = "#onetrust-close-btn-container > button")   
   WebElement deleteCookieBtn;
   
    @FindBy(xpath = "//button[@title='Cats']" )
    WebElement CatFoods;
    
    @FindBy(css = "a[title='Cat food']")
    WebElement CatFoodOption;
    
    @FindBy(xpath = "//div[@data-qa='topnav-submenu Cats']")
    WebElement CatFoodContainer;
    
    @FindBy(xpath = "(//button[@class='sc-e578fac8-0 bnlujD'])[1]")
    WebElement locationBtn;
    
//    public ProductListPage naviagteToPLP() {
//    	// Create an Actions object to perform complex interactions
//        Actions actions = new Actions(driver);
//
//        // Perform hover action on the button
//        actions.moveToElement(CatFoods).perform();
//        waitForWebElementToAppear(CatFoodContainer);
//        CatFoodOption.click();
//        return new ProductListPage(driver);
//       
//    }
    
    public ProductListPage naviagteToPLP() {
        // Create an Actions object to perform complex interactions
        Actions actions = new Actions(driver);

        // Add a debug log or print statement for troubleshooting
        System.out.println("Attempting to hover over the 'CatFoods' button.");
        
        // Perform hover action on the button
        actions.moveToElement(CatFoods).perform();
        
        // Wait for the CatFoodContainer to appear (make sure it's visible)
        waitForWebElementToAppear(CatFoodContainer);
        
        // Debugging to check if the CatFoodContainer is visible
        System.out.println("Cat food container is visible. Now clicking on the CatFoodOption.");

        // Click the CatFoodOption
        CatFoodOption.click();
        
        // Check if the navigation was successful by printing the current URL
        System.out.println("Navigated to PLP. Current URL: " + driver.getCurrentUrl());

        return new ProductListPage(driver);
    }

    
    public SelectCountryPage goToSelectLocation() {
    	
    	waitForWebElementToAppear(locationBtn);
    	locationBtn.click();
    	return new SelectCountryPage(driver);
    }
    
    @FindBy(css = "button[title='Where to Buy'] span")
    WebElement WhereBuyBtn;
    
    @FindBy(css = "a[title='Find a retailer']")
    WebElement retailerOption;
    
    public WhereToBuyPage goToWhereBuyPage() {
    	WhereBuyBtn.click();
    	
    	waitForWebElementToAppear(retailerOption);
    	retailerOption.click();
    	return new WhereToBuyPage(driver);
    	
    }
    
    @FindBy(css = "button[title='Contact Us']")
    WebElement contactUsBtn;
    
    @FindBy(xpath = "//a[@href='https://www.royalcanin.com/us/contact-us']//span[normalize-space()='By Email']")
    WebElement ByEmailBtn;
    
    
    public ContactFormPage goToContactPage() {
    	contactUsBtn.click();
    	 waitForWebElementToAppear(ByEmailBtn);
    	 ByEmailBtn.click();
    	 return new ContactFormPage(driver);
    }
    
    public ProductListPage navigateToPLPWithoutFilters() {
        // Create an Actions object to perform complex interactions
        Actions actions = new Actions(driver);

        // Hover over the "CatFoods" button
        actions.moveToElement(CatFoods).perform();

        // Wait for the CatFoodContainer to appear (make sure it's visible)
        waitForWebElementToAppear(CatFoodContainer);

        // Click on the "CatFoodOption"
        CatFoodOption.click();

        // Confirm navigation by printing the current URL or using assertion
        System.out.println("Navigated to PLP. Current URL: " + driver.getCurrentUrl());

        // Return ProductListPage object
        return new ProductListPage(driver);
    }

	

}
