package AutomateRoyalCanin.TestComponent;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import AutomateRoyalCanin.BaseTest.BaseTest;
import AutomateRoyalCanin.PageObjects.ProductListPage;

public class ProductListPageTest extends BaseTest{
	
   public ProductListPage productListPage;
	
	@BeforeMethod
	public void setup() {
		productListPage=new ProductListPage(BaseTest.driver);
	}
	
	@Test
	public void VerifyFilterContainer() {
		log.info("Verifying the logo at navbar in Home page");
		productListPage.isFilterContainerDisplayed();

        // Apply the "Wet Food" filter
        String result1 = productListPage.applyFoodTextureFilter();
        System.out.println(result1);

        Boolean isFilterApplied1 = productListPage.verifyAppliedFoodFilter();
        System.out.println("Is the correct food filter applied: " + isFilterApplied1);

        Boolean isCountMatching1 = productListPage.verifyProductCountMatches1();
        System.out.println("Is the food product count matching: " + isCountMatching1);

        // Apply the "Age" filter
        String result2 = productListPage.applyAgeFilter();
        System.out.println(result2);

        Boolean isFilterApplied2 = productListPage.verifyAppliedAgeFilter();
        System.out.println("Is the correct age filter applied: " + isFilterApplied2);

        Boolean isCountMatching2 = productListPage.verifyProductCountMatches2();
        System.out.println("Is the age product count matching: " + isCountMatching2);
        
        productListPage.goToProductDetailsPage();
	}
	
}
