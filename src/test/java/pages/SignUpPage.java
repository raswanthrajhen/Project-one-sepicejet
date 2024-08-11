package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpacificationMethod;

public class SignUpPage extends ProjectSpacificationMethod{

	
	@FindBy(xpath="(//select[contains(@class,'form-control form-select')])[1]")
	WebElement dropElement;
	
	@FindBy(xpath = "//input[@id='first_name']")
	WebElement nameElement;
	
	@FindBy(xpath="//input[@id='last_name']")
	WebElement lastNameElement;
	
	@FindBy(xpath="//select[@class='form-control form-select']")
	WebElement countryDropDownElement;
	
	@FindBy(xpath="//input[@id='email_id']")
	WebElement emailElement;
	
	@FindBy(xpath="//input[@id='new-password']")
	WebElement passwordElement;
	
	@FindBy(xpath="//input[@id='c-password']")
	WebElement conformPasswordElement;
	
	@FindBy(xpath="//button[normalize-space()='Submit']")
	WebElement submitButton;
	
	@FindBy(xpath="(//label[@class='font-14 bold'])[6]")
	WebElement labelMobile;
	
	@FindBy(xpath="(//label[@class='font-14 bold'])[4]")
	WebElement labelCountry;
	
	@FindBy(xpath="(//label[@class='font-14 bold'])[8]")
	WebElement labelConformPassword;
	//label[@class='font-14 bold'])[8]
	
	@FindBy(xpath="//input[@id='dobDate']")
	WebElement datePickerElement;
	
	@FindBy(xpath="//select[@class='react-datepicker__month-select']")
	WebElement datePickerMonthElement;
	
	@FindBy(xpath="//select[@class='react-datepicker__year-select']")
	WebElement datePickerYearElement;
	
	@FindBy(xpath="@//input[@placeholder='+91 01234 56789']")
	WebElement phoneNumberElement;
	
	WebDriverWait wait;
	 
	
	
	public SignUpPage(WebDriver driver) {
		this.driver=driver;
		wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		PageFactory.initElements(driver, this);
		
	}
	
	public void signUpValidation() {
		
		dropDown(dropElement,"MR","Mr");
		sendKeyElements(nameElement,"Raswanth");
		sendKeyElements(lastNameElement,"Rajhen");
		dropDown(countryDropDownElement,"IN","India");
		clickElement(datePickerElement);
		 
		 String day="26";
		 datePicker(datePickerElement,datePickerMonthElement,datePickerYearElement);
		 String dayXPath = "//div[contains(@class, 'react-datepicker__day') and text()='" + day + "']";
	     WebElement dayElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dayXPath)));
	     clickElement(dayElement);
		
	     //Scroll to target Element
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		//scrollToElementByCoordinates(labelMobile, jsExecutor );
		//jsExecutor.executeScript("arguments[0].scrollIntoView(true);", labelCountry);
		WebElement phoneElement=  driver.findElement(By.xpath("//input[@type='tel']"));
		phoneElement.sendKeys("8220722156");
		sendKeyElements(emailElement,"raswanth@gmail.com");
		jsExecutor.executeScript("window.scrollTo(arguments[0], arguments[1]);", labelConformPassword.getLocation().getX(), labelConformPassword.getLocation().getY());
		wait.until(ExpectedConditions.elementToBeClickable(labelConformPassword));

		sendKeyElements(passwordElement,"Admin@1234");
		sendKeyElements(conformPasswordElement,"Admin@1234");
		
	
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
