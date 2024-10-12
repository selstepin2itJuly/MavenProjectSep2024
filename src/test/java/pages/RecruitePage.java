package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class RecruitePage {

	public RecruitePage(WebDriver dr)
	{
		PageFactory.initElements(dr, this);
	}
}
