package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/java/cucumber/LoginPage.feature", // Path to feature files
    glue = "AutomateRoyalCanin.stepDefinations", // Package containing step definitions
    plugin = {"pretty", "html:target/cucumber.html"}, // Report generation
    monochrome = true // Clean console output
)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
}

