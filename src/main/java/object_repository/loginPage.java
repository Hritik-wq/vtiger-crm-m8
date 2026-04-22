package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	public loginPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "user_name")
	private WebElement un;
	
	@FindBy(name = "user_password")
	private WebElement pwd;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	public WebElement getUn() {
		return un;
	}
	
	public WebElement getPwd() {
		return pwd;
	}
	
	public WebElement loginBtn() {
		return loginBtn;
	}
	
//	business utility
	public void login(String username, String password) {
		un.sendKeys(username);
		pwd.sendKeys(password);
		loginBtn.click();
	}
	
}
