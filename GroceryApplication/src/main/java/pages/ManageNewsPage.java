package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	public WebDriver driver;
	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']") WebElement newbutton;
@FindBy(xpath = "//textarea[@id='news']") WebElement enternews;
@FindBy(xpath = "//button[@type='submit']") WebElement savebtn;
@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement newscreatedsuccesfully;
@FindBy(xpath = "//a[@onclick='click_button(2)']") WebElement searchbtn;
@FindBy(xpath = "//input[@class='form-control']") WebElement searchnews;
@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']") WebElement hitsearch;
@FindBy(xpath = "//table//tr//td[text() = 'Hi this is your latest news for the day']") WebElement newstext;

public ManageNewsPage clicknewbutton() {
	newbutton.click();
	return this;
}
public ManageNewsPage enternews(String newsValue) {
	enternews.sendKeys(newsValue);
	return this;
}
public ManageNewsPage savebutton() {
	savebtn.click();
	return this;
}
public boolean createdsuccessfullydisplayed() {
	return newscreatedsuccesfully.isDisplayed();
}
public ManageNewsPage searchbutton() {
	searchbtn.click();
	return this;
}
public ManageNewsPage searchnews(String newsValue) {
	searchnews.sendKeys(newsValue);
	return this;
}
public ManageNewsPage hitsearchnewsbutton() {
	hitsearch.click();
	return this;
}
public String searchnewstextdisplayed() {
	return newstext.getText();
}
}
