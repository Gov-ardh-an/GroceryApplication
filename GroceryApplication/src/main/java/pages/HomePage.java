package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;
	public HomePage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@data-toggle='dropdown']") WebElement admin;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout' and @class=\"dropdown-item\"]") WebElement logout;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @ class='small-box-footer']") WebElement dashmoreInfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact' and @ class='small-box-footer']") WebElement contactmoreinfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @ class='small-box-footer']") WebElement newsmoreinfo;
	
	public HomePage adminpage() {
		admin.click();
		return this;
	}
	public LoginPage logoutpage() {
		logout.click();
		return new LoginPage(driver);
	}
	public AdminUserPage dashboardmoreInfotab() {
		dashmoreInfo.click();
		return new AdminUserPage(driver);
	}
	public ManageContactPage mangecontactmoreinfo() {
		contactmoreinfo.click();	
		return new ManageContactPage(driver);
		}
	public ManageNewsPage managenewsmoreinfo() {
		newsmoreinfo.click();
		return new ManageNewsPage(driver);
	}
	
	
}
