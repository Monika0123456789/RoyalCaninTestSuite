package AutomateRoyalCanin.TestComponent;



import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import AutomateRoyalCanin.BaseTest.BaseTest;
import AutomateRoyalCanin.PageObjects.GetFoodForPetPage;


public class GetFoodForPatPageTest {
	
public GetFoodForPetPage getFoodForPetPage;
	
	@BeforeMethod
	public void setup() {
		getFoodForPetPage=new GetFoodForPetPage(BaseTest.driver);
	}
	
	@Test
	public void FindingPetFood() throws InterruptedException {
		
		getFoodForPetPage.VerifyDynamicForm();
		getFoodForPetPage.selectCatImage();
		getFoodForPetPage.writePetName("Bella");
	}
	
	

}
