package testCases;

import static org.junit.Assert.assertTrue;

import org.apache.logging.log4j.core.appender.rolling.action.IfAccumulatedFileCount;
import org.junit.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.dataProviders;


public class TC003_LoginDDT extends BaseClass{

	@Test(dataProvider="LoginData",dataProviderClass=dataProviders.class,groups="Datadriven")
	public void verify_LoginDDT(String email, String pwd, String exp) {
		
		logger.info("********* Starting TC003_LoginDDT*************");
		
		try {
		//home page
		HomePage hp=new HomePage(driver);
		hp.ClickMyAcnt();
		hp.ClickLoginLink();
		//login page
		LoginPage lp=new LoginPage(driver);
		lp.EnterEmail(email);
		lp.Enterpassword(pwd);
		lp.ClickLogin();
		//my account page
		MyAccountPage map=new MyAccountPage(driver);
		boolean targetpage=map.isMyAccountPageExists();
		

/* Data is valid   login success              test pass         logout
                    login failed               test gail        
 * 
 * Data is invalid   login pass             test fail      logout
                       login fail           test pass      
 */
		
		if(exp.equalsIgnoreCase("Valid")){
			if(targetpage==true) {
				map.ClickLogout();
				Assert.assertTrue(true);
				
			}
			else {
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("Invalid")) {
			if(targetpage==true)
			{
				map.ClickLogout();
				Assert.assertTrue(false);
				}
			else {
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("******** Finished TC003_LoginDDT***********");
	}
	
	
}
