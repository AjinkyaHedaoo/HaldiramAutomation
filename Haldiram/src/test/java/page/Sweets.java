package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Sweets {
	@FindBy (xpath ="//span[text()='Sweets']")
	private WebElement sweets ;
	
	@FindBy (xpath ="//span[text()='Packed Sweets']")
	private WebElement packedSweets ;
	
	WebDriver driver;
	Actions act;
	
	public Sweets(WebDriver driver) {
		PageFactory.initElements(driver,this);
		 this.driver = driver;
	}
	public void  moveToSweets() {
		act = new Actions(driver);
		act.moveToElement(sweets).perform();
	}
	public void clickOnPackedSweets() {
		packedSweets.click();
	}


}
