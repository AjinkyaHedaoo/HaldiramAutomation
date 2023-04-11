package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HaldiramLogo {
	@FindBy (xpath ="//a[@id='logo']")
	private WebElement haldiramLogo;
	
	public HaldiramLogo(WebDriver driver) {
		PageFactory.initElements(driver,this);	
	}
	public void clickOnhaldiramLogo() {
		haldiramLogo.click();
	}

}
