package learning_annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class OrgTest {
	
	@BeforeClass
	public void setUp() {
		System.out.println("Opening Browser");
		
	}
		
		@BeforeMethod
		public void login() {
			System.out.println("Login");
		}
		
		@Test
		public void createOrgTest() {
			System.out.println("Create Org");
			System.out.println("Verify Org");
	}
		
		@AfterMethod
		public void logout() {
			System.out.println("Logout");
		}
		
		@AfterClass
		
		public void closeBro() {
			System.out.println("Closing Browser");
		}
		
		

}
