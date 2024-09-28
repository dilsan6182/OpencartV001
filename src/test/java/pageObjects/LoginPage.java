package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
		super(driver);	
		}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement EmailInput;
	public void EnterEmail(String email) {
		EmailInput.sendKeys(email);
	}
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement EmailPasswordinput;
	public void Enterpassword(String password) {
		EmailPasswordinput.sendKeys(password);
	}
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement Loginbutton;
	public void ClickLogin() {
		Loginbutton.click();
		}
	}



