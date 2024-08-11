package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpacificationMethod;

public class PassengerDetailPage extends ProjectSpacificationMethod {
	
	@FindBy(xpath="//div[contains(text(),'I am flying as the primary passenger')]")
	WebElement labelPassanger;
	
	@FindBy(xpath="//div[@data-testid='traveller-info-continue-cta']")
	WebElement continueElement;
	
	
	WebDriverWait wait;
	
	public PassengerDetailPage(WebDriver driver) {
		this.driver=driver;
		wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		PageFactory.initElements(driver, this);
	}
	
	public AddOnPage passengerDetailsValidation() {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", labelPassanger);
		clickElement(labelPassanger);
		clickElement(continueElement);
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new AddOnPage(driver);
	}

}
