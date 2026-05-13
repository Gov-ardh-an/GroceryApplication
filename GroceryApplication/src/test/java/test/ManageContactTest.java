package test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import mainProject.MainProjectBase;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;
import utilities.RandomDataUltility;

public class ManageContactTest extends MainProjectBase {
	HomePage homepage;
	ManageContactPage managecontactpage;
	@Test(description = "User Is Able To Update Contact Details")
	public void verifyWhetherUserIsAbleToUpdateContactDetails() throws IOException {
		String usernameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterusername(usernameValue).enterpassword(passwordValue);
		homepage = login.clickLoginButton();
		managecontactpage = homepage.mangecontactmoreinfo();
		RandomDataUltility randomdata = new RandomDataUltility();
		String mobilenumberValue = randomdata.randomMobilenumber();
		String addressValue = ExcelUtility.readStringData(0, 0, "ManagePage");
		managecontactpage.actionButton().updatephonenumber(mobilenumberValue).updateaddress(addressValue).updatebutton();
		boolean addressupdatedsuccessfully = managecontactpage.contactupdatedsuccesfullydisplayed();
		Assert.assertTrue(addressupdatedsuccessfully, Constant.UPDATECONTACTDETAILSERROR);
		
	}

}
