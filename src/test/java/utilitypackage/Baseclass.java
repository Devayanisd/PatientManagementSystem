package utilitypackage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	
	
	public static WebDriver driver;
	public static Actions act;
	public static Robot r;
	public static Select s;
	public static JavascriptExecutor js;
	public static TakesScreenshot ts;


	public void setUp() {
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void passUrl(String URL) {
		driver.get(URL);
	}

	public void mousehover(WebElement ele, String val) {
		
		act = new Actions(driver);
		act.moveToElement(ele).perform();

	}

	public void clickElement(WebElement ele) {
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(ele)).click();
		ele.click();

	}

	public void passValues(WebElement ele, String val) {
		ele.clear();
		ele.sendKeys(val);

	}

	public void runThread(int waitTime) throws InterruptedException {
		Thread.sleep(waitTime);
	}

	public void elementDoubleClick(WebElement ele) {
		
		act.doubleClick(ele).perform();
	}

	public void elementContextClick(WebElement ele) {
		act.contextClick(ele).perform();
	}

	public void robotclass() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		// For enter value
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	public void selectByVisibleText( String Visibletext, WebElement dropdownelement) {
		s = new Select(dropdownelement);
		s.deselectByVisibleText(Visibletext);
	}

	public void selectByValue(String value) {
		s.selectByValue(value);
	}

	public void selectByIndex(WebElement dropdownelement, int index) {
		s.selectByIndex(index);

	}

	public void deSelectByVisibleText(WebElement dropdownelement, String Visibletext) {
		s = new Select(dropdownelement);
		s.deselectByVisibleText(Visibletext);
	}

	public void deSelectByValue(WebElement dropdownelement, String value) {
		s.deselectByValue(value);
	}

	public void deSelectByIndex(WebElement dropdownelement, int index) {
		s.deselectByIndex(index);

	}

	public void deselectAllElement(WebElement dropdownelement) {
		s.deselectAll();
	}

	public void scrollupPage(WebElement ele) {
		js = (JavascriptExecutor) driver;
		js.executeScript("aruguments[0].scrollIntoView(true);", ele);
	}

	public void scrollDown(WebElement ele) {
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
	}

	public static void switchToWindow() {
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for (String windowHandle : allWindows) {
			if (!windowHandle.equals(parentWindow)) {
				driver.switchTo().window(windowHandle);
			}
		}
	}

	public void getTextFromE(WebElement ele) {
		ele.getText();

	}

	public void getAttributeFromElement(WebElement ele, String attributeName) {
		ele.getAttribute(attributeName);

	}

	public void takesScreenshot(String filepath) throws IOException {
		ts = (TakesScreenshot) driver;
		File sre = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(filepath);
		FileUtils.copyFile(sre, dest);

	}

}
