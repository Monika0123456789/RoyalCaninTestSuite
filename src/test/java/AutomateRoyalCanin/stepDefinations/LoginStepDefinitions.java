package AutomateRoyalCanin.stepDefinations;

import org.testng.Assert;
import AutomateRoyalCanin.BaseTest.BaseTest;
import AutomateRoyalCanin.PageObjects.HomePage;
import AutomateRoyalCanin.PageObjects.LoginPage;
import io.cucumber.java.en.*;

public class LoginStepDefinitions extends BaseTest {

    LoginPage loginPage;
    HomePage homePage;

    @Given("the user is on the homepage")
    public void the_user_is_on_the_homepage() throws Exception {
        // Use the already initialized driver from BaseTest
        launchApplication();  // This ensures the app is launched if not already done
        loginPage = new LoginPage(driver);
    }

    @When("the user navigates to the login page")
    public void the_user_navigates_to_the_login_page() {
        loginPage.goToLoginPage();
    }

    @When("the user provides valid email {string} and password {string}")
    public void the_user_provides_valid_email_and_password(String email, String password) {
        loginPage.provideLoginDetails(email, password);
    }

    @When("the user submits the login form")
    public void the_user_submits_the_login_form() {
        homePage = loginPage.submitLoginForm();
    }

//    @Then("the user should be redirected to the homepage")
//    public void the_user_should_be_redirected_to_the_homepage() {
//        String expectedTitle = "Royal Canin - Home"; // Adjust as per the actual title
////        Assert.assertEquals(driver.getTitle(), expectedTitle, "User was not redirected to the homepage");
//    }
}
