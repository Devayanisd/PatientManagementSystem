package Listcollection;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ListExample {
      static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://omayo.blogspot.com/");
		
	List<WebElement> TableData = driver.findElements(By.xpath("//table[@id=\"table1\"]//tr//td|//table[@id=\"table1\"]//th"));
	
	for(WebElement e : TableData) {
		System.out.println(e.getText());
	}
	
	}

}
