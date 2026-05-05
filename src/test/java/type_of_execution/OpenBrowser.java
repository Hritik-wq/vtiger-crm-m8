package type_of_execution;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;


public class OpenBrowser {

	WebDriver driver;

	@Parameters("browser")
	@Test

	public void openBro(String bro) throws InterruptedException {
		// String bro = "edge";

		if (bro.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (bro.equals("edge")) {
			driver = new EdgeDriver();
		} else if (bro.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		Thread.sleep(3000);
		driver.quit();

	}

}
