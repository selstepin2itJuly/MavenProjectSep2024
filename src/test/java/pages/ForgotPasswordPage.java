package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {
	static final Logger logger = LogManager.getLogger(ForgotPasswordPage.class);
	
	public ForgotPasswordPage(WebDriver dr)
	{
		logger.info("Initializing Forgot Password Page Elements");
		PageFactory.initElements(dr, this); // to initialize the locators
	}
	
	@FindBy(xpath="//input[@name='username']")
	private WebElement user;
	
	@FindBy(css="[class$='button--cancel']")
	private WebElement cancel;
	
	public void enterUser(String str)
	{
		logger.info("Enter User for which Password needs to change");
		user.sendKeys(str);
	}
	
	public void clickOnCancel()
	{
		logger.info("Click On Cancel");
		cancel.click();
	}
	
}
