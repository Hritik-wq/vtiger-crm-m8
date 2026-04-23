package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createOrgPage {

	public createOrgPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "accountname")
	private WebElement OrgName;
	
	@FindBy(css="input[type='button'][value='  Save  ']")
	private WebElement saveBtn;
	
	public WebElement getOrgName() {
		return OrgName;
	}
	
	public WebElement saveBtn() {
		return saveBtn;
	}
	
//	business utility
	public void createOrg(String orgName) {
		OrgName.sendKeys(orgName);
		saveBtn.click();
	}
	
}
