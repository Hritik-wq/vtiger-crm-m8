package helper_att;

import org.testng.annotations.Test;
import org.junit.Assert;
import org.testng.Reporter;

public class sampleDependson {

    @Test
    public void createCity() {
        Reporter.log("created Noida", true);
    }

    @Test(dependsOnMethods = "createCity")
    public void modifyCity() {
    	// To Check if Skips
    	Assert.assertTrue(false);
        Reporter.log("Noida=>SmartNoida", true);
    }

    @Test(dependsOnMethods = "modifyCity", alwaysRun = true)
    public void deleteCity() {
        Reporter.log("SmartNoida deleted", true);
    }
    
//    @Test()
//    public void deleteCity() {
//        Reporter.log("Noida=>SmartNoida", true);
//        Reporter.log("SmartNoida deleted", true);
//    }
    
}