package com.pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagePayments {
	
	public static WebDriver driver;
	
	@FindBy(xpath="//a[@title=\"Manage Payments\"]")
	private WebElement managepaymentsMenu;
	
	@FindBy(xpath="//*[.=\"Excel\"]")
	private WebElement excelDownload;
	
	@FindBy(xpath="//*[.=\"PDF\"]")
	private WebElement pdfDownload;
	
	@FindBy(xpath="//input[@placeholder=\"From Date\"]")
	private WebElement fromDate;
	
	@FindBy(xpath="//input[@placeholder=\"To Date\"]")
	private WebElement toDate;
	
	@FindBy(xpath="//span[.=\"OK\"]")
	private WebElement datePickOk;
	
	@FindBy(xpath="//button[.=\"Search\"]")
	private WebElement searchButton;
	
	@FindBy(xpath="(//button[@type=\"button\"])[5]")
	private WebElement resetButton;
	
	@FindBy(xpath="//*[@id=\"main-wrapper\"]/div[5]/div/div[2]/div[2]/div[2]/table/tbody/tr[1]/td[8]/span")
	private WebElement receiptDownload;
	
	@FindBy(xpath="//*[@id=\"main-wrapper\"]/div[5]/div/div[2]/div[2]/div/table/thead/tr/th[1]/div/input")
	private WebElement searchWithLocation;
	
	@FindBy(xpath="//*[@id=\"main-wrapper\"]/div[5]/div/div[2]/div[2]/div/table/thead/tr/th[2]/div/input")
	private WebElement searchWithLastName;
	
	@FindBy(xpath="//*[@id=\"main-wrapper\"]/div[5]/div/div[2]/div[2]/div/table/thead/tr/th[3]/div/input")
	private WebElement searchWithFirstName;
	
	@FindBy(xpath="//*[@id=\"main-wrapper\"]/div[5]/div/div[2]/div[2]/div/table/thead/tr/th[4]/div/input")
	private WebElement searchWithProcedure;
	
	@FindBy(xpath="//*[@id=\"main-wrapper\"]/div[5]/div/div[2]/div[2]/div/table/thead/tr/th[5]/div/input")
	private WebElement searchWithAmount;
	
	@FindBy(xpath="//*[@id=\"main-wrapper\"]/div[5]/div/div[2]/div[2]/div/table/thead/tr/th[6]/div/input")
	private WebElement searchWithDate;
	
	@FindBy(xpath="//*[@id=\"main-wrapper\"]/div[5]/div/div[2]/div[2]/div/table/thead/tr/th[7]/div/input")
	private WebElement searchWithStatus;
	
	@FindBy(xpath="(//span[@class=\"MuiIconButton-label\"])[1]")
	private WebElement previousMonth;
	
	@FindBy(xpath="(//p[.=\"1\"])[1]")
	private WebElement previousDate;
	
	@FindBy(xpath="//span[.=\"No Records Found\"]")
	private WebElement noRecord;
	
	public WebElement getNoRecord() {
		return noRecord;
	}
	
	public WebElement getPreviousMonth() {
		return previousMonth;
	}

	public WebElement getPreviousDate() {
		return previousDate;
	}

	public WebElement getManagepaymentsMenu() {
		return managepaymentsMenu;
	}

	public WebElement getExcelDownload() {
		return excelDownload;
	}

	public WebElement getPdfDownload() {
		return pdfDownload;
	}

	public WebElement getFromDate() {
		return fromDate;
	}

	public WebElement getToDate() {
		return toDate;
	}

	public WebElement getDatePickOk() {
		return datePickOk;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getResetButton() {
		return resetButton;
	}

	public WebElement getReceiptDownload() {
		return receiptDownload;
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

	public WebElement getSearchWithProcedure() {
		return searchWithProcedure;
	}

	public WebElement getSearchWithAmount() {
		return searchWithAmount;
	}

	public WebElement getSearchWithDate() {
		return searchWithDate;
	}

	public WebElement getSearchWithStatus() {
		return searchWithStatus;
	}

	public ManagePayments(WebDriver driver1) {
		driver = driver1;
		PageFactory.initElements(driver, this);}

}
