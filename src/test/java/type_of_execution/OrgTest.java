package type_of_execution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class OrgTest {
	
	WebDriver driver;
	
	@Test
	public void createOrgTest() throws InterruptedException {
		driver = new FirefoxDriver();
		System.out.println("Create Org");
		Thread.sleep(3000);
	}
	
	@Test
	public void modifyOrgTest() throws InterruptedException {
		driver = new FirefoxDriver();
		System.out.println("Modify Org");
		Thread.sleep(3000);
	}
	
	@Test
	public void deleteOrgTest() throws InterruptedException {
		driver = new FirefoxDriver();
		System.out.println("Delete Org");
		Thread.sleep(3000);
	}


}
