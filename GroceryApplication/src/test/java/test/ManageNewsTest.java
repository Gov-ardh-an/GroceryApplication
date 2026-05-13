package test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import mainProject.MainProjectBase;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends MainProjectBase{
	HomePage homepage;
	ManageNewsPage managenewspage;
	@Test(description = "User Is Able To Add New News")
	public void verifyWhetherUserIsAbleToAddNewNews() throws IOException {
		String usernameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterusername(usernameValue).enterpassword(passwordValue);
		homepage = login.clickLoginButton();
		managenewspage = homepage.managenewsmoreinfo();
		String newsValue = ExcelUtility.readStringData(0, 0, "NewsPage");
		managenewspage.clicknewbutton().enternews(newsValue).savebutton();
		boolean newscreatedsuccessfully = managenewspage.createdsuccessfullydisplayed();
		Assert.assertTrue(newscreatedsuccessfully, Constant.ADDNEWNEWSERROR);
		
	}
	
	@Test(description = "User Is Able To Search Newly Added News")
	public void verifyWhetherUserIsAbleToSearchNewlyAddedNews() throws IOException {
		String usernameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterusername(usernameValue).enterpassword(passwordValue);
		homepage = login.clickLoginButton();
		managenewspage = homepage.managenewsmoreinfo();
		String newsValue = ExcelUtility.readStringData(0, 0, "NewsPage");
		managenewspage.searchbutton().searchnews(newsValue).hitsearchnewsbutton();
		String expected = "Hi this is your latest news for the day";
		String actual = managenewspage.searchnewstextdisplayed();
		Assert.assertEquals(expected, actual, Constant.SEARCHNEWLYADDEDNEWSERROR);
		
	}

}
