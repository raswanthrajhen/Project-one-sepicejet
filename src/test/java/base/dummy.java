package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.PaymentPages;
public class dummy {
	
	
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
	
	
	
	
	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		driver.get("https://www.spicejet.com/booking/prepayment");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//@FindBy(xpath="//input[@data-testid='user-mobileno-input-box']")
		WebElement phoneNumberElement=driver.findElement(By.xpath("//input[@data-testid='user-mobileno-input-box']"));
		
		
		

		WebElement cardNumberElement=driver.findElement(By.xpath("//input[@type='tel' and @name='card_number']"));
		
		wait.until(ExpectedConditions.elementToBeClickable(cardNumberElement));
		
		cardNumberElement.sendKeys("331231212121212");
		//	sendKeyElements(cardNumberElement,"7852100101012051");
			
		

	   
	}

}
