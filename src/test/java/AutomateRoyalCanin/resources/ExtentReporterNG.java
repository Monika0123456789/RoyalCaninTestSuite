package AutomateRoyalCanin.resources;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterNG {

	public static ExtentReports getExtentReport() {
		String path = System.getProperty("user.dir") + "//Test-Result//TestNG//testNg.html";

		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Hand-Made-Craft Report");
		reporter.config().setDocumentTitle("Hand-Made-Craft TestCase Result");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setTimelineEnabled(true);

		reporter.config().setCss(".r-img { width: 50%; } .r-caption { font-size: 14px; color: #333; }");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Project", "Hand-Made-Craft");
		extent.setSystemInfo("tester", "Monika");

		return extent;

	}

}
