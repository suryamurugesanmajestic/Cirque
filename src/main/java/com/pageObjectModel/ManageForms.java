package com.pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageForms {

	public static WebDriver driver;

	@FindBy(xpath = "//span[.=\"Manage Forms\"]")
	private WebElement manageFormsMenu;

	@FindBy(xpath = "(//a[@title=\"View\"])[1]")
	private WebElement standardFormView;

	@FindBy(xpath = "(//a[@title=\"View\"])[2]")
	private WebElement faithFormView;

	@FindBy(xpath = "(//a[@title=\"View\"])[3]")
	private WebElement advanceFormView;

	@FindBy(xpath = "(//a[@title=\"Edit\"])[1]")
	private WebElement standardFormEdit;

	@FindBy(xpath = "(//a[@title=\"Edit\"])[2]")
	private WebElement faithFormEdit;

	@FindBy(xpath = "(//a[@title=\"Edit\"])[3]")
	private WebElement advanceFormEdit;

	@FindBy(xpath = "(//a[@title=\"Assign Service Location\"])[1]")
	private WebElement standardFormAssign;

	@FindBy(xpath = "(//a[@title=\"Assign Service Location\"])[2]")
	private WebElement faithFormAssign;

	@FindBy(xpath = "(//a[@title=\"Assign Service Location\"])[3]")
	private WebElement advanceFormAssign;

	@FindBy(xpath = "/html/body/div[5]/div/div/div[2]/div/textarea[1]")
	private WebElement formHeading;

	@FindBy(xpath = "/html/body/div[5]/div/div/div[2]/div/div[1]/textarea[1]")
	private WebElement advanceHeading;

	public WebElement getAdvanceHeading() {
		return advanceHeading;
	}

	@FindBy(xpath = "/html/body/div[5]/div/div/div[2]/div/textarea[2]")
	private WebElement formPara;

	@FindBy(xpath = "//div[@class=\"modal-footer\"]/button[@type=\"button\"]")
	private WebElement updateButton;
	
	@FindBy(xpath = "/html/body/div[5]/div/div/div[3]/button")
	private WebElement faithUpdateButton;

	@FindBy(xpath = "//button[@class=\"btn-close btn\"]")
	private WebElement popupCloseIcon;

	@FindBy(xpath = "(//div[@class=\"swal-button-container\"])[1]")
	private WebElement popupNoButton;

	@FindBy(xpath = "(//div[@class=\"swal-button-container\"])[2]")
	private WebElement popupYesButton;

	@FindBy(xpath = "//*[@class=\" css-2b097c-container\"]")
	private WebElement serviceLocation;

	@FindBy(xpath = "//button[.=\"Assign\"]")
	private WebElement assignButton;

	public WebElement getManageFormsMenu() {
		return manageFormsMenu;
	}

	public WebElement getStandardFormView() {
		return standardFormView;
	}

	public WebElement getFaithFormView() {
		return faithFormView;
	}

	public WebElement getAdvanceFormView() {
		return advanceFormView;
	}

	public WebElement getStandardFormEdit() {
		return standardFormEdit;
	}

	public WebElement getFaithFormEdit() {
		return faithFormEdit;
	}

	public WebElement getAdvanceFormEdit() {
		return advanceFormEdit;
	}

	public WebElement getStandardFormAssign() {
		return standardFormAssign;
	}

	public WebElement getFaithFormAssign() {
		return faithFormAssign;
	}

	public WebElement getAdvanceFormAssign() {
		return advanceFormAssign;
	}

	public WebElement getFormHeading() {
		return formHeading;
	}

	public WebElement getFormPara() {
		return formPara;
	}

	public WebElement getUpdateButton() {
		return updateButton;
	}
	
	public WebElement getFaithUpdateButton() {
		return faithUpdateButton;
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

	public WebElement getServiceLocation() {
		return serviceLocation;
	}

	public WebElement getAssignButton() {
		return assignButton;
	}

	public ManageForms(WebDriver driver1) {
		driver = driver1;
		PageFactory.initElements(driver, this);
	}

}
