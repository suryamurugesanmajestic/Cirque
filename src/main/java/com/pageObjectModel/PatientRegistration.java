package com.pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientRegistration {
	
	public static WebDriver driver;
	
	@FindBy(name="LastName")
	private WebElement lastName;
	
	@FindBy(name="DOB")
	private WebElement DOB;
	
	@FindBy(xpath="//span[.=\"OK\"]")
	private WebElement datePickOk;
	
	@FindBy(xpath="//button[.=\"Verify\"]")
	private WebElement verifyBtn;
	
	@FindBy(xpath="(//div[@class=\"invalid-feedback\"])[1]")
	private WebElement lastNameValidation;
	
	@FindBy(xpath="(//div[@class=\"invalid-feedback\"])[2]")
	private WebElement dOBValidation;
	
	@FindBy(xpath="//div[.=\"Authentication failed. Please check your credentials and try again.\"]")
	private WebElement pageLevelValidation;
	
	@FindBy(name="FirstName")
	private WebElement firstName;
	
	@FindBy(name="SSN")
	private WebElement ssn;
	
	@FindBy(name="Address1")
	private WebElement mailingAddress1;
	
	@FindBy(name="City")
	private WebElement city;
	
	@FindBy(xpath="(//div[.=\"Select...\"])[4]")
	private WebElement state;
	
	@FindBy(name="Zipcode")
	private WebElement zipCode;
	
	@FindBy(name="PhoneNumber")
	private WebElement phoneNumber;
	
	@FindBy(name="Email")
	private WebElement email;
	
	@FindBy(xpath="//span[text()=\"Please enter a Email\"]")
	private WebElement emailValidation;
	
	@FindBy(xpath="(//input[@type=\"radio\"])[1]")
	private WebElement isMinorYes;
	
	@FindBy(xpath="(//input[@type=\"radio\"])[2]")
	private WebElement isMinorNo;
	
	@FindBy(xpath="(//input[@type=\"radio\"])[3]")
	private WebElement insuranceYes;
	
	@FindBy(xpath="(//input[@type=\"radio\"])[4]")
	private WebElement insuranceNo;
	
	@FindBy(name="GuardianLastName")
	private WebElement guardianLastName;
	
	@FindBy(name="GuardianFirstName")
	private WebElement guardianFirstName;
	
	@FindBy(name="GuardianDOB")
	private WebElement guardianDOB;
	
	@FindBy(name="GuardianAddress1")
	private WebElement guardianAddress1;
	
	@FindBy(xpath="(//div[.=\"Select...\"])[4]")
	private WebElement guardianState;
	
	@FindBy(name="GuardianCity")
	private WebElement guardianCity;
	
	@FindBy(name="GuardianZipCode")
	private WebElement guardianZipcode;
	
	@FindBy(name="GuardianEmail")
	private WebElement guardianEmail;
	
	@FindBy(name="GuardianPhoneNumber")
	private WebElement guardianPhoneNumber;
	
	@FindBy(xpath="(//input[@type=\"checkbox\"])[1]")
	private WebElement sameAsAddress;
	
	@FindBy(xpath="(//div[@class=\" css-2b097c-container\"])[3]")
	private WebElement insuranceCarrier;
	
	@FindBy(name="MemberID")
	private WebElement memberId;
	
	@FindBy(name="GroupNumber")
	private WebElement groupNumber;
	
	@FindBy(name="PrimarySubscriberName")
	private WebElement primarySubscriberName;
	
	@FindBy(name="PrimarySubscriberDOB")
	private WebElement primarySubscriberDOB;
	
	@FindBy(xpath="(//input[@type=\"checkbox\"])[2]")
	private WebElement confirmCheckbox;
	
	@FindBy(xpath="//canvas[@class=\"sigRef1 \"]")
	private WebElement digitalSign2;
	
	@FindBy(xpath="//canvas[@class=\"sigRef  border-danger\"]")
	private WebElement digitalSign1;
	
	@FindBy(xpath="(//li[@title=\"Clear\"])[1]")
	private WebElement signClear1;
	
	@FindBy(xpath="//button[.=\"Next\"]")
	private WebElement nextButton;
	
	@FindBy(xpath="(//li[@title=\"Clear\"])[2]")
	private WebElement signClear2;
	
	@FindBy(xpath="//button[.=\"Proceed to Payment\"]")
	private WebElement proceedToPayment;
	
	@FindBy(xpath="//button[.=\"Prev\"]")
	private WebElement prevButton;
	
	@FindBy(id="Field-numberInput")
	private WebElement cardNumber;
	
	@FindBy(id="Field-expiryInput")
	private WebElement expiryNumber;
	
	@FindBy(id="Field-cvcInput")
	private WebElement cvcNumber;
	
	@FindBy(id="Field-postalCodeInput")
	private WebElement postalCode;
	
	@FindBy(xpath="//button[.=\"Pay\"]")
	private WebElement payButton;
	
	@FindBy(xpath="//iframe[@name=\"__privateStripeFrame5364\"]")
	private WebElement paymentFrame;
	
	@FindBy(id="Field-numberError")
	private WebElement cardValidation;
	
	@FindBy(xpath="(//p[@role=\"alert\"])[2]")
	private WebElement expiryValidation;
	
	@FindBy(xpath="//p[.='Your card’s security code is incomplete.']")
	private WebElement cvcValidation;
	
	@FindBy(xpath="//p[.='Your ZIP is invalid.']")
	private WebElement cardZipcodeValidation;
	
	@FindBy(xpath="(//button[@type=\"button\"])[1]")
	private WebElement downloadInvoice;
	
	@FindBy(xpath="(//button[@type=\"button\"])[2]")
	private WebElement doneButton;
	
	@FindBy(xpath="(//span[@class=\"validation-text text-danger\"])[6]")
	private WebElement ssnValidation;
	
	@FindBy(xpath="(//span[@class=\"validation-text text-danger\"])[10]")
	private WebElement zipcodeValidation;
	
	@FindBy(xpath="(//span[@class=\"validation-text text-danger\"])[9]")
	private WebElement stateValidation;
	
	@FindBy(xpath="(//span[@class=\"validation-text text-danger\"])[11]")
	private WebElement phValidation;
	
	@FindBy(xpath="//div[text()=\"Please confirm that the information is accurate.\"]")
	private WebElement accurateValidation;
	
	public WebElement getPaymentFrame() {
		return paymentFrame;
	}
	public WebElement getInsuranceCarrier() {
		return insuranceCarrier;
	}

	public WebElement getMemberId() {
		return memberId;
	}

	public WebElement getGroupNumber() {
		return groupNumber;
	}

	public WebElement getPrimarySubscriberName() {
		return primarySubscriberName;
	}

	public WebElement getPrimarySubscriberDOB() {
		return primarySubscriberDOB;
	}

	public WebElement getSsnValidation() {
		return ssnValidation;
	}
	
	public WebElement getEmailValidaton() {
		return emailValidation;
	}
	

	public WebElement getZipcodeValidation() {
		return zipcodeValidation;
	}

	public WebElement getStateValidation() {
		return stateValidation;
	}

	public WebElement getPhValidation() {
		return phValidation;
	}

	public WebElement getAccurateValidation() {
		return accurateValidation;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getDOB() {
		return DOB;
	}
	
	public WebElement getDatePickOk() {
    	return datePickOk;
    }

	public WebElement getVerifyBtn() {
		return verifyBtn;
	}

	public WebElement getLastNameValidation() {
		return lastNameValidation;
	}

	public WebElement getdOBValidation() {
		return dOBValidation;
	}

	public WebElement getPageLevelValidation() {
		return pageLevelValidation;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getSsn() {
		return ssn;
	}

	public WebElement getMailingAddress1() {
		return mailingAddress1;
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

	public WebElement getIsMinorYes() {
		return isMinorYes;
	}

	public WebElement getIsMinorNo() {
		return isMinorNo;
	}

	public WebElement getInsuranceYes() {
		return insuranceYes;
	}

	public WebElement getInsuranceNo() {
		return insuranceNo;
	}

	public WebElement getGuardianLastName() {
		return guardianLastName;
	}

	public WebElement getGuardianFirstName() {
		return guardianFirstName;
	}

	public WebElement getGuardianDOB() {
		return guardianDOB;
	}

	public WebElement getGuardianAddress1() {
		return guardianAddress1;
	}

	public WebElement getGuardianState() {
		return guardianState;
	}

	public WebElement getGuardianCity() {
		return guardianCity;
	}

	public WebElement getGuardianZipcode() {
		return guardianZipcode;
	}

	public WebElement getGuardianEmail() {
		return guardianEmail;
	}

	public WebElement getGuardianPhoneNumber() {
		return guardianPhoneNumber;
	}

	public WebElement getSameAsAddress() {
		return sameAsAddress;
	}

	public WebElement getConfirmCheckbox() {
		return confirmCheckbox;
	}
	
	public WebElement getDigitalSign1() {
		return digitalSign1;
	}
	
	public WebElement getDigitalSign2() {
		return digitalSign2;
	}

	public WebElement getSignClear1() {
		return signClear1;
	}

	public WebElement getNextButton() {
		return nextButton;
	}

	public WebElement getSignClear2() {
		return signClear2;
	}

	public WebElement getProceedToPayment() {
		return proceedToPayment;
	}

	public WebElement getPrevButton() {
		return prevButton;
	}

	public WebElement getCardNumber() {
		return cardNumber;
	}

	public WebElement getExpiryNumber() {
		return expiryNumber;
	}

	public WebElement getCvcNumber() {
		return cvcNumber;
	}

	public WebElement getPostalCode() {
		return postalCode;
	}

	public WebElement getPayButton() {
		return payButton;
	}

	public WebElement getCardValidation() {
		return cardValidation;
	}

	public WebElement getExpiryValidation() {
		return expiryValidation;
	}

	public WebElement getCvcValidation() {
		return cvcValidation;
	}

	public WebElement getCardZipcodeValidation() {
		return cardZipcodeValidation;
	}

	public WebElement getDownloadInvoice() {
		return downloadInvoice;
	}

	public WebElement getDoneButton() {
		return doneButton;
	}

	public PatientRegistration(WebDriver driver1) {
		driver = driver1;
		PageFactory.initElements(driver, this);
	}

}
