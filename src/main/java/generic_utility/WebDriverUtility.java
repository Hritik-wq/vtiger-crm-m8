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

	public void maxWin() {
		driver.manage().window().maximize();
	}

	public void minWin() {
		driver.manage().window().minimize();
	}

	public void FullScrn() {
		driver.manage().window().fullscreen();
	}

	public void getSize() {
		Dimension ref = driver.manage().window().getSize();
		System.out.println(ref);
	}

	public void setSize() {
		driver.manage().window().setSize(new Dimension(0, 0));
	}

	public void getPosition() {
		Point ref = driver.manage().window().getPosition();
		System.out.println(ref);
	}

	public void setPosition() {
		driver.manage().window().setPosition(new Point(0, 0));
	}

	public void getCookies() {
		driver.manage().getCookies();
	}

	public void getCookieNamed() {
		driver.manage().getCookieNamed("Name Of Cookie");
	}

	public void addCookies() {
		Cookie element = driver.manage().getCookieNamed("Name of Cookie Created");
		driver.manage().addCookie(element);
	}

	public void deleteCookie() {
		driver.manage().deleteCookie(null);
	}

	public void deleteCookieNamed() {
		driver.manage().deleteCookieNamed("Name Of Cookie");
	}

	public void deleteAllCookies() {
		driver.manage().deleteAllCookies();
	}

	public void NavigateBack() {
		driver.navigate().back();
	}

	public void NavigateForward() {
		driver.navigate().forward();
	}

	public void Refresh() {
		driver.navigate().refresh();
	}

	public void toStringUrl() {
		driver.navigate().to("Url");
	}

	public void toUrlUrl() {
		driver.navigate().to(new String("Url"));
	}

	public void OpenUrl() throws InterruptedException {
		driver.get("Fully Qualified Path");
	}

	public void getTitle() {
		String title = driver.getTitle();
		System.out.println(title);
	}

	public void getCurrentUrl() {
		String url = driver.getCurrentUrl();
		System.out.println(url);
	}

	public void getPageSource() {
		String source = driver.getPageSource();
		System.out.println(source);
	}

	public void close() {
		driver.close();
	}

	public void quit() {
		driver.quit();
	}

	public void waitForPageLoad() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
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
	
	

	public void hoverElement(WebElement element) {
		act.moveToElement(element).build().perform();
	}

	public void hoverByOffset(int x, int y) {
		act.moveByOffset(0, 0).build().perform();
	}

	public void hoverToElementCoordinate(WebElement element, int x, int y) {
		act.moveToElement(element, 0, 0).build().perform();
	}

	public void click() {
		act.click().build().perform();
	}

	public void clickElement(WebElement element) {
		act.click(element).build().perform();
	}

	public void right() {
		act.contextClick().build().perform();
	}

	public void rightElement(WebElement element) {
		act.contextClick(element).build().perform();
	}

	public void DoubleClick() {
		act.doubleClick().build().perform();
	}

	public void DoubleClickElement(WebElement element) {
		act.doubleClick(element).build().perform();
	}

	public void ClicknHold() {
		act.clickAndHold().build().perform();
	}

	public void ClicknHoldElement(WebElement element) {
		act.clickAndHold(element).build().perform();
	}

	public void Release() {
		act.release().build().perform();
	}

	public void ReleaseElement(WebElement element) {
		act.release(element).build().perform();
	}

	public void DragnDrop(WebElement source, WebElement destination) {
		act.dragAndDrop(source, destination).build().perform();
	}

	public void DragnDropBy(WebElement source, int x, int y) {
		act.dragAndDropBy(source, 0, 0).build().perform();
	}

	public void Scrolling(WebElement element) {
		act.scrollToElement(element).build().perform();
	}

	public void Scrolling2(int x, int y) {
		act.scrollByAmount(0, 0).build().perform();
	}

	public void SendKeys() {
		act.sendKeys("Admin").build().perform();
	}

	public void keyDown() {
		act.keyDown(Keys.CONTROL).build().perform();
	}

	public void keyUp() {
		act.keyUp(Keys.TAB).build().perform();
	}

	public void TakessofWebpage() throws IOException {
		WebDriver driver = new ChromeDriver();
		TakesScreenshot tks = (TakesScreenshot) driver;
		File src = tks.getScreenshotAs(OutputType.FILE);
		File dest = new File("Path to File");
		FileHandler.copy(src, dest);
	}

	public void TakessofWebElement() throws IOException {
		WebElement element = driver.findElement(By.xpath(""));
		File src2 = element.getScreenshotAs(OutputType.FILE);
		File dest2 = new File("Path to File");
		FileHandler.copy(src2, dest2);
	}

	public void JseLocation() throws InterruptedException {

		jse.executeScript("window.location='Url';");

	}

	public void JseScrollTo(int x, int y) {
		jse.executeScript("window.scrollTo(0, 0)");

	}

	public void JseScrollBy(int x, int y) {
		jse.executeScript("window.scrollBy(0, 0)");
	}
	
	public void JsescrollIntoView(WebElement element) {
		jse.executeScript("arguments[0].scrollIntoView();", element);
	}

	public void JseDocument() {
		System.out.println(jse.executeScript("return document.title"));
	}
	
	public void switchToWindowByTitle(String partialWindowTitle) {
		Set<String> windowHandles = driver.getWindowHandles();
		
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
			if (driver.getTitle().contains(partialWindowTitle)) {
				break;
			}
		}
	}

	public void switchToWindowByUrl(String partialUrl) {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
			if (driver.getCurrentUrl().contains(partialUrl)) {
				break;
			}
		}
	}

	public void switchToParentWindow(String parentWindowHandle) {
		driver.switchTo().window(parentWindowHandle);
	}

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

	public void selectByVisibleText(WebElement dropdown, String text) {
		Select sel = new Select(dropdown);
		sel.selectByVisibleText(text);
	}

	public void selectByValue(WebElement dropdown, String value) {
		Select sel = new Select(dropdown);
		sel.selectByValue(value);
	}

	public void selectByIndex(WebElement dropdown, int index) {
		Select sel = new Select(dropdown);
		sel.selectByIndex(index);
	}

	public void deselectByVisibleText(WebElement dropdown, String text) {
		Select sel = new Select(dropdown);
		sel.deselectByVisibleText(text);
	}

	public void deselectByValue(WebElement dropdown, String value) {
		Select sel = new Select(dropdown);
		sel.deselectByValue(value);
	}

	public void deselectByIndex(WebElement dropdown, int index) {
		Select sel = new Select(dropdown);
		sel.deselectByIndex(index);
	}

	public void deselectAll(WebElement dropdown) {
		Select sel = new Select(dropdown);
		sel.deselectAll();
	}

	public boolean isMultiple(WebElement dropdown) {
		Select sel = new Select(dropdown);
		return sel.isMultiple();
	}

	public WebElement getFirstSelectedOption(WebElement dropdown) {
		Select sel = new Select(dropdown);
		return sel.getFirstSelectedOption();
	}

	public void jsClick(WebElement element) {
		jse.executeScript("arguments[0].click();", element);
	}

	public void jsValue(WebElement element) {
		jse.executeScript("arguments[0].value='Value to be Passed';", element);
	}
	
	public void jsScrollTop() {
		jse.executeScript("window.scrollTo(0, 0);");
	}
	
	public void jsScrollBottom() {
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}

	public WebElement getCssValue(String string) {
		WebElement element = getCssValue(string);
		System.out.println(element);
		return element;
	}

	public WebElement getTagName(String string) {
		WebElement element = getTagName(string);
		System.out.println(element);
		return element;
	}

	public WebElement getAttributeName(String string) {
		WebElement element = getAttributeName(string);
		System.out.println(element);
		return element;
	}

	public WebElement getText(String string) {
		WebElement element = getText(string);
		System.out.println(element);
		return element;
	}

	public boolean isDisplayed(WebElement element) {
		boolean displayed = element.isDisplayed();
		System.out.println("Is displayed: " + displayed);
		return displayed;
	}
	
	public boolean isEnabled(WebElement element) {
		boolean displayed = element.isEnabled();
		System.out.println("Is Enabled: " + displayed);
		return displayed;
	}
	
	public boolean isSelected(WebElement element) {
		boolean displayed = element.isSelected();
		System.out.println("Is Selected: " + displayed);
		return displayed;
	}
}
