package testng_extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class DemoTest {

	public static void main(String[] args) {
		System.out.println("just a main method");
	}
	
	@Test
	public void case2() {
		WebDriver driver = new EdgeDriver();
		Reporter.log("hi", true);
	}
	
	@Test
	public void case1() {
		WebDriver driver = new ChromeDriver();
	}
	

}