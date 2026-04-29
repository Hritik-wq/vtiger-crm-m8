package helper_att;

import java.time.Duration;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LearningDataProvider {

	@Test(dataProvider = "getData")
	public void fbLogin(String username, String password) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.facebook.com/");

		new Actions(driver)
		.pause(Duration.ofSeconds(1))
		.sendKeys(username + Keys.TAB + password + Keys.ENTER)
		.build()
		.perform();

		Thread.sleep(1000);
		driver.quit();
	}

	@DataProvider
	public Object[][] getData() {
		String[][] cred = new String[15][2];
		
		// Anime Name as 'username', Placeholder as 'password'
	    cred[0][0] = "Naruto";              cred[0][1] = "Pass_Naruto1";
	    cred[1][0] = "One Piece";           cred[1][1] = "Pass_Luffy2";
	    cred[2][0] = "Dragon Ball Z";       cred[2][1] = "Pass_Goku3";
	    cred[3][0] = "Death Note";          cred[3][1] = "Pass_Kira4";
	    cred[4][0] = "Fullmetal Alchemist"; cred[4][1] = "Pass_Ed5";
	    cred[5][0] = "Attack on Titan";     cred[5][1] = "Pass_Eren6";
	    cred[6][0] = "Hunter x Hunter";     cred[6][1] = "Pass_Gon7";
	    cred[7][0] = "Cowboy Bebop";        cred[7][1] = "Pass_Spike8";
	    cred[8][0] = "Bleach";              cred[8][1] = "Pass_Ichigo9";
	    cred[9][0] = "Demon Slayer";        cred[9][1] = "Pass_Tanjiro10";
	    cred[10][0] = "Jujutsu Kaisen";     cred[10][1] = "Pass_Yuji11";
	    cred[11][0] = "My Hero Academia";   cred[11][1] = "Pass_Deku12";
	    cred[12][0] = "Steins Gate";        cred[12][1] = "Pass_Okabe13";
	    cred[13][0] = "Code Geass";         cred[13][1] = "Pass_Lelouch14";
	    cred[14][0] = "One Punch Man";      cred[14][1] = "Pass_Saitama15";
	    
	    return cred;
	}

}
