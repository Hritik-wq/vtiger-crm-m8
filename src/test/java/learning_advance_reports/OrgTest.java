package learning_advance_reports;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import generic_utility.JavaUtility;

public class OrgTest {

	@Test
	public void createOrgTest() {

		// =========================================================
		// STEP 1: Configure Extent Spark Reporter
		// =========================================================

		String time = JavaUtility.generateTime();
		ExtentSparkReporter spark = new ExtentSparkReporter("./advance_reports/" + time + ".html");

		spark.config().setDocumentTitle("VTiger CRM | Automation Test Results");
		spark.config().setReportName("QA Automation Regression Suite Execution Report");
		spark.config().setTheme(Theme.STANDARD);

		// =========================================================
		// STEP 2: Create Extent Reports Object
		// =========================================================

		ExtentReports report = new ExtentReports();
		report.attachReporter(spark);

		// =========================================================
		// STEP 3: Add System / Environment Information
		// =========================================================

		report.setSystemInfo("Project Name", "VTiger CRM Automation");
		report.setSystemInfo("Module", "Organization Management");
		report.setSystemInfo("Tester", "QA Automation Engineer");
		report.setSystemInfo("Environment", "QA");
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("Operating System", "Windows 11");
		report.setSystemInfo("Automation Tool", "Selenium WebDriver");
		report.setSystemInfo("Framework", "TestNG Hybrid Framework");
		report.setSystemInfo("Build Version", "v1.0.0");

		// =========================================================
		// STEP 4: Create Test Case Entry in Report
		// =========================================================

		ExtentTest test = report.createTest("createOrgTest");

		WebDriver driver = null;

		try {

			// =========================================================
			// STEP 5: Launch Browser
			// =========================================================

			test.log(Status.INFO, "Launching Chrome browser");

			driver = new ChromeDriver();

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

			test.log(Status.PASS, "Browser launched successfully");

			// =========================================================
			// STEP 6: Navigate to Application
			// =========================================================

			driver.get("http://localhost:8888/");

			test.log(Status.INFO, "Navigated to VTiger CRM application");

			// =========================================================
			// STEP 7: Login to Application
			// =========================================================

			driver.findElement(By.name("user_name")).sendKeys("admin");
			test.log(Status.INFO, "Entered username");

			driver.findElement(By.name("user_password")).sendKeys("password");
			test.log(Status.INFO, "Entered password");

			new Actions(driver).sendKeys(Keys.ENTER).build().perform();

			test.log(Status.INFO, "Clicked on Login button");

			// =========================================================
			// STEP 8: Validation
			// =========================================================

			boolean status = driver.findElement(By.partialLinkText("Home")).isDisplayed();

			Assert.assertTrue(status, "Login failed...");

			test.log(Status.PASS, "User logged into VTiger CRM successfully");

		} catch (Exception e) {

			// =========================================================
			// STEP 9: Handle Failure
			// =========================================================

			test.log(Status.FAIL, "Test case failed due to : " + e.getMessage());

			throw e;

		} finally {

			// =========================================================
			// STEP 10: Close Browser
			// =========================================================

			if (driver != null) {
				driver.quit();
				test.log(Status.INFO, "Browser closed successfully");
			}

			// =========================================================
			// STEP 11: Generate Report
			// =========================================================

			report.flush();
		}
	}
}