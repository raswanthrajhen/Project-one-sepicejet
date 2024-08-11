package test;

import org.testng.annotations.Test;

import base.ProjectSpacificationMethod;
import pages.HomePage;
import pages.SignUpPage;

public class TC001_SignUp extends ProjectSpacificationMethod {

	 
	@Test
	public void signUptest() {
		HomePage object=new HomePage(driver);
		SignUpPage signUpPage=new SignUpPage(driver); 
		
		object.clickSignUpButton();
		signUpPage.signUpValidation();
	}
	
}
