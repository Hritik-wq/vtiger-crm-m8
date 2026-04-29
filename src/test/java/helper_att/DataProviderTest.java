package helper_att;

import java.time.Duration;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DataProviderTest {
@Test(dataProvider = "getData")
public void sdLogin(String user_name, String password) throws InterruptedException {

    WebDriver driver = new ChromeDriver();
    driver.get("https://www.saucedemo.com/");

    new Actions(driver)
        .pause(Duration.ofSeconds(1))
        .sendKeys(user_name + Keys.TAB + password + Keys.ENTER)
        .build()
        .perform();

    Thread.sleep(1000);
    driver.quit();
}

@DataProvider
public Object[][] getData() {
    String[][] cred = new String[6][2];

    cred[0][0] = "standard_user";            cred[0][1] = "secret_sauce";
    cred[1][0] = "locked_out_user";          cred[1][1] = "secret_sauce";
    cred[2][0] = "problem_user";             cred[2][1] = "secret_sauce";
    cred[3][0] = "performance_glitch_user";  cred[3][1] = "secret_sauce";
    cred[4][0] = "error_user";               cred[4][1] = "secret_sauce";
    cred[5][0] = "visual_user";              cred[5][1] = "secret_sauce";

    return cred;
}
}