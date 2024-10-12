package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	static final Logger logger = LogManager.getLogger(ForgotPasswordPage.class);
	
	public DashboardPage(WebDriver dr)
	{
		logger.info("Initializing Dashboard Page Elements");
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(className="oxd-userdropdown-name")
	private WebElement userDisplayed;
	
	@FindBy(css="[href='/auth/logout']")
	private WebElement logout;
	
	@FindBy(xpath="//span[text()='My Info']")
	private WebElement myInfoTab;
	
	public void logout()
	{
		logger.info("Logout of application");
		userDisplayed.click();
		logout.click();
	}
	
	public boolean isLoginSuccessFul()
	{
		boolean b = false;
		try {
			b = userDisplayed.isDisplayed();
		}catch(Exception e){
			e.printStackTrace();
		}
		logger.info("is Login Successful: "+b);
		return b;
	}
	
	public void clickOnMyInfoTab()
	{
		myInfoTab.click();
	}
}
