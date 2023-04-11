package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchProduct {
	@FindBy (xpath = "//input[@id='search']")
	private WebElement SearchEntireStore;
	
	@FindBy (xpath = "//button[@class='action search']")
	private WebElement SearchButton;
	
	public SearchProduct(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public void SendOnSearchEntireStore(String search) {
		SearchEntireStore.sendKeys(search);
	}
	public void ClickOnSearchButton () {
		SearchButton.click();
	}
		
}

