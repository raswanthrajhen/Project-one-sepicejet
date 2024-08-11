package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpacificationMethod;

public class HomePage extends ProjectSpacificationMethod {

	WebDriverWait wait;
	
	@FindBy(xpath = "(//div[contains(text(),'Signup')])")
	WebElement SignUpButton;
	
	@FindBy(xpath="//div[@class='css-76zvg2 r-jwli3a r-ubezar']")
	WebElement loginButton;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));	
		PageFactory.initElements(driver, this);
	}
	
	public SignUpPage clickSignUpButton() {
		
		// Capture the original window handle
        Set<String> existingWindows = driver.getWindowHandles();
		wait.until(ExpectedConditions.visibilityOf(SignUpButton));
		clickElement(SignUpButton);
		System.out.println(driver.getCurrentUrl());
		
		 // Wait for new window or tab to open
        wait.until(driver -> driver.getWindowHandles().size() > existingWindows.size());

        // Get all window handles and convert to a list
        ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
        //switch the window
        
        switchToNewWindowOne(windows,existingWindows);
		System.out.println("Second"+ driver.getCurrentUrl());
		return new SignUpPage(driver);
	
	}

	public void clickloginButton() {
		wait.until(ExpectedConditions.visibilityOf(loginButton));
		clickElement(loginButton);
		
	}
	
}
