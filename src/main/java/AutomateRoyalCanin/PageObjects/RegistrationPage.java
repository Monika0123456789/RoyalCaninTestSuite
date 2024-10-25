package AutomateRoyalCanin.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AutomateRoyalCanin.AbstractComponent.AbstractComponent;

public class RegistrationPage extends AbstractComponent{

	public WebDriver driver;
	
	public RegistrationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class=' mini-user-unLogin iconfont iconuser']")
	WebElement profileIcon;
	
	@FindBy(xpath ="//a[normalize-space()='Register now']" )
	WebElement RegistrationBtn;
	
	
	public void goToRegistrationPage() {
		
        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);
        
        profileIcon.click();
        RegistrationBtn.click();

	}

     @FindBy(xpath="//input[@id='registerName']")
     WebElement nameFiled;
     
     @FindBy(xpath = "//input[@id='registerEmail']")
     WebElement emailField;
     
     @FindBy(xpath = "//input[@id='registerPassword']")
     WebElement passwordFiled;
     
     @FindBy(id = "id-checkbox-9999-93")
     WebElement checkbox1;
     
     @FindBy(id = "id-checkbox-9999-95")
     WebElement checkbox2;
     
     @FindBy(id = "id-checkbox-9999-99")
     WebElement checkbox3;
     
          
     
     @FindBy(xpath = "//button[@id='registerSubmitBtn']")
     WebElement submitBtn;
     
	public void provideDetails(String name,String Email,String Password) {
		nameFiled.sendKeys(name);
		emailField.sendKeys(Email);
		passwordFiled.sendKeys(Password);
	}
	
	public void acceptCheckbox() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");

		checkbox1.click();
        checkbox2.click();
        checkbox3.click();
	}
	
	public void submitForm() {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(500, 1000);");
		 submitBtn.click();
	}

}
