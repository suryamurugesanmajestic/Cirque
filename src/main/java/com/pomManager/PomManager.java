package com.pomManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.pageObjectModel.AccountManagerMenu;
import com.pageObjectModel.CensusList;
import com.pageObjectModel.ChangePassword;
import com.pageObjectModel.LoginPage;
import com.pageObjectModel.ManageForms;
import com.pageObjectModel.ManagePatients;
import com.pageObjectModel.ManagePayments;
import com.pageObjectModel.ManageProviders;
import com.pageObjectModel.PatientRegistration;
import com.pageObjectModel.ServiceLocation;

public class PomManager {

	public static WebDriver driver;

	private LoginPage login;
	private AccountManagerMenu accountManagerMenu;
	private ServiceLocation serviceLocation;
	private ManageForms manageForms;
	private ManageProviders manageProviders;
	private ManagePatients managePatients;
	private PatientRegistration patientRegistration;
	private ManagePayments managePayments;
	private CensusList censusList;
	private ChangePassword changePassword;

	public LoginPage getLogin() {
		if (login == null) {
			login = new LoginPage(driver);
		}
		return login;
	}

	public AccountManagerMenu getAccountManagerMenu() {
		if (accountManagerMenu == null) {
			accountManagerMenu = new AccountManagerMenu(driver);
		}
		return accountManagerMenu;
	}

	public ServiceLocation getServiceLocation() {
		if (serviceLocation == null) {
			serviceLocation = new ServiceLocation(driver);
		}
		return serviceLocation;
	}

	public ManageForms getManageForms() {
		if (manageForms == null) {
			manageForms = new ManageForms(driver);
		}
		return manageForms;
	}

	public ManageProviders getManageProvider() {
		if (manageProviders == null) {
			manageProviders = new ManageProviders(driver);
		}
		return manageProviders;
	}
	
	public ManagePatients getManagePatients() {
		if(managePatients == null) {
			managePatients = new ManagePatients(driver);
		}
		return managePatients;
	}
	
	public PatientRegistration getPatientRegistration() {
		if(patientRegistration == null) {
			patientRegistration = new PatientRegistration(driver);
		}
		return patientRegistration;
	}
	
	public ManagePayments getManagePayments() {
		if(managePayments == null) {
			managePayments = new ManagePayments(driver);
		}
		return managePayments;
	}
	
	public CensusList getCensusList() {
		if(censusList == null) {
			censusList = new CensusList(driver);
		}
		return censusList;
	}
	
	public ChangePassword getChangePassword() {
		if(changePassword == null) {
			changePassword = new ChangePassword(driver);
		}
		return changePassword;
	}
	
	public PomManager(WebDriver driver1) {
		driver = driver1;
		PageFactory.initElements(driver, this);
	}

}
