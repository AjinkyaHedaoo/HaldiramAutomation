package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInImage {
	@FindBy (xpath = "//li[@class='authorization-link']")
	private WebElement  SignInImageButton;
	
	public  SignInImage (WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public void ClickOnSignInImageButton() {
		SignInImageButton.click();
	}

}
