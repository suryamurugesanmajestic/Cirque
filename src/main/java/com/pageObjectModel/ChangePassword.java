package com.pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePassword {
	
	public static WebDriver driver;
	
	@FindBy(xpath="//a[@title='Settings']")
	private WebElement settings;
	
	@FindBy(xpath="//h5[@class='fa fa-exclamation-triangle text-white']")
	private WebElement oldPasswordToaster;
	
	@FindBy(xpath="//h5[@class='fa fa-exclamation-triangle text-white']")
	private WebElement commonValidation;
	
	@FindBy(name="CurrentPassword")
	private WebElement oldPassword;
	
	@FindBy(name="NewPassword")
	private WebElement newPassword;
	
	@FindBy(name="ConfirmPassword")
	private WebElement confirmNewPassword;
	
	@FindBy(xpath="//button[.='Change Password']")
	private WebElement changePasswordButton;
	
	@FindBy(xpath="(//i[@title=\"Show password\"])[1]")
	private WebElement showOldPassword;
	
	@FindBy(xpath="(//i[@title=\"Show password\"])[2]")
	private WebElement showNewPassword;
	
	@FindBy(xpath="(//span[@class='input-group-text togglePassword'])[3]")
	private WebElement showConfirmPassword;
	
	@FindBy(xpath="(//i[@title=\"Hide password\"])[1]")
	private WebElement hideOldPassword;
	
	@FindBy(xpath="(//i[@title=\"Hide password\"])[2]")
	private WebElement hideNewPassword;
	
	@FindBy(xpath="(//i[@title=\"Hide password\"])[3]")
	private WebElement hideConfirmPassword;
	
	@FindBy(xpath="(//div[@class=\"swal-button-container\"])[1]")
	private WebElement popupNoButton;
	
	@FindBy(xpath="(//div[@class=\"swal-button-container\"])[2]")
	private WebElement popupYesButton;
	
	@FindBy(xpath="//span[@class='validation-text text-danger']")
	private WebElement newPasswordValidation;
	
	public WebElement getNewPasswordValidation() {
		return newPasswordValidation;
	}
	
	public WebElement getSettings() {
		return settings;
	}
	
	public WebElement getOldPasswordToaster() {
		return oldPasswordToaster;
	}
	
	public WebElement getCommonValidation() {
		return commonValidation;
	}
	
	
	public WebElement getOldPassword() {
		return oldPassword;
	}

	public WebElement getNewPassword() {
		return newPassword;
	}

	public WebElement getConfirmNewPassword() {
		return confirmNewPassword;
	}

	public WebElement getChangePasswordButton() {
		return changePasswordButton;
	}

	public WebElement getShowOldPassword() {
		return showOldPassword;
	}

	public WebElement getShowNewPassword() {
		return showNewPassword;
	}

	public WebElement getShowConfirmPassword() {
		return showConfirmPassword;
	}

	public WebElement getHideOldPassword() {
		return hideOldPassword;
	}

	public WebElement getHideNewPassword() {
		return hideNewPassword;
	}

	public WebElement getHideConfirmPassword() {
		return hideConfirmPassword;
	}

	public WebElement getPopupNoButton() {
		return popupNoButton;
	}

	public WebElement getPopupYesButton() {
		return popupYesButton;
	}

	public ChangePassword (WebDriver driver1) {
		driver = driver1;
		PageFactory.initElements(driver, this);
	}
	
	
}
