package crm.vtiger.Sales;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import generic_utility.FileUtility;
import object_repository.createSalesOrderPage;
import object_repository.homePage;
import object_repository.loginPage;
import object_repository.salesOrder;
import object_repository.verifySalesOrder;

public class CreateSalesPom {
	public static void main(String[] args) throws InterruptedException, IOException {

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

		// Click More for Sales
		// Click SalesOrder
		salesOrder saleS = new salesOrder(driver);
		saleS.sales();

		createSalesOrderPage csOP = new createSalesOrderPage(driver);
		// fill form
		// Select Subject from Excel File for Sales Order
		String actSalesName = fUtil.getDatafromExcelFile("testdata", 2, 5);
		csOP.getSalesName().sendKeys(actSalesName);

		// Change window and Click
		String parentWindow = driver.getWindowHandle();
		
		csOP.clickOrgzcreate().click();

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

		// Enter Organization Name from Excel - Generic Utility Package ---> Used
		// Fileutility.java
		String orgName = fUtil.getDatafromExcelFile("testdata", 2, 1);
		csOP.clickOrgzName().click();

		// Interact In Popup
		Alert ale = driver.switchTo().alert();
		ale.accept();

		Thread.sleep(3000);

		// Switch back to parent
		driver.switchTo().window(parentWindow);

		// Shipping Address changes according to Organization Name Selected
		// driver.findElement(By.name("ship_street")).sendKeys("Tokyo");

		// item name in item details open window

		String parentWindow2 = driver.getWindowHandle();
		
		String itemName = fUtil.getDatafromExcelFile("testdata", 4, 7);
		csOP.clickItemName().click();

		driver.findElement(By.id("searchIcon1")).click();
		Thread.sleep(2000);

		Set<String> allWindows2 = driver.getWindowHandles();

		for (String j : allWindows2) {

			driver.switchTo().window(j);

		}

		for (String windowHandle : allWindows2) {
			if (!windowHandle.equals(parentWindow2)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}

		// Select item name in Select Product Popup
		driver.findElement(By.linkText(itemName)).click();

		Thread.sleep(3000);

		// Switch back to parent
		driver.switchTo().window(parentWindow);

		// Enter Quantity from Excel File - Generic Utility Package ---> Used
		// Fileutility.java
		String qty = fUtil.getDatafromExcelFile("testdata", 2, 8);
		csOP.enterQty().sendKeys(qty);
		csOP.saveBtn().click();

//		verify Sales
		verifySalesOrder vfySO = new verifySalesOrder(driver);
		String actSaleName = vfySO.getSalesText().getText();

		if (actSaleName.equals(actSalesName)) {
			System.out.println("Sales Order created successfullyy !!!!");
		} else {
			System.out.println("Better luck next time... Dingeshhh");
		}

//		// Logout
		homePage hP = new homePage(driver);
		hP.ClickProfile().click();
		hP.logoutBtn().click();

//		Browser close		
		Thread.sleep(3000);
		driver.quit();
	}
}
