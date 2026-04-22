package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createProductsPage {

	public createProductsPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "productname")
	private WebElement ProdName;
	
	@FindBy(css="input[type='submit'][value='  Save  ']")
	private WebElement saveBtn;
	
	public WebElement getProdName() {
		return ProdName;
	}
	
	public WebElement saveBtn() {
		return saveBtn;
	}
	
//	business utility
	public void createProd(String prodName) {
		ProdName.sendKeys(prodName);
		saveBtn.click();
	}
	
}
