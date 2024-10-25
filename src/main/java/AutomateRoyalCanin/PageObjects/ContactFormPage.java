package AutomateRoyalCanin.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import AutomateRoyalCanin.AbstractComponent.AbstractComponent;

public class ContactFormPage extends AbstractComponent {

    public WebDriver driver;

    public ContactFormPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locate form fields
    @FindBy(css = "select[id='Case.Web_Reason__c']")
    WebElement reasonForContactDropdown;

    @FindBy(css = "input[id='Case.AccountId.FirstName']")
    WebElement firstNameInput;

    @FindBy(css = "input[id='Case.AccountId.LastName']")
    WebElement lastNameInput;

    @FindBy(css = "input[id='Case.AccountId.PersonEmail']")
    WebElement emailInput;

    @FindBy(css = "input[id='Case.AccountId.PersonHomePhone']")
    WebElement phoneNumberInput;

    @FindBy(css = "input[id='Case.AccountId.ShippingCity']")
    WebElement cityInput;

    @FindBy(css = "input[id='Case.Order_Number__c']")
    WebElement orderNumberInput;

    @FindBy(css = "input[id='Case.RC_Web_Product_Name__c']")
    WebElement productNameInput;

    @FindBy(css = "input[id='Case.Product_Product_Pack_Size_Description__c']")
    WebElement productSizeInput;

    @FindBy(css = "input[id='Case.Product_Batch_Code__c']")
    WebElement batchCodeInput;

    @FindBy(css = "input[id='Case.Packaging_code__c']")
    WebElement packagingCodeInput;

    @FindBy(css = "input[id='Case.Product_Best_Before__c']")
    WebElement bestBeforeInput;

    @FindBy(css = "input[id='Case.Subject']")
    WebElement subjectInput;

    @FindBy(css = "textarea[id='Case.Description']")
    WebElement commentsInput;

    @FindBy(css = "select[id='Case.Web_Pet_Type__c']")
    WebElement petTypeDropdown;

    @FindBy(css = "input[id='Case.Web_Pet_Name__c']")
    WebElement petNameInput;

    @FindBy(css = "input[id='Case.Web_Pet_Breed__c']")
    WebElement breedInput;

    @FindBy(css = "select[id='Case.Web_Pet_Gender__c']")
    WebElement petGenderDropdown;

    @FindBy(css = "select[id='Case.Web_Pet_Size__c']")
    WebElement petSizeDropdown;

    @FindBy(xpath = "//button[@class=\"QSIWebResponsiveDialog-Layout1-SI_9ubxezlRTzYh6gS_close-btn\"]")
    WebElement FeedbackDeleteBtn;

    @FindBy(xpath = "//a[normalize-space()='1']")
    WebElement selectDate;

    @FindBy(xpath = "//input[@id='btnsubmit']")
    WebElement SubmitBtn;
    
    @FindBy(css = "#ff-ui-datepicker-div > table > tbody > tr:nth-child(1) > td:nth-child(3) > a")
    WebElement date;

    // Method to fill the form with dummy data
    public void fillContactForm() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Select reason for contact
        wait.until(ExpectedConditions.visibilityOf(reasonForContactDropdown));
        Select reasonForContact = new Select(reasonForContactDropdown);
        reasonForContact.selectByVisibleText("General Question");

        // Fill personal details
        firstNameInput.sendKeys("John");
        lastNameInput.sendKeys("Doe");
        emailInput.sendKeys("john.doe@example.com");
        phoneNumberInput.sendKeys("1234567890");
        cityInput.sendKeys("New York");

        // Fill about your contact section
        orderNumberInput.sendKeys("123456");
        productNameInput.sendKeys("Royal Canin Dog Food");
        productSizeInput.sendKeys("Large");
        batchCodeInput.sendKeys("A12345");
        packagingCodeInput.sendKeys("P67890");
        bestBeforeInput.sendKeys("12/2021");

        // Fill about your pet section
        Select petType = new Select(petTypeDropdown);
        petType.selectByVisibleText("Dog");

        petNameInput.sendKeys("Buddy");
        breedInput.sendKeys("Golden Retriever");

        Select petGender = new Select(petGenderDropdown);
        petGender.selectByVisibleText("Male");

        Select petSize = new Select(petSizeDropdown);
        petSize.selectByVisibleText("Large");

        // Handle any feedback pop-up
        if (FeedbackDeleteBtn.isDisplayed()) {
            FeedbackDeleteBtn.click();
        }

        // Scroll and submit
        scrollToElement(SubmitBtn);
        clickElementViaJS(SubmitBtn);
        Thread.sleep(1000);
        clickElementViaJS(date);
    }
}
