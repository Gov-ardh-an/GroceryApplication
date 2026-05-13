package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Waitutility;

public class LoginPage {
	public WebDriver driver;
	public LoginPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	Waitutility wait = new Waitutility();
	
@FindBy(name = "username") WebElement userName;
@FindBy(name = "password") WebElement password;
@FindBy(tagName = "button") WebElement loginButton;
@FindBy(xpath = "//p[text() = 'Dashboard']") WebElement dashboardDisplayed;
@FindBy(xpath = "//b[text() = '7rmart supermarket']") WebElement headingText;

public LoginPage enterusername(String usernameValue) {
	userName.sendKeys(usernameValue);
	return this;
	
}
public LoginPage enterpassword(String passwordValue) {
	password.sendKeys(passwordValue);
	return this;
	
}
public HomePage clickLoginButton() {
	wait.waitUntilElementToBeClickable(driver, loginButton);  // this is how wait utility class has been applied 
	loginButton.click();
	return new HomePage(driver);
}
public boolean isDashboardDisplayed() {
	return dashboardDisplayed.isDisplayed();
}
public String getHeadingText( ) {
	return headingText.getText();
}

}
