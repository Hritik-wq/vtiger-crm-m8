package helper_att;

import org.testng.annotations.Test;
import org.testng.Reporter;

public class samplePriority {

    @Test(priority = -1)
    public void createCity() {
        Reporter.log("created Noida", true);
    }

    @Test(priority = 0)
    public void modifyCity() {
        Reporter.log("Noida=>SmartNoida", true);
    }

    @Test(priority = 1)
    public void deleteCity() {
        Reporter.log("SmartNoida deleted", true);
    }
}