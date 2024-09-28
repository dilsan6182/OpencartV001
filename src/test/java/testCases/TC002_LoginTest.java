package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	@Test(groups={"Sanity","Master"})
	public void verify_login() {
		
		logger.info("***********Starting login test********");
		
		try {
			//home page
		HomePage hp=new HomePage(driver);
		hp.ClickMyAcnt();
		hp.ClickLoginLink();
		//login page
		LoginPage lp=new LoginPage(driver);
		lp.EnterEmail(p.getProperty("email"));
		lp.Enterpassword(p.getProperty("password"));
		lp.ClickLogin();
		//my account page
		MyAccountPage map=new MyAccountPage(driver);
		boolean targetpage=map.isMyAccountPageExists();
		
		//Assert.assertEquals(targetpage, true, "Login Failed");
		Assert.assertTrue(targetpage);
		}
		catch(Exception e) {
			Assert.fail();
		}
	}

}
