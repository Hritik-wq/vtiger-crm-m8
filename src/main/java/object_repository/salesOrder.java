package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class salesOrder {
	
	public salesOrder(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "More")
	private WebElement MoreInf;
	
	@FindBy(linkText = "Sales Order")
	private WebElement SalesOrderInf;

	@FindBy(css = "img[alt='Create Sales Order...']")
	private WebElement plus;
	
	public WebElement moreClick() {
		return MoreInf;
	}
	
	public WebElement salesOrderBtn() {
		return SalesOrderInf;
	}
	
	public WebElement plusSalesOrderBtn() {
		return plus;
	}
	
//	business utility
	public void sales() {
		MoreInf.click();
		SalesOrderInf.click();
		plus.click();
	}

}
