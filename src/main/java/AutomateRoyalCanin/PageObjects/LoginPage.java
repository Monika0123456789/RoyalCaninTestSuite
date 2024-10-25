package AutomateRoyalCanin.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AutomateRoyalCanin.AbstractComponent.AbstractComponent;

public class LoginPage extends AbstractComponent {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@class=' mini-user-unLogin iconfont iconuser']")
	WebElement profileIcon;
	
	@FindBy(xpath = "//a[normalize-space()='Login']")
	WebElement loginbtn;
	
	@FindBy(id="input28")
	WebElement EmailFeild;
	
	@FindBy(id = "input36")
	WebElement PasswordField;
	
	@FindBy(xpath = "//div[@class='checkmark']")
	WebElement checkbox;
	
	@FindBy(css = "input[value='Sign in']")
	WebElement Submitbtn;
	
	@FindBy(xpath = "//div[@class='user-unLogin-popover']")
	WebElement loginContiner;
	
	public void goToLoginPage() {
		 // Get the title of the page
       String pageTitle = driver.getTitle();
       System.out.println("Page Title: " + pageTitle);
		profileIcon.click();
//		waitForWebElementToAppear(loginContiner);
		loginbtn.click();
		
	}
	
	public void provideLoginDetails(String email,String password) {
		waitForWebElementToAppear(EmailFeild);
		EmailFeild.sendKeys(email);
		PasswordField.sendKeys(password);
		checkbox.click();
	}
	
	public HomePage submitLoginForm() {
		Submitbtn.click();		
		return new HomePage(driver);
	}
	

}
