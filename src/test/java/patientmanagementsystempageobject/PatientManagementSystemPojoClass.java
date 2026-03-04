package patientmanagementsystempageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilitypackage.Baseclass;

public class PatientManagementSystemPojoClass {
	
	WebDriver driver;
	 
	public PatientManagementSystemPojoClass(WebDriver driver) {
		this.driver = driver;
		 PageFactory.initElements(driver, this);
	}
	// user name
	
	@FindBy(xpath="//input[@name=\"username\"]")
	private WebElement username;
	
	// password
	@FindBy(xpath="//input[@placeholder=\"Password\"]")
	private WebElement password;
	
	@FindBy(xpath="//button[text()=\" Login \"]")
	private WebElement loginbtn;

	
	public void openUrl(String url) {
		driver.get(url);
	}

	public void getUsername(String name) {
		 username.clear();
		 username.sendKeys("Admin");
	}

	public void  getPassword(String pass) {
		 password.clear();
		 password.sendKeys("admin123");
	}

	public void getLoginbtn() {
		 loginbtn.click();;
	}
	
	}

