package com.stepDefinition;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.cirqueBaseClass.BaseClass;

import com.pomManager.PomManager;
import com.runner.TestRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends BaseClass {
	public static String last = null;
	public static String first = null;
	public static String patientLast = null;
	public static WebDriver driver = TestRunner.driver;

	static PomManager pom = new PomManager(driver);

	@Given("User launch the URL {string}")
	public void user_launch_the_url(String string) {	
		getURL(string);
		implicitlyWait(100);

	}

	@When("Verify the User has been navigated to Application login page")
	public void verify_the_user_has_been_navigated_to_application_login_page() {

		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://cirque.sgssys.info/login";
		assertEquals(actualUrl, expectedUrl);

		if (actualUrl.equals("https://cirque.sgssys.info/login")) {
			System.out.println("User was navigated to Login Page");

		} else {
			System.err.println("Application Url is not working");
		}

	}

	@When("User enter the Username name into Username field")
	public void user_enter_the_username_name_into_username_field() throws InterruptedException {
		click_on_the_login_button();
		Thread.sleep(3000);
		String currentURL = getCurrentURL();
		assertEquals("https://cirque.sgssys.info/login", currentURL);
		String emailFieldValidation = getText(pom.getLogin().getEmailValidation());
		String passFieldValidation = getText(pom.getLogin().getPasswordValidation());
		if (emailFieldValidation.equals("Email is required")) {
			System.out.println("Email Validation message has been displayed");
			if (passFieldValidation.equals("Password is required")) {
				System.out.println("Email Validation message has been displayed");
			} else {
				System.err.println("Password validation is not displayed");
			}

		} else {
			System.err.println("Email field validation is not displayed");
		}

		sendKeys(pom.getLogin().getUsername(), "superadmin@cirque.com");
		Thread.sleep(3000);
		click_on_the_login_button();
		assertEquals("https://cirque.sgssys.info/login", getCurrentURL());

	}

	@When("Enter Invalid Username and Valid Password")
	public void enter_invalid_username_and_valid_password() throws InterruptedException, AWTException {
		navigateRefresh();
		click_on_the_login_button();
		Thread.sleep(2000);
		String currentURL = getCurrentURL();

		if (currentURL.equals("https://cirque.sgssys.info/login")) {
			sendKeys(pom.getLogin().getUsername(), "superadmin@@cirque.com");
			sendKeys(pom.getLogin().getPassword(), "Admin@123");
			Thread.sleep(1000);
			robot("enter");
			Thread.sleep(5000);
			String emailFieldValidation = getText(pom.getLogin().getEmailValidation());
			if (emailFieldValidation.equals("Please enter a valid Email")) {
				clear(pom.getLogin().getUsername());
				clear(pom.getLogin().getPassword());
				Thread.sleep(3000);
				sendKeys(pom.getLogin().getUsername(), "54superadmin@cirque.com");
				sendKeys(pom.getLogin().getPassword(), "Admin@123");
				robot("enter");
				Thread.sleep(1000);
				String text = getText(pom.getLogin().getPageLevelValiidation());
				if (text.equals("Email / Password is invalid")) {
					clear(pom.getLogin().getUsername());
					clear(pom.getLogin().getPassword());
					Thread.sleep(3000);
					sendKeys(pom.getLogin().getUsername(), "superadmin@cirque.com");
					System.out.println("Login Page Level validation is displayed");
				}
			}
		}
	}

	@When("Enter Valid Username and Invalid Password")
	public void enter_valid_username_and_invalid_password() throws InterruptedException, AWTException {
		navigateRefresh();
		click_on_the_login_button();
		Thread.sleep(2000);
		String currentURL = getCurrentURL();

		if (currentURL.equals("https://cirque.sgssys.info/login")) {
			sendKeys(pom.getLogin().getUsername(), "superadmin@cirque.com");
			sendKeys(pom.getLogin().getPassword(), "Admin@123et");
			Thread.sleep(1000);
			click_on_the_login_button();
			Thread.sleep(5000);
			String text = getText(pom.getLogin().getPageLevelValiidation());
			if (text.equals("Email / Password is invalid")) {
				clear(pom.getLogin().getUsername());
				clear(pom.getLogin().getPassword());
				Thread.sleep(3000);
				sendKeys(pom.getLogin().getUsername(), "54super@admincirque.com");
				sendKeys(pom.getLogin().getPassword(), "admin@12354");
				System.out.println("Verified the Password field");
				Thread.sleep(2000);
			}
		}

		clear(pom.getLogin().getUsername());
		clear(pom.getLogin().getPassword());
		Thread.sleep(2000);
		sendKeys(pom.getLogin().getUsername(), "superadmin@" + "cirque.com");
		sendKeys(pom.getLogin().getPassword(), "Admin@123");

	}

	@When("Click on the login Button")
	public void click_on_the_login_button() {
		click(pom.getLogin().getSignIn());
	}

	@Then("Employer navigated to Employer Dashboard page")
	public void employer_navigated_to_employer_dashboard_page() throws InterruptedException, IOException {
		getTitle();
		Thread.sleep(2000);
		String currentURL = getCurrentURL();
		if (currentURL.equals("https://cirque.sgssys.info/dashboard")) {
			System.out.println("User Landed on the Dashboard Page");
			Thread.sleep(2000);
			takesScreenshot("dashboard");
			Thread.sleep(2000);
			click(pom.getAccountManagerMenu().getAccountManager());
		} else {
			System.err.println("User doesn't logged In");

		}

		// Thread.sleep(2500); click(pom.getManageProvider().getManageProvidersMenu());

	}

	@Given("User Click the Account Manager Menu")
	public void user_click_the_account_manager_menu() {
		String currentURL = getCurrentURL();
		if (currentURL.equals("https://cirque.sgssys.info/ManageAccountManager")) {
			System.out.println("User has been redirected to Account Manager Page");
		} else {
			System.err.println("User doesn't redirected to Account Manager Page");
		}

	}

	@When("User click the Add Account Manager button")
	public void user_click_the_add_account_manager_button() throws InterruptedException{
		webDriverWait(40, "invisible", pom.getLogin().getLoader());
		webDriverWait(30, "visible", pom.getAccountManagerMenu().getAddButton());
		Thread.sleep(4000);
		click(pom.getAccountManagerMenu().getAddButton());
		
	}

	@When("User enter input into the Last and First Name fields")
	public void user_enter_input_into_the_last_and_first_name_fields() throws InterruptedException {
		click(pom.getAccountManagerMenu().getAddAccountManager());
		Thread.sleep(2000);
		last = randomAlphabetics(pom.getAccountManagerMenu().getLastName(), 5);
		first = randomAlphabetics(pom.getAccountManagerMenu().getFirstName(), 5);
		Thread.sleep(3000);
	}

	@When("User enter input into the Phone Number and Email address fields")
	public void user_enter_input_into_the_phone_number_and_email_address_fields() throws InterruptedException {
		randomNumeric(pom.getAccountManagerMenu().getPhoneNumber(), 7);
		click(pom.getAccountManagerMenu().getAddAccountManager());
		Thread.sleep(2000);
		randomNumeric(pom.getAccountManagerMenu().getPhoneNumber(), 3);
		randomEmail(pom.getAccountManagerMenu().getEmail(), 5);
		Thread.sleep(3000);
	}

	@When("User Choose the Commission Type")
	public void user_choose_the_commission_type() throws InterruptedException {
		actions("click", pom.getAccountManagerMenu().getFlatRadio());
		click(pom.getAccountManagerMenu().getAddAccountManager());
		Thread.sleep(2000);
		actions("click", pom.getAccountManagerMenu().getPercentageRadio());
		Thread.sleep(3000);
		actions("click", pom.getAccountManagerMenu().getBothRadio());
		Thread.sleep(2000);
		actions("click", pom.getAccountManagerMenu().getOtherRadio());

		actions("click", pom.getAccountManagerMenu().getFlatRadio());
		sendKeys(pom.getAccountManagerMenu().getFlatAmount(), "4545");
		Thread.sleep(2000);
		actions("click", pom.getAccountManagerMenu().getPercentageRadio());
		sendKeys(pom.getAccountManagerMenu().getPercentage(), "45");
		Thread.sleep(2000);
		click(pom.getAccountManagerMenu().getActiveCheckbox());
		Thread.sleep(3000);
		actions("click", pom.getAccountManagerMenu().getPopupCloseIcon());
		Thread.sleep(3000);
		click(pom.getAccountManagerMenu().getPopupNoButton());

	}

	@When("User Click the close Icon to get the Confirmation Popup")
	public void user_click_the_close_icon_to_get_the_confirmation_popup() throws InterruptedException {
		Thread.sleep(2000);
		actions("click", pom.getAccountManagerMenu().getPopupCloseIcon());
		Thread.sleep(2000);
		click(pom.getAccountManagerMenu().getPopupYesButton());
	}

	@When("Enter the Account Manager details")
	public void enter_the_account_manager_details() throws InterruptedException, IOException {
		Thread.sleep(2000);
		user_click_the_add_account_manager_button();
		takesScreenshot("addAccountManagerPopup");
		user_enter_input_into_the_last_and_first_name_fields();
		user_enter_input_into_the_phone_number_and_email_address_fields();
		user_choose_the_commission_type();
		click(pom.getAccountManagerMenu().getActiveCheckbox());
		Thread.sleep(3000);

	}

	@When("Click the Add button to create the Account Manager")
	public void click_the_add_button_to_create_the_account_manager() {
		actions("click", pom.getAccountManagerMenu().getAddAccountManager());
	}

	@When("Download the Excel and PDF files")
	public void download_the_excel_and_pdf_files() throws InterruptedException {
		navigateRefresh();
		Thread.sleep(3000);
		webDriverWait(30, "visible", pom.getAccountManagerMenu().getPdfDownload());
		click(pom.getAccountManagerMenu().getPdfDownload());
		webDriverWait(30, "visible", pom.getAccountManagerMenu().getExcelDownload());
		Thread.sleep(2000);
		click(pom.getAccountManagerMenu().getExcelDownload());
	}

	@When("Search the added Account Manager listed in the resultant Grid")
	public void search_the_added_account_manager_listed_in_the_resultant_grid() throws InterruptedException {
		Thread.sleep(3000);
		click(pom.getAccountManagerMenu().getSearchWithLastName());
		// sendKeys(pom.getAccountManagerMenu().getSearchWithLastName(),last);
		sendKeys(pom.getAccountManagerMenu().getSearchWithLastName(), "Barof");
		Thread.sleep(3000);
		click(pom.getAccountManagerMenu().getSearchWithLastName());
		// sendKeys(pom.getAccountManagerMenu().getSearchWithFirstName(),first);
		sendKeys(pom.getAccountManagerMenu().getSearchWithFirstName(), "BAeNn");

		Thread.sleep(3000);
		click(pom.getAccountManagerMenu().getSearchWithPhone());
		sendKeys(pom.getAccountManagerMenu().getSearchWithPhone(), "85746738");
		Thread.sleep(3000);
		click(pom.getAccountManagerMenu().getSearchWithEmail());
		sendKeys(pom.getAccountManagerMenu().getSearchWithEmail(), "surya@131");
		Thread.sleep(3000);
		String text = getText(pom.getAccountManagerMenu().getNoRecords());
		if (text.equals("No Records Found")) {
			navigateRefresh();
			click(pom.getAccountManagerMenu().getSearchWithLastName());
			// sendKeys(pom.getAccountManagerMenu().getSearchWithLastName(),last);
			sendKeys(pom.getAccountManagerMenu().getSearchWithLastName(), "Barof");
			Thread.sleep(3000);
			click(pom.getAccountManagerMenu().getSearchWithLastName());
			// sendKeys(pom.getAccountManagerMenu().getSearchWithFirstName(),first);
			sendKeys(pom.getAccountManagerMenu().getSearchWithFirstName(), "BAeNn");
			Thread.sleep(3000);
		} else {
			System.out.println("Quick search is not working");
		}

	}

	@When("User click the Edit the Account Manager Details")
	public void user_click_the_edit_the_account_manager_details() {
		webDriverWait(30, "visible", pom.getAccountManagerMenu().getEditAccountManager());
		click(pom.getAccountManagerMenu().getEditAccountManager());
		System.out.println("clicked edit Icon");
		

	}

	@When("User Click the close Icon to getting the Confirmation popup")
	public void user_click_the_close_icon_to_getting_the_confirmation_popup() throws InterruptedException, IOException {
		actions("click", pom.getAccountManagerMenu().getPopupCloseIcon());
		Thread.sleep(3000);
		click(pom.getAccountManagerMenu().getPopupNoButton());
		actions("click", pom.getAccountManagerMenu().getPopupCloseIcon());
		Thread.sleep(3000);
		click(pom.getAccountManagerMenu().getPopupYesButton());
		user_click_the_edit_the_account_manager_details();
		takesScreenshot("EditAccountManager");

	}

	@When("User again Click Edit icon to change the Account Manager informations")
	public void user_again_click_edit_icon_to_change_the_account_manager_informations() throws InterruptedException {
		clear(pom.getAccountManagerMenu().getPhoneNumber());
		clear(pom.getAccountManagerMenu().getEmail());
		Thread.sleep(2000);
		sendKeys(pom.getAccountManagerMenu().getEmail(), "suryaam@yopmail.com");
		randomNumeric(pom.getAccountManagerMenu().getPhoneNumber(), 10);
		Thread.sleep(2000);
		click(pom.getAccountManagerMenu().getUpdateAccountManager());
		Thread.sleep(2000);

		if (isDisplayed(pom.getAccountManagerMenu().getEmailToaster())) {
			clear(pom.getAccountManagerMenu().getEmail());
			Thread.sleep(3000);
			randomEmail(pom.getAccountManagerMenu().getEmail(), 7);
		} else {
			System.out.println("Toster validation is not displayed");
		}
		Thread.sleep(2000);
		click(pom.getAccountManagerMenu().getBothRadio());
		Thread.sleep(2000);
		sendKeys(pom.getAccountManagerMenu().getFlatBoth(), "50");
		sendKeys(pom.getAccountManagerMenu().getPercentageBoth(), "25");
		Thread.sleep(2000);

	}

	@Then("User Update the Account Manager Details")
	public void user_update_the_account_manager_details() throws InterruptedException {
		click(pom.getAccountManagerMenu().getUpdateAccountManager());
		Thread.sleep(3000);
		webDriverWait(30, "visible", pom.getServiceLocation().getServiceLocationMenu());
		click(pom.getServiceLocation().getServiceLocationMenu());

	}

	@Given("User click the Service Location Menu")
	public void user_click_the_service_location_menu() throws InterruptedException {
		String actualUrl = getCurrentURL();
		String expectedUrl = "https://cirque.sgssys.info/ServiceLocation";
		assertEquals(actualUrl, expectedUrl);

		if (actualUrl.equals("https://cirque.sgssys.info/ServiceLocation")) {
			System.out.println("User was navigated to Service Location Page");

		} else {
			System.err.println("User doesn't navigated to Service Location Page");
		}

	}

	@When("User click the Add New Service Location button")
	public void user_click_the_add_new_service_location_button() throws InterruptedException {
		Thread.sleep(3000);
		click(pom.getServiceLocation().getAddButton());
	}

	@When("User enter location input into Location Name field")
	public void user_enter_location_input_into_location_name_field() throws InterruptedException {
		click(pom.getServiceLocation().getAddServiceLocation());
		Thread.sleep(2000);
		randomAlphabetics(pom.getServiceLocation().getLocationName(), 5);
		Thread.sleep(1000);
	}

	@When("User enter the Location Address1 and Address2")
	public void user_enter_the_location_address1_and_address2() throws InterruptedException {
		randomAlphaNumeric(pom.getServiceLocation().getLocationAddress1(), 6);
		Thread.sleep(1000);
		randomAlphaNumeric(pom.getServiceLocation().getLocationAddress2(), 5);

	}

	@When("User enter the input into City field")
	public void user_enter_the_input_into_city_field() {
		sendKeys(pom.getServiceLocation().getCity(), "New York");
	}

	@When("User Select the value from State dropdown")
	public void user_select_the_value_from_state_dropdown() throws InterruptedException, AWTException {
		webDriverWait(30, "clickable", pom.getServiceLocation().getState());
		click(pom.getServiceLocation().getState());
		TimeUnit.SECONDS.sleep(2);
		robot("down");
		robot("enter");
	}

	@When("User enter the input into zip code and Phone number fields")
	public void user_enter_the_input_into_zip_code_and_phone_number_fields() throws InterruptedException {

		Thread.sleep(2000);
		String zipValidation = getText(pom.getServiceLocation().getZipCodeValidation());
		if (zipValidation.equals("Please enter a Zip Code")) {
			randomNumeric(pom.getServiceLocation().getZipCode(), 3);

		} else {
			System.out.println("Zip Code field validation is not displayed");
		}
		Thread.sleep(2000);
		String zipValidation1 = getText(pom.getServiceLocation().getZipCodeValidation());
		if (zipValidation1.equals("Please Enter 5 digit Zip Code")) {
			clear(pom.getServiceLocation().getZipCode());
			Thread.sleep(1500);
			randomNumeric(pom.getServiceLocation().getZipCode(), 5);
		} else {
			System.out.println("Zip Code field validation is not displayed");
		}

		Thread.sleep(2000);
		String phValidation = getText(pom.getServiceLocation().getPhoneValidation());
		if (phValidation.equals("Please enter a Phone Number")) {
			randomNumeric(pom.getServiceLocation().getPhoneNumber(), 7);
			click(pom.getServiceLocation().getAddServiceLocation());

		} else {
			System.out.println("Phone Number field validation is not displayed");
		}
		Thread.sleep(2000);
		String phValidation1 = getText(pom.getServiceLocation().getPhoneValidation());
		if (phValidation1.equals("Please enter a valid Phone Number")) {
			clear(pom.getServiceLocation().getPhoneNumber());
			Thread.sleep(1500);
			randomNumeric(pom.getServiceLocation().getPhoneNumber(), 10);
		} else {
			System.out.println("Phone Number field validation is not displayed");
		}

	}

	@When("User enter the input into email and Website URL fields")
	public void user_enter_the_input_into_email_and_website_url_fields() throws InterruptedException {
		Thread.sleep(1000);
		String emailValidation = getText(pom.getServiceLocation().getEmailValidation());
		if (emailValidation.equals("Please enter a Email")) {
			sendKeys(pom.getServiceLocation().getEmail(), "rwte@@gmail..com");
			click(pom.getServiceLocation().getAddServiceLocation());

		} else {
			System.out.println("Email field validation is not displayed");
		}

		Thread.sleep(2000);
		String emailValidation1 = getText(pom.getServiceLocation().getEmailValidation());
		if (emailValidation1.equals("Please enter a valid Email")) {
			clear(pom.getServiceLocation().getEmail());
			Thread.sleep(1500);
			randomEmail(pom.getServiceLocation().getEmail(), 6);
			;
		} else {
			System.out.println("Email field validation is not displayed");
		}

		Thread.sleep(1000);
		String webValidation = getText(pom.getServiceLocation().getWebsiteUrlValidation());
		if (webValidation.equals("Please enter a Website URL")) {
			sendKeys(pom.getServiceLocation().getWebsiteUrl(), "SDFG24GM.COM");
			click(pom.getServiceLocation().getAddServiceLocation());

		} else {
			System.out.println("Website Url field validation is not displayed");
		}

		Thread.sleep(2000);
		String webValidation1 = getText(pom.getServiceLocation().getWebsiteUrlValidation());
		if (webValidation1.equals("Please enter a valid Website URL")) {
			clear(pom.getServiceLocation().getWebsiteUrl());
			Thread.sleep(1500);
			sendKeys(pom.getServiceLocation().getWebsiteUrl(), "https://www.cirque.sgssys.info/");
		} else {
			System.out.println("Website Url field validation is not displayed");
		}

	}

	@When("User select the Account Manager and Procedures value from the dropdown")
	public void user_select_the_account_manager_and_procedures_value_from_the_dropdown()
			throws InterruptedException, AWTException {
		webDriverWait(30, "clickable", pom.getServiceLocation().getAccManagerDropdown());
		click(pom.getServiceLocation().getAccManagerDropdown());
		Thread.sleep(2000);
		robot("enter");

		webDriverWait(30, "clickable", pom.getServiceLocation().getAccManagerDropdown());
		click(pom.getServiceLocation().getAccManagerDropdown());
		TimeUnit.SECONDS.sleep(3);
		robot("enter");

		TimeUnit.SECONDS.sleep(3);
		webDriverWait(30, "clickable", pom.getServiceLocation().getProcedure());
		click(pom.getServiceLocation().getProcedure());
		TimeUnit.SECONDS.sleep(3);
		robot("down");
		robot("enter");

		TimeUnit.SECONDS.sleep(3);

		webDriverWait(30, "clickable", pom.getServiceLocation().getProcedureFee());
		randomNumeric(pom.getServiceLocation().getProcedureFee(), 2);
		TimeUnit.SECONDS.sleep(3);
		actions("click", pom.getServiceLocation().getProcedurePlusIcon());
		TimeUnit.SECONDS.sleep(3);
		click(pom.getServiceLocation().getProcedureRemoveIcon());
		TimeUnit.SECONDS.sleep(3);
		click(pom.getServiceLocation().getAddServiceLocation());

		if (getText(pom.getServiceLocation().getProcedureValidation())
				.equals("Please " + "enter a valid Procedure and Procedure Fee")) {
			webDriverWait(30, "Visible", pom.getServiceLocation().getProcedure());
			webDriverWait(30, "clickable", pom.getServiceLocation().getProcedure());
			click(pom.getServiceLocation().getProcedure());
			Thread.sleep(1500);
			robot("down");
			robot("enter");
			Thread.sleep(1000);
			randomNumeric(pom.getServiceLocation().getProcedureFee(), 2);
			Thread.sleep(1500);
			actions("click", pom.getServiceLocation().getProcedurePlusIcon());

		} else {
			System.out.println("Procedure Add Common validation error" + "message not displayed");
		}

	}

	@When("User choose the Service logo")
	public void user_choose_the_service_logo() {
		sendKeys(pom.getServiceLocation().getImgUpload(), "D:\\Surya M Folder\\CIrque\\logo.png");
		click(pom.getServiceLocation().getActiveCheckbox());
	}

	@When("User Click to close the Add Service location popup")
	public void user_click_to_close_the_add_service_location_popup() throws InterruptedException {
		Thread.sleep(3000);
		actions("click", pom.getServiceLocation().getPopupCloseIcon());
		Thread.sleep(3000);
		click(pom.getServiceLocation().getPopupNoButton());
		Thread.sleep(2000);
		actions("click", pom.getServiceLocation().getPopupCloseIcon());
		Thread.sleep(2000);
		click(pom.getServiceLocation().getPopupYesButton());

	}

	@When("User again Enter the Service Location details")
	public void user_again_enter_the_service_location_details() throws InterruptedException, AWTException, IOException {
		user_click_the_add_new_service_location_button();
		takesScreenshot("addServiceLoction");
		user_enter_location_input_into_location_name_field();
		user_enter_the_location_address1_and_address2();
		user_enter_the_input_into_city_field();
		user_select_the_value_from_state_dropdown();
		user_enter_the_input_into_zip_code_and_phone_number_fields();
		user_enter_the_input_into_email_and_website_url_fields();
		user_select_the_account_manager_and_procedures_value_from_the_dropdown();
		user_choose_the_service_logo();
		Thread.sleep(2000);
		click(pom.getServiceLocation().getActiveCheckbox());

	}

	@When("Click the Add button to create the Service Location")
	public void click_the_add_button_to_create_the_service_location() {
		click(pom.getServiceLocation().getAddServiceLocation());
	}

	@When("Download the service location Excel and PDF files")
	public void download_the_service_location_excel_and_pdf_files() throws InterruptedException {
		Thread.sleep(2000);
		click(pom.getServiceLocation().getPdfDownload());
		Thread.sleep(2000);
		click(pom.getServiceLocation().getExcelDownload());

	}

	@When("User click the Edit the Service Location Details")
	public void user_click_the_edit_the_service_location_details() throws InterruptedException {
		Thread.sleep(3000);
		click(pom.getServiceLocation().getSearchWithLocationName());
		sendKeys(pom.getServiceLocation().getSearchWithLocationName(), "new Service");
		Thread.sleep(3000);
		click(pom.getServiceLocation().getSearchWithLocationAddress());
		sendKeys(pom.getServiceLocation().getSearchWithLocationAddress(), "Service Location");
		Thread.sleep(3000);
		click(pom.getServiceLocation().getSearchWithPhone());
		sendKeys(pom.getServiceLocation().getSearchWithPhone(), "567-5956");
		Thread.sleep(3000);
		click(pom.getServiceLocation().getSearchWithWebsiteUrl());
		sendKeys(pom.getServiceLocation().getSearchWithWebsiteUrl(), "surya@131");
		Thread.sleep(3000);
		String text = getText(pom.getAccountManagerMenu().getNoRecords());
		if (text.equals("No Records Found")) {
			navigateRefresh();
			click(pom.getServiceLocation().getSearchWithLocationName());
			sendKeys(pom.getServiceLocation().getSearchWithLocationName(), "new Service");
			Thread.sleep(3000);
			click(pom.getServiceLocation().getEditServiceLocation());
		} else {
			System.out.println("Quick search is not working");
		}

	}

	@When("User again Click Edit icon to change the Service Location informations")
	public void user_again_click_edit_icon_to_change_the_service_location_informations()
			throws InterruptedException, AWTException, IOException {
		Thread.sleep(2000);
		takesScreenshot("editServiceLocation");
		Thread.sleep(2000);
		clear(pom.getServiceLocation().getLocationAddress1());
		Thread.sleep(2000);
		clear(pom.getServiceLocation().getEmail());
		Thread.sleep(3000);
		clear(pom.getServiceLocation().getPhoneNumber());
		Thread.sleep(2000);
		click(pom.getServiceLocation().getEditProcedureRemoveIcon());
		Thread.sleep(3000);
		click(pom.getServiceLocation().getUpdateServiceLocation());
		Thread.sleep(2000);
		if (getText(pom.getServiceLocation().getProcedureValidation())
				.equals("Please " + "enter a valid Procedure and Procedure Fee")) {
			webDriverWait(50, "clickable", pom.getServiceLocation().getEditProcedure());
			click(pom.getServiceLocation().getEditProcedure());
			Thread.sleep(2500);
			robot("down");
			Thread.sleep(1500);
			robot("enter");
			Thread.sleep(2000);
			randomNumeric(pom.getServiceLocation().getEditProcedureFee(), 3);
			Thread.sleep(2500);
			actions("click", pom.getServiceLocation().getProcedurePlusIcon());

		} else {
			System.out.println("Procedure Add Common validation error" + "message not displayed");
		}
		Thread.sleep(3000);
		clear(pom.getServiceLocation().getEmail());
		randomEmail(pom.getServiceLocation().getEmail(), 6);
		Thread.sleep(2000);
		clear(pom.getServiceLocation().getLocationAddress1());
		randomAlphabetics(pom.getServiceLocation().getLocationAddress1(), 4);

		Thread.sleep(2000);
		randomNumeric(pom.getServiceLocation().getPhoneNumber(), 10);
		Thread.sleep(2000);
	}

	@Then("User Update the Service Location Details")
	public void user_update_the_service_location_details() {
		click(pom.getServiceLocation().getUpdateServiceLocation());
	}

	@Given("User Click to navigate Manage Form menu")
	public void user_click_to_navigate_manage_form_menu() throws InterruptedException {
		Thread.sleep(2000);
		navigateRefresh();
		Thread.sleep(3000);
		click(pom.getManageForms().getManageFormsMenu());
		String actualUrl = getCurrentURL();
		String expectedUrl = "https://cirque.sgssys.info/ManageForm";
		assertEquals(actualUrl, expectedUrl);

		if (actualUrl.equals("https://cirque.sgssys.info/ManageForm")) {
			System.out.println("User was navigated to Manage Forms Page");

		} else {
			System.err.println("User doesn't navigated to Manage Forms Page");
		}
		navigateRefresh();

	}

	@When("User click View Icon to view the Forms")
	public void user_click_view_icon_to_view_the_forms() throws InterruptedException {
		Thread.sleep(2000);
		click(pom.getManageForms().getStandardFormView());
		Thread.sleep(2000);
		click(pom.getManageForms().getPopupCloseIcon());
		Thread.sleep(2000);
		click(pom.getManageForms().getFaithFormView());
		Thread.sleep(2000);
		click(pom.getManageForms().getPopupCloseIcon());
		Thread.sleep(2000);
		click(pom.getManageForms().getAdvanceFormView());
		Thread.sleep(2000);
		click(pom.getManageForms().getPopupCloseIcon());
		Thread.sleep(2000);
	}

	@When("User click to Edit the Forms")
	public void user_click_to_edit_the_forms() throws InterruptedException {

		click(pom.getManageForms().getStandardFormEdit());
		if (getText(pom.getManageForms().getFormHeading()).contains("Standard Notice")) {
			sendKeys(pom.getManageForms().getFormHeading(), "test");
			Thread.sleep(3000);
			clear(pom.getManageForms().getFormHeading());
			Thread.sleep(3000);
			sendKeys(pom.getManageForms().getFormHeading(), "Standard Notice and Consent");
			Thread.sleep(3000);
			click(pom.getManageForms().getUpdateButton());

		} else {
			System.out.println("Standard Notice Form is not popuped");

		}
		Thread.sleep(2000);
		click(pom.getManageForms().getFaithFormEdit());
		if (getText(pom.getManageForms().getFormHeading()).contains("Good Faith")) {

			sendKeys(pom.getManageForms().getFormHeading(), "test");
			Thread.sleep(3000);
			clear(pom.getManageForms().getFormHeading());
			Thread.sleep(3000);
			sendKeys(pom.getManageForms().getFormHeading(), "Good Faith Estimate");
			Thread.sleep(1000);
		} else {

			System.out.println("Good Faith Form is not popuped");
		}
		
		navigateRefresh();
		Thread.sleep(3000);
		click(pom.getManageForms().getAdvanceFormEdit());
		if (getText(pom.getManageForms().getAdvanceHeading()).contains("Advance Beneficiary Notice")) {
			sendKeys(pom.getManageForms().getAdvanceHeading(), "testing");
			Thread.sleep(2000);
			clear(pom.getManageForms().getAdvanceHeading());
			Thread.sleep(3000);
			sendKeys(pom.getManageForms().getAdvanceHeading(), "Advance Beneficiary Notice for Self-Pay Procedures");
			Thread.sleep(3000);
			click(pom.getManageForms().getUpdateButton());
		} else {
			System.out.println("Standard Notice Form is not popuped");

		}

	}

	@When("User Assign the Service Location")
	public void user_assign_the_service_location() throws InterruptedException, AWTException {

		navigateRefresh();
		click(pom.getManageForms().getStandardFormAssign());
		Thread.sleep(2000);
		webDriverWait(50, "clickable", pom.getManageForms().getServiceLocation());
		actions("moveToElement", pom.getManageForms().getServiceLocation());
		click(pom.getManageForms().getServiceLocation());
		Thread.sleep(2500);
		robot("down");
		Thread.sleep(1500);
		robot("enter");
		Thread.sleep(3000);
		actions("click", pom.getManageForms().getPopupCloseIcon());
		Thread.sleep(3000);
		click(pom.getManageForms().getPopupNoButton());
		Thread.sleep(3000);
		actions("click", pom.getManageForms().getPopupCloseIcon());
		Thread.sleep(3000);
		click(pom.getManageForms().getPopupYesButton());
		Thread.sleep(3000);
		click(pom.getManageForms().getStandardFormAssign());
		Thread.sleep(3000);
		click(pom.getManageForms().getAssignButton());
		Thread.sleep(3000);

		click(pom.getManageForms().getFaithFormAssign());
		Thread.sleep(3000);
		webDriverWait(50, "clickable", pom.getManageForms().getServiceLocation());
		actions("moveToElement", pom.getManageForms().getServiceLocation());
		click(pom.getManageForms().getServiceLocation());
		Thread.sleep(2500);
		robot("down");
		Thread.sleep(1500);
		robot("enter");
		Thread.sleep(2000);
		actions("click", pom.getManageForms().getPopupCloseIcon());
		Thread.sleep(3000);
		click(pom.getManageForms().getPopupNoButton());
		Thread.sleep(3000);
		actions("click", pom.getManageForms().getPopupCloseIcon());
		Thread.sleep(3000);
		click(pom.getManageForms().getPopupYesButton());
		Thread.sleep(3000);

	}

	@When("User Update the assigned service Location")
	public void user_update_the_assigned_service_location() throws InterruptedException, AWTException {
		click(pom.getManageForms().getAdvanceFormAssign());
		Thread.sleep(2000);
		webDriverWait(50, "clickable", pom.getManageForms().getServiceLocation());
		actions("moveToElement", pom.getManageForms().getServiceLocation());
		click(pom.getManageForms().getServiceLocation());
		Thread.sleep(2500);
		robot("down");
		Thread.sleep(1500);
		robot("enter");
		Thread.sleep(2000);
		actions("click", pom.getManageForms().getPopupCloseIcon());
		Thread.sleep(3000);
		click(pom.getManageForms().getPopupNoButton());
		Thread.sleep(2000);
		actions("click", pom.getManageForms().getPopupCloseIcon());
		Thread.sleep(2000);
		click(pom.getManageForms().getPopupYesButton());
		click(pom.getManageForms().getAdvanceFormAssign());
		Thread.sleep(2000);
		click(pom.getManageForms().getAssignButton());

	}

	@Given("User Click to navigate Manage Providers menu")
	public void user_click_to_navigate_manage_providers_menu() throws InterruptedException {
		Thread.sleep(2500);
		navigateRefresh();
		Thread.sleep(2500);
		click(pom.getManageProvider().getManageProvidersMenu());
		Thread.sleep(2500);
		String actualUrl = getCurrentURL();
		String expectedUrl = "https://cirque.sgssys.info/ManageProviders";
		assertEquals(actualUrl, expectedUrl);
		if (actualUrl.equals("https://cirque.sgssys.info/ManageProviders")) {
			System.out.println("User was navigated to Manage Providers Page");
			Thread.sleep(3000);

		} else {
			System.err.println("User doesn't navigated to Manage Providers Page");
		}
		navigateRefresh();
		Thread.sleep(2000);

	}

	@When("User click the Add Manager Providers button")
	public void user_click_the_add_manager_providers_button() throws InterruptedException {
		click(pom.getManageProvider().getAddButton());
		Thread.sleep(2000);
	}

	@When("User enter the provider Last Name and First Name")
	public void user_enter_the_provider_last_name_and_first_name() throws InterruptedException {
		click(pom.getManageProvider().getAddProvider());
		Thread.sleep(2000);
		randomAlphabetics(pom.getManageProvider().getLastName(), 5);
		Thread.sleep(3000);
		randomAlphabetics(pom.getManageProvider().getFirstName(), 5);
		Thread.sleep(3000);

	}

	@When("User select the provider suffix from the dropdown field")
	public void user_select_the_provider_suffix_from_the_dropdown_field() throws AWTException, InterruptedException {
		webDriverWait(30, "clickable", pom.getManageProvider().getSuffix());
		click(pom.getManageProvider().getSuffix());
		robot("down");
		Thread.sleep(1000);
		robot("enter");

	}

	@When("User enter the provider Phone Number and Email address")
	public void user_enter_the_provider_phone_number_and_email_address() throws InterruptedException {
		Thread.sleep(2000);
		String phValidation = getText(pom.getManageProvider().getPhoneValidation());
		if (phValidation.equals("Please enter a Phone Number")) {
			randomNumeric(pom.getManageProvider().getPhoneNumber(), 7);
			click(pom.getManageProvider().getAddProvider());

		} else {
			System.out.println("Phone Number field validation is not displayed");
		}
		Thread.sleep(2000);
		String phValidation1 = getText(pom.getManageProvider().getPhoneValidation());
		if (phValidation1.equals("Please enter a valid Phone Number")) {
			clear(pom.getManageProvider().getPhoneNumber());
			Thread.sleep(1500);
			clear(pom.getManageProvider().getPhoneNumber());
			randomNumeric(pom.getManageProvider().getPhoneNumber(), 10);
		} else {
			System.out.println("Phone Number field validation is not displayed");
		}

		Thread.sleep(2000);
		sendKeys(pom.getManageProvider().getEmail(), "suryaam@yopmail.com");
		Thread.sleep(2000);

	}

	@When("User select the provider State from the dropdown field.")
	public void user_select_the_provider_state_from_the_dropdown_field() throws InterruptedException, AWTException {
		webDriverWait(30, "clickable", pom.getManageProvider().getState());
		click(pom.getManageProvider().getState());
		TimeUnit.SECONDS.sleep(5);
		robot("down");
		Thread.sleep(1000);
		robot("enter");

	}

	@When("User enter the provider Medical License Number and NPI number")
	public void user_enter_the_provider_medical_license_number_and_npi_number() throws InterruptedException {
		Thread.sleep(2000);
		randomNumeric(pom.getManageProvider().getMedicalLicense(), 11);
		Thread.sleep(2000);
		randomNumeric(pom.getManageProvider().getNPI(), 11);

	}

	@When("User provider mapping the Account Manager from the dropdown field")
	public void user_provider_mapping_the_account_manager_from_the_dropdown_field()
			throws InterruptedException, AWTException {
		webDriverWait(30, "clickable", pom.getManageProvider().getAccountManager());
		click(pom.getManageProvider().getAccountManager());
		Thread.sleep(2000);
		robot("enter");

		webDriverWait(30, "clickable", pom.getManageProvider().getAccountManager());
		click(pom.getManageProvider().getAccountManager());
		TimeUnit.SECONDS.sleep(3);
		robot("enter");

		Thread.sleep(1000);
		click(pom.getManageProvider().getAddProvider());
		Thread.sleep(2000);

		if (isDisplayed(pom.getManageProvider().getEmailToaster())) {
			clear(pom.getManageProvider().getEmail());
			Thread.sleep(3000);
			randomEmail(pom.getManageProvider().getEmail(), 5);
		} else {
			System.out.println("Toster validation is not displayed");
		}
		Thread.sleep(3000);

	}

	@Given("User check the Cancel Confirmation popup is displayed")
	public void user_check_the_cancel_confirmation_popup_is_displayed() throws InterruptedException {
		Thread.sleep(3000);
		click(pom.getManageProvider().getPopupCloseIcon());
		Thread.sleep(2000);
		click(pom.getManageProvider().getPopupNoButton());
		click(pom.getManageProvider().getPopupCloseIcon());
		Thread.sleep(2000);
		click(pom.getManageProvider().getPopupYesButton());
		Thread.sleep(2000);
	}

	@When("user Add the New Provider account")
	public void user_add_the_new_provider_account() throws InterruptedException, AWTException {
		user_click_the_add_manager_providers_button();
		user_enter_the_provider_last_name_and_first_name();
		user_select_the_provider_suffix_from_the_dropdown_field();
		user_enter_the_provider_phone_number_and_email_address();
		user_select_the_provider_state_from_the_dropdown_field();
		user_enter_the_provider_medical_license_number_and_npi_number();
		user_provider_mapping_the_account_manager_from_the_dropdown_field();
		Thread.sleep(1000);
		click(pom.getManageProvider().getAddProvider());

	}

	@Given("Download to Export Providers List to Excel and PDF files")
	public void download_to_export_providers_list_to_excel_and_pdf_files() throws InterruptedException {
		Thread.sleep(3000);
		actions("click", pom.getManageProvider().getPdfDownload());
		Thread.sleep(2000);
		click(pom.getManageProvider().getExcelDownload());
		Thread.sleep(3000);

	}

	@When("User click the Edit button from the provider Grid list")
	public void User_click_the_Edit_button_from_the_provider_Grid_list() throws InterruptedException {
		Thread.sleep(3000);
		click(pom.getManageProvider().getSearchWithLastName());
		sendKeys(pom.getManageProvider().getSearchWithLastName(), "zkccJ zkccJ");
		Thread.sleep(3000);
		click(pom.getManageProvider().getSearchWithFirstName());
		sendKeys(pom.getManageProvider().getSearchWithFirstName(), "dHRgM dHRgM");
		Thread.sleep(3000);
		click(pom.getManageProvider().getSearchWithPhone());
		sendKeys(pom.getManageProvider().getSearchWithPhone(), "(459) 320-4500");
		Thread.sleep(3000);
		click(pom.getManageProvider().getSearchWithEmail());
		sendKeys(pom.getManageProvider().getSearchWithEmail(), "surya@131");
		Thread.sleep(3000);
		String text = getText(pom.getManageProvider().getNoRecords());
		if (text.equals("No Records Found")) {
			navigateRefresh();
			click(pom.getManageProvider().getSearchWithLastName());
			sendKeys(pom.getManageProvider().getSearchWithLastName(), "checkprovider");
			Thread.sleep(3000);
			click(pom.getManageProvider().getEditProvider());
			Thread.sleep(3000);
		} else {
			System.out.println("Quick search is not working");
		}

	}

	@When("User again Click Edit icon to change the Provider informations")
	public void user_again_click_edit_icon_to_change_the_provider_informations()
			throws InterruptedException, AWTException {
		user_check_the_cancel_confirmation_popup_is_displayed();
		Thread.sleep(2000);
		click(pom.getManageProvider().getEditProvider());
		clear(pom.getManageProvider().getEmail());
		Thread.sleep(3000);
		sendKeys(pom.getManageProvider().getEmail(), "yeui");
		Thread.sleep(2000);
		click(pom.getManageProvider().getUpdateProvider());
		Thread.sleep(2000);
		if (isDisplayed(pom.getManageProvider().getEmailValidation())) {
			Thread.sleep(3000);
			clear(pom.getManageProvider().getEmail());
			Thread.sleep(2000);
			clear(pom.getManageProvider().getFirstName());
			Thread.sleep(2000);
			clear(pom.getManageProvider().getPhoneNumber());
			Thread.sleep(2000);
			randomAlphabetics(pom.getManageProvider().getFirstName(), 4);
			Thread.sleep(2000);
			randomNumeric(pom.getManageProvider().getPhoneNumber(), 10);
			clear(pom.getManageProvider().getEmail());
			Thread.sleep(2000);
			sendKeys(pom.getManageProvider().getEmail(), "suryaam@yopmail.com");

			click(pom.getManageProvider().getUpdateProvider());
			Thread.sleep(2000);
			if (isDisplayed(pom.getManageProvider().getEmailToaster())) {
				clear(pom.getManageProvider().getEmail());
				Thread.sleep(3000);
				randomEmail(pom.getManageProvider().getEmail(), 5);
			} else {
				System.out.println("Toster validation is not displayed");
			}

		} else {
			System.out.println("Email field is not throwing validation error message");
		}

		Thread.sleep(2000);

	}

	@Then("User Update the Provider Details")
	public void user_update_the_provider_details() throws InterruptedException {
		click(pom.getManageProvider().getUpdateProvider());
		Thread.sleep(2000);
	}

	@Given("User click the Manage Patients Menu to redirected to manage patient page")
	public void user_click_the_manage_patients_menu_to_redirected_to_manage_patient_page() throws InterruptedException {
		navigateRefresh();
		Thread.sleep(2000);
		getTitle();
		click(pom.getManagePatients().getManagePatientMenu());
		String currentURL = getCurrentURL();
		Thread.sleep(1500);
		if (currentURL.equals("https://cirque.sgssys.info/ManagePatients")) {
			System.out.println("User has been redirected to Manage Patient Page");
		} else {
			System.err.println("User doesn't redirected to Manage Patient Page");
		}

	}

	@Given("User click the Add Manager patients button")
	public void user_click_the_add_manager_patients_button() throws InterruptedException {
		Thread.sleep(2000);
		click(pom.getManagePatients().getAddButton());
	}

	@Given("User select the Service Location Name from the dropdown field")
	public void user_select_the_service_location_name_from_the_dropdown_field()
			throws InterruptedException, AWTException {
		Thread.sleep(2000);
		webDriverWait(30, "clickable", pom.getManagePatients().getServiceLocation());
		click(pom.getManagePatients().getServiceLocation());
		robot("down");
		robot("down");
		robot("enter");
	}

	@Given("User select the Provider Name from the dropdown field")
	public void user_select_the_provider_name_from_the_dropdown_field() throws InterruptedException, AWTException {
		Thread.sleep(2000);
		webDriverWait(30, "clickable", pom.getManagePatients().getProviderName());
		click(pom.getManagePatients().getProviderName());
		robot("down");
		robot("enter");
	}

	@Given("User select the Account Manager Name from the dropdown field")
	public void user_select_the_account_manager_name_from_the_dropdown_field()
			throws InterruptedException, AWTException {
		Thread.sleep(2000);
		webDriverWait(30, "clickable", pom.getManagePatients().getAccountManagerName());
		click(pom.getManagePatients().getAccountManagerName());
		robot("down");
		robot("enter");
	}

	@Given("User enter the Patient Last Name and First Name")
	public void user_enter_the_patient_last_name_and_first_name() throws InterruptedException {
		click(pom.getManagePatients().getShareLink());
		Thread.sleep(1500);
		patientLast = randomAlphabetics(pom.getManagePatients().getLastName(), 4);
		Thread.sleep(1500);
		randomAlphabetics(pom.getManagePatients().getFirstName(), 5);

	}

	@Given("User select the Patient DOB from the Date picker")
	public void user_select_the_patient_dob_from_the_date_picker() throws AWTException, InterruptedException {
		click(pom.getManagePatients().getDateOfBirth());
		Thread.sleep(1500);
		click(pom.getManagePatients().getDatePickOk());

	}

	@Given("User enter the Patient Phone Number and Email Address")
	public void user_enter_the_patient_phone_number_and_email_address() throws InterruptedException {
		Thread.sleep(2000);
		String phValidation = getText(pom.getManagePatients().getPhoneValidation());
		if (phValidation.equals("Please enter a Phone Number")) {
			randomNumeric(pom.getManagePatients().getPhoneNumber(), 7);
			click(pom.getManagePatients().getShareLink());

		} else {
			System.out.println("Phone Number field validation is not displayed");
		}
		Thread.sleep(2000);
		String phValidation1 = getText(pom.getManagePatients().getPhoneValidation());
		if (phValidation1.equals("Please enter a valid Phone Number")) {
			clear(pom.getManagePatients().getPhoneNumber());
			Thread.sleep(1500);
			clear(pom.getManagePatients().getPhoneNumber());
			randomNumeric(pom.getManagePatients().getPhoneNumber(), 10);
		} else {
			System.out.println("Phone Number field validation is not displayed");
		}

		Thread.sleep(2000);
		sendKeys(pom.getManagePatients().getEmail(), "patientregistration@yopmail.com");
		Thread.sleep(2000);

	}

	@Given("User select the Procedure Name from the dropdown field")
	public void user_select_the_procedure_name_from_the_dropdown_field() throws AWTException, InterruptedException {
		webDriverWait(30, "clickable", pom.getManagePatients().getProcedureName());
		click(pom.getManagePatients().getProcedureName());
		// TimeUnit.SECONDS.sleep(5);
		robot("down");
		robot("enter");
	}

	@Given("User Select the invite sharing Preference")
	public void user_select_the_invite_sharing_preference() throws InterruptedException {
		Thread.sleep(2000);
		click(pom.getManagePatients().getEmailRadioButton());
	}

	@Given("User Close the Add Patient Popup")
	public void user_close_the_add_patient_popup() throws InterruptedException {
		Thread.sleep(3000);
		actions("click", pom.getAccountManagerMenu().getPopupCloseIcon());
		Thread.sleep(3000);
		click(pom.getAccountManagerMenu().getPopupNoButton());
		Thread.sleep(2000);
		actions("click", pom.getAccountManagerMenu().getPopupCloseIcon());
		Thread.sleep(2000);
		click(pom.getAccountManagerMenu().getPopupYesButton());

	}

	@Given("User Click the Share Link button")
	public void user_click_the_share_link_button() throws InterruptedException, AWTException {
		Thread.sleep(2000);
		user_click_the_add_manager_patients_button();
		user_select_the_service_location_name_from_the_dropdown_field();
		user_select_the_provider_name_from_the_dropdown_field();
		user_select_the_account_manager_name_from_the_dropdown_field();
		user_enter_the_patient_last_name_and_first_name();
		user_select_the_patient_dob_from_the_date_picker();
		user_enter_the_patient_phone_number_and_email_address();
		Thread.sleep(2000);
		webDriverWait(30, "clickable", pom.getManagePatients().getProcedureName1());
		click(pom.getManagePatients().getProcedureName1());
		robot("down");
		robot("enter");
		user_select_the_invite_sharing_preference();
		Thread.sleep(2000);
		click(pom.getManagePatients().getShareLink());

	}

	@Then("User Check the Invite has been received to Patient email address")
	public void user_check_the_invite_has_been_received_to_patient_email_address()
			throws AWTException, InterruptedException {
		Thread.sleep(2000);
		if (getText(pom.getManagePatients().getServiceValidation()).equals("Please select a Service Location")) {
			user_select_the_service_location_name_from_the_dropdown_field();
			user_select_the_provider_name_from_the_dropdown_field();
			user_select_the_account_manager_name_from_the_dropdown_field();
			user_select_the_procedure_name_from_the_dropdown_field();
			user_select_the_invite_sharing_preference();
			Thread.sleep(1500);
			click(pom.getManagePatients().getShareLink());

		} else {
			System.out.println("Patient invite has been to sent");
		}

	}

	@Given("Patient Click the Registration Invite Link")
	public void patient_click_the_registration_invite_link() throws InterruptedException, AWTException {
		Thread.sleep(3000);
		navigateRefresh();
		webDriverWait(30, "Visible", pom.getManagePatients().getLogout());
		actions("click", pom.getManagePatients().getLogout());
		Thread.sleep(1500);
		((JavascriptExecutor) driver).executeScript("window.open()");
		windowHandles(1);
		getURL("https://yopmail.com/");
		TimeUnit.SECONDS.sleep(3);
		sendKeys(pom.getManagePatients().getYopEmail(), "patientRegistration");
		TimeUnit.SECONDS.sleep(4);
		robot("Enter");
		Thread.sleep(2000);
		click(pom.getManagePatients().getRefresh());
		frameByElement(pom.getManagePatients().getInboxList());
		Thread.sleep(2000);
		click(pom.getManagePatients().getMail());
		backwardFrame("defaultContent");
		frameByElement(pom.getManagePatients().getMailContent());
		Thread.sleep(2000);
		click(pom.getManagePatients().getRegisterNow());
		Thread.sleep(1200);
		backwardFrame("defaultContent");

	}

	@Given("Patient Enter the Last Name into LastName field")
	public void patient_enter_the_last_name_into_last_name_field() throws InterruptedException, AWTException {
		windowHandles(2);
		click(pom.getPatientRegistration().getVerifyBtn());
		Thread.sleep(1500);
		if (getText(pom.getPatientRegistration().getLastNameValidation()).equals("Last name is required")) {
			randomAlphabetics(pom.getPatientRegistration().getLastName(), 4);
			Thread.sleep(1000);
			click(pom.getPatientRegistration().getDOB());
			Thread.sleep(1000);
			robot("leftArrow");
			Thread.sleep(2000);
			click(pom.getPatientRegistration().getDatePickOk());
			Thread.sleep(2000);
			click(pom.getPatientRegistration().getVerifyBtn());
			Thread.sleep(2000);
			if (getText(pom.getPatientRegistration().getPageLevelValidation()).equals("Authentication failed. Please "

					+ "check your credentials and try again.")) {
				Thread.sleep(1500);
				clear(pom.getPatientRegistration().getLastName());
			} else {
				System.out.println("page level validation is not displayed");
			}
		} else {
			System.out.println("Field level validation is not displayed");
		}

	}

	@Given("Patient Enter the DOB into DOB field")
	public void patient_enter_the_dob_into_dob_field() throws InterruptedException, AWTException {
		Thread.sleep(2000);
		sendKeys(pom.getPatientRegistration().getLastName(), patientLast + " " + patientLast);
		click(pom.getPatientRegistration().getDOB());
		Thread.sleep(1000);
		robot("rightArrow");
		Thread.sleep(2000);
		click(pom.getPatientRegistration().getDatePickOk());
		Thread.sleep(2000);

	}

	@Given("Patient click to verify button")
	public void patient_click_to_verify_button() throws InterruptedException {
		click(pom.getPatientRegistration().getVerifyBtn());
		Thread.sleep(2000);

	}

	@Then("Patient should navigate to Patient Registration Page")
	public void patient_should_navigate_to_patient_registration_page() throws InterruptedException {
		String actualUrl = getCurrentURL();
		String expectedUrl = "https://cirque.sgssys.info/PatientRegistration";
		if (actualUrl.contains(expectedUrl)) {
			System.out.println("User was navigated to Patient Registration Page");
			Thread.sleep(3000);
		} else {
			System.err.println("User doesn't navigated to Patient Registration Page");
		}
	}

	@Given("patient entering patient SSN and Address")
	public void patient_entering_patient_ssn_and_address() throws InterruptedException {
		Thread.sleep(2000);
		click(pom.getPatientRegistration().getNextButton());
		Thread.sleep(2000);
		randomNumeric(pom.getPatientRegistration().getSsn(), 7);
		if (getText(pom.getPatientRegistration().getSsnValidation()).equals("Patient SSN must be 9 digits")) {
			randomNumeric(pom.getPatientRegistration().getSsn(), 9);
		} else {
			System.out.println("Patient SSN field is not thrown validation message");
		}
		randomAlphabetics(pom.getPatientRegistration().getMailingAddress1(), 4);
	}

	@When("Patient entering city and Select state from the dropdown")
	public void patient_entering_city_and_select_state_from_the_dropdown() throws AWTException, InterruptedException {
		sendKeys(pom.getPatientRegistration().getCity(), "New York");
		Thread.sleep(2000);
		webDriverWait(30, "clickable", pom.getPatientRegistration().getState());
		click(pom.getPatientRegistration().getState());
		robot("down");
		robot("enter");

	}

	@When("Patient entering Zipcode and Modify the Phone and Email")
	public void patient_entering_zipcode_and_modify_the_phone_and_email() throws InterruptedException {
		randomNumeric(pom.getPatientRegistration().getZipCode(), 3);
		Thread.sleep(2000);
		if (getText(pom.getPatientRegistration().getZipcodeValidation()).equals("Zip Code must be 5 digit")) {
			randomNumeric(pom.getPatientRegistration().getZipCode(), 5);
		} else {
			System.out.println("Zipcode field is not thrown validation message");
		}

		randomNumeric(pom.getPatientRegistration().getPhoneNumber(), 7);
		Thread.sleep(2000);
		if (getText(pom.getPatientRegistration().getPhValidation()).equals("Please enter a valid Phone Number")) {
			randomNumeric(pom.getPatientRegistration().getPhoneNumber(), 10);
		} else {
			System.out.println("Phone Number field is not thrown validation message");
		}
		isEnable(pom.getPatientRegistration().getEmail());

	}

	@When("Select is patient a minor radio button")
	public void select_is_patient_a_minor_radio_button() throws InterruptedException, AWTException {
		click(pom.getPatientRegistration().getIsMinorYes());
		Thread.sleep(1500);
		sendKeys(pom.getPatientRegistration().getGuardianLastName(), "Guardian Last Name");
		Thread.sleep(1500);
		sendKeys(pom.getPatientRegistration().getGuardianFirstName(), "Guardian First Name");
		Thread.sleep(1000);
		click(pom.getPatientRegistration().getGuardianDOB());
		click(pom.getPatientRegistration().getDatePickOk());
		Thread.sleep(2000);
		randomAlphabetics(pom.getPatientRegistration().getGuardianAddress1(), 4);
		randomAlphabetics(pom.getPatientRegistration().getGuardianCity(), 4);
		Thread.sleep(2000);
		webDriverWait(30, "clickable", pom.getPatientRegistration().getGuardianState());
		click(pom.getPatientRegistration().getGuardianState());
		robot("down");
		robot("enter");
		Thread.sleep(2000);
		randomNumeric(pom.getPatientRegistration().getGuardianZipcode(), 5);
		randomNumeric(pom.getPatientRegistration().getGuardianPhoneNumber(), 10);
		Thread.sleep(2500);
		if (isDisplayed((pom.getPatientRegistration().getEmailValidaton()))) {
			Thread.sleep(2500);
			randomEmail(pom.getPatientRegistration().getGuardianEmail(), 5);
		} else {
			System.out.println("Email is already presented");
		}

	}

	@When("Patient click the same As checkbox  and unchecked up the sameAs checkbox")
	public void patient_click_the_same_as_checkbox_and_unchecked_up_the_same_as_checkbox() throws InterruptedException {
		Thread.sleep(3000);
		click(pom.getPatientRegistration().getSameAsAddress());
		Thread.sleep(2000);
		click(pom.getPatientRegistration().getIsMinorNo());
		Thread.sleep(2000);
		click(pom.getPatientRegistration().getIsMinorYes());
		Thread.sleep(3000);
		click(pom.getPatientRegistration().getSameAsAddress());

	}

	@When("Patient entering Parent or Legal Guardian information")
	public void patient_entering_parent_or_legal_guardian_information() throws InterruptedException, AWTException {
		Thread.sleep(3000);
		clear(pom.getPatientRegistration().getGuardianLastName());
		Thread.sleep(3000);
		clear(pom.getPatientRegistration().getGuardianFirstName());
		Thread.sleep(3000);
		select_is_patient_a_minor_radio_button();

	}

	@When("Patient select the insurance information radio button")
	public void patient_select_the_insurance_information_radio_button() throws InterruptedException, AWTException {
		click(pom.getPatientRegistration().getInsuranceYes());
		Thread.sleep(2000);
		webDriverWait(30, "clickable", pom.getPatientRegistration().getInsuranceCarrier());
		click(pom.getPatientRegistration().getInsuranceCarrier());
		robot("down");
		robot("enter");
		randomAlphaNumeric(pom.getPatientRegistration().getMemberId(), 8);
		Thread.sleep(1500);
		randomAlphaNumeric(pom.getPatientRegistration().getGroupNumber(), 7);
		Thread.sleep(1500);
		randomAlphabetics(pom.getPatientRegistration().getPrimarySubscriberName(), 4);
		Thread.sleep(1500);
		click(pom.getPatientRegistration().getPrimarySubscriberDOB());
		click(pom.getPatientRegistration().getDatePickOk());

	}

	@When("Entering Patient Insurance information details")
	public void entering_patient_insurance_information_details() throws InterruptedException {
		Thread.sleep(2500);
		click(pom.getPatientRegistration().getInsuranceNo());
		Thread.sleep(2500);
		click(pom.getPatientRegistration().getInsuranceYes());
		Thread.sleep(2500);
	}

	@When("User checkedUp the confirm this information is accurate checkbox")
	public void user_checked_up_the_confirm_this_information_is_accurate_checkbox() throws InterruptedException {
		Thread.sleep(2500);
		click(pom.getPatientRegistration().getConfirmCheckbox());

	}

	@When("patient entering digital signature")
	public void patient_entering_digital_signature() {

		jsScrollIntoView(pom.getPatientRegistration().getDigitalSign1());
		WebElement sign = pom.getPatientRegistration().getDigitalSign1();
		Actions builder = new Actions(driver);
		builder.moveToElement(sign, 10, 10).clickAndHold().moveByOffset(20, 10).moveByOffset(20, 20)
				.moveByOffset(20, -10).release().build().perform();

	}

	@When("Patient moved to next form tab by clicking the next button")
	public void patient_moved_to_next_form_tab_by_clicking_the_next_button() throws InterruptedException {
		Thread.sleep(3000);
		click(pom.getPatientRegistration().getNextButton());

	}

	@When("User Entering the Digital signature")
	public void user_entering_the_digital_signature() throws InterruptedException {
		Thread.sleep(3000);
		jsScrollIntoView(pom.getPatientRegistration().getDigitalSign2());
		WebElement sign = pom.getPatientRegistration().getDigitalSign2();
		Actions builder = new Actions(driver);
		builder.moveToElement(sign, 10, 10).clickAndHold().moveByOffset(20, 10).moveByOffset(20, 20)
				.moveByOffset(20, -10).release().build().perform();
	}

	@When("Click the Prev button to check the Patient Informations")
	public void click_the_prev_button_to_check_the_patient_informations() throws InterruptedException {
		Thread.sleep(3000);
		click(pom.getPatientRegistration().getPrevButton());
		patient_moved_to_next_form_tab_by_clicking_the_next_button();

	}

	@When("Click the Proceed to Pay to redirected to payment Page")
	public void click_the_proceed_to_pay_to_redirected_to_payment_page() throws InterruptedException {
		Thread.sleep(3000);
		click(pom.getPatientRegistration().getProceedToPayment());

	}

	@When("User Enter payment card details")
	public void user_enter_payment_card_details() throws InterruptedException {
		Thread.sleep(4000);
		click(pom.getPatientRegistration().getPayButton());
		Thread.sleep(1000);
		frameByIndex(0);
		Thread.sleep(3000);
		if (isDisplayed(pom.getPatientRegistration().getCardValidation())) {
			sendKeys(pom.getPatientRegistration().getCardNumber(), "4242424242424242");
		} else {
			System.out.println("card number already entered");
		}

		if (isDisplayed(pom.getPatientRegistration().getExpiryValidation())) {
			sendKeys(pom.getPatientRegistration().getExpiryNumber(), "1245");
		} else {
			System.out.println("Card Expiry date already entered");
		}

		if (isDisplayed(pom.getPatientRegistration().getCvcValidation())) {
			sendKeys(pom.getPatientRegistration().getCvcNumber(), "666");
		} else {
			System.out.println("Card CVC Number already entered");
		}

		if (isDisplayed(pom.getPatientRegistration().getCardZipcodeValidation())) {
			sendKeys(pom.getPatientRegistration().getPostalCode(), "23354");
		} else {
			System.out.println("Card Zipcode already entered");
		}

	}

	@When("User click the Pay button")
	public void user_click_the_pay_button() throws InterruptedException {
		backwardFrame("defaultContent");
		Thread.sleep(2000);
		click(pom.getPatientRegistration().getPayButton());

	}

	@Then("Patient should navigate the Payment Status page")
	public void patient_should_navigate_the_payment_status_page() throws InterruptedException, AWTException {
		click(pom.getPatientRegistration().getDownloadInvoice());
		Thread.sleep(4000);
		click(pom.getPatientRegistration().getDoneButton());
		Thread.sleep(4000);
		((JavascriptExecutor) driver).executeScript("window.close()");
		windowHandles(1);
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("window.close()");
		windowHandles(0);
		Thread.sleep(2000);
		sendKeys(pom.getLogin().getUsername(), "superadmin@cirque.com");
		Thread.sleep(2000);
		sendKeys(pom.getLogin().getPassword(), "Admin@123");
		Thread.sleep(2000);
		robot("Enter");
	}

	@Given("User navigated to Manage payment Menu")
	public void user_navigated_to_manage_payment_menu() throws InterruptedException, AWTException {
		Thread.sleep(1500);
		click(pom.getManagePayments().getManagepaymentsMenu());

	}

	@When("User click the Manage Payment Menu")
	public void user_click_the_manage_payment_menu() {
		String actualUrl = getCurrentURL();
		String expectedUrl = "https://cirque.sgssys.info/ManagePayments";
		assertEquals(actualUrl, expectedUrl);

		if (actualUrl.equals("https://cirque.sgssys.info/ManagePayments")) {
			System.out.println("User was navigated to Manage Payments Page");

		} else {
			System.err.println("User doesn't navigated to Manage Payments Page");
		}

	}

	@When("User pick the From date and To date from the Date Picker")
	public void user_pick_the_from_date_and_to_date_from_the_date_picker() throws InterruptedException {
		navigateRefresh();
		Thread.sleep(3000);
		webDriverWait(30, "visible", pom.getManagePayments().getFromDate());
		click(pom.getManagePayments().getFromDate());
		Thread.sleep(1500);
		click(pom.getManagePayments().getPreviousMonth());
		Thread.sleep(1500);
		click(pom.getManagePayments().getPreviousDate());
		Thread.sleep(1500);
	}

	@When("User filtering the Payment list by using Date Range filter")
	public void user_filtering_the_payment_list_by_using_date_range_filter() throws InterruptedException {
		Thread.sleep(2500);
		click(pom.getManagePayments().getToDate());
		Thread.sleep(1500);
		click(pom.getManagePayments().getDatePickOk());
		Thread.sleep(3000);
		click(pom.getManagePayments().getResetButton());
	}

	@When("User Click the Search button to filter the data")
	public void user_click_the_search_button_to_filter_the_data() throws InterruptedException {
		user_pick_the_from_date_and_to_date_from_the_date_picker();
		Thread.sleep(2500);
		click(pom.getManagePayments().getToDate());
		Thread.sleep(1500);
		click(pom.getManagePayments().getDatePickOk());
		Thread.sleep(3000);
		click(pom.getManagePayments().getSearchButton());
	}

	@When("User Click the Reset button to get all the datas")
	public void user_click_the_reset_button_to_get_all_the_datas() throws InterruptedException {
		Thread.sleep(3000);
		click(pom.getManagePayments().getResetButton());
		Thread.sleep(3000);
		user_pick_the_from_date_and_to_date_from_the_date_picker();
		Thread.sleep(3000);
		Thread.sleep(2500);
		click(pom.getManagePayments().getToDate());
		Thread.sleep(1500);
		click(pom.getManagePayments().getDatePickOk());
		Thread.sleep(2000);
		click(pom.getManagePayments().getSearchButton());

	}

	@When("User flitering the data by using Quick search options")
	public void user_flitering_the_data_by_using_quick_search_options() throws InterruptedException {
		Thread.sleep(2000);
		randomAlphabetics(pom.getManagePayments().getSearchWithLocation(), 1);
		if (isDisplayed(pom.getManagePayments().getNoRecord())) {
			clear(pom.getManagePayments().getSearchWithLocation());
			Thread.sleep(3000);
			sendKeys(pom.getManagePayments().getSearchWithLocation(), "Annur");
		} else {
			System.out.println("records are displayed");
		}

		Thread.sleep(2000);
		randomAlphabetics(pom.getManagePayments().getSearchWithLastName(), 3);
		if (isDisplayed(pom.getManagePayments().getNoRecord())) {
			clear(pom.getManagePayments().getSearchWithLastName());
			Thread.sleep(3000);
			sendKeys(pom.getManagePayments().getSearchWithLastName(), "OTph OTph");
		} else {
			clear(pom.getManagePayments().getSearchWithLastName());
			System.out.println("records are displayed");
		}

		Thread.sleep(2000);
		randomAlphabetics(pom.getManagePayments().getSearchWithFirstName(), 3);
		if (isDisplayed(pom.getManagePayments().getNoRecord())) {
			clear(pom.getManagePayments().getSearchWithFirstName());
			Thread.sleep(3000);
			sendKeys(pom.getManagePayments().getSearchWithFirstName(), "QIqEh QIqEh");
		} else {
			clear(pom.getManagePayments().getSearchWithFirstName());
			System.out.println("records are displayed");
		}

		Thread.sleep(2000);
		randomAlphabetics(pom.getManagePayments().getSearchWithProcedure(), 3);
		if (isDisplayed(pom.getManagePayments().getNoRecord())) {
			clear(pom.getManagePayments().getSearchWithProcedure());
			Thread.sleep(3000);
			sendKeys(pom.getManagePayments().getSearchWithProcedure(), "A0021 - Outside state ambulance serv");
		} else {
			clear(pom.getManagePayments().getSearchWithProcedure());
			System.out.println("records are displayed");
		}

		Thread.sleep(2000);
		randomNumeric(pom.getManagePayments().getSearchWithAmount(), 2);
		Thread.sleep(1500);
		if (isDisplayed(pom.getManagePayments().getNoRecord())) {
			clear(pom.getManagePayments().getSearchWithAmount());
			Thread.sleep(3000);
			sendKeys(pom.getManagePayments().getSearchWithAmount(), "19.20");
		} else {
			clear(pom.getManagePayments().getSearchWithAmount());
			System.out.println("records are displayed");
		}

		Thread.sleep(2000);
		randomNumeric(pom.getManagePayments().getSearchWithDate(), 3);
		if (isDisplayed(pom.getManagePayments().getNoRecord())) {
			clear(pom.getManagePayments().getSearchWithDate());
			Thread.sleep(3000);
			sendKeys(pom.getManagePayments().getSearchWithDate(), "11/25/2024");
		} else {
			clear(pom.getManagePayments().getSearchWithDate());
			System.out.println("records are displayed");
		}

		clear(pom.getManagePayments().getSearchWithLastName());
		Thread.sleep(1000);
		clear(pom.getManagePayments().getSearchWithFirstName());
		Thread.sleep(1000);
		clear(pom.getManagePayments().getSearchWithProcedure());
		Thread.sleep(1000);
		clear(pom.getManagePayments().getSearchWithAmount());
		Thread.sleep(1000);
		clear(pom.getManagePayments().getSearchWithDate());
		Thread.sleep(2000);

		randomAlphabetics(pom.getManagePayments().getSearchWithStatus(), 4);
		Thread.sleep(1500);
		if (isDisplayed(pom.getManagePayments().getNoRecord())) {
			clear(pom.getManagePayments().getSearchWithStatus());
			Thread.sleep(2500);
			sendKeys(pom.getManagePayments().getSearchWithStatus(), "Failed");
			Thread.sleep(2500);
			clear(pom.getManagePayments().getSearchWithStatus());
			Thread.sleep(2500);
			sendKeys(pom.getManagePayments().getSearchWithStatus(), "Pending");
			Thread.sleep(2500);
			clear(pom.getManagePayments().getSearchWithStatus());
			Thread.sleep(2500);
			sendKeys(pom.getManagePayments().getSearchWithStatus(), "Paid");
			Thread.sleep(2500);

		} else {
			System.out.println("Quick Search is not working as expected");
		}

	}

	@When("User Click the Payment receipt download icon")
	public void user_click_the_payment_receipt_download_icon() throws InterruptedException {
		Thread.sleep(2000);
		click(pom.getManagePayments().getReceiptDownload());
	}

	@Then("User Exporting the payment lists to Excel and PDF file")
	public void user_exporting_the_payment_lists_to_excel_and_pdf_file() throws InterruptedException {
		Thread.sleep(2000);
		click(pom.getManagePayments().getPdfDownload());
		Thread.sleep(2000);
		click(pom.getManagePayments().getExcelDownload());
	}

	@Given("User click Census List Menu to redirected to Census List Page")
	public void user_click_census_list_menu_to_redirected_to_census_list_page() throws InterruptedException {
		Thread.sleep(3000);
		click(pom.getCensusList().getCensusListMenu());
		Thread.sleep(2000);
		String actualUrl = getCurrentURL();
		String expectedUrl = "https://cirque.sgssys.info/CensusList";
		assertEquals(actualUrl, expectedUrl);

		if (actualUrl.equals("https://cirque.sgssys.info/CensusList")) {
			System.out.println("User was navigated to Census Lists Page");

		} else {
			System.err.println("User doesn't navigated to Census Lists Page");
		}

	}

	@When("User flitering the Pending Census data by using Quick search options")
	public void user_flitering_the_pending_census_data_by_using_quick_search_options() throws InterruptedException {
		Thread.sleep(2000);
		randomAlphabetics(pom.getCensusList().getSearchPendingLastName(), 1);
		if (isDisplayed(pom.getCensusList().getNoRecord())) {
			clear(pom.getCensusList().getSearchPendingLastName());
			Thread.sleep(3000);
			sendKeys(pom.getCensusList().getSearchPendingLastName(), "killer");
		} else {
			System.out.println("records are displayed");
		}

		Thread.sleep(2000);
		randomAlphabetics(pom.getCensusList().getSearchPendingFirstName(), 2);
		if (isDisplayed(pom.getCensusList().getNoRecord())) {
			clear(pom.getCensusList().getSearchPendingFirstName());
			Thread.sleep(3000);
			sendKeys(pom.getCensusList().getSearchPendingFirstName(), "kill");
		} else {
			System.out.println("records are displayed");
		}

		Thread.sleep(2000);
		randomAlphabetics(pom.getCensusList().getSearchPendingProcedure(), 4);
		if (isDisplayed(pom.getCensusList().getNoRecord())) {
			clear(pom.getCensusList().getSearchPendingProcedure());
			Thread.sleep(3000);
			sendKeys(pom.getCensusList().getSearchPendingProcedure(), "Mtms by pharm addl 15 min");
		} else {
			System.out.println("records are displayed");
		}

		Thread.sleep(2000);
		randomNumeric(pom.getCensusList().getSearchPendingTransactionDate(), 3);
		if (isDisplayed(pom.getCensusList().getNoRecord())) {
			clear(pom.getCensusList().getSearchPendingTransactionDate());
			Thread.sleep(3000);
			sendKeys(pom.getCensusList().getSearchPendingTransactionDate(), "10/09/2024");
		} else {
			clear(pom.getCensusList().getSearchPendingTransactionDate());
			System.out.println("records are displayed");
		}

		Thread.sleep(2000);
		sendKeys(pom.getCensusList().getSearchPendingStatus(), "Complete");
		Thread.sleep(2500);
		if (isDisplayed(pom.getCensusList().getNoRecord())) {
			clear(pom.getCensusList().getSearchPendingStatus());
			Thread.sleep(3000);
			sendKeys(pom.getCensusList().getSearchPendingStatus(), "Pending");
			Thread.sleep(3000);
			sendKeys(pom.getCensusList().getSearchPendingStatus(), "In-Progess");
		} else {
			clear(pom.getCensusList().getSearchPendingTransactionDate());
			System.out.println("records are displayed");
		}
		navigateRefresh();

	}

	@When("User click the Edit Status icon in the Grid list")
	public void user_click_the_edit_status_icon_in_the_grid_list() throws InterruptedException {
		Thread.sleep(3000);
		click(pom.getCensusList().getEditStatus());
		Thread.sleep(3500);
		click(pom.getCensusList().getUpdateButton());

	}

	@When("User change the Patient Status From the dropdown")
	public void user_change_the_patient_status_from_the_dropdown() throws InterruptedException {
		Thread.sleep(2000);
		if (getText(pom.getCensusList().getStatusValidation()).contains("Please select a status")) {
			select(pom.getCensusList().getPatientStatus(), "text", "In-Progress");
			Thread.sleep(2000);
			click(pom.getCensusList().getUpdateButton());
		} else {
			System.out.println("dropdown value is selected");

		}

	}

	@When("User click Update button to change the Patient Status")
	public void user_click_update_button_to_change_the_patient_status() throws InterruptedException {

		Thread.sleep(2000);
		if (getText(pom.getCensusList().getStatusText()).equals("In-Progress")) {
			click(pom.getCensusList().getEditStatus());
			Thread.sleep(1500);
			select(pom.getCensusList().getPatientStatus(), "text", "Completed");
			Thread.sleep(1000);
			click(pom.getCensusList().getUpdateButton());
		} else {
			System.out.println("Patient Census has been Completed");
		}
	}

	@When("User check the Changed Patient data moved to completed Grid list")
	public void user_check_the_changed_patient_data_moved_to_completed_grid_list() throws InterruptedException {
		Thread.sleep(2000);
		click(pom.getCensusList().getNavigateCompleted());

	}

	@When("User flitering the Completed Census data by using Quick search options")
	public void user_flitering_the_completed_census_data_by_using_quick_search_options() throws InterruptedException {
		Thread.sleep(2000);
		randomAlphabetics(pom.getCensusList().getSearchCompletedLastName(), 5);
		if (isDisplayed(pom.getCensusList().getNoRecord())) {
			clear(pom.getCensusList().getSearchCompletedLastName());
			Thread.sleep(3000);
			sendKeys(pom.getCensusList().getSearchCompletedLastName(), "testing");
		} else {
			System.out.println("records are displayed");
		}

		Thread.sleep(2000);
		randomAlphabetics(pom.getCensusList().getSearchCompletedFirstName(), 5);
		if (isDisplayed(pom.getCensusList().getNoRecord())) {
			clear(pom.getCensusList().getSearchCompletedFirstName());
			Thread.sleep(3000);
			sendKeys(pom.getCensusList().getSearchCompletedFirstName(), "edit");
		} else {
			System.out.println("records are displayed");
		}

		Thread.sleep(2000);
		randomAlphabetics(pom.getCensusList().getSearchCompletedProcedure(), 4);
		if (isDisplayed(pom.getCensusList().getNoRecord())) {
			clear(pom.getCensusList().getSearchCompletedProcedure());
			Thread.sleep(3000);
			sendKeys(pom.getCensusList().getSearchCompletedProcedure(), "Interest escort in non");
		} else {
			System.out.println("records are displayed");
		}

		Thread.sleep(2000);
		randomNumeric(pom.getCensusList().getSearchCompletedTransactionDate(), 5);
		if (isDisplayed(pom.getCensusList().getNoRecord())) {
			clear(pom.getCensusList().getSearchCompletedTransactionDate());
			Thread.sleep(3000);
			sendKeys(pom.getCensusList().getSearchCompletedTransactionDate(), "11/20/2024");
		} else {
			clear(pom.getCensusList().getSearchCompletedTransactionDate());
			System.out.println("records are displayed");
		}

		Thread.sleep(2000);
		sendKeys(pom.getCensusList().getSearchCompletedStatus(), "Pending");
		Thread.sleep(2000);
		clear(pom.getCensusList().getSearchCompletedStatus());
		Thread.sleep(3000);
		sendKeys(pom.getCensusList().getSearchCompletedStatus(), "In-Progess");
		Thread.sleep(3000);
		if (isDisplayed(pom.getCensusList().getNoRecord())) {
			clear(pom.getCensusList().getSearchCompletedStatus());
			Thread.sleep(3000);
			sendKeys(pom.getCensusList().getSearchCompletedStatus(), "Completed");
		} else {
			System.out.println("records are displayed");
		}

	}

	@Then("User Exporting the Census lists to Excel and PDF file")
	public void user_exporting_the_census_lists_to_excel_and_pdf_file() throws InterruptedException {
		Thread.sleep(2000);
		click(pom.getCensusList().getCompletedPDFDownload());
		Thread.sleep(2000);
		click(pom.getCensusList().getCompletedExcelDownload());
		Thread.sleep(2000);
		click(pom.getCensusList().getNavigatePending());
		Thread.sleep(4000);
		click(pom.getCensusList().getPendingPDFDownload());
		Thread.sleep(2000);
		click(pom.getCensusList().getPendingExcelDownload());
	}

	@Given("User click Settings menu to redirected to Change Password Page")
	public void user_click_settings_menu_to_redirected_to_change_password_page() throws InterruptedException {
		Thread.sleep(3000);
		click(pom.getChangePassword().getSettings());
		Thread.sleep(2000);
		String actualUrl = getCurrentURL();
		String expectedUrl = "https://cirque.sgssys.info/ChangePassword";
		assertEquals(actualUrl, expectedUrl);

		if (actualUrl.equals("https://cirque.sgssys.info/ChangePassword")) {
			System.out.println("User was navigated to Change Password Page");

		} else {
			System.err.println("User doesn't navigated to Change Password Page");
		}

	}

	@When("User click entering Old Password into Old Password field")
	public void user_click_entering_old_password_into_old_password_field() throws InterruptedException {

		click(pom.getChangePassword().getChangePasswordButton());
		webDriverWait(30, "visible", pom.getChangePassword().getCommonValidation());
		if (getText(pom.getChangePassword().getCommonValidation())
				.contains("Please fill in the " + "required missing fields")) {
			Thread.sleep(6000);
			click(pom.getChangePassword().getShowOldPassword());
			sendKeys(pom.getChangePassword().getOldPassword(), "Admin");
			click(pom.getChangePassword().getHideOldPassword());
			webDriverWait(30, "visible", pom.getChangePassword().getOldPasswordToaster());
			if (getText(pom.getChangePassword().getOldPasswordToaster()).contains("Old Password is incorrect")) {
				Thread.sleep(2000);
				sendKeys(pom.getChangePassword().getOldPassword(), "@123");
				Thread.sleep(1500);
			} else {
				System.err.println("Incorrect old password was accepted");
			}

		} else {
			System.err.println("old password field is not thrown validation error message");
		}

	}

	@When("User entering the New Password into New Password Field")
	public void user_entering_the_new_password_into_new_password_field() throws InterruptedException {
		randomAlphabetics(pom.getChangePassword().getNewPassword(), 3);
		Thread.sleep(2500);
		click(pom.getChangePassword().getShowNewPassword());
		Thread.sleep(2000);
		webDriverWait(30, "visible", pom.getChangePassword().getNewPasswordValidation());
		if (getText(pom.getChangePassword().getNewPasswordValidation())
				.contains("Password must contain 8 characters")) {
			clear(pom.getChangePassword().getNewPassword());
			Thread.sleep(2500);
			sendKeys(pom.getChangePassword().getNewPassword(),"Test@123".trim());
		} else {
			System.err.println("New Password field validation is not displayed");
		}
		Thread.sleep(2000);
		click(pom.getChangePassword().getChangePasswordButton());

	}

	@When("User entering the Confirm New Password into Confirm New Password Field")
	public void user_entering_the_confirm_new_password_into_confirm_new_password_field() throws InterruptedException {
		webDriverWait(30, "visible", pom.getChangePassword().getOldPasswordToaster());
		if (getText(pom.getChangePassword().getCommonValidation())
				.contains("Please fill in the required missing fields")) {
			randomAlphabetics(pom.getChangePassword().getConfirmNewPassword(), 4);
			Thread.sleep(2500);
			click(pom.getChangePassword().getShowConfirmPassword());
			Thread.sleep(6000);
			click(pom.getChangePassword().getChangePasswordButton());
		}

	}

	@When("User check the New and Confirm New Password field with invalid input")
	public void user_check_the_new_and_confirm_new_password_field_with_invalid_input() throws InterruptedException {

		webDriverWait(30, "visible", pom.getChangePassword().getCommonValidation());
		if (getText(pom.getChangePassword().getCommonValidation())
				.contains("The new password and the confirm new password")) {
			clear(pom.getChangePassword().getConfirmNewPassword());
			Thread.sleep(2500);
			sendKeys(pom.getChangePassword().getConfirmNewPassword(), "Test@123");
		} else {
			System.out.println("Confirmation password toaster is successfully thrown");
			clear(pom.getChangePassword().getConfirmNewPassword());
			Thread.sleep(2500);
			sendKeys(pom.getChangePassword().getConfirmNewPassword(), "Test@123");
		}
		Thread.sleep(2000);
		click(pom.getChangePassword().getChangePasswordButton());

	}

	@When("User check the New and Confirm New Password field with valid input")
	public void user_check_the_new_and_confirm_new_password_field_with_valid_input() throws InterruptedException {
		Thread.sleep(3000);
		click(pom.getChangePassword().getPopupNoButton());
		Thread.sleep(3000);
		click(pom.getChangePassword().getChangePasswordButton());

	}

	@When("User check the Confirmation Popup is presented")
	public void user_check_the_confirmation_popup_is_presented() throws InterruptedException {
		Thread.sleep(3000);
		click(pom.getChangePassword().getPopupYesButton());
		Thread.sleep(3000);
		if(getText(pom.getChangePassword().getOldPasswordToaster()).contains("Old Password is incorrect")) {
			Thread.sleep(3000);
			click(pom.getChangePassword().getChangePasswordButton());
			Thread.sleep(2500);
			click(pom.getChangePassword().getPopupYesButton());
			Thread.sleep(2500);
		}

	}

	@When("User check the successfully logged out from the Application after click the ok button")
	public void user_check_the_successfully_logged_out_from_the_application_after_click_the_ok_button() {
		String actualUrl = getCurrentURL();
		String expectedUrl = "https://cirque.sgssys.info/login";
		assertEquals(actualUrl, expectedUrl);

		if (actualUrl.equals("https://cirque.sgssys.info/login")) {
			System.out.println("User was navigated to Login Page");

		} else {
			System.err.println("User doesn't navigated to Login Page");
		}

	}

	@When("User verify the Login with old password")
	public void user_verify_the_login_with_old_password() throws InterruptedException {
		Thread.sleep(2500);
		sendKeys(pom.getLogin().getUsername(), "superadmin@cirque.com");
		Thread.sleep(3000);
		sendKeys(pom.getLogin().getPassword(), "Admin@123");
		Thread.sleep(2000);
		click(pom.getLogin().getSignIn());

	}

	@When("User verify the login with newly changed Password")
	public void user_verify_the_login_with_newly_changed_password() throws InterruptedException, AWTException {
		Thread.sleep(2500);
		if (getText(pom.getLogin().getPageLevelValiidation()).equals("Email / Password is invalid")) {
			Thread.sleep(2500);
			clear(pom.getLogin().getPassword());
			Thread.sleep(3000);
			click(pom.getLogin().getViewIcon());
			Thread.sleep(1500);
			sendKeys(pom.getLogin().getPassword(), "Test@123");
			robot("enter");

		} else {
			System.err.println("Old Password was accepted");
		}
	}

	@Then("User should be logged in to Application")
	public void user_should_be_logged_in_to_application() throws InterruptedException {
		Thread.sleep(2000);
		click(pom.getChangePassword().getSettings());
		Thread.sleep(2500);
		sendKeys(pom.getChangePassword().getOldPassword(), "Test@123");
		click(pom.getChangePassword().getShowOldPassword());
		Thread.sleep(2000);
		sendKeys(pom.getChangePassword().getNewPassword(), "Admin@123");
		click(pom.getChangePassword().getShowNewPassword());
		Thread.sleep(2000);
		sendKeys(pom.getChangePassword().getConfirmNewPassword(), "Admin@123");
		click(pom.getChangePassword().getShowConfirmPassword());
		Thread.sleep(2000);
		click(pom.getChangePassword().getChangePasswordButton());
		Thread.sleep(2000);
		click(pom.getChangePassword().getPopupYesButton());
	
	}
	
	
}
