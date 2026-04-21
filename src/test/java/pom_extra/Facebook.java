package pom_extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Facebook {
	
	//To declare the WebElement
	
	//For Email
    @FindBy(name = "email")
    private WebElement un;
    
    //For Password
    @FindBy(name = "pass")  
    private WebElement pwd;
    
    //For Log In Button
    @FindBy(linkText= "Log in")  
    private WebElement btn;

    // Constructor initializes PageFactory
    // To initialize the WebElement
    public Facebook(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getUn() {
        return un;
    }

    public WebElement getPwd() {
        return pwd;
    }
    
    public WebElement getBtn() {
        return btn;
    }

    public static void main(String[] args) throws InterruptedException {
    	
    	//To utilize the WebElement
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        Facebook fb = new Facebook(driver);
        fb.getUn().sendKeys("hitik");
        fb.getPwd().sendKeys("Rose");
        fb.getBtn().click();
        
        Thread.sleep(3000);
        driver.quit();
    }
}