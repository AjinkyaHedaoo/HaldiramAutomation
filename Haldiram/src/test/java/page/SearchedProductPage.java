package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchedProductPage {
	@FindBy (xpath = "//img[@alt='Bhujia Sev Jar (700 gms)']")
	private WebElement BhujiaSevJar;
	
	public SearchedProductPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public void ClickOnBhujiaSevJar() {
		BhujiaSevJar.click();
	}

}
