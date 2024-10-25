package AutomateRoyalCanin.TestComponent;

import org.testng.annotations.BeforeMethod;

import AutomateRoyalCanin.BaseTest.BaseTest;
import AutomateRoyalCanin.PageObjects.SelectCountryPage;

public class SelectCountryPageTest {
	
	public SelectCountryPage selectCountryPage;
	
	@BeforeMethod
	public void setup() {
		selectCountryPage=new SelectCountryPage(BaseTest.driver);
	}
	
	public void SelectLocationAndVerifyLanguage() {
		selectCountryPage.SelectLocation();  // Select Australia as the location
		selectCountryPage.verifyLauguge();  // Verify the language is Australia
	}

}
