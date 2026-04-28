package helper_att;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class sampleThreadpool {

//    @Test
//    public void edge() {
//        WebDriver driver = new EdgeDriver();
//    }

//    @Test(invocationCount = 4)
//    public void chrome() throws InterruptedException {
//    	WebDriver driver = new ChromeDriver();
//    	Thread.sleep(2000);
//    	driver.quit();
//    }
    
    // Time Saved by Parallel Execution
    @Test(invocationCount = 10, threadPoolSize=10)
    public void chrome() throws InterruptedException {
    	WebDriver driver = new ChromeDriver();
    	Thread.sleep(2000);
    	driver.quit();
    }
    
}