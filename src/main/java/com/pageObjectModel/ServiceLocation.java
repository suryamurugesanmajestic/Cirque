package com.pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ServiceLocation {
	
	public static WebDriver driver;
	
	@FindBy(xpath="//span[@title=\"Service Location\"]")
	private WebElement serviceLocationMenu;
	
	@FindBy(xpath ="//*[.=\"Add\"]")
	private WebElement addButton;
	
	@FindBy(name="LocationName")
	private WebElement locationName;
	
	@FindBy(name="Address1")
	private WebElement locationAddress1;
	
	@FindBy(name="Address2")
	private WebElement locationAddress2;
	
	@FindBy(name="City")
	private WebElement city;
	
	@FindBy(xpath="(//div[@class=\" css-2b097c-container\"])[1]")
	private WebElement state;
	
	@FindBy(name="Zipcode")
	private WebElement zipCode;
	
	@FindBy(name="PhoneNumber")
	private WebElement phoneNumber;
	
	@FindBy(name="Email")
	private WebElement email;
	
	@FindBy(name="WebsiteURL")
	private WebElement websiteUrl;
	
	@FindBy(xpath="/html/body/div[6]/div/div/div[2]/form/div[5]/div[2]/div/div/div[1]/div[1]")
	//@FindBy(xpath="(//div[@class=\\\" css-2b097c-container\\\"])[2]")
	private WebElement accManagerDropdown;
	
	@FindBy(xpath="/html/body/div[6]/div/div/div[2]/form/div[6]/div[1]/div/div/div/div[1]/div[1]")
	//@FindBy(xpath="(//div[@class=\\\" css-2b097c-container\\\"])[3]")
	private WebElement procedure;
	
	@FindBy(xpath="//*[@class=\"custom_select_css__value-container css-1hwfws3\"]")
	private WebElement editProcedure;
	
	@FindBy(xpath="/html/body/div[6]/div/div/div[2]/form/div[6]/div[2]/div/input")
	private WebElement procedureFee;
	
	@FindBy(xpath="/html/body/div[5]/div/div/div[2]/form/div[6]/div[2]/div/input")
	private WebElement editProcedureFee;
	
	@FindBy(xpath="//input[@type=\"file\"]")
	private WebElement imgUpload;
	
	@FindBy(id="flexSwitchCheckDefault")
	private WebElement activeCheckbox;
	
	@FindBy(xpath="(//button[.=\"Add\"])[2]")
	private WebElement addServiceLocation;
	
	@FindBy(xpath="//button[.=\"Update\"]")
	private WebElement updateServiceLocation;
	
	@FindBy(xpath="/html/body/div[6]/div/div/div[2]/form/div[7]/div/div/div[1]/i")
	private WebElement procedureRemoveIcon;
	
	@FindBy(xpath="//span[@class=\"input-group-text\"]")
	private WebElement procedurePlusIcon;
	
	@FindBy(xpath="//button[@class=\"btn-close btn\"]")
	private WebElement popupCloseIcon;
	
	@FindBy(xpath="(//div[@class=\"swal-button-container\"])[1]")
	private WebElement popupNoButton;
	
	@FindBy(xpath="(//div[@class=\"swal-button-container\"])[2]")
	private WebElement popupYesButton;
	
	@FindBy(xpath="//*[.=\"Excel\"]")
	private WebElement excelDownload;
	
	@FindBy(xpath="//*[.=\"PDF\"]")
	private WebElement pdfDownload;
	
	@FindBy(xpath="//*[@id=\"main-wrapper\"]/div[5]/div/div[2]/div[2]/div/table/thead/tr/th[1]/div/input")
	private WebElement searchWithLocationName;
	
	@FindBy(xpath="//*[@id=\"main-wrapper\"]/div[5]/div/div[2]/div[2]/div/table/thead/tr/th[2]/div/input")
	private WebElement searchWithLocationAddress;
	
	@FindBy(xpath="//*[@id=\"main-wrapper\"]/div[5]/div/div[2]/div[2]/div/table/thead/tr/th[3]/div/input")
	private WebElement searchWithPhone;
	
	@FindBy(xpath="//*[@id=\"main-wrapper\"]/div[5]/div/div[2]/div[2]/div/table/thead/tr/th[4]/div/input")
	private WebElement searchWithWebsiteUrl;
	
	@FindBy(xpath="//*[@id=\"main-wrapper\"]/div[5]/div/div[2]/div[2]/div/table/tbody/tr[1]/td[6]/div/a/i")
	private WebElement editServiceLocation;
	
	@FindBy(xpath="(//span[@class=\"validation-text text-danger\"])[5]")
	private WebElement zipCodeValidation;
	
	@FindBy(xpath="(//span[@class=\"validation-text text-danger\"])[6]")
	private WebElement phoneValidation;
	
	@FindBy(xpath="(//span[@class=\"validation-text text-danger\"])[7]")
	private WebElement emailValidation;
	
	@FindBy(xpath="(//span[@class=\"validation-text text-danger\"])[8]")
	private WebElement websiteUrlValidation;
	
	@FindBy(xpath="//span[.=\"Please enter a valid Procedure and Procedure Fee\"]")
	private WebElement procedureValidation;
	
	@FindBy(xpath="/html/body/div[5]/div/div/div[2]/form/div[7]/div/div/div/i")
	private WebElement editProcedureRemoveIcon;
	
	public WebElement getEditProcedureRemoveIcon() {
		return editProcedureRemoveIcon;
	}
	
	public WebElement getProcedureValidation() {
		return procedureValidation;
	}
	

	public WebElement getEditProcedure() {
		return editProcedure;
	}

	public WebElement getEditProcedureFee() {
		return editProcedureFee;
	}

	public WebElement getServiceLocationMenu() {
		return serviceLocationMenu;
	}

	public WebElement getAddButton() {
		return addButton;
	}

	public WebElement getLocationName() {
		return locationName;
	}

	public WebElement getLocationAddress1() {
		return locationAddress1;
	}

	public WebElement getLocationAddress2() {
		return locationAddress2;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getState() {
		return state;
	}

	public WebElement getZipCode() {
		return zipCode;
	}

	public WebElement getPhoneNumber() {
		return phoneNumber;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getWebsiteUrl() {
		return websiteUrl;
	}

	public WebElement getAccManagerDropdown() {
		return accManagerDropdown;
	}

	public WebElement getProcedure() {
		return procedure;
	}

	public WebElement getProcedureFee() {
		return procedureFee;
	}

	public WebElement getImgUpload() {
		return imgUpload;
	}

	public WebElement getActiveCheckbox() {
		return activeCheckbox;
	}

	public WebElement getAddServiceLocation() {
		return addServiceLocation;
	}

	public WebElement getUpdateServiceLocation() {
		return updateServiceLocation;
	}

	public WebElement getProcedureRemoveIcon() {
		return procedureRemoveIcon;
	}

	public WebElement getProcedurePlusIcon() {
		return procedurePlusIcon;
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

	public WebElement getExcelDownload() {
		return excelDownload;
	}

	public WebElement getPdfDownload() {
		return pdfDownload;
	}

	public WebElement getSearchWithLocationName() {
		return searchWithLocationName;
	}

	public WebElement getSearchWithLocationAddress() {
		return searchWithLocationAddress;
	}

	public WebElement getSearchWithPhone() {
		return searchWithPhone;
	}

	public WebElement getSearchWithWebsiteUrl() {
		return searchWithWebsiteUrl;
	}

	public WebElement getEditServiceLocation() {
		return editServiceLocation;
	}
	public WebElement getZipCodeValidation() {
		return zipCodeValidation;
	}

	public WebElement getPhoneValidation() {
		return phoneValidation;
	}

	public WebElement getEmailValidation() {
		return emailValidation;
	}

	public WebElement getWebsiteUrlValidation() {
		return websiteUrlValidation;
	}

	public ServiceLocation(WebDriver driver1) {
		driver = driver1;
		PageFactory.initElements(driver, this);
	}

}
