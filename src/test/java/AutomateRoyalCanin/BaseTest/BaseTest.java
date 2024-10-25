package AutomateRoyalCanin.BaseTest;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import AutomateRoyalCanin.PageObjects.LoginPage;

public class BaseTest {
    public Properties prop;
    public static WebDriver driver;
    public LoginPage loginPage;
    public static Logger log;

    public WebDriver initialize() throws IOException {
    	
    	log = LogManager.getLogger(BaseTest.class);


        prop = new Properties();
        
        FileInputStream fis = new FileInputStream(
                System.getProperty("user.dir") + "\\src\\main\\java\\AutomateRoyalCanin\\resources\\GlobalData.properties");
        prop.load(fis);
        
        String browser = System.getProperty("browser") != null ? System.getProperty("browser")
                : prop.getProperty("browser");
     // String browser = prop.getProperty("browser");
     		log.info("Initializing {} Browser", browser);

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(prop.getProperty("AppUrl"));
        log.info("Launching the Application");
        return driver;
    }

    @BeforeSuite
    public void launchApplication() throws IOException {
        driver = initialize();
        loginPage = new LoginPage(driver);
    }

//    @AfterSuite
//    public void closeConnection() {
//    log.info("Closing the browser");
//
//        if (driver != null) {
//            driver.close();
//        }
//    }
    
    public String getScreenShot(String testCase, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File path = new File(
				System.getProperty("user.dir") + "//Test-Result//TestNG//ScreenShots//" + testCase + ".png");
		FileUtils.copyFile(source, path);

		return System.getProperty("user.dir") + "//Test-Result//TestNG//ScreenShots//" + testCase + ".png";
	}

}
