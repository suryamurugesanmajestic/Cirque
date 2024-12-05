package com.pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageProviders {
	
	public static WebDriver driver;
	
	@FindBy(xpath="//span[.=\"Manage Providers\"]")
	private WebElement manageProvidersMenu;
	
	@FindBy(xpath ="//*[.=\"Add\"]")
	private WebElement addButton;
	
	@FindBy(xpath="//input[@name=\"LastName\"]")
	private WebElement lastName;
	
	@FindBy(xpath="//input[@name=\"FirstName\"]")
	private WebElement firstName;
	
	@FindBy(name="PhoneNumber")
	private WebElement phoneNumber;
	
	@FindBy(name="Email")
	private WebElement email;
	
	@FindBy(xpath="(//*[@class=\" css-2b097c-container\"])[1]")
	private WebElement suffix;
	
	@FindBy(xpath="(//*[@class=\" css-2b097c-container\"])[2]")
	private WebElement state;
	
	@FindBy(name="MedicalLicenseNumber")
	private WebElement medicalLicense;
	
	@FindBy(name="NPI")
	private WebElement NPI;
	
	@FindBy(xpath="(//*[@class=\" css-2b097c-container\"])[3]")
	private WebElement accountManager;
	
	@FindBy(xpath="(//button[.=\"Add\"])[2]")
	private WebElement addProvider;
	
	@FindBy(id="flexSwitchCheckDefault")
	private WebElement activeCheckbox;	

	@FindBy(xpath="//button[@class=\"btn-close btn\"]")
	private WebElement popupCloseIcon;
	
	@FindBy(xpath="(//div[@class=\"swal-button-container\"])[1]")
	private WebElement popupNoButton;
	
	@FindBy(xpath="(//div[@class=\"swal-button-container\"])[2]")
	private WebElement popupYesButton;
	
	@FindBy(xpath="//*[@id=\"main-wrapper\"]/div[5]/div/div[2]/div[2]/div/table/thead/tr/th[1]/div/input")
	private WebElement searchWithLastName;
	
	@FindBy(xpath="//*[@id=\"main-wrapper\"]/div[5]/div/div[2]/div[2]/div/table/thead/tr/th[2]/div/input")
	private WebElement searchWithFirstName;
	
	@FindBy(xpath="//*[@id=\"main-wrapper\"]/div[5]/div/div[2]/div[2]/div/table/thead/tr/th[3]/div/input")
	private WebElement searchWithPhone;
	
	@FindBy(xpath="//*[@id=\"main-wrapper\"]/div[5]/div/div[2]/div[2]/div/table/thead/tr/th[4]/div/input")
	private WebElement searchWithEmail;
	
	@FindBy(xpath="//td[@class=\"norecordfound\"]")
	private WebElement noRecords;
	
	@FindBy(xpath="//*[.=\"Excel\"]")
	private WebElement excelDownload;
	
	@FindBy(xpath="//*[.=\"PDF\"]")
	private WebElement pdfDownload;
	
	@FindBy(xpath="//*[@id=\"main-wrapper\"]/div[5]/div/div[1]/div")
	private WebElement emailToaster;
	
	@FindBy(xpath="(//span[@class=\"validation-text text-danger\"])[3]")
	private WebElement phoneValidation;
	
	@FindBy(xpath="(//span[@class=\"validation-text text-danger\"])[4]")
	private WebElement emailValidation;
	
	@FindBy(xpath="//*[@id=\"main-wrapper\"]/div[5]/div/div[2]/div[2]/div/table/tbody/tr[1]/td[6]/div/a/i")
	private WebElement editProvider;
	
	@FindBy(xpath="//button[.=\"Update\"]")
	private WebElement updateProvider;
	
	public WebElement getUpdateProvider() {
		return updateProvider;
	}
	
	public WebElement getEditProvider() {
		return editProvider;
	}
	
	public WebElement getManageProvidersMenu() {
		return manageProvidersMenu;
	}
	
	public WebElement getAddButton() {
		return addButton;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getPhoneNumber() {
		return phoneNumber;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getSuffix() {
		return suffix;
	}

	public WebElement getState() {
		return state;
	}

	public WebElement getMedicalLicense() {
		return medicalLicense;
	}

	public WebElement getNPI() {
		return NPI;
	}

	public WebElement getAccountManager() {
		return accountManager;
	}

	public WebElement getAddProvider() {
		return addProvider;
	}

	public WebElement getActiveCheckbox() {
		return activeCheckbox;
	}

	public WebElement getPopupCloseIcon() {
		return popupCloseIcon;
	}

	public WebElement getPopupNoButton() {
		return popupNoButton;
	}

	public WebElement getPopupYesButton() {
		return popupYesButton;
	}

	public WebElement getSearchWithLastName() {
		return searchWithLastName;
	}

	public WebElement getSearchWithFirstName() {
		return searchWithFirstName;
	}

	public WebElement getSearchWithPhone() {
		return searchWithPhone;
	}

	public WebElement getSearchWithEmail() {
		return searchWithEmail;
	}

	public WebElement getNoRecords() {
		return noRecords;
	}

	public WebElement getExcelDownload() {
		return excelDownload;
	}

	public WebElement getPdfDownload() {
		return pdfDownload;
	}

	public WebElement getEmailToaster() {
		return emailToaster;
	}

	public WebElement getPhoneValidation() {
		return phoneValidation;
	}

	public WebElement getEmailValidation() {
		return emailValidation;
	}

	public ManageProviders(WebDriver driver1) {
		driver = driver1;
		PageFactory.initElements(driver, this);
	}

}
