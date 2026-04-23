package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class productsPage {
	
	public productsPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Products")
	private WebElement ProdTab;

	@FindBy(css = "img[alt='Create Product...']")
	private WebElement plus;
	
	public WebElement clickproducts() {
		return ProdTab;
	}
	
	public WebElement plusProductsBtn() {
		return plus;
	}
	
//	business utility
	public void product() {
		ProdTab.click();
		plus.click();
	}

}
