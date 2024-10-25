package AutomateRoyalCanin.stepDefinations;

import AutomateRoyalCanin.BaseTest.BaseTest;
import AutomateRoyalCanin.PageObjects.HomePage;
import AutomateRoyalCanin.PageObjects.LoginPage;
import AutomateRoyalCanin.PageObjects.ProductDetailsPage;
import AutomateRoyalCanin.PageObjects.ProductListPage;
import io.cucumber.java.en.*;

import java.io.IOException;

import org.testng.Assert;

public class ReviewStepDefination extends BaseTest{
	
    LoginPage loginPage;
    HomePage homePage;
    ProductListPage productListPage;
    ProductDetailsPage productDetailsPage;

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() throws IOException {
    	// Use the already initialized driver from BaseTest
        launchApplication();  // This ensures the app is launched if not already done
        loginPage = new LoginPage(driver);
        loginPage.goToLoginPage();
    }

    @When("the user logs in with valid credentials")
    public void the_user_logs_in_with_valid_credentials() {
        // Provide valid login credentials
        loginPage.provideLoginDetails("monikamonika1379@gmail.com", "Monika@123");
        
        // Submit login form
        homePage = loginPage.submitLoginForm();
    }

    @Then("the user should be redirected to the homepage")
    public void the_user_should_be_redirected_to_the_homepage() {
        // Verify successful login by checking user icon
        homePage.verifyLogin();
    }

    @And("the user navigates to the Product Listing Page \\(PLP\\)")
    public void the_user_navigates_to_the_Product_Listing_Page_PLP() {
        // Navigate to the PLP
        productListPage = homePage.naviagteToPLP();
    }

//    @When("the user selects a product from PLP")
//    public void the_user_selects_a_product_from_PLP() {
//    	productListPage.isFilterContainerDisplayed();
//
//        // Apply the "Wet Food" filter
//        String result1 = productListPage.applyFoodTextureFilter();
//        System.out.println(result1);
//
//        Boolean isFilterApplied1 = productListPage.verifyAppliedFoodFilter();
//        System.out.println("Is the correct food filter applied: " + isFilterApplied1);
//
//        Boolean isCountMatching1 = productListPage.verifyProductCountMatches1();
//        System.out.println("Is the food product count matching: " + isCountMatching1);
//
//         //Apply the "Age" filter
//        String result2 = productListPage.applyAgeFilter();
//        System.out.println(result2);
//
//        Boolean isFilterApplied2 = productListPage.verifyAppliedAgeFilter();
//        System.out.println("Is the correct age filter applied: " + isFilterApplied2);
//
//        Boolean isCountMatching2 = productListPage.verifyProductCountMatches2();
//        System.out.println("Is the age product count matching: " + isCountMatching2);
//        ProductDetailsPage productDetailsPage = productListPage.goToProductDetailsPage();
//    }
    
    @When("the user selects a product from PLP")
    public void the_user_selects_a_product_from_PLP() {
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

        // Navigate to Product Details Page and assign to productDetailsPage
        productDetailsPage = productListPage.goToProductDetailsPage();
    }


    @Then("the user should be on the Product Details Page \\(PDP\\)")
    public void the_user_should_be_on_the_Product_Details_Page_PDP() {
        // Verify user is on PDP by checking the product details
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("products"), "User not redirected to PDP!");
    }

    @When("the user clicks on Rating star")
    public void the_user_clicks_on_Rating_star() {
        // Click on "Add Review" button
        productDetailsPage.goToReviewSection();
    }
//
//    @And("the user fills in the review details")
//    public void the_user_fills_in_the_review_details() {
//        // Fill in the review form details (e.g., review title, description)
//        productDetailsPage.fillInReviewForm("Amazing product", "This is an excellent product. Highly recommended!");
//    }
//
//    @And("the user submits the review")
//    public void the_user_submits_the_review() {
//        // Submit the review form
//        productDetailsPage.submitReviewForm();
//    }
//
//    @Then("the review should be successfully submitted")
//    public void the_review_should_be_successfully_submitted() {
//        // Verify that the review is successfully submitted
//        Assert.assertTrue(productDetailsPage.isReviewSubmitted(), "Review was not successfully submitted!");
//        
//        // Close the driver
//        driver.quit();
//    }

}
