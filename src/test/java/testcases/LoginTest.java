package testcases;

import org.testng.annotations.Test;

import driverUtility.TestBase;
import listeners.TestNGListener;
import pages.DashboardPage;
import pages.ForgotPasswordPage;
import pages.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

@Listeners(TestNGListener.class)
public class LoginTest {
	static final Logger logger = LogManager.getLogger(ForgotPasswordPage.class);
	
	private WebDriver driver;
	private LoginPage lp;
	private DashboardPage dp;
	private TestBase tb;
	private ForgotPasswordPage fpp;
	
  @Test(description="TC001 Verify successful login", dataProvider ="Valid User")
  public void TC001_LoginSuccessful(String user, String pass) {
	  logger.info("Credentials:"+user+":"+pass);
	  lp.login(user, pass);
	  boolean act = dp.isLoginSuccessFul();
	  Assert.assertTrue(act);
	  dp.logout(); 
  }
  
  @Test(description="TC002 Verify unsuccessful login", dataProvider ="Invalid Users")
  public void TC002_LoginUnSuccessful(String user, String pass) {
	  logger.info("Credentials:"+user+":"+pass);
	  lp.login(user, pass);
	  //boolean act = dp.isLoginSuccessFul();
	  boolean act = lp.isErrorDisplayed();
	  Assert.assertTrue(act);
	  String errorAct = lp.getErrorText();
	  Assert.assertEquals(errorAct, "Invalid credentials");
  }
  
  @Test(description="Verify Forgot Your Password")
  public void TC004_VerifyForgotYourPassword()
  {
	  logger.info("Verify Forgot Your Password");
	  lp.clickOnForgotyourPassword();
	  fpp.enterUser("Admin");
	  fpp.clickOnCancel();
	  boolean act = lp.isLoginPageDisplayed();
	  Assert.assertTrue(act);
	
  }
  @BeforeMethod(alwaysRun=true) //precondition
  public void beforeMethod() throws Throwable {
	  
	  tb = new TestBase();
	  driver = tb.getDriver();
	  lp = new LoginPage(driver);
	  dp = new DashboardPage(driver);
	  fpp = new ForgotPasswordPage(driver);
	  
  }

  @AfterMethod(alwaysRun=true) //PostCondition
  public void afterMethod() {
	  tb.quitBrowser();
  }
  @DataProvider(name="Invalid Users")
  public String[][] getInvalidUsers()
  {
	  return new String[][] {
		  {"Admin1", "admin123"},
		  {"Admin", "admin1234"},
		  {"Admin1", "admin1234"}
		  };
  }
  
  @DataProvider(name="Valid User")
  public String[][] getValidUsers()
  {
	  return new String[][] {
		  {"Admin", "admin123"}
		  };
  }
  

}
