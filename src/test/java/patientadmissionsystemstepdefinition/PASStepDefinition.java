package patientadmissionsystemstepdefinition;

import io.cucumber.java.en.Given;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import patientmanagementsystempageobject.PatientManagementSystemPojoClass;
import utilitypackage.Baseclass;

public class PASStepDefinition extends Baseclass{

	PatientManagementSystemPojoClass Patient;
	
	@Given("the user opens the browser")
	public void openBrowser() {
		
		setUp();
		 Patient = new PatientManagementSystemPojoClass(driver);
	}

	@When("the users navigate to the login page")
	public void launchUrl() {
		
		Patient.openUrl("https://opensource-demo.orangehrmlive.com/");
	}

	@When("the user type the username {string}")
	public void the_user_type_the_username(String string) throws InterruptedException {
		Patient.getUsername("username");
	}

	@When("the user type the password {string}")
	public void the_user_type_the_password(String string) {
	  Patient.getPassword("password");
	}

	@When("user clicks on login button")
	public void users_clicks_on_login_button() {
	   Patient.getLoginbtn();
	}

	@Then("the user should navigate to the Dashboard page")
	public void the_users_should_navigate_to_the_Dashboard_page() {
	    System.out.println("login successfull");
	    
	    driver.quit();
	}
	
	
	///Scenario for invalid login
	@Given("the user opens the browser")
	public void openBrowser2() {
		
		setUp();
		 Patient = new PatientManagementSystemPojoClass(driver);
	}

	@When("the user navigate to the login page")
	public void openUrl() {
		Patient.openUrl("https://opensource-demo.orangehrmlive.com/");
	}

	@When("the user enters the username {string}")
	public void enterUsername(String string) throws InterruptedException {
		Patient.getUsername("username");
	}

	@When("the user enters the password {string}")
	public void enterPassword(String string) {
	  Patient.getPassword("password");
	}

	@When("user clicks on login button")
	public void clickLogin() {
	   Patient.getLoginbtn();
	}

	@Then("the users should see error message")
	public void errorMeassage() {
	    System.out.println("login successfull");
	    
	    driver.quit();
	}
}

