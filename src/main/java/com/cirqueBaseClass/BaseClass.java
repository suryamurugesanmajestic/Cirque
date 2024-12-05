package com.cirqueBaseClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.text.TextProducer;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	// browser Launch method

	public static WebDriver browserLaunch(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		}else if(browser.equalsIgnoreCase("chromeIncognito")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions option = new ChromeOptions();
			option.addArguments("incognito");

		}else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}else if(browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		}else if(browser.equalsIgnoreCase("safari")) {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();			
		}else {
			System.out.println("Invalid browser please enter the valid browser name");
		}
		driver.manage().window().maximize();
		return driver;
	}

	// ImplicitlyWait Method

	public static void implicitlyWait(int sec) {
		driver.manage().timeouts().implicitlyWait(sec,TimeUnit.SECONDS);	
	}
	
	// GetURL Method
	public static void getURL(String URL) {
		driver.get(URL);
	}

	// GetTitle Method
	public static void getTitle() {

		String title = driver.getTitle();
		System.out.println("Title --> "+title);
	}

	// getCurrentURL Method
	public static String getCurrentURL() {
		String getCurrentURL = driver.getCurrentUrl();
		System.out.println("CurrentURL --> "+getCurrentURL);
		return getCurrentURL;
	}

	// Navigation methods

	public static void navigateTo(String url) {
		driver.navigate().to(url);

	}
	public static void navigateBack() {
		driver.navigate().back();
	}
	public static void navigateForward() {
		driver.navigate().forward();

	}
	public static void navigateRefresh() {
		driver.navigate().refresh();
	}

	// getAttribute methods
	public static void getAttributeValue(WebElement refName, String value) {
		String attribute = refName.getAttribute(value);
		System.out.print("attribute value --> "+attribute);
	}

	// input value click
	public static void sendKeys(WebElement refName, String value) {
		refName.sendKeys(value);
	}
	// CLICK 
	public static void click(WebElement refName) {
		refName.click();
	}

	// CLEAR
	public static void clear(WebElement refName) {
		refName.clear();
	}

	// WebElement radioButton
	public static void radioButton(WebElement refName) {
		refName.click();
	}


	// RamdonAlphabetics Method
	public static String randomAlphabetics(WebElement refName, int value) {
		String random = RandomStringUtils.randomAlphabetic(value);
	    refName.sendKeys(random+" "+random);
		return random;
		
	}
	
	public static void randomEmail(WebElement refName, int value) {
		String random = RandomStringUtils.randomAlphabetic(value);
	    refName.sendKeys(random+"@yopmail.com");
	}
	
	public  static int RandomNumericBelwo20(WebElement RefName, int value) {
		  String random = RandomStringUtils.randomNumeric(value);	      
	      RefName.sendKeys(random);      
	      int randomBelow20 = ThreadLocalRandom.current().nextInt(20);     
	      return randomBelow20;
	  }
	
	
	// Random Data Generator
	public static void RandomData(WebElement refName,String dataType) {
		Fairy fairy = Fairy.create();
		TextProducer person = fairy.textProducer();
		
		if(dataType.equalsIgnoreCase("firstName")) {
			String firstName = person.randomString(3);
			refName.sendKeys(firstName);
			System.out.println(firstName);
		}else if(dataType.equalsIgnoreCase("lastName")) {
			String lastName = person.randomString(3);
			refName.sendKeys(lastName);
			System.out.println(lastName);
		}
		
	}
	
	// RandomAlphaNunmeric Method
	public static void randomAlphaNumeric(WebElement refName,int value) {
	String random = RandomStringUtils.randomAlphanumeric(value);
	refName.sendKeys(random+" "+random);
	
	}
	
	// getting text from the application
	public static String getText(WebElement refName) {
		String text = refName.getText();
		System.out.println("Getted value "+ text );
		return text;
	}
	
	// RandomNumeric Method
	public static String randomNumeric(WebElement refName,int value) {
		String random = RandomStringUtils.randomNumeric(value);
		System.out.println(random);
		refName.sendKeys(random);
		return random;
	}

	// WebDriverWait Method
	public static void webDriverWait(int sec, String Options,WebElement refName) {

		WebDriverWait wait = new WebDriverWait(driver, sec);

		if(Options.equalsIgnoreCase("clickable")) {
			wait.until(ExpectedConditions.elementToBeClickable(refName));
		}else if(Options.equalsIgnoreCase("visible")) {
			wait.until(ExpectedConditions.visibilityOf(refName));

		}else if(Options.equalsIgnoreCase("Selectable")) {
			wait.until(ExpectedConditions.elementToBeSelected(refName));
		}else if(Options.equalsIgnoreCase("invisible")) {
			wait.until(ExpectedConditions.invisibilityOf(refName));
		}else if(Options.equalsIgnoreCase("alertIsPresent")) {
			wait.until(ExpectedConditions.alertIsPresent());
		}
	}
	
	// Actions Methods	
	public static void actions(String options, WebElement refName) {

		Actions builder = new Actions(driver);

		if(options.equalsIgnoreCase("click")) {
			builder.click(refName).perform();
		}else if(options.equalsIgnoreCase("clickAndHold")) {
			builder.clickAndHold(refName).perform();
		}else if(options.equalsIgnoreCase("MoveToElement")) {
			builder.moveToElement(refName).perform();
		}else if(options.equalsIgnoreCase("doubleclick")) {
			builder.doubleClick().perform();
		}else if(options.equalsIgnoreCase("dragAndDrop")) {
			//builder.dragAndDrop(refName, refName);
			builder.dragAndDropBy(refName, 50, 80);
		}else if(options.equalsIgnoreCase("release")) {
			builder.release().perform();
		}else if(options.equalsIgnoreCase("contextClick")) {
			builder.contextClick(refName);

		}else {
			System.err.println("GIVE THE CORRECT ACTIONS METHOD");
		}

	}

	public static void select(WebElement refName,String options,String value) {
		Select select = new Select(refName);

		if(options.equalsIgnoreCase("text")) {
			select.selectByVisibleText(value);
		}else if(options.equalsIgnoreCase("value")) {
			select.selectByValue(value);
		}else if(options.equalsIgnoreCase("index")) {
			int parseInt = Integer.parseInt(value);
			select.selectByIndex(parseInt);
		}
	}

	public static void deSelect (WebElement refName,String options,String value) {
		Select select = new Select(refName);

		if(options.equalsIgnoreCase("text")) {
			select.deselectByVisibleText(value);
		}else if(options.equalsIgnoreCase("value")) {
			select.deselectByValue(value);
		}else if(options.equalsIgnoreCase("index")) {
			int parseInt = Integer.parseInt(value);
			select.deselectByIndex(parseInt);
		}else if(options.equalsIgnoreCase("deselectAll")) {
			select.deselectAll();
		}
	}

	// isMultiple method
	public static void isMultiple(WebElement refName) {
		Select select = new Select(refName);
		boolean multiple = select.isMultiple();
		System.out.println("isMultiple --> "+"/n"+ multiple);
		System.out.print("              Gettting All Options             ");
		System.out.print("-----------------------------------------------");

		if(select.isMultiple()== true) {
			List<WebElement> options = select.getOptions();
			for(WebElement opt : options) {
				String text = opt.getText();
				System.out.println("dropdown values --> "+text);
			}
		}else {
			System.out.println("Dropdown  is not multi selectable");
		}
	}

	// gettingAllSelectedOptions methods
	public static void getAllSelectedOptions(WebElement refName) {
		Select select = new Select(refName);
		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
		System.out.println("            Getting all selected options           ");
		System.out.println("---------------------------------------------------");
		for(WebElement allSelect : allSelectedOptions) {
			String text = allSelect.getText();
			System.out.println(text);
		}
	}

	// gettingFirstSelected Option method
	public static void getFirstSelectedOption(WebElement refName) {
		Select select = new Select(refName);
		WebElement firstSelectedOption = select.getFirstSelectedOption();
		String text = firstSelectedOption.getText();
		System.out.println("First Selected Value ");
		System.out.println("-----------------------");
		System.out.println(text);
	}

	// isEnabled methods boolean type verification method
	public static void isEnable(WebElement refName) {
		boolean enabled = refName.isEnabled();
		System.out.println("isEnabled --> " + enabled);
	}

	// isDisabled boolean type verification method
	public static boolean isDisplayed(WebElement refName) {
		boolean displayed = refName.isDisplayed();
		System.out.println("isDisplayed --> "+displayed);
		return displayed;
	}

	// isSelected boolean type verification method
	public static void isSelectable(WebElement refName) {
		boolean selected = refName.isSelected();
		System.out.println("isSelected --> "+selected);
	}

	// Using a simpleAlert method
	public static void simpleAlert() {
		driver.switchTo().alert().accept();
	}

	//Using a confirmAlert method
	public static void confirmAlert(String options) {
		if(options.equalsIgnoreCase("accept")) {
			driver.switchTo().alert().accept();
		}else if(options.equalsIgnoreCase("cancel")) {
			driver.switchTo().alert().dismiss();
		}
	}
	
	// Using a PromptAlert method
	public static void promptAlert(String value) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(value);
		alert.accept();
	}

	// i frame using frame by WebElement
	public static void frameByElement(WebElement refName) {
		driver.switchTo().frame(refName);  
	}

	// i frame using frame by index
	public static void frameByIndex(int index) {
		driver.switchTo().frame(index);
	}

	// i frame using frame by String
	public static void frameByValue(String value) {
		driver.switchTo().frame(value);	
	}
	
	// backward to previous frame
	public static void backwardFrame(String options) {
		if(options.equalsIgnoreCase("parentFrame")) {
			driver.switchTo().parentFrame();
		}else if(options.equalsIgnoreCase("defaultContent")) {
			driver.switchTo().defaultContent();
		}
	}
	
	// TakeScreenShot by using TakesScreenShot Method
	public static void takesScreenshot(String name) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\surya\\eclipse-workspace\\WOTC_Project\\"+name+".PNG");
		FileUtils.copyFile(src, dest);
	}
	
	// using windowHandle Method
	public static void windowHandle() {
		String windowHandle = driver.getWindowHandle();
		driver.switchTo().window(windowHandle);
	}
	
	// Using windowHandles
	public static void windowHandles(int value) {
		Set<String> windowHandles= driver.getWindowHandles();
		List<String> listWindow = new ArrayList<String>(windowHandles);
		System.out.println("ALL window URL --> \n"+listWindow);
		driver.switchTo().window(listWindow.get(value));
		System.out.println("Current URL ---> /n"+driver.getCurrentUrl());
		
	}
	// OTP entering method
	public static void OTP(WebElement refName) {
		String currentUrl = driver.getCurrentUrl();
		Scanner s = new Scanner(System.in);
		String OTP = s.next();
		refName.sendKeys(OTP);
		s.close();
		String currentUrl2 = driver.getCurrentUrl();
		if(currentUrl.equals(currentUrl2)) {
			System.out.println("Invalid OTP.Please Enter the Valid OTP");
			Scanner s1 = new Scanner(System.in);
			String OTP1 = s1.next();
			refName.sendKeys(OTP1);
			s1.close();
		}else if(currentUrl != currentUrl2) {
			System.out.println("OTP Verification has been successfully completed");
		}
		
		
	}
	
	   // Using Scanner class the input the value 
	
		public static void scannerValue(WebElement refName) {
			System.out.println("ENTER THE VALUE");
			Scanner scanner = new Scanner(System.in);
			String value = scanner.next();
			refName.sendKeys(value);
			scanner.close();		
		}

	   //Using javascriptExecutor to scrollIntoView the element
		public static void jsScrollIntoView(WebElement refName) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView();", refName);
		}
		
		// Using JavaScriptExecutor method for click
	    public static void jsExecuteClick(WebElement refName) {
	    	JavascriptExecutor js = (JavascriptExecutor)driver;
	    	js.executeScript("arguments[0].click();", refName);
	    }
	    
	    // using valuePass by using JavascriptExecutor method
	    public static void jsExecuteValuePass( String value,WebElement refName) {
	    	JavascriptExecutor js = (JavascriptExecutor)driver;
	    	js.executeScript("arguments[0].value=arguments[1]", refName,value);
	    	//                        OR
	    //	js.executeScript("arguments[0].value='"+value+"'", refName);
	   	
	    }
	    
	    // using valuePass by using a id locator in javascriptExecutor method
	    public static void jsExecuteIdValuePass(String id,String value) {
	    	JavascriptExecutor js =(JavascriptExecutor)driver;
	    	js.executeScript("document.getElementById('"+id+"').value='"+value+"';");
	    }
	    
	   // using JavascriptExecutor to scroll down method
	    public static void jsScrolling(String opt,String rangeValue) {
	    	if(opt.equalsIgnoreCase("down")) {
	    		JavascriptExecutor js = (JavascriptExecutor)driver;
	    		js.executeScript("window.scrollBy(0,"+rangeValue+");");
	    	}
	    	else if(opt.equalsIgnoreCase("up")) {
	    		JavascriptExecutor js = (JavascriptExecutor)driver;
	    		js.executeScript("window.scrollBy(0,"+rangeValue+");");
	    	}
	    	
	    }
	   
	   //Robot Class Method
	    
	    public static void robot(String option) throws AWTException, InterruptedException {
	    	Robot robot = new Robot();
	    	if(option.equalsIgnoreCase("Enter")) {
	    		robot.keyPress(KeyEvent.VK_ENTER);
	    		Thread.sleep(1000);
	    		robot.keyRelease(KeyEvent.VK_ENTER);
	    	}else if(option.equalsIgnoreCase("doubleDown")) {
	    		robot.keyPress((KeyEvent.VK_DOWN));
	    		robot.keyPress((KeyEvent.VK_DOWN));
	    		robot.keyRelease(KeyEvent.VK_DOWN);
	    		robot.keyRelease(KeyEvent.VK_DOWN);
	    	}else if(option.equalsIgnoreCase("down")) {
	    		robot.keyPress((KeyEvent.VK_DOWN));
	    		Thread.sleep(1500);
	    		robot.keyRelease(KeyEvent.VK_DOWN);
	    	}
	    	else if(option.equalsIgnoreCase("Tab")) {
	    		robot.keyPress(KeyEvent.VK_TAB);
	    		robot.keyRelease(KeyEvent.VK_TAB);
	    	}else if (option.equalsIgnoreCase("controlPress")) {
	    		robot.keyPress(KeyEvent.VK_CONTROL);	
	    	}else if(option.equalsIgnoreCase("controlRelease")) {
	    		robot.keyRelease(KeyEvent.VK_CONTROL);
	    		
	    	}else if (option.equalsIgnoreCase("VPress")) {
	    		robot.keyPress(KeyEvent.VK_V);
	    		
	    	}else if(option.equalsIgnoreCase("VRelease")) {
	    		robot.keyRelease(KeyEvent.VK_V);
	     	}else if(option.equalsIgnoreCase("spaceBar")) {
	     		robot.keyPress(KeyEvent.VK_SPACE);
	     		robot.keyRelease(KeyEvent.VK_SPACE);
	     	}else if(option.equals("leftArrow")) {
	     		robot.keyPress(KeyEvent.VK_LEFT);
	     		robot.keyRelease(KeyEvent.VK_LEFT);
	     	}else if(option.equals("rightArrow")) {
	     		robot.keyPress(KeyEvent.VK_RIGHT);
	     		robot.keyRelease(KeyEvent.VK_RIGHT);
	     	}
	    }
	    // using to close and quit the browser
	    
	    public static void close() {
	    	driver.close();
	    }
	    
	    public static void quit() {
	    	driver.quit();
	    }


	




}
