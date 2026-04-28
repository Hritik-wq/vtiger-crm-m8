package helper_att;

import org.testng.annotations.Test;
import org.testng.Reporter;

public class sampleDependson {

    @Test
    public void createCity() {
        Reporter.log("created Noida", true);
    }

    @Test(dependsOnMethods = "createCity")
    public void modifyCity() {
        Reporter.log("Noida=>SmartNoida", true);
    }

    @Test(dependsOnMethods = "modifyCity", alwaysRun = true)
    public void deleteCity() {
        Reporter.log("SmartNoida deleted", true);
    }
}