package com.pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountManagerMenu {
	
	public static WebDriver driver;
	
	@FindBy(xpath ="//li[@title=\"Account Manager\"]")
	private WebElement accountManager;
	
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
	
	@FindBy(xpath="(//input[@type=\"radio\"])[1]")
	private WebElement flatRadio;
	
	@FindBy(name="FlatAmount")
	private WebElement flatAmount;
	
	@FindBy(xpath="(//input[@type=\"radio\"])[2]")
	private WebElement percentageRadio;
	
	@FindBy(name="Percentage")
	private WebElement Percentage;
	
	@FindBy(xpath="(//input[@type=\"radio\"])[3]")
	private WebElement bothRadio;
	
	@FindBy(name="BothFlatAmount")
	private WebElement FlatBoth;
	
	@FindBy(name="BothPercentage")
	private WebElement PercentageBoth;
	
	@FindBy(xpath="(//input[@type=\"radio\"])[4]")
	private WebElement otherRadio;
	
	@FindBy(name="Other")
	private WebElement otherValue;
	
	@FindBy(id="flexSwitchCheckDefault")
	private WebElement activeCheckbox;
	
	@FindBy(xpath="(//button[.=\"Add\"])[2]")
	private WebElement addAccountManager;
	
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
	
	@FindBy(xpath="/html/body/div[1]/div/div[5]/div/div[2]/div[2]/div/table/thead/tr/th[3]/div/input")
	private WebElement searchWithPhone;
	
	@FindBy(xpath="/html/body/div[1]/div/div[5]/div/div[2]/div[2]/div/table/thead/tr/th[4]/div/input")
	private WebElement searchWithEmail;
	
	@FindBy(xpath="//td[@class=\"norecordfound\"]")
	private WebElement noRecords;
	
	@FindBy(xpath="//*[.=\"Excel\"]")
	private WebElement excelDownload;
	
	@FindBy(xpath="//*[.='PDF']")
	private WebElement pdfDownload;
	
	@FindBy(xpath="//*[@id=\"main-wrapper\"]/div[5]/div/div[1]/div")
	private WebElement emailToaster;
	
	public WebElement getEmailToaster() {
		return emailToaster;
	}

	public WebElement getExcelDownload() {
		return excelDownload;
	}

	public WebElement getPdfDownload() {
		return pdfDownload;
	}
	
	@FindBy(xpath="//*[@id=\"main-wrapper\"]/div[5]/div/div[2]/div[2]/div/table/tbody/tr/td[7]/div/a/i")
	private WebElement editAccountManager;
	
	@FindBy(xpath="//button[.=\"Update\"]")
	private WebElement updateAccountManager;
	
	public WebElement getUpdateAccountManager() {
		return updateAccountManager;
	}

	public WebElement getAccountManager() {
		return accountManager;
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
	
	public WebElement getFlatRadio() {
		return flatRadio;
	}

	public WebElement getFlatAmount() {
		return flatAmount;
	}
	public WebElement getPercentage() {
		return Percentage;
	}

	public WebElement getFlatBoth() {
		return FlatBoth;
	}

	public WebElement getPercentageBoth() {
		return PercentageBoth;
	}

	public WebElement getPercentageRadio() {
		return percentageRadio;
	}

	public WebElement getBothRadio() {
		return bothRadio;
	}

	public WebElement getOtherRadio() {
		return otherRadio;
	}
	
	public WebElement getOtherValue() {
		return otherValue;
	}

	public WebElement getActiveCheckbox() {
		return activeCheckbox;
	}

	public WebElement getAddAccountManager() {
		return addAccountManager;
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

	public WebElement getEditAccountManager() {
		return editAccountManager;
	}
	
	public AccountManagerMenu(WebDriver driver1) {
		driver = driver1;
		PageFactory.initElements(driver, this);
	}
	
	
}
