package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpacificationMethod;

public class SearchFlightPage extends ProjectSpacificationMethod{

	
	
	@FindBy(xpath="//div[@data-testid='one-way-radio-button']")
	WebElement oneWayRadioButtonElement;
	
	@FindBy(xpath="//div[contains(text(),'round trip')]")
	WebElement roundTripRadioButtonElement;
	
	
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
	
	
	@FindBy(xpath="//div[@data-testid='return-date-dropdown-label-test-id']")
	WebElement returnMonthElement;
	
	@FindBy(xpath="(//div[@class='css-76zvg2 r-jwli3a r-ubezar r-16dba41'])[1]")
	WebElement selectDateElement;
	
	@FindBy(xpath="//div[@data-testid='home-page-flight-cta']")
	WebElement searchFlightButtonElement;
	
	@FindBy(xpath="//div[@data-testid='continue-search-page-cta']")
	WebElement continueButtonElement;
	
	@FindBy(xpath="(//div[(text()=5)])[2]")
	WebElement clickDateElement;
	
	@FindBy(xpath="(//div[text()=14])[2]")
	WebElement clickReturnDateElement;
	
	
	WebDriverWait wait;
	
	public SearchFlightPage(WebDriver driver) {
		this.driver=driver;
		wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		PageFactory.initElements(driver, this);
	}
	
	
	public PassengerDetailPage oneWaySearchFlight() {
		wait.until(ExpectedConditions.elementToBeClickable(labelWelcomeElement));
		wait.until(ExpectedConditions.elementToBeClickable(fromCityElement));
		wait.until(ExpectedConditions.elementToBeClickable(toCityElement));
		sendKeyElements(toCityElement,"Chennai");
		clickElement(selectMonthElement);
		try {
			clickElement(clickDateElement);
		}
		catch(Exception ex){
			
			System.out.print(" To date slected exception");
			ex.printStackTrace();
		}
		clickElement(searchFlightButtonElement);

		wait.until(ExpectedConditions.elementToBeClickable(continueButtonElement));
		clickElement(continueButtonElement);
	
			try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	
			return new PassengerDetailPage(driver);
	}
	
	public PassengerDetailPage twoWaySearchFlight() {
		wait.until(ExpectedConditions.elementToBeClickable(labelWelcomeElement));
		wait.until(ExpectedConditions.elementToBeClickable(fromCityElement));
		wait.until(ExpectedConditions.elementToBeClickable(toCityElement));
		clickElement(roundTripRadioButtonElement);
		
		sendKeyElements(toCityElement,"Chennai");
		clickElement(selectMonthElement);
		try {
			clickElement(clickDateElement);
		}
		catch(Exception ex){
			
			System.out.print(" To date slected exception");
			ex.printStackTrace();
		}
		
		clickElement(returnMonthElement);
	
		
		try {
			clickElement(clickReturnDateElement);	
		    
		}
		catch(Exception ex){
			
			System.out.print("return date slected exception");
			ex.printStackTrace();
		}
		
		
		clickElement(searchFlightButtonElement);

		wait.until(ExpectedConditions.elementToBeClickable(continueButtonElement));
		clickElement(continueButtonElement);
	
	
			return new PassengerDetailPage(driver);
	}
	
	
}
