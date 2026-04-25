package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.PageFactory;

public class orgPageTest {
	
	public orgPageTest(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Organizations")
	private WebElement OrgTab;

	@FindBy(css = "img[alt='Create Organization...']")
	private WebElement plus;
	
	@FindAll({
		@FindBy(css = "img[alt='Create Organization...']"),
		@FindBy(css = "img[src='themes/softed/images/btnL3Add.gif']")
	})
	
	@FindBys({
		@FindBy(css = "img[alt='Create Organization...']"),
		@FindBy(css = "img[alt='Create Organ']")
	})
	
	private WebElement plusAlt;
	
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
		plusAlt.click
	}

}
