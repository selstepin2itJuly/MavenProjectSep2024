package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	private final Logger logger = LogManager.getLogger(LoginPage.class);
	private WebDriver driver;
	//Constructor to initialize page factory
	public LoginPage(WebDriver dr)
	{
		logger.info("Initializing Driver & Login Page Elements");
		this.driver=dr;
		PageFactory.initElements(driver, this); // to initialize the locators
	}
	
	//Locators on Login Page
	@FindBy(name="username")
	private WebElement username;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(css="[type='submit']")
	private WebElement login;
	
	@FindBy(xpath="//div[@class='orangehrm-login-error']/descendant::p")
	private WebElement error;
	
	@FindBy(css="[class='orangehrm-login-forgot']>p")
	private WebElement forgotYourPassword;
	
	//Functions of Login page
	public void login(String user, String pass) {
		logger.info("enter user credentials");
		username.sendKeys(user);
		password.sendKeys(pass);
		login.click();
	}
	
	public boolean isErrorDisplayed()
	{
		boolean b = false;
		try {
			b = error.isDisplayed();
		}catch(Exception e){
			e.printStackTrace();
		}
		logger.info("Is Error Displayed: "+b);
		return b;
	}
	
	public String getErrorText()
	{
		logger.info("Error Text is: "+error.getText());
		return error.getText();
	}
	
	public boolean isLoginPageDisplayed()
	{
		boolean b = false;
		try {
			b = login.isDisplayed();
		}catch(Exception e){
			e.printStackTrace();
		}
		logger.info("Is Login Page Displayed: "+b);
		return b;
	}
	
	public void clickOnForgotyourPassword()
	{
		logger.info("Click on Forgot your password");
		forgotYourPassword.click();
	}
}
