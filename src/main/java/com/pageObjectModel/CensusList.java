package com.pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CensusList {
	
	public static WebDriver driver;
	
	@FindBy(xpath="//span[.=\"Census List\"]")
	private WebElement censusListMenu;
	
	@FindBy(xpath="//a[.=\"Completed\"]")
	private WebElement navigateCompleted;
	
	@FindBy(xpath="//a[.=\"Pending\"]")
	private WebElement navigatePending;
	
	@FindBy(xpath="//*[@id=\"pending-procedure\"]/div/div[2]/div/table/thead/tr/th[1]/div/input")
	private WebElement searchPendingLastName;
	
	@FindBy(xpath="//*[@id=\"pending-procedure\"]/div/div[2]/div/table/thead/tr/th[2]/div/input")
	private WebElement searchPendingFirstName;
	
	@FindBy(xpath="//*[@id=\"pending-procedure\"]/div/div[2]/div/table/thead/tr/th[3]/div/input")
	private WebElement searchPendingProcedure;
	
	@FindBy(xpath="//*[@id=\"pending-procedure\"]/div/div[2]/div/table/thead/tr/th[4]/div/input")
	private WebElement searchPendingTransactionDate;
	
	@FindBy(xpath="//*[@id=\"pending-procedure\"]/div/div[2]/div/table/thead/tr/th[5]/div/input")
	private WebElement searchPendingStatus;
	
	@FindBy(xpath="//*[@id=\"procedure-completed\"]/div/div/div[2]/div/table/thead/tr/th[1]/div/input")
	private WebElement searchCompletedLastName;
	
	@FindBy(xpath="//*[@id=\"procedure-completed\"]/div/div/div[2]/div/table/thead/tr/th[2]/div/input")
	private WebElement searchCompletedFirstName;
	
	@FindBy(xpath="//*[@id=\"procedure-completed\"]/div/div/div[2]/div/table/thead/tr/th[3]/div/input")
	private WebElement searchCompletedProcedure;
	
	@FindBy(xpath="//*[@id=\"procedure-completed\"]/div/div/div[2]/div/table/thead/tr/th[4]/div/input")
	private WebElement searchCompletedTransactionDate;
	
	@FindBy(xpath="//*[@id=\"procedure-completed\"]/div/div/div[2]/div/table/thead/tr/th[5]/div/input")
	private WebElement searchCompletedStatus;
	
	@FindBy(xpath="(//a[@title=\"Edit\"])[1]")
	private WebElement editStatus;
	
	@FindBy(id="paymentStatus")
	private WebElement patientStatus;
	
	@FindBy(xpath="//button[@class=\"btn-close btn\"]")
	private WebElement popupClose;
	
	@FindBy(xpath="//button[.=\"Update\"]")
	private WebElement updateButton;
	
	@FindBy(xpath="//div[.=\"Please select a status.\"]")
	private WebElement statusValidation;
	
	@FindBy(xpath="(//*[.='Excel'])[1]")
	private WebElement pendingExcelDownload;
	
	@FindBy(xpath="(//*[.='PDF'])[1]")
	private WebElement pendingPDFDownload;
	
	@FindBy(xpath="(//*[.='Excel'])[2]")
	private WebElement completedExcelDownload;
	
	@FindBy(xpath="(//*[.='PDF'])[2]")
	private WebElement completedPDFDwnload;
	
	@FindBy(xpath="//span[.=\"No Records Found\"]")
	private WebElement noRecord;
	
	@FindBy(xpath="(//span[.=\"In-Progress\"])[1]")
	private WebElement statusText;
	
	public WebElement getStatusText() {
		return statusText;
	}
	
	public WebElement getNoRecord() {
		return noRecord;
	}
	
	public WebElement getCensusListMenu() {
		return censusListMenu;
	}

	public WebElement getNavigateCompleted() {
		return navigateCompleted;
	}

	public WebElement getNavigatePending() {
		return navigatePending;
	}

	public WebElement getSearchPendingLastName() {
		return searchPendingLastName;
	}

	public WebElement getSearchPendingFirstName() {
		return searchPendingFirstName;
	}

	public WebElement getSearchPendingProcedure() {
		return searchPendingProcedure;
	}

	public WebElement getSearchPendingTransactionDate() {
		return searchPendingTransactionDate;
	}

	public WebElement getSearchPendingStatus() {
		return searchPendingStatus;
	}

	public WebElement getSearchCompletedLastName() {
		return searchCompletedLastName;
	}

	public WebElement getSearchCompletedFirstName() {
		return searchCompletedFirstName;
	}

	public WebElement getSearchCompletedProcedure() {
		return searchCompletedProcedure;
	}

	public WebElement getSearchCompletedTransactionDate() {
		return searchCompletedTransactionDate;
	}

	public WebElement getSearchCompletedStatus() {
		return searchCompletedStatus;
	}

	public WebElement getEditStatus() {
		return editStatus;
	}

	public WebElement getPatientStatus() {
		return patientStatus;
	}

	public WebElement getPopupClose() {
		return popupClose;
	}

	public WebElement getUpdateButton() {
		return updateButton;
	}

	public WebElement getStatusValidation() {
		return statusValidation;
	}

	public WebElement getPendingExcelDownload() {
		return pendingExcelDownload;
	}

	public WebElement getPendingPDFDownload() {
		return pendingPDFDownload;
	}
	
	public WebElement getCompletedExcelDownload() {
		return completedExcelDownload;
	}

	public WebElement getCompletedPDFDownload() {
		return completedPDFDwnload;
	}

	public CensusList(WebDriver driver1) {
		driver = driver1;
		PageFactory.initElements(driver, this);
	}

}
