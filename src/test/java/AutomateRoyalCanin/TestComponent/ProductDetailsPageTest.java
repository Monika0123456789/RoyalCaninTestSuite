package AutomateRoyalCanin.TestComponent;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import AutomateRoyalCanin.BaseTest.BaseTest;
import AutomateRoyalCanin.PageObjects.ProductDetailsPage;


public class ProductDetailsPageTest {
	
	 public ProductDetailsPage productDetailsPage;
		
		@BeforeMethod
		public void setup() {
			productDetailsPage=new ProductDetailsPage(BaseTest.driver);
		}
		
		@Test
		public void VerifyProductInPDP() {
			productDetailsPage.verifyProductDetailsPage();
			productDetailsPage.increaseQuantityByOne();
			productDetailsPage.verifyQuantityAfterIncrease(2); 
			productDetailsPage.addToCart();
			productDetailsPage.handleCartWarningAndDeleteProducts(); 
			productDetailsPage.verifyProductNameWithTitle();
			productDetailsPage.goToCartPage();
		}

}
