package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class verifySalesOrder {

	public verifySalesOrder(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="dtlview_Subject")
	private WebElement verifySalesName;
	
	public WebElement getSalesText() {
		return verifySalesName;
	}
	
//	business utility
	public void verifySales() {
		verifySalesName.getText();
	}
	
}
