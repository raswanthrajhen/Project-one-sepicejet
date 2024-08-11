package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpacificationMethod;
import pages.AddOnPage;
import pages.HomePage;
import pages.LoginPage;
import pages.PassengerDetailPage;
import pages.PaymentPages;
import pages.SearchFlightPage;

public class TC001_LoginPage extends ProjectSpacificationMethod {

	 
	@BeforeTest
	public void setup() throws Exception {
		readFromPropFile();
		String sheetNameFromProp=prop.getProperty("sheetname");
		readFromPropFile();
		sheetname=sheetNameFromProp;
	}
	
	@Test(dataProvider="getData")
	public void signUptest(String[] sheetData) {
		HomePage homePageObject=new HomePage(driver);
		LoginPage loginPageObject=new LoginPage(driver);
		homePageObject.clickloginButton();
		loginPageObject.loginPageValidation(sheetData[0],sheetData[1]);
	}
	
	 @Test(dependsOnMethods = {"signUptest"})
	public void oneWayFlight() {
		 SearchFlightPage SearchFlightPageObject=new SearchFlightPage(driver);
		 PassengerDetailPage passengerDetailObject=new PassengerDetailPage(driver);
		 AddOnPage addOnPageObject=new AddOnPage(driver);
		 SearchFlightPageObject.oneWaySearchFlight();
		 passengerDetailObject.passengerDetailsValidation();
		 addOnPageObject.AddOnPageValidation();
	}
	
	 @Test(dependsOnMethods = {"oneWayFlight"})
	 public void payment() {
		 PaymentPages paymentPagesObject=new PaymentPages(driver);
		 paymentPagesObject.paymentPagesValidation();
		 
	 }
	
}
