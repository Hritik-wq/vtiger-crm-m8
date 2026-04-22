package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createSalesOrderPage {

	public createSalesOrderPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "subject")
	private WebElement SalesName;
	
	@FindBy(css="img[alt='Select']")
	private WebElement selectOrgz;
	
	@FindBy(linkText="vtiger")
	private WebElement clickorgzName;
	
	@FindBy(id="searchIcon1")
	private WebElement itemName;
	
	@FindBy(linkText="Vtiger 25 Users Pack")
	private WebElement prodName;
	
	@FindBy(id="qty1")
	private WebElement qty;
	
	@FindBy(css="input[type='submit'][value='  Save  ']")
	private WebElement saveBtn;
	
	public WebElement getSalesName() {
		return SalesName;
	}
	
	public WebElement selectOrgzName() {
		return selectOrgz;
	}
	
	public WebElement clickOrgzName() {
		return clickorgzName;
	}
	
	public WebElement saveBtn() {
		return saveBtn;
	}
	
	
	
//	business utility
	public void createSales(String salesName, String qtyNum) {
		SalesName.sendKeys(salesName);
		selectOrgz.click();
		clickorgzName.click();
		itemName.click();
		prodName.click();
		qty.sendKeys(qtyNum);
		saveBtn.click();
		
	}
	
}
