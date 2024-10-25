package AutomateRoyalCanin.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import AutomateRoyalCanin.AbstractComponent.AbstractComponent;

public class SelectCountryPage extends AbstractComponent{
	
	public WebDriver driver;

	public SelectCountryPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[normalize-space()='USA']")
	WebElement locationFiled;
	
	@FindBy(css = "ul[role='listbox']")
	WebElement locationConatiner;
	
	@FindBy(xpath = "//li[normalize-space()='Australia']")
	WebElement AustraliaCountry;
	
	public void SelectLocation() {
	    scrollToElement(locationFiled);  // Scroll to the element to ensure it's visible
	    clickElementViaJS(locationFiled);  // Click using JavaScript to avoid interception issues
	    waitForWebElementToAppear(locationConatiner);
	    clickElementViaJS(AustraliaCountry);  // Click using JavaScript
	}

	
	@FindBy(xpath = "(//button[@type='button'][normalize-space()='Australia'])[2]")
	WebElement LauguageFiled;
	
	

	public void verifyLauguge() {
	    String expectedLanguage = "Australia";
	    String actualLanguage = LauguageFiled.getText();
	    
	    Assert.assertEquals(actualLanguage, expectedLanguage, "Language verification failed.");
	}

	@FindBy(xpath = "//button[normalize-space()='Submit']")
	WebElement SubmitBtn;
	
	public void clickSubmitBtn() {
		
		 SubmitBtn.click();
	}
	
}
