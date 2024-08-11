package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpacificationMethod;

public class LoginPage extends ProjectSpacificationMethod {

	@FindBy(xpath="//input[@data-testid='user-mobileno-input-box']")
	WebElement phoneNumberElement;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement passwordElement;
	
	@FindBy(xpath="//div[@data-testid='login-cta']")
	WebElement loginButtonElement;
	
	@FindBy(xpath="//div[@data-testid='one-way-radio-button']")
	WebElement oneWayRadioButtonElement;
	
	@FindBy(xpath="//div[.='Welcome aboard']")
	WebElement labelWelcomeElement;
	
	@FindBy(xpath="//div[@data-testid='round-trip-radio-button']")
	WebElement labelRoundElement;
	
	@FindBy(xpath="(//input[@type='text'])[1]")
	WebElement fromCityElement;
	
	@FindBy(xpath="(//input[@type='text'])[2]")
	WebElement toCityElement;
	
	@FindBy(xpath="//div[@class='css-1dbjc4n r-1mdbw0j r-ymttw5 r-b2dl2 r-mzjzbw r-wk8lta r-tvv088' and @data-testid='undefined-month-September-2024']")
	WebElement selectMonthElement;
	
	@FindBy(xpath="(//div[@class='css-76zvg2 r-jwli3a r-ubezar r-16dba41'])[1]")
	WebElement selectDateElement;
	
	@FindBy(xpath="//div[@data-testid='home-page-flight-cta']")
	WebElement searchFlightButtonElement;
	
	
	WebDriverWait wait;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		PageFactory.initElements(driver, this);
	}
	

	public PassengerDetailPage loginPageValidation(String phoneNumber,String password) {
		sendKeyElements(phoneNumberElement,phoneNumber);
		sendKeyElements(passwordElement,password);
		clickElement(loginButtonElement);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new PassengerDetailPage(driver);		
	}
	
	
	
}
