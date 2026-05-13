package test;

import java.io.IOException;
import java.lang.invoke.ConstantBootstraps;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
import mainProject.MainProjectBase;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;


public class LoginTest extends MainProjectBase {
	HomePage homepage; // global reference variable 
	@Test(priority = 1,  description = "User isLogin With Valid Credentials", groups = {"smoke"} )
	public void verifyUserLoginWithValidCredentials() throws IOException {
		String usernameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterusername(usernameValue).enterpassword(passwordValue);
		homepage = login.clickLoginButton();
		boolean dashboardDisplayed = login.isDashboardDisplayed(); //dashboardDisplayed is a boolean variable created to store 
		Assert.assertTrue(dashboardDisplayed, Constant.VALIDCREDENTIALERROR); // is its false it will display the " error message "
        		
		
	}
	@Test(priority = 2, description = "User is Login With inValid Credentials",retryAnalyzer = retry.Retry.class)
	public void verifyUserLoginWithInvalidCredentials() throws IOException {
		String usernameValue = ExcelUtility.readStringData(1, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterusername(usernameValue).enterpassword(passwordValue).clickLoginButton();
		String expected = "7rmart supermarket";
		String actual = login.getHeadingText();
		Assert.assertEquals(actual, expected, Constant.INVALIDCREDENTIALERROR);
		
	}
	@Test( priority = 3, description = "User isLogin With Valid username")
	public void verifyUserLoginWithValidUsername() throws IOException {
		String usernameValue = ExcelUtility.readStringData(2, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(2, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterusername(usernameValue).enterpassword(passwordValue).clickLoginButton();
		String expected = "7rmart supermarket";
		String actual = login.getHeadingText();
		Assert.assertEquals(actual, expected, Constant.VALIDUSERNAMEERROR);
		
	}
	@Test( priority = 4, description = "User isLogin With Valid password", groups = {"smoke"}, dataProvider = "loginProvider" )
	public void verifyUserLoginWithValidPassword(String usernameValue, String passwordValue) throws IOException {
		//String usernameValue = ExcelUtility.readStringData(3, 0, "LoginPage");
		//String passwordValue = ExcelUtility.readStringData(3, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterusername(usernameValue).enterpassword(passwordValue).clickLoginButton();
		String expected = "7rmart supermarket";
		String actual = login.getHeadingText();
		Assert.assertEquals(actual, expected, Constant.VALIDPASSWORDERROR);
	}
	@DataProvider(name = "loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException {

	return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" },
	// new Object[] {ExcelUtility.getStringData(3,
	// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
	};
	}


}
