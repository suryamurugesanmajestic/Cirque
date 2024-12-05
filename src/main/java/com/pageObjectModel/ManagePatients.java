package com.pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagePatients {
	
	public static WebDriver driver;
	
	@FindBy(xpath="//span[.=\"Manage Patients\"]")
	private WebElement managePatientMenu;
	
	@FindBy(xpath ="//*[.=\"Add\"]")
	private WebElement addButton;
	
	@FindBy(xpath="//*[.=\"Excel\"]")
	private WebElement excelDownload;
	
	@FindBy(xpath="//*[.=\"PDF\"]")
	private WebElement pdfDownload;
	
	@FindBy(xpath="(//div[@class=\" css-2b097c-container\"])[1]")
	private WebElement serviceLocation;
	
	@FindBy(xpath="(//div[@class=\" css-2b097c-container\"])[2]")
	private WebElement providerName;
	
	@FindBy(xpath="(//div[@class=\" css-2b097c-container\"])[3]")
	private WebElement accountManagerName;
	
	@FindBy(xpath="(//div[@class=\" css-2b097c-container\"])[4]")
	private WebElement procedureName;
	
	@FindBy(xpath="/html/body/div[6]/div/div/div[2]/form/div/div[9]/div/div/div/div[1]")
	private WebElement procedureName1;
	
	@FindBy(xpath="//input[@name=\"LastName\"]")
	private WebElement lastName;
	
	@FindBy(xpath="//input[@name=\"FirstName\"]")
	private WebElement firstName;
	
	@FindBy(name="PhoneNumber")
	private WebElement phoneNumber;
	
	@FindBy(name="Email")
	private WebElement email;
	
	@FindBy(name="DateOfBirth")
	private WebElement dateOfBirth;
	
	@FindBy(xpath="//button[.=\"Share Link\"]")
	private WebElement shareLink;
	
	@FindBy(xpath="(//input[@type=\"radio\"])[1]")
	private WebElement textRadioButton;
	
	@FindBy(xpath="(//input[@name=\"PreferenceType\"])[2]")
	private WebElement emailRadioButton;
	
	@FindBy(xpath="//button[@class=\"btn-close btn\"]")
	private WebElement popupCloseIcon;
	
	@FindBy(xpath="(//div[@class=\"swal-button-container\"])[1]")
	private WebElement popupNoButton;
	
	@FindBy(xpath="(//div[@class=\"swal-button-container\"])[2]")
	private WebElement popupYesButton;
	
	@FindBy(xpath="//*[@id=\"main-wrapper\"]/div[5]/div/div[2]/div[2]/div/table/thead/tr/th[1]/div/input")
	private WebElement searchWithLocation;
	
	@FindBy(xpath="//*[@id=\"main-wrapper\"]/div[5]/div/div[2]/div[2]/div/table/thead/tr/th[2]/div/input")
	private WebElement searchWithLastName;
	
	@FindBy(xpath="//*[@id=\"main-wrapper\"]/div[5]/div/div[2]/div[2]/div/table/thead/tr/th[3]/div/input")
	private WebElement searchWithFirstName;
	
	@FindBy(xpath="/html/body/div[1]/div/div[5]/div/div[2]/div[2]/div/table/thead/tr/th[4]/div/input")
	private WebElement searchWithPhone;
	
	@FindBy(xpath="//*[@id=\"main-wrapper\"]/div[5]/div/div[2]/div[2]/div/table/thead/tr/th[5]/div/input")
	private WebElement searchWithEmail;
	
	@FindBy(xpath="//td[@class=\"norecordfound\"]")
	private WebElement noRecords;
	
	@FindBy(xpath="//*[@id=\"main-wrapper\"]/div[5]/div/div[2]/div[2]/div/table/tbody/tr[1]/td[8]/div/a[1]/i")
	private WebElement editPatient;
	
	@FindBy(xpath="//*[@id=\"main-wrapper\"]/div[5]/div/div[2]/div[2]/div/table/tbody/tr[1]/td[8]/div/a[2]/i")
	private WebElement viewPatient;
	
	@FindBy(xpath="(//span[@class=\"validation-text text-danger\"])[1]")
	private WebElement serviceValidation;
	
	@FindBy(xpath="(//span[@class=\"validation-text text-danger\"])[7]")
	private WebElement phoneValidation;
	
	@FindBy(xpath="(//span[@class=\"validation-text text-danger\"])[8]")
	private WebElement emailValidation;
	
	@FindBy(xpath="//span[.=\"OK\"]")
	private WebElement datePickOk;
		
	@FindBy(id="login")
	private WebElement yopEmail;
	
	@FindBy(xpath="(//iframe)[1]")
	private WebElement inboxList;
	
	@FindBy(xpath="(//div[@class=\"lmfd\"])[1]")
	private WebElement mail;
	
	@FindBy(id="refresh")
	private WebElement refresh;
	
	@FindBy(xpath="(//iframe)[3]")
	private WebElement mailContent;
	
	@FindBy(xpath="//a[.=\"Register Now\"]")
	private WebElement registerNow;
	
	@FindBy(xpath="//*[@id=\"icon-logout\"]")
	private WebElement logout;
	
	public WebElement getLogout() {
		return logout;
	}
	
	public WebElement getYopEmail() {
		return yopEmail;
	}
	
    public WebElement getInboxList() {
		return inboxList;
	}

	public WebElement getMail() {
		return mail;
	}

	public WebElement getRefresh() {
		return refresh;
	}

	public WebElement getMailContent() {
		return mailContent;
	}

	public WebElement getRegisterNow() {
		return registerNow;
	}

	public WebElement getDatePickOk() {
    	return datePickOk;
    }
    
	public WebElement getServiceValidation() {
		return serviceValidation;
	}
	
	
	public WebElement getPhoneValidation() {
		return phoneValidation;
	}

	public WebElement getEmailValidation() {
		return emailValidation;
	}
	
	
	public WebElement getManagePatientMenu() {
		return managePatientMenu;
	}

	public WebElement getAddButton() {
		return addButton;
	}

	public WebElement getExcelDownload() {
		return excelDownload;
	}

	public WebElement getPdfDownload() {
		return pdfDownload;
	}

	public WebElement getServiceLocation() {
		return serviceLocation;
	}

	public WebElement getProviderName() {
		return providerName;
	}

	public WebElement getAccountManagerName() {
		return accountManagerName;
	}

	public WebElement getProcedureName() {
		return procedureName;
	}
	
	public WebElement getProcedureName1() {
		return procedureName1;
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
	
	public WebElement getDateOfBirth() {
		return dateOfBirth;
	}

	public WebElement getShareLink() {
		return shareLink;
	}

	public WebElement getTextRadioButton() {
		return textRadioButton;
	}

	public WebElement getEmailRadioButton() {
		return emailRadioButton;
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

	public WebElement getSearchWithLocation() {
		return searchWithLocation;
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

	public WebElement getEditPatient() {
		return editPatient;
	}

	public WebElement getViewPatient() {
		return viewPatient;
	}

	public ManagePatients(WebDriver driver1) {
		driver = driver1;
		PageFactory.initElements(driver, this);
	}

}
