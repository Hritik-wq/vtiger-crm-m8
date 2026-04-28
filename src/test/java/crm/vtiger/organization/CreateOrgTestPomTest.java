package crm.vtiger.organization;

import java.io.IOException;

import object_repository.createOrgPage;
import object_repository.homePage;
import object_repository.loginPage;
import object_repository.orgPage;
import object_repository.verifyOrgPage;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;
import junit.framework.Assert;

public class CreateOrgTestPomTest {
	
	@Test
	
	public void createOrganizationTest() throws IOException, InterruptedException {

//		opening browser		
		WebDriver driver = new ChromeDriver();
		
		WebDriverUtility wdUtil = new WebDriverUtility(driver);
		wdUtil.maxWin();
		wdUtil.waitForPageLoad();

//		We Used Generic Utility Package and Used Fileutility.java to get the data from Properties File in one go
		FileUtility fUtil = new FileUtility();
		String URL = fUtil.getDataFromPropFile("url");
		String USERNAME = fUtil.getDataFromPropFile("un");
		String PASSWORD = fUtil.getDataFromPropFile("pwd");

		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);

//		login
		driver.get(URL);
		
		//Can Use This Also
		//loginPage lp = new loginPage(driver);
		//lp.getUn().sendKeys(USERNAME);  
		
		// Handles un, pwd, and loginBtn internally
		loginPage lp = new loginPage(driver);
		lp.login(USERNAME, PASSWORD);
		
		//Click Organization
		orgPage orG = new orgPage(driver);
		orG.org();
		
//		fill form
		createOrgPage cOP = new createOrgPage(driver);
		String orgName = fUtil.getDatafromExcelFile("testdata", 1, 1);
		cOP.getOrgName().sendKeys(orgName);
		cOP.saveBtn().click();
		
		// verify opportunity
		verifyOrgPage vOP = new verifyOrgPage(driver);
		String actOppName = vOP.getOrgText().getText();
		
		Assert.assertEquals(actOppName, orgName);
		
//		if (actOppName.equals("abc"+orgName)) {
//		Reporter.log("Organization created successfullyy !!!!");
//	} else {
//		Reporter.log("Better luck next time... Dingeshhh");
//	}

//		if (actOppName.equals(orgName)) {
//			System.out.println("Organization created successfullyy !!!!");
//		} else {
//			System.out.println("Better luck next time... Dingeshhh");
//		}

//		Logout
		homePage hP = new homePage(driver);
		hP.ClickProfile().click();
		hP.logoutBtn().click();
		
//		Browser close		
		Thread.sleep(3000);
		driver.quit();
	}
}
