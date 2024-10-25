package AutomateRoyalCanin.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import AutomateRoyalCanin.AbstractComponent.AbstractComponent;

public class GetFoodForPetPage extends AbstractComponent {
    
    public WebDriver driver;

    public GetFoodForPetPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//a[@title='Get the tailored product'])[1]")
    WebElement GetProductBtn;
    
    @FindBy(css = "#dynamicForm")
    WebElement DynamicForm;
    
    @FindBy(css = "label[for='cat']")
    WebElement catImageSelector;
    
    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement continuebtn;
    
//    // Updated XPath to avoid the apostrophe issue
//    @FindBy(xpath = "//input[@class='rc-field__input ng-untouched ng-pristine ng-valid ng-star-inserted']")
//    WebElement petNameInput;
//
//    
//    @FindBy(css = "label[for='genderCode-field__male']")
//    WebElement gender;
    
 // Updated XPath to avoid the apostrophe issue
    @FindBy(xpath = "//input[@class='rc-field__input ng-untouched ng-pristine ng-valid ng-star-inserted']")
    WebElement petNameInput;
    
    @FindBy(css = "label[for='genderCode-field__male']")
    WebElement gender;
    
    @FindBy(xpath= "//input[@id='unknownBirthdate']")
    WebElement dateCheckbox;
    
    @FindBy(css = "input[aria-label='Counter field']")
    WebElement ageCounter;
    
//    public void goToPetFoodFinderPage() {
//        GetProductBtn.click();
//    }
//    
    public void VerifyDynamicForm() {
        boolean isDynamicFormDisplayed = DynamicForm.isDisplayed();
        Assert.assertTrue(isDynamicFormDisplayed, "The dynamic form is not displayed on the pet food finder page.");     
    }
    
    public void selectCatImage() {
        scrollToElement(catImageSelector);  // Scroll to the cat image
        clickElementViaJS(catImageSelector);  // Click using JavaScript to avoid interception issues
        
    }
    
    public void clickContinuebtn() {
    	clickElementViaJS(continuebtn);  // Click the continue button
    }
    
    public void writePetName(String petName) {
        petNameInput.sendKeys(petName);  // Enter the pet's name
    }

    public void selectGender() {

        
        // Scroll to the gender element if needed
        scrollToElement(gender);

        // Use JavaScript click to avoid interception issues
        clickElementViaJS(gender);
    }
    
 // Example XPath for selecting a specific date, replace '2024-09-20' with the desired date
    @FindBy(xpath = "//input[@class='mat-datepicker-input rc-datepicker__input ng-untouched ng-pristine ng-valid']")
    WebElement DateField;
    
    @FindBy(css = "#mat-datepicker-0")
    WebElement datePicker;
    
    @FindBy(xpath = "//span[normalize-space()='1']")
    WebElement desiredDate;

    public void selectDate() {
//        // Click the DateField to open the date picker
//        waitForWebElementToAppear(DateField);
//        scrollToElement(DateField);
//        clickElementViaJS(DateField);
//        
//        // Wait for the date picker to appear
//        waitForWebElementToAppear(datePicker);
//        
//        // Ensure the desired date is clickable before clicking
//        waitForWebElementToClickabel(desiredDate);
//        
//        // Click the desired date
//        clickElementViaJS(desiredDate);
    	
    	
    }
    
    @FindBy(css = "#breedCode-field-checkbox")
    WebElement breedCheckbox;



    public void enterAge(String age) {
        // Scroll to the date checkbox
        scrollToElement(dateCheckbox);
        
        // Wait for the checkbox to be clickable
        waitForWebElementToClickabel(dateCheckbox);
        
        // Click the unknown birthdate checkbox using JavaScript
        clickElementViaJS(dateCheckbox);
        
        // Scroll to the age counter
        ageCounter.clear();  // Clear any pre-filled value
        ageCounter.sendKeys(age);  // Enter the pet's age
    }
    
    public void selectBreed() {
    	
    	 scrollToElement(breedCheckbox);
         
         // Wait for the checkbox to be clickable
         waitForWebElementToClickabel(breedCheckbox);
         
         // Click the unknown birthdate checkbox using JavaScript
         clickElementViaJS(breedCheckbox);
    }
    
    @FindBy(css = "label[for='neutered-field__true']")
    WebElement neuteredField;
    
    public void selectNeuteredFiled() {
         scrollToElement(neuteredField);
         
         // Wait for the checkbox to be clickable
         waitForWebElementToClickabel(neuteredField);
    	
    	 clickElementViaJS(neuteredField);
    }

    @FindBy(css = "input[type='number']")
    WebElement PetWeight;
    
    @FindBy(css = "label[for='3']")
    WebElement PetBodyShape;
    
    public void selectPetWeight(String weight) {
    	PetWeight.sendKeys(weight);
    	
    	  scrollToElement( PetBodyShape);
     	
     	 clickElementViaJS( PetBodyShape);
    	
    }
    
    @FindBy(css = "label[for='lifestyle-field__indoor']")
    WebElement LifeStyleFiled;
    
    @FindBy(css ="label[for='low']")
    WebElement ActiveLevel;
    
    public void selectLifeStyleOfPet() {
    	LifeStyleFiled.click();
    	
    	scrollToElement( ActiveLevel);
     	
    	 clickElementViaJS( ActiveLevel);
    }
    
    @FindBy(css = "label[for='petFussyEaterCat-field__true']")
    WebElement Fussyeater;
    
    @FindBy(css = "label[for='sensitivity-field__none']")
    WebElement sensitivityFiled;
    
    @FindBy(xpath = "//button[normalize-space()='Get my recommendation']")
    WebElement recommenditionBtn;
    
    
    public void selectFoodCondition() {
    	
    	scrollToElement(Fussyeater);
    	waitForWebElementToClickabel(Fussyeater);
      	 clickElementViaJS(Fussyeater);
    	
    	scrollToElement(sensitivityFiled);
     	
   	 clickElementViaJS( sensitivityFiled);
    }
    
    public void clickRecommendationbtn() {
    	clickElementViaJS( recommenditionBtn);  // Click the continue button
    }
    
    @FindBy(xpath = "//div[@class='wet-container']")
    List<WebElement> recommendationContainer;  // Make sure the list is typed with WebElement

    public void verifyRecommendationBlocks() {
        // Count the number of recommendation blocks
        int recommendationCount = recommendationContainer.size();
        
        // Print the count
        System.out.println("Number of recommendation blocks: " + recommendationCount);
        
        // Optionally, assert that the count is as expected
        Assert.assertTrue(recommendationCount > 0, "No recommendation blocks found!");
    }

}
