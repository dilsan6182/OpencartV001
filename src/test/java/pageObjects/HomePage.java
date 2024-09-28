package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement MyacntLink;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement RegisterLink;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement LoginLink;
	public void ClickLoginLink() {
		LoginLink.click();
	}
	
	public void ClickMyAcnt() {
		MyacntLink.click();
	}
	
	public void ClickRegisterLink() {
		RegisterLink.click();
	}
	
	
}
