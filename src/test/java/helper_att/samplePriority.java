package helper_att;

import org.testng.annotations.Test;
import org.junit.Assert;
import org.testng.Reporter;

public class samplePriority {

    @Test(priority = -1)
    public void createCity() {
    	Assert.assertTrue(true);
        Reporter.log("created Noida", true);
    }

    @Test(priority = 0)
    public void modifyCity() {
    	Assert.assertTrue(false);
        Reporter.log("Noida=>SmartNoida", true);
    }

    @Test(priority = 1)
    public void deleteCity() {
    	Assert.assertTrue(true);
        Reporter.log("SmartNoida deleted", true);
    }
}