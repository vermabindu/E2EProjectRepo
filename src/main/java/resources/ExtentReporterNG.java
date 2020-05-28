package resources;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	public WebDriver driver;
	static ExtentReports extent;
	public static ExtentReports getReportObject()
	{
		//ExtentReporter, ExtentSparkReporter
				String path = System.getProperty("user.dir")+"/reports/index.html";
				ExtentSparkReporter reporter = new ExtentSparkReporter(path);
				reporter.config().setReportName("Web Atomation Results");
				reporter.config().setDocumentTitle("Test Results!");
				
				extent = new ExtentReports();
				extent.attachReporter(reporter);
				extent.setSystemInfo("Tester", "Bindu");
				return extent;
	}
	

}
