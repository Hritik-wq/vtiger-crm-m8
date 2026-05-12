package crm.vtiger.organization;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base_utility.BaseClass;
import generic_utility.FileUtility;
import object_repository.createOrgPage;
import object_repository.orgPage;
import object_repository.verifyOrgPage;

public class CreateOrgTestExtentRep extends BaseClass {

	@Test
	public void createOrganizationTest() throws IOException, InterruptedException {

		// STEP 1: Configure Extent Report

		ExtentSparkReporter spark = new ExtentSparkReporter("./advance_reports/OrganizationReport.html");

		spark.config().setDocumentTitle("VTiger CRM |Results of Automation Test");
		spark.config().setReportName("Organization Module Regression Execution Report");
		spark.config().setTheme(Theme.DARK);

		// Create Extent Reports Object
		ExtentReports report = new ExtentReports();
		report.attachReporter(spark);

		// Add System Information - Extent Reports
		report.setSystemInfo("Project Name", "VTiger CRM Automation");
		report.setSystemInfo("Module", "Organization Module");
		report.setSystemInfo("Tester", "QA Engineer - Hritik");
		report.setSystemInfo("Environment", "QA");
		report.setSystemInfo("Browser", "Edge");
		report.setSystemInfo("Framework", "Hybrid Framework");
		report.setSystemInfo("Automation Tool", "Selenium WebDriver");
		report.setSystemInfo("Build Version", "v2.1.1");

		// STEP 4: Create Test Entry
		ExtentTest test = report.createTest("Create Organization Test");

		try {

			// Navigate to Organization Module

			// Click Create Organization Icon

			orgPage orG = new orgPage(driver);
			orG.org();

			test.log(Status.PASS, "Navigated to Organization module");

			test.log(Status.PASS, "Clicked on Create Organization icon");

			// STEP 7: Read Test Data

			FileUtility fUtil = new FileUtility();

			String orgName = fUtil.getDatafromExcelFile("testdata", 1, 1);

			test.log(Status.INFO, "Generated organization name : " + orgName);

			// Fill Organization Form

			createOrgPage cOP = new createOrgPage(driver);

			String orgName1 = fUtil.getDatafromExcelFile("testdata", 1, 1);

			cOP.getOrgName().sendKeys(orgName1);

			test.log(Status.PASS, "Entered organization name");

			cOP.saveBtn().click();

			test.log(Status.PASS, "Clicked on Save button");

			// STEP 9: Verify Organization Creation

			verifyOrgPage vOP = new verifyOrgPage(driver);
			String actOppName = vOP.getOrgText().getText();

			Assert.assertEquals(actOppName, orgName1);

			test.log(Status.PASS, "Organization created successfully");

			test.log(Status.INFO, "Expected Org Name : " + orgName1);
			test.log(Status.INFO, "Actual Org Name : " + actOppName);

		} catch (Exception e) {

			// Failure Handling

			test.log(Status.FAIL, "Test case failed due to : " + e.getMessage());

			throw e;

			// Run regardless of Pass, Fail, Exception Finally Block

		} finally {

			// Generates the Report

			report.flush();
		}
	}
}