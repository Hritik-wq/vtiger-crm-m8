package crm.vtiger.organization;

import java.io.IOException;
import org.testng.annotations.Test;

import base_utility.BaseClass;
import generic_utility.FileUtility;
import junit.framework.Assert;
import object_repository.createOrgPage;
import object_repository.orgPage;
import object_repository.verifyOrgPage;

public class CreateOrgTestBaseC extends BaseClass{
	
	@Test
	public void createOrgBaseTest() throws InterruptedException, IOException {
		
//		Get data from properties file

//		opening browser		
		
//		login
		
//Click Organization
		
		orgPage orG = new orgPage(driver);
		orG.org();
		
		//create organization
		createOrgPage cOP = new createOrgPage(driver);
		FileUtility fUtil = new FileUtility();
		String orgName = fUtil.getDatafromExcelFile("testdata", 1, 1);
		cOP.getOrgName().sendKeys(orgName);
		cOP.saveBtn().click();
		
		// verify opportunity
		verifyOrgPage vOP = new verifyOrgPage(driver);
		String actOppName = vOP.getOrgText().getText();
		
		Assert.assertEquals(actOppName, orgName);
		
//		logout

//		browser close
		
	}
}
