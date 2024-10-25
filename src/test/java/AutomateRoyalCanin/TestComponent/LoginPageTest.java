package AutomateRoyalCanin.TestComponent;

import java.io.IOException;

import org.testng.annotations.Test;

import AutomateRoyalCanin.BaseTest.BaseTest;
//import AutomateRoyalCanin.PageObjects.LoginPage;

public class LoginPageTest extends BaseTest {

    @Test
    public void loginTest() throws IOException {
        // Use the correctly initialized loginPage object
        loginPage.goToLoginPage();
        log.info("Login Scenario");
        loginPage.provideLoginDetails("monikamonika1379@gmail.com", "Monika@123");
        loginPage.submitLoginForm();
    }
}
