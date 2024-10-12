package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyInfoPage {

	public MyInfoPage(WebDriver dr)
	{
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(css="[class*='orangehrm-tabs-item']")
	private List<WebElement> menu;
	
	public int getMenuItemCount()
	{
		return menu.size();
	}
	
	public List<String> getMenuItemsText()
	{
		List<String> temp = new ArrayList<String>();
		for(WebElement e:menu)
		{
			temp.add(e.getText());
		}
		
		return temp;
	}
}
