package base_utility;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import object_repository.createOrgPage;
import object_repository.homePage;
import object_repository.loginPage;
import object_repository.orgPage;
import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;

public class BaseClass {

	public WebDriver driver;

	@BeforeClass
	public void setUp() {

		driver = new ChromeDriver();
		WebDriverUtility wdUtil = new WebDriverUtility(driver);
		
		wdUtil.maxWin();
		wdUtil.waitForPageLoad();

	}

	@BeforeMethod
	public void login() throws IOException {
		FileUtility fUtil = new FileUtility();
		
		String URL = fUtil.getDataFromPropFile("url");
		String USERNAME = fUtil.getDataFromPropFile("un");
		String PASSWORD = fUtil.getDataFromPropFile("pwd");

		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);

		driver.get(URL);

		loginPage lp = new loginPage(driver);
		lp.login(USERNAME, PASSWORD);

	}
	
	@AfterMethod
	public void logout() {
//		Logout
		
		homePage hP = new homePage(driver);
		hP.ClickProfile().click();
		hP.logoutBtn().click();
	}
	
	@AfterClass
	public void closeBro() throws InterruptedException {
		
//		Browser close		
		Thread.sleep(3000);
		driver.quit();
	}

}
