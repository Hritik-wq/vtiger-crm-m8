package crm.vtiger.opportunities;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import generic_utility.FileUtility;
import junit.framework.Assert;
import object_repository.createOpporPage;
import object_repository.homePage;
import object_repository.loginPage;
import object_repository.opporPage;
import object_repository.verifyOpporPage;

public class CreateOpportunitiesPomTest {
	
	@Test
	
	public void createOpportunitiesTest() throws IOException, InterruptedException {
//		opening browser		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

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

		// Handles un, pwd, and loginBtn internally
		loginPage lp = new loginPage(driver);
		lp.login(USERNAME, PASSWORD);

		// Select Opportunity
		opporPage oppOR = new opporPage(driver);
		oppOR.oppor();

//		fill form
		createOpporPage copP = new createOpporPage(driver);
		String orgName = fUtil.getDatafromExcelFile("testdata", 1, 1);
		copP.getOpporName().sendKeys(orgName);

		// Need to Change Window to select Link

		String parentWindow = driver.getWindowHandle();

		// Select Related To
		copP.relatedTo().click();

		Set<String> allWindows = driver.getWindowHandles();

		for (String i : allWindows) {

			driver.switchTo().window(i);

		}

		for (String windowHandle : allWindows) {
			if (!windowHandle.equals(parentWindow)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}

		// Load test data from Excel for realtedField
		fUtil.getDatafromExcelFile("testdata", 1, 3);
		copP.selectRelatedTo().click();

		Thread.sleep(3000);

		// Switch back to parent
		driver.switchTo().window(parentWindow);

		// To Click on Save Button
		copP.saveBtn().click();

		// verify organization
		verifyOpporPage vfyOppor = new verifyOpporPage(driver);
		String actOrgName = vfyOppor.getOpporText().getText();
		
		Assert.assertEquals(actOrgName, orgName);

//		if (actOrgName.equals(orgName)) {
//			System.out.println("Opportunity created successfullyy !!!!");
//		} else {
//			System.out.println("Better luck next time... Dingeshhh");
//		}

		// Logout
		homePage hP = new homePage(driver);
		hP.ClickProfile().click();
		hP.logoutBtn().click();

		// browser close
		Thread.sleep(3000);
		driver.quit();
	}
}
