package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class verifyOrgPage {

	public verifyOrgPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="dtlview_Organization Name")
	private WebElement verifyOrgName;
	
	public WebElement getOrgText() {
		return verifyOrgName;
	}
	
//	business utility
	public void verifyOrg() {
		verifyOrgName.getText();
	}
	
}
