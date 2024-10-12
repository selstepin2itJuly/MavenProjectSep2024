package common;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class CommonUtility {

	public WebDriver driver;

	public CommonUtility(WebDriver dr) {
		this.driver = dr;
	}

	public void scrollToElementUsingActions(WebElement ele) {
		Actions action = new Actions(driver);
		action.scrollToElement(ele).perform();
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,400)", "");
	}

	public void clickOnElementUsingActions(WebElement ele) {
		Actions action = new Actions(driver);
		action.click(ele).perform();
	}

	public void scrollToElementUsingJS(WebElement ele) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", ele);
		je.executeScript("window.scrollBy(0,-400)", "");
	}

	public void clickOnElementUsingJS(WebElement ele) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].click();", ele);
	}

	public void captureScreenshot() throws IOException {
		File file = new File("screenshot");
		if (!file.isDirectory()) {
			file.mkdirs();
		} else {
			System.out.println("Folder Exist!!!!");
		}
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		System.out.println(src);
		FileHandler.copy(src, new File(file + "/" + getDateAndTime() + "_image.jpg")); // jpg/png

	}

	private static String getDateAndTime() {
		Date dt = new Date();
		System.out.println(dt);
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY_MMMM_dd_HH_mm_ss_S");
		return sdf.format(dt);
	}

	public static void attachScreenshot(WebDriver dr)
	{
		TakesScreenshot ts = (TakesScreenshot) dr;
		String src = ts.getScreenshotAs(OutputType.BASE64);
		String image="<img src=\"data:image/png;base64,"+src+"\" height=\"600\" width=\"800\" />";
		Reporter.log(image);
	}
}
