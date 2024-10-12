package listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import common.CommonUtility;
import driverUtility.Constants;
import pages.ForgotPasswordPage;

public class TestNGListener implements ITestListener {
	static final Logger logger = LogManager.getLogger(ForgotPasswordPage.class);
	
	@Override
	public void onTestFailure(ITestResult tr) {
		Reporter.log(tr.getName()+"\n"+tr.getStartMillis());
		Reporter.log(tr.getEndMillis()+"\n"+tr.getStatus());
		logger.info(tr.getName()+"\n"+tr.getStartMillis());
		logger.info(tr.getEndMillis()+"\n"+tr.getStatus());
		CommonUtility.attachScreenshot(Constants.driverConst);
		CommonUtility.closeBrowser(Constants.driverConst);
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		Reporter.log(tr.getName()+"\n"+tr.getStartMillis());
		Reporter.log(tr.getEndMillis()+"\n"+tr.getStatus());
		logger.info(tr.getName()+"\n"+tr.getStartMillis());
		logger.info(tr.getEndMillis()+"\n"+tr.getStatus());
		CommonUtility.attachScreenshot(Constants.driverConst);
		CommonUtility.closeBrowser(Constants.driverConst);
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		Reporter.log(tr.getName()+"\n"+tr.getStartMillis());
		Reporter.log(tr.getEndMillis()+"\n"+tr.getStatus());
		logger.info(tr.getName()+"\n"+tr.getStartMillis());
		logger.info(tr.getEndMillis()+"\n"+tr.getStatus());
		CommonUtility.attachScreenshot(Constants.driverConst);
		CommonUtility.closeBrowser(Constants.driverConst);
	}

}
