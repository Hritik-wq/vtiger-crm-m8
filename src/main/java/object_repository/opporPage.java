package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class opporPage {
	
	public opporPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Opportunities")
	private WebElement OppTab;

	@FindBy(css = "img[alt='Create Opportunity...']")
	private WebElement plus;
	
	public WebElement opporClick() {
		return OppTab;
	}
	
	public WebElement plusOpporBtn() {
		return plus;
	}
	
//	business utility
	public void oppor() {
		OppTab.click();
		plus.click();
	}

}
