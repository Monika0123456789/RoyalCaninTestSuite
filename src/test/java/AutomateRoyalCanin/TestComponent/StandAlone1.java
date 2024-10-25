package AutomateRoyalCanin.TestComponent;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import AutomateRoyalCanin.BaseTest.BaseTest;
import AutomateRoyalCanin.PageObjects.GetFoodForPetPage;
import AutomateRoyalCanin.PageObjects.HomePage;
import AutomateRoyalCanin.PageObjects.LoginPage;

public class StandAlone1 extends BaseTest{

	
	 @BeforeMethod
	    public void setup() {
	    	loginPage = new LoginPage(driver);
	    }
	   
	    @Test
	    public void Demo() {
	       
			loginPage.goToLoginPage();
	        loginPage.provideLoginDetails("monikamonika1379@gmail.com", "Monika@123");
	        HomePage homePage = loginPage.submitLoginForm();
	        homePage.verifyLogin();
             homePage.verifyLogo();
	        GetFoodForPetPage getFoodForPetPage = homePage.goToPetFoodFinderPage();
			getFoodForPetPage.VerifyDynamicForm();
			getFoodForPetPage.selectCatImage();
			getFoodForPetPage.clickContinuebtn();
			getFoodForPetPage.writePetName("Bella");
			getFoodForPetPage.selectGender();
			 getFoodForPetPage.enterAge("2");
			 getFoodForPetPage.clickContinuebtn();
			 getFoodForPetPage.selectBreed();
			 getFoodForPetPage.clickContinuebtn();
			 getFoodForPetPage.selectNeuteredFiled();
			 getFoodForPetPage.clickContinuebtn();
			 getFoodForPetPage.selectPetWeight("50");
			 getFoodForPetPage.clickContinuebtn();
			 getFoodForPetPage.selectLifeStyleOfPet();
			 getFoodForPetPage.clickContinuebtn();
			 getFoodForPetPage.selectFoodCondition();
			 getFoodForPetPage.clickRecommendationbtn();
			 getFoodForPetPage.verifyRecommendationBlocks();
	        
	    }
}
