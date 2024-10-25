package AutomateRoyalCanin.TestComponent;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import AutomateRoyalCanin.BaseTest.BaseTest;
import AutomateRoyalCanin.PageObjects.ContactFormPage;

public class ContactFormPageTest extends BaseTest {
	
	private ContactFormPage contactFormPage;

    // This method will initialize the page objects before each test
    @BeforeMethod
    public void setup() {
        // Initialize the WhereToBuyPage with the WebDriver instance from BaseTest
    	contactFormPage = new ContactFormPage(BaseTest.driver);
    }
    
    @Test
    public void AddComment() throws InterruptedException {
    	contactFormPage.fillContactForm();
    }

}
