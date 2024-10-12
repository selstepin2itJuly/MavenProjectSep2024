package testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import common.CommonUtility;
import driverUtility.TestBase;
import listeners.TestNGListener;
import pages.DashboardPage;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import pages.MyInfoPage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

@Listeners(TestNGListener.class)
public class MyInfoTest {
	static final Logger logger = LogManager.getLogger(ForgotPasswordPage.class);
	
	private TestBase tb;
	private LoginPage loginpage;
	private DashboardPage dp;
	private MyInfoPage mfp;
	private WebDriver dr;
	
  @Test(description="TC005 Verify My Info Tab Menu Items Count")
  public void TC005_verifyMyInfoTabMenuItemsCount() {
	  int act = mfp.getMenuItemCount();
	  Assert.assertEquals(act, 10);
  }
  
  @Test(description="TC006 Verify My Info Tab Menu Items Text")
  public void TC006_verifyMyInfoTabMenuItemsText() {
	  List<String> act = mfp.getMenuItemsText();
	  String[] data = {"Personal Details",
			  "Contact Details",
			  "Emergency Contacts",
			  "Dependents",
			  "Immigration",
			  "Job",
			  "Salary",
			 // "Tax Exemptions",
			  "Report-to",
			  "Qualifications",
			  "Memberships"};
	  List<String> exp = Arrays.asList(data);
	  //Assert.assertEquals(act, exp, "Menu Items Text");
	  SoftAssert sa = new SoftAssert();
	  int count = 0;
	  for(String s:exp) {
		  sa.assertEquals(act.get(count), s, "Menu Items Text:"+count);
		  count++;
	  }
	  sa.assertAll();
	  
  }
  
  @Parameters({"Username", "Password"})
  @BeforeClass(alwaysRun=true)
  public void beforeClass(String user, String pass) throws Throwable {
	    tb = new TestBase();
	    dr = tb.getDriver();
		loginpage =new LoginPage(dr);
		dp = new DashboardPage(dr);
		mfp = new MyInfoPage(dr);
		loginpage.login(user, pass);
		boolean b = dp.isLoginSuccessFul();
		Assert.assertTrue(b);
		dp.clickOnMyInfoTab();
  }

  @AfterClass(alwaysRun=true)
  public void afterClass() {
	  if(dr !=null) {
			logger.info("Driver Value:"+dr);
			CommonUtility.attachScreenshot(dr);
			CommonUtility.closeBrowser(dr);
			}
  }

}
