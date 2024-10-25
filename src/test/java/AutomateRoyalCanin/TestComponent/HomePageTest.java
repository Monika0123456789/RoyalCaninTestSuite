package AutomateRoyalCanin.TestComponent;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import AutomateRoyalCanin.BaseTest.BaseTest;
import AutomateRoyalCanin.PageObjects.HomePage;

public class HomePageTest extends BaseTest{
	
	public HomePage homePage;
	
	@BeforeMethod
	public void setup() {
		homePage=new HomePage(BaseTest.driver);
	}
	
	@Test(priority=1)
	public void VerifyUserIcon() throws InterruptedException {
		
		homePage.verifyLogin();
		homePage.verifyLogo();
//		homePage.naviagteToPLP();
//		homePage.goToSelectLocation();
		
	}
	
	@Test(priority = 2)
	public void GoToPLP() {
		homePage.naviagteToPLP();
	}
	
	@Test(priority = 3)
	public void GoToWhereToBuy() {
		homePage.goToWhereBuyPage();
	}
	
	@Test(priority = 4)
	public void GoToContactPage() {
		homePage.goToContactPage();
	}
	
	@Test(priority = 5)
	public void goToPLPWithoutFilter() {
		homePage.navigateToPLPWithoutFilters();
	}
	
	

}

