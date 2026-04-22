package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class orgPage {
	
	public orgPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "//img[alt='Create Organization...']")
	private WebElement plus;
	
	public WebElement plusOrgBtn() {
		return plus;
	}
	
//	business utility
	public void org() {
		plus.click();
	}

}
