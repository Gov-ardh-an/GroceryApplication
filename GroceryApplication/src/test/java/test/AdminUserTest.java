package test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import mainProject.MainProjectBase;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUltility;

public class AdminUserTest extends MainProjectBase {
	HomePage homepage;
	AdminUserPage adminuserpage;
	@Test(description = "user Is Able To Succesfully Logout")
	public void verifyWhetherUserIsAbleToAddNewAdminUser() throws IOException {
		String usernameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterusername(usernameValue).enterpassword(passwordValue);
		homepage = login.clickLoginButton();
		adminuserpage = homepage.dashboardmoreInfotab();
		RandomDataUltility randomdata = new RandomDataUltility();
		String userValue = randomdata.randomUsername();
		String passValue = randomdata.randomPassword();
		adminuserpage.addnew().enterUsername(userValue).enterPassword(passValue).selectUserType().clickSaveButton();
		boolean usercreatedsuccessfully = adminuserpage.iscreatedsuccesfullyDisplayed();
		Assert.assertTrue(usercreatedsuccessfully, Constant.ADDNEWADMINUSERERROR);
		
	}
	@Test(description = "User Is Able To Search The Newly Added User")
	public void verifyWhetherUserIsAbleToSearchTheNewlyAddedUser() throws IOException {
		String usernameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterusername(usernameValue).enterpassword(passwordValue);
		homepage = login.clickLoginButton();
		adminuserpage = homepage.dashboardmoreInfotab();
		String userValue = ExcelUtility.readStringData(0, 0, "AdminPage");
		adminuserpage.searchButton().enterusernametosearch(userValue).enterusertypetosearch().usersearchbutton();
		String expected = "lionel..mess";
		String actual = adminuserpage.searchusernametextdisplayed();
		Assert.assertEquals(expected, actual, Constant.SEARCHNEWLYADDEDUSERERROR);
	
		
	}

}

