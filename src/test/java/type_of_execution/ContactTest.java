package type_of_execution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ContactTest {
	
	WebDriver driver;
	
	@Test
	public void createContactTest() throws InterruptedException {
		driver = new ChromeDriver();
		System.out.println("Create Contact");
		Thread.sleep(2000);
	}
	
	@Test
	public void modifyContactTest() throws InterruptedException {
		driver = new ChromeDriver();
		System.out.println("Modify Contact");
		Thread.sleep(2000);
	}
	
	@Test
	public void deleteContactTest() throws InterruptedException {
		driver = new ChromeDriver();
		System.out.println("Delete Contact");
		Thread.sleep(2000);
	}


}
