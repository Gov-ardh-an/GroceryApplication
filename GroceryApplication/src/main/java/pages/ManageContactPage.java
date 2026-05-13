package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Pageutility;

public class ManageContactPage {
	public WebDriver driver;
	public ManageContactPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	Pageutility manage = new Pageutility();
	
	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-primary btncss']") WebElement actionbutton;
	@FindBy(xpath = "//input[@id='phone']") WebElement phonenumber;
	@FindBy(xpath = "//textarea[@name='address']") WebElement address;
	@FindBy(xpath = "//button[@name='Update']") WebElement update;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement updatedsuccesfullydisplayed;
	
	public ManageContactPage actionButton() {
		actionbutton.click();
		return this;
		
	}
	public ManageContactPage updatephonenumber(String mobilenumberValue) {
		phonenumber.clear();
		phonenumber.sendKeys(mobilenumberValue);
		return this;
		
	}
	public ManageContactPage updateaddress(String addressValue) {
		address.clear();
		address.sendKeys(addressValue);
		return this;
		
	}
	public ManageContactPage updatebutton() {
		manage.clickWithJSexecutor(driver, update); //pageutility method has been applied 
		
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", update);
		return this;
	}
	public boolean contactupdatedsuccesfullydisplayed() {
		return updatedsuccesfullydisplayed.isDisplayed();
	}

}
