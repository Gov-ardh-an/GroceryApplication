package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Pageutility {
	public void selectDragDropWithValue(WebElement element, String value) {
		Select object=new Select(element);
		object.selectByValue(value);
	}
	
	public void selectDragDropWithindex(WebElement element, int value) {
		Select object=new Select(element);
		object.selectByIndex(value);
	}
	
	public void selectDragDropWithVisibleText(WebElement element, String value) {
		Select object=new Select(element);
		object.selectByVisibleText(value);
	}
	
	public void selectscrollbyjavascript(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,350)", "");
	}
	public void clickWithJSexecutor(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }


}
