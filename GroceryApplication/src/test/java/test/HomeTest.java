package test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import mainProject.MainProjectBase;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends MainProjectBase{
	HomePage homepage;
	
	@Test(description = "user Is Able To Succesfully Logout")
	public void verifyWhetherUserIsAbleToSuccesfullyLogout( ) throws IOException {
		String usernameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterusername(usernameValue).enterpassword(passwordValue);
		homepage = login.clickLoginButton();
		
		homepage.adminpage();
		login = homepage.logoutpage();
		String expected = "7rmart supermarket";
		String actual = login.getHeadingText();
		Assert.assertEquals(actual, expected, Constant.SUCEESSFULLYLOGOUTERROR);
		
	
	}
}
