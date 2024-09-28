package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstname;
	public void Enterfirstname(String fname) {
		txtFirstname.sendKeys(fname);
	}
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastname;
	public void EnterLastname(String lname) {
		txtLastname.sendKeys(lname);
		}


	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	public void EnterEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtTelephone;
	public void Enterphomenumber(String number) {
		txtTelephone.sendKeys(number);
	}
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPwd;
	public void Enterpassword(String password) {
		txtPwd.sendKeys(password);
	}
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtConfirmPwd;
	public void ConfirmPassword(String password) {
	txtConfirmPwd.sendKeys(password);
	}
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement CheckAgree;
	public void ClickCheckagree() {
		CheckAgree.click();
	}
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement ContinueButton;
	public void ClickContinueButton() {
		ContinueButton.click();
	}
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement SuccessMessage;
	public String DisplaySuccessmessage() {
		try {
			return(SuccessMessage.getText());
		}
		catch(Exception e) {
			return(e.getMessage());
			
		}
		
	}
	
	

}
