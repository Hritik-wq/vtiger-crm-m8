package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class verifyProducts {

	public verifyProducts(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="dtlview_Product Name")
	private WebElement verifyProdName;
	
	public WebElement getProdText() {
		return verifyProdName;
	}
	
//	business utility
	public void verifyProd() {
		verifyProdName.getText();
	}
	
}
