package generic_utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	WebDriver driver;
	Actions act;
	JavascriptExecutor jse;
	WebDriverWait wait;
	FluentWait<WebDriver> fluentWait;

	public WebDriverUtility(WebDriver driver) {
		act = new Actions(driver);
		jse = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		fluentWait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofMillis(500));
		// sel = new Sel(element);
		this.driver = driver;
	}
	
   //To Maximize Window
	public void maxWin() {
		driver.manage().window().maximize();
	}
	
	//To Minimize Window
	public void minWin() {
		driver.manage().window().minimize();
	}
	
	//To FullScreen Window
	public void FullScrn() {
		driver.manage().window().fullscreen();
	}
	
    //To get the Size of Window in form of int Width, int Height
	public void getSize() {
		Dimension ref = driver.manage().window().getSize();
		System.out.println(ref);
	}
	
	//To set the Size of Window in form of Dimension Target Size - int Width, int Height
	public void setSize() {
		driver.manage().window().setSize(new Dimension(0, 0));
	}
	
    //To get the Position of the Window Relative to the Upper Left Corner of the Screen
	public void getPosition() {
		Point ref = driver.manage().window().getPosition();
		System.out.println(ref);
	}
	
	//To set the position of Window in form of Point Target Position - int X, int Y
	public void setPosition() {
		driver.manage().window().setPosition(new Point(0, 0));
	}
	
	//Adds a Cookie
	public void getCookies() {
		driver.manage().getCookies();
	}
	
	//Add a Cookie whose Name is:
	public void getCookieNamed() {
		driver.manage().getCookieNamed("Name Of Cookie");
	}
	
	//Add a Cookie whose Name is:
	public void addCookies() {
		Cookie element = driver.manage().getCookieNamed("Name of Cookie Created");
		driver.manage().addCookie(element);
	}
	
	//Delete the Cookie Recently Created:
	public void deleteCookie() {
		driver.manage().deleteCookie(null);
	}
	
	//Delete the Cookie Named As:
	public void deleteCookieNamed() {
		driver.manage().deleteCookieNamed("Name Of Cookie");
	}
	
	//Delete All the Cookies
	public void deleteAllCookies() {
		driver.manage().deleteAllCookies();
	}
	
	//Navigate Back 1 Step
	public void NavigateBack() {
		driver.navigate().back();
	}
	
	//Navigate Forward 1 Step
	public void NavigateForward() {
		driver.navigate().forward();
	}
	
	//Refreshes the Page
	public void Refresh() {
		driver.navigate().refresh();
	}
	
	//Alternate way of opening Up Url
	public void toStringUrl() {
		driver.navigate().to("Url");
	}
	
	//Another Alternate way of opening Up Url
	public void toUrlUrl() {
		driver.navigate().to(new String("Url"));
	}
	
	//Opens up a Specified Url
	public void OpenUrl() throws InterruptedException {
		driver.get("Fully Qualified Path");
	}
	
	//Get Title of the Webpage
	public void getTitle() {
		String title = driver.getTitle();
		System.out.println(title);
	}
	
	//Get Current Url of the Webpage
	public void getCurrentUrl() {
		String url = driver.getCurrentUrl();
		System.out.println(url);
	}
	
	//Get PageSource of the Webpage
	public void getPageSource() {
		String source = driver.getPageSource();
		System.out.println(source);
	}
	
	//Closes the Page
	public void close() {
		driver.close();
	}
	
	//Quits the Page
	public void quit() {
		driver.quit();
	}
	
	//Implicit Wait
	public void waitForPageLoad() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	//Alert Is Present Check
	 public Alert waitForAlert() {
	        return wait.until(ExpectedConditions.alertIsPresent());
	    }
	 
	 public Boolean elementSelectionStateToBe(By locator) {
			return wait.until(ExpectedConditions.elementSelectionStateToBe(locator, false));
		}
	 
	 public WebElement waitUntilClickable(WebElement element) {
	        return wait.until(ExpectedConditions.elementToBeClickable(element));
	    }
	 
	 public Boolean elementToBeSelected(By locator) {
			return wait.until(ExpectedConditions.elementToBeSelected(locator));
		}
	 
	 public WebDriver frameToBeAvailableAndSwitchToIt(By locator) {
			return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
		}
	 
	 public Boolean invisibilityOfElementLocated(By locator) {
			return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		}
	 
	 public Boolean invisibilityOfElementWithText(By locator) {
			return wait.until(ExpectedConditions.invisibilityOfElementWithText(locator, null));
		}
	 
	 public List<WebElement> presenceOfAllElementsLocatedBy(By locator) {
			return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		}
	 
	 public WebElement presenceOfElementLocated(By locator) {
			return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		}
	 
	 public Boolean titleIs(String locator) {
			return wait.until(ExpectedConditions.titleIs(locator));
		}
	 
	 public Boolean titleContains(String locator) {
			return wait.until(ExpectedConditions.titleContains(locator));
		}
	 
	 public WebElement visibilityOfAllElements(WebElement[] locator) {
			return (WebElement) wait.until(ExpectedConditions.visibilityOfAllElements(locator));
		}
	 
	 public WebElement waitUntilVisibleBy(By locator) {
			return (WebElement) wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		}

	public WebElement waitUntilVisible(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	//Hover to Element
	public void hoverElement(WebElement element) {
		act.moveToElement(element).build().perform();
	}
	
	//Hover By Offset
	public void hoverByOffset(int x, int y) {
		act.moveByOffset(0, 0).build().perform();
	}
	
	//Hover to Element at x,y coordinates
	public void hoverToElementCoordinate(WebElement element, int x, int y) {
		act.moveToElement(element, 0, 0).build().perform();
	}
	
	//Performs Click
	public void click() {
		act.click().build().perform();
	}
	
	//Performs Click on Element
	public void clickElement(WebElement element) {
		act.click(element).build().perform();
	}
	
	//Performs Right-Click
	public void right() {
		act.contextClick().build().perform();
	}
	
	//Performs Right-Click on Element
	public void rightElement(WebElement element) {
		act.contextClick(element).build().perform();
	}
	
	//Performs Double-Clic
	public void DoubleClick() {
		act.doubleClick().build().perform();
	}
	
	//Performs Double-Click on Element
	public void DoubleClickElement(WebElement element) {
		act.doubleClick(element).build().perform();
	}
	
	//Click and Hold
	public void ClicknHold() {
		act.clickAndHold().build().perform();
	}
	
	//Click and Hold on Element
	public void ClicknHoldElement(WebElement element) {
		act.clickAndHold(element).build().perform();
	}
	
	//Release
	public void Release() {
		act.release().build().perform();
	}
	
	//Release an Element
	public void ReleaseElement(WebElement element) {
		act.release(element).build().perform();
	}
	
	//Drag And Drop from src to dest
	public void DragnDrop(WebElement source, WebElement destination) {
		act.dragAndDrop(source, destination).build().perform();
	}
	
	//Drag And Drop By src with x and y coordinates
	public void DragnDropBy(WebElement source, int x, int y) {
		act.dragAndDropBy(source, 0, 0).build().perform();
	}
	
	//Scroll to Element
	public void scrollToElement(WebElement element) {
		act.scrollToElement(element).build().perform();
	}
	
	//Scroll By Amount
	public void scrollByAmount(int x, int y) {
		act.scrollByAmount(0, 0).build().perform();
	}
	
	//Send Data from Keys Enum
	public void SendKeys() {
		act.sendKeys("Admin").build().perform();
	}
	
	//Press a Special Key
	public void keyDown() {
		act.keyDown(Keys.CONTROL).build().perform();
	}
	
	//Press a Special Key
	public void keyUp() {
		act.keyUp(Keys.TAB).build().perform();
	}
	
	//Takes Screen Shot of Webpage
	public void TakessofWebpage() throws IOException {
		WebDriver driver = new ChromeDriver();
		TakesScreenshot tks = (TakesScreenshot) driver;
		File src = tks.getScreenshotAs(OutputType.FILE);
		File dest = new File("Path to File");
		FileHandler.copy(src, dest);
	}
	
	//Takes Screen Shot of WebElement
	public void TakessofWebElement() throws IOException {
		WebElement element = driver.findElement(By.xpath(""));
		File src2 = element.getScreenshotAs(OutputType.FILE);
		File dest2 = new File("Path to File");
		FileHandler.copy(src2, dest2);
	}
	
	//Open Url through JS
	public void JseLocation() throws InterruptedException {

		jse.executeScript("window.location='Url';");

	}
	
	//Scroll Page through JS - Absolute Scroliing
	public void JseScrollTo(int x, int y) {
		jse.executeScript("window.scrollTo(0, 0)");

	}
	
	//Scroll Page through JS - Relative Scrolling
	public void JseScrollBy(int x, int y) {
		jse.executeScript("window.scrollBy(0, 0)");
	}
	
	//Scroll Page through JS into View of the Element
	public void JsescrollIntoView(WebElement element) {
		jse.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	//Get the Title of Webpage through JS
	public void JseDocument() {
		System.out.println(jse.executeScript("return document.title"));
	}
	
	//switchToWindowByTitle
	public void switchToWindowByTitle(String partialWindowTitle) {
		Set<String> windowHandles = driver.getWindowHandles();
		
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
			if (driver.getTitle().contains(partialWindowTitle)) {
				break;
			}
		}
	}
	
	//switchToWindowByUrl
	public void switchToWindowByUrl(String partialUrl) {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
			if (driver.getCurrentUrl().contains(partialUrl)) {
				break;
			}
		}
	}
	
	//switchToParentWindow
	public void switchToParentWindow(String parentWindowHandle) {
		driver.switchTo().window(parentWindowHandle);
	}
	
	//closeAllChildWindows
	public void closeAllChildWindows(String parentWindowHandle) {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			if (!handle.equals(parentWindowHandle)) {
				driver.switchTo().window(handle);
				driver.close();
			}

		}
		driver.switchTo().window(parentWindowHandle);
	}
	
	//selectByVisibleText - Dropdown
	public void selectByVisibleText(WebElement dropdown, String text) {
		Select sel = new Select(dropdown);
		sel.selectByVisibleText(text);
	}
	
	//selectByValue - Dropdown
	public void selectByValue(WebElement dropdown, String value) {
		Select sel = new Select(dropdown);
		sel.selectByValue(value);
	}
	
	//selectByIndex - Dropdown
	public void selectByIndex(WebElement dropdown, int index) {
		Select sel = new Select(dropdown);
		sel.selectByIndex(index);
	}
	
	//deselectByVisibleText - Dropdown
	public void deselectByVisibleText(WebElement dropdown, String text) {
		Select sel = new Select(dropdown);
		sel.deselectByVisibleText(text);
	}
	
	//deselectByValue - Dropdown
	public void deselectByValue(WebElement dropdown, String value) {
		Select sel = new Select(dropdown);
		sel.deselectByValue(value);
	}
	
	//deselectByIndex - Dropdown
	public void deselectByIndex(WebElement dropdown, int index) {
		Select sel = new Select(dropdown);
		sel.deselectByIndex(index);
	}
	
	//deselectAll - Dropdown
	public void deselectAll(WebElement dropdown) {
		Select sel = new Select(dropdown);
		sel.deselectAll();
	}
	
	//isMultiple - To Check if the Dropdown is Single or Multiple Select
	public boolean isMultiple(WebElement dropdown) {
		Select sel = new Select(dropdown);
		return sel.isMultiple();
	}
	
	//getFirstSelectedOption - Dropdown
	public WebElement getFirstSelectedOption(WebElement dropdown) {
		Select sel = new Select(dropdown);
		return sel.getFirstSelectedOption();
	}
	
	//To Click An Element in JS
	public void jsClick(WebElement element) {
		jse.executeScript("arguments[0].click();", element);
	}
	
	//To SendValue in An Element in JS
	public void jsValue(WebElement element) {
		jse.executeScript("arguments[0].value='Value to be Passed';", element);
	}
	
	//To Scroll to Top of a page in JS
	public void jsScrollTop() {
		jse.executeScript("window.scrollTo(0, 0);");
	}
	
	//To Scroll to Bottom of a page in JS
	public void jsScrollBottom() {
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}
	
	//Getters Method
	public WebElement getCssValue(String string) {
		WebElement element = getCssValue(string);
		System.out.println(element);
		return element;
	}
	
	//Getters Method
	public WebElement getTagName(String string) {
		WebElement element = getTagName(string);
		System.out.println(element);
		return element;
	}
	
	//Getters Method
	public WebElement getAttributeName(String string) {
		WebElement element = getAttributeName(string);
		System.out.println(element);
		return element;
	}
	
	//Getters Method
	public WebElement getText(String string) {
		WebElement element = getText(string);
		System.out.println(element);
		return element;
	}
	
	// Validation/Verification
	public boolean isDisplayed(WebElement element) {
		boolean displayed = element.isDisplayed();
		System.out.println("Is displayed: " + displayed);
		return displayed;
	}
	
	// Validation/Verification
	public boolean isEnabled(WebElement element) {
		boolean displayed = element.isEnabled();
		System.out.println("Is Enabled: " + displayed);
		return displayed;
	}
	
	// Validation/Verification
	public boolean isSelected(WebElement element) {
		boolean displayed = element.isSelected();
		System.out.println("Is Selected: " + displayed);
		return displayed;
	}
}
