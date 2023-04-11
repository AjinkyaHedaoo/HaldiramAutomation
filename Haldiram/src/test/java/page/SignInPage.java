package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	@FindBy (xpath = "(//input[@id='email'])[2]")
	private WebElement Email ;
	
	@FindBy (xpath = "(//input[@id='pass'])[1]")
	private WebElement Password ;
	
	@FindBy (xpath = "((//div[@class='recaptcha-checkbox-border'])[1])[1]")
	private WebElement Robot ;
	
	@FindBy (xpath = "(//span[text()='Sign In'])[1]")
	private WebElement SignInButton ;

    public SignInPage (WebDriver driver) {
	PageFactory.initElements(driver,this);
    }
    public void SendOnEmail() {
    	Email.sendKeys("ajinkyahedaoo786@gmail.com");
    }
    public void SendOnPassword() {
    	Password.sendKeys("shishimanu@1");
    }
    public void ClickOnRobot() {
    	Robot.click();
    }
    public void ClickOnSignInButton() {
    	SignInButton.click();
    }

}
