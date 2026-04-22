package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class opporPage {
	
	public opporPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "//img[alt='Create Opportunity...']")
	private WebElement plus;
	
	public WebElement plusOpporBtn() {
		return plus;
	}
	
//	business utility
	public void oppor() {
		plus.click();
	}

}
