package helper_att;

import org.testng.annotations.Test;
import org.testng.Reporter;

public class sampleTest {

    @Test(invocationCount = 5)
    public void case1() {
        Reporter.log("sample1");
    }

    @Test(invocationCount = 2)
    public void case2() {
        Reporter.log("sample2");
    }
    
    // No run in Default Suite but goes in Default Test if IC = 0
    @Test(invocationCount = 0)
    public void case3() {
        Reporter.log("sample3");
    }
    
    //Ignore neither in Default Test or Default Suite
    @Test(enabled = false)
    public void case4() {
        Reporter.log("sample4");
    }
}