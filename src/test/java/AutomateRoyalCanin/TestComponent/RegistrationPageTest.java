package AutomateRoyalCanin.TestComponent;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import AutomateRoyalCanin.BaseTest.BaseTest;
import AutomateRoyalCanin.PageObjects.RegistrationPage;

public class RegistrationPageTest extends BaseTest {
	
	public RegistrationPage registerationPage;
	
	@BeforeMethod
	public void setup() {
		registerationPage = new RegistrationPage(BaseTest.driver);
	}
	
	@Test
	public void RegistrationTest() {
		registerationPage.goToRegistrationPage();
		registerationPage.provideDetails("Monika","monika007@gmail.com","Abcd@1234");
		registerationPage.acceptCheckbox();
		registerationPage.submitForm();
	}

}
