package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createOpporPage {

	public createOpporPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "potentialname")
	private WebElement OpporName;
	
	@FindBy(css="img[alt='Select']")
	private WebElement RelatedTo;
	
	@FindBy(linkText="vtiger")
	private WebElement selectRelated;
	
	@FindBy(css="input[type='submit'][value='  Save  ']")
	private WebElement saveBtn;
	
	public WebElement getOpporName() {
		return OpporName;
	}
	
	public WebElement relatedTo() {
		return RelatedTo;
	}
	
	public WebElement selectRelatedTo() {
		return selectRelated;
	}
	
	public WebElement saveBtn() {
		return saveBtn;
	}
	
//	business utility
	public void createOppor(String opporName) {
		OpporName.sendKeys(opporName);
		RelatedTo.click();
		selectRelated.click();
		saveBtn.click();
	}
	
}
