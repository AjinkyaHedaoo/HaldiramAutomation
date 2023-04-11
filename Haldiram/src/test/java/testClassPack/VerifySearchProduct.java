package testClassPack;

import java.io.IOException;
import java.time.Duration;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import page.BhujiaSevJarPage;
import page.HaldiramLogo;
import page.SearchProduct;
import page.SearchedProductPage;
import page.SignInImage;
import page.SignInPage;
import page.Sweets;
import utils.Utility;

public class VerifySearchProduct {
	WebDriver driver;
	SearchProduct searchProduct;
	SearchedProductPage searchedProductPage;
	BhujiaSevJarPage bhujiaSevJarPage;
	SoftAssert soft;
	HaldiramLogo haldiramLogo;
	Sweets sweets;
	String testID;
	@BeforeClass
	public void a() {
		System.out.println("Before Class");

		System.setProperty("webdriver.chrome.driver","D:\\selineum\\chromedriver_win11\\chromedriver.exe");
		ChromeOptions ops = new ChromeOptions ();
		ops.addArguments("--remote-allow-origins=*");
		 driver = new ChromeDriver(ops);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.manage().window().maximize();
		 
	}
	@BeforeMethod
	public void b() {
		System.out.println("Before method");
		 driver.get("https://www.haldirams.com/");

		haldiramLogo = new HaldiramLogo(driver);
		haldiramLogo.clickOnhaldiramLogo();
	}
	@Test (priority = 1)
	public void VerifyBhujiaSevProduct() throws EncryptedDocumentException, IOException {
		testID = "T2012";
		soft = new SoftAssert();
		System.out.println("Test");
		searchProduct = new SearchProduct(driver);
		searchProduct.SendOnSearchEntireStore(Utility.getExelData("haldiram", 0, 0));
		
		searchProduct.ClickOnSearchButton();
		
		searchedProductPage = new SearchedProductPage(driver);
		searchedProductPage.ClickOnBhujiaSevJar();
		
		bhujiaSevJarPage = new BhujiaSevJarPage(driver);
		String ActualMsg = bhujiaSevJarPage.GetBhujiaSevMsgText();
		String ExpectedMsg = "Bhujia Sev Jar (600 gms)";
		soft.assertNotEquals(ActualMsg, ExpectedMsg);
		
		String ActualText = bhujiaSevJarPage.GetInclusiveAllTaxMsgText();
		String ExpectedText = "Inclusive of all taxes Haldiram's Bhujia Sev is an authentic rendition of the classic namkeen - crispy gram flour sticks. Lip-smackingly flavourful, this special edition pack is made from our director's secret recipe. Share with your loved ones over a cup of tea, or top it on a steaming bowl of upma, poha or chaats.";
		soft.assertEquals(ActualText, ExpectedText);
		
		boolean CheckBox = bhujiaSevJarPage.CheckStandredGiftWrapingCheckBox();
		if(CheckBox == false)
		{
			System.out.println("CheckBox");
			System.out.println("pass");
		}
		else
		{
			System.out.println(CheckBox);
			System.out.println("Fail");
		}
		bhujiaSevJarPage.ClickOnAddToCart();
		soft.assertAll();
	}
	@Test (priority = 2)
	public void verifySweets() {
		testID = "t101";
		System.out.println("Test1");
		sweets = new Sweets(driver);
		sweets.moveToSweets();
		sweets.clickOnPackedSweets();
		
	}
	@AfterMethod
		public void logOutFromApplication(ITestResult result) throws IOException  {
			if(ITestResult.FAILURE == result.getStatus())
			{
				Utility.captureScreen(driver,testID);
			}
		 driver.get("https://www.haldirams.com/");
		}

	@AfterClass
	public void e() {
		System.out.println("After Class");
		driver.quit();
	}

}
