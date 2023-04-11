package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BhujiaSevJarPage {
	@FindBy (xpath  = "//span[@data-ui-id='page-title-wrapper']")
	private WebElement BhujiaSevMsg;
	
	@FindBy (xpath  = "//div[@itemprop='description']")
	private WebElement InclusiveAllTaxMsg;
	
	@FindBy (xpath  = "//input[@id='options_17276_2']")
	private WebElement StandredGiftWraping;
	
	@FindBy (xpath  = "//button[@id='product-addtocart-button']")
	private WebElement AddToCart ;
	
	public BhujiaSevJarPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public String GetBhujiaSevMsgText() {
		return BhujiaSevMsg.getText();
	}
	public String GetInclusiveAllTaxMsgText() {
		 return InclusiveAllTaxMsg.getText();
	}
	public boolean CheckStandredGiftWrapingCheckBox() {
		return StandredGiftWraping.isSelected();
	}
	public void ClickOnAddToCart() {
		AddToCart.click();
	}

}
