package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class orgPage {
	
	public orgPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Organizations")
	private WebElement OrgTab;

	@FindBy(css = "img[alt='Create Organization...']")
	private WebElement plus;
	
	public WebElement orgClick() {
		return OrgTab;
	}
	
	public WebElement plusOrgBtn() {
		return plus;
	}
	
//	business utility
	public void org() {
		OrgTab.click();
		plus.click();
	}

}
