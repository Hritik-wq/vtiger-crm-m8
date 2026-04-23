package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage {
	public homePage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Opportunities")
	private WebElement OpporTab;
	
	@FindBy(css = "img[src='themes/softed/images/user.PNG']")
	private WebElement ProfileIntf;
	
	@FindBy(linkText="Sign Out")
	private WebElement logoutBtn;
	
	public WebElement ClickOpportunities() {
		return OpporTab;
	}
	
	public WebElement ClickProfile() {
		return ProfileIntf;
	}
	
	public WebElement logoutBtn() {
		return logoutBtn;
	}
	
//	business utility
	public void home() {
		OpporTab.click();
		ProfileIntf.click();
		logoutBtn.click();
	}
	
}
