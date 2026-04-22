package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class verifyOpporPage {

	public verifyOpporPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="dtlview_Opportunity Name")
	private WebElement verifyOpporName;
	
	public WebElement getOpporText() {
		return verifyOpporName;
	}
	
//	business utility
	public void verifyOppor() {
		verifyOpporName.getText();
	}
	
}
