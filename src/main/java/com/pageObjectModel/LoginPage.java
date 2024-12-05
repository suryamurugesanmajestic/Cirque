package com.pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public static WebDriver driver;
	
	@FindBy(name="username")
	private WebElement username;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(xpath ="//button[.=\"Sign In\"]")
	private WebElement signIn;
	
	@FindBy(xpath="//*[@loading=\"lazy\"]")
	private WebElement loader;
	
	@FindBy(xpath="(//div[@class=\"invalid-feedback\"])[1]")
	private WebElement emailValidation;
	
	@FindBy(xpath="(//div[@class=\"invalid-feedback\"])[2]")
	private WebElement passwordValidation;
	
	@FindBy(xpath="//div[.=\"Email / Password is invalid\"]")
	private WebElement pageLevelValiidation;
	
	@FindBy(xpath="/html/head/link[1]")
	private WebElement favIcon;
	
	@FindBy(xpath="//i[@title='Show password']")
	private WebElement viewIcon;
	
	public WebElement getViewIcon() {
		return viewIcon;
	}
	
	public WebElement getUsername() {
		return username;
	}
	
	public WebElement getPassword() {
		return password;
	}
	
	public WebElement getSignIn() {
		return signIn;
	}
	
	public WebElement getLoader() {
		return loader;
	}
	
	public WebElement getEmailValidation() {
		return emailValidation;
	}

	public WebElement getPasswordValidation() {
		return passwordValidation;
	}

	public WebElement getPageLevelValiidation() {
		return pageLevelValiidation;
	}
	
	public LoginPage(WebDriver driver1) {
		driver = driver1;
		PageFactory.initElements(driver, this);
	}

}
