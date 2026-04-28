package crm.vtiger.Products;

import java.io.IOException;
import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import generic_utility.FileUtility;
import junit.framework.Assert;
import object_repository.createProductsPage;
import object_repository.homePage;
import object_repository.loginPage;
import object_repository.productsPage;
import object_repository.verifyProducts;

public class CreateProductsPomTest {
	
	@Test
	
	public void createProductsTest() throws IOException, InterruptedException {
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

		// Click Products
		// Create Products
		productsPage prod = new productsPage(driver);
		prod.product();

		createProductsPage cProd = new createProductsPage(driver);
		String prodName = fUtil.getDatafromExcelFile("testdata", 2, 2);

		// Enter Oppor and Save
		cProd.getProdName().sendKeys(prodName);
		cProd.saveBtn().click();

//		verify Opportunity
		verifyProducts vfyProd = new verifyProducts(driver);
		String actProdName = vfyProd.getProdText().getText();
		
		Assert.assertEquals(actProdName, prodName);

//		if (actProdName.equals(prodName)) {
//			System.out.println("Product created successfullyy !!!!");
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
