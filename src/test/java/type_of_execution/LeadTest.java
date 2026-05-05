package type_of_execution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class LeadTest {
	
	WebDriver driver;
	
	@Test
	public void createLeadTest() throws InterruptedException {
		driver = new EdgeDriver();
		System.out.println("Create Lead");
		Thread.sleep(2000);
	}
	
	@Test
	public void modifyLeadTest() throws InterruptedException {
		driver = new EdgeDriver();
		System.out.println("Modify Lead");
		Thread.sleep(2000);
	}
	
	@Test
	public void deleteLeadTest() throws InterruptedException {
		driver = new EdgeDriver();
		System.out.println("Delete Lead");
		Thread.sleep(2000);
	}


}
