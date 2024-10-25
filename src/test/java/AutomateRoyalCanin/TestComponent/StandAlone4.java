package AutomateRoyalCanin.TestComponent;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import AutomateRoyalCanin.BaseTest.BaseTest;
import AutomateRoyalCanin.PageObjects.ContactFormPage;
import AutomateRoyalCanin.PageObjects.HomePage;
import AutomateRoyalCanin.PageObjects.LoginPage;

public class StandAlone4 extends BaseTest {

    @BeforeMethod
    public void setup() {
        loginPage = new LoginPage(driver);
    }

    @Test
    public void Demo() throws InterruptedException {
        // Log in to the application
        loginPage.goToLoginPage();
        loginPage.provideLoginDetails("monikamonika1379@gmail.com", "Monika@123");
        HomePage homePage = loginPage.submitLoginForm();

        // Verify login success and proceed to contact page
        homePage.verifyLogin();
        homePage.verifyLogo();
        ContactFormPage contactFormPage = homePage.goToContactPage();

        // Fill and submit the contact form
        contactFormPage.fillContactForm();
    }
}
