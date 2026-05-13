package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.Pageutility;

public class AdminUserPage {
		public WebDriver driver;
		public AdminUserPage (WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		Pageutility page = new Pageutility();
		@FindBy(xpath = "//a[@href='javascript:void(0)' and @ onclick='click_button(1)']") WebElement newButton;
		@FindBy(id = "username") WebElement username;
		@FindBy(id = "password") WebElement password;
		@FindBy(id = "user_type") WebElement usertype;
		@FindBy(xpath = "//button[@name='Create']") WebElement savebutton;
		@FindBy(xpath = "//a[@onclick='click_button(2)']") WebElement search;
		@FindBy(xpath = "//input[@id='un']") WebElement searchusername;
		@FindBy(xpath = "//select[@id='ut']") WebElement searchusertype;
		@FindBy(xpath = "//button[@name='Search']") WebElement usersearch;
		@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement createdsuccesfullyDisplayed;
		@FindBy(xpath = "//table//tr/td[text() ='lionel..mess']") WebElement usernametext;
		
		
		
		public AdminUserPage addnew() {
			newButton.click();
			return this;
		}
		public AdminUserPage enterUsername(String userValue) {
			username.sendKeys(userValue);
			return this;
			
		}
		public AdminUserPage enterPassword(String passValue) {
			password.sendKeys(passValue);
			return this;
			
		}
		public AdminUserPage selectUserType() {
			page.selectDragDropWithindex(usertype, 0);
			return this;
			//Select select = new Select(usertype);
			//select.selectByIndex(2);
			
		}
		public AdminUserPage clickSaveButton() {
			savebutton.click();
			return this;
		}
		public AdminUserPage searchButton() {
			search.click();
			return this;
			
		}
		public AdminUserPage enterusernametosearch(String userValue) {
			searchusername.sendKeys(userValue);
			return this;
			
		}
		public AdminUserPage enterusertypetosearch() {
			page.selectDragDropWithVisibleText(searchusertype, "Admin"); //pageutility method applying 
			return this;
			//Select select = new Select(searchusertype);
			//select.selectByIndex(2);
			
		}
		public AdminUserPage usersearchbutton() {
			usersearch.click();
			return this;
		}
		public boolean iscreatedsuccesfullyDisplayed() {
			return createdsuccesfullyDisplayed.isDisplayed();
		}
		public String searchusernametextdisplayed() {
			return usernametext.getText();
		}
		

}
