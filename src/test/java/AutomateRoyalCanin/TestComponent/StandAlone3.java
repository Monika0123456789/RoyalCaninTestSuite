package AutomateRoyalCanin.TestComponent;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import AutomateRoyalCanin.BaseTest.BaseTest;
import AutomateRoyalCanin.PageObjects.HomePage;
import AutomateRoyalCanin.PageObjects.LoginPage;
import AutomateRoyalCanin.PageObjects.WhereToBuyPage;

public class StandAlone3 extends BaseTest{
	
	@BeforeMethod
    public void setup() {
    	loginPage = new LoginPage(driver);
    }
   
    @Test
    public void Demo() throws InterruptedException {
       
		loginPage.goToLoginPage();
        loginPage.provideLoginDetails("monikamonika1379@gmail.com", "Monika@123");
        HomePage homePage = loginPage.submitLoginForm();
        homePage.verifyLogin();
        homePage.verifyLogo();
        WhereToBuyPage whereToBuyPage = homePage.goToWhereBuyPage();
//       whereToBuyPage.enterLocation("WashingTon");
        whereToBuyPage.printAndClickStockist();
        whereToBuyPage.clickGetDirectionsForFirstStockist();
    }

}
