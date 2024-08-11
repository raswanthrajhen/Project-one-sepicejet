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

public class PaymentPages extends ProjectSpacificationMethod {

	@FindBy(xpath="//input[@type='tel' and @name='card_number']")
	WebElement cardNumberElement;
	
	@FindBy(xpath="//input[@type='text' and @name='name_on_card']")
	WebElement cardNameElement;
	
	@FindBy(xpath="//input[@type='tel' and @name='card_exp_month']")
	WebElement cardMonthElement;
	
	@FindBy(xpath="//input[@type='tel' and @name='card_exp_year']")
	WebElement cardYearElement;
	
	@FindBy(xpath="//input[@type='tel' and @name='security_code']")
	WebElement securityCodeElement;
	
	WebDriverWait wait;
	public PaymentPages(WebDriver driver) {
		this.driver=driver;
		wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		PageFactory.initElements(driver, this);
	}
	
	public PaymentPages paymentPagesValidation() {    
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        WebElement iframsCardNo=driver.findElement(By.xpath("//iframe[@class='card_number_iframe']"));
        
        driver.switchTo().frame(iframsCardNo);
     
      
		sendKeyElements(cardNumberElement,"785210010101205");
		driver.switchTo().parentFrame();
		
		WebElement iframsName=driver.findElement(By.xpath("//iframe[@class='name_on_card_iframe']"));
		driver.switchTo().frame(iframsName);
		sendKeyElements(cardNameElement,"rajhen");
		driver.switchTo().parentFrame();
		
		
		WebElement iframsExpMonth=driver.findElement(By.xpath("//iframe[@class='card_exp_month_iframe'] "));
		driver.switchTo().frame(iframsExpMonth);
		sendKeyElements(cardMonthElement,"01");
		driver.switchTo().parentFrame();
		
		WebElement iframsExpYear=driver.findElement(By.xpath("//iframe[@class='card_exp_year_iframe']"));
		driver.switchTo().frame(iframsExpYear);
		sendKeyElements(cardYearElement,"29");
		driver.switchTo().parentFrame();
		
		
	
		WebElement iframsScc=driver.findElement(By.xpath("//iframe[@class='security_code_iframe']"));
		driver.switchTo().frame(iframsScc);
		sendKeyElements(securityCodeElement,"213");
		driver.switchTo().parentFrame();

		return this;
	}
	
}
