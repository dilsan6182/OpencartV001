package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import org.testng.Assert;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_AccountRegistrationTest extends BaseClass {
	
	
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration() {
		logger.info("*********** Starting TC_AccountRegistrationTest ************");
		try{
			HomePage hm=new HomePage(driver);
		
		hm.ClickMyAcnt();
		logger.info("clicked on my account link");
		hm.ClickRegisterLink();
		logger.info("clicked on register link");
		AccountRegistrationPage arp=new AccountRegistrationPage(driver);
		logger.info("providing customer info");
		arp.Enterfirstname(randomeString().toUpperCase());
		arp.EnterLastname(randomeString().toUpperCase());
		arp.EnterEmail(randomeString()+"@gmail.com");
		arp.Enterphomenumber(randomeNumber());
		String password=randomeAlphaNumeric();
		arp.Enterpassword(password);
		arp.ConfirmPassword(password);
		arp.ClickCheckagree();
		arp.ClickContinueButton();
		
		logger.info("validating expected message");
		String confirmation=arp.DisplaySuccessmessage();
		
		if(confirmation.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
		}
		else {
			logger.error("test failed");
			logger.debug("debug logs...");
			Assert.assertTrue(false);
		}
		
		//Assert.assertEquals(confirmation, "Your Account Has Been Created!");
		}
		catch(Exception e) {
			
			Assert.fail();
		}
		
		logger.info("*********** Finished TC_AccountRegistrationTest ************");
		
		}
	
	
}
