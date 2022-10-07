package automation.genericLib;

import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CommonUtility {
	public int getRandom()
	{
		Random r=new Random();
		int num=r.nextInt(10000);
		return num;
	}
	public void alertCancel(WebDriver driver)
	{
		Alert alt=driver.switchTo().alert();
		alt.dismiss();
	}

	public void getSelectbyVisibleText(WebElement dropdown,String visibleText)
	{
		Select s=new Select(dropdown);
		s.selectByVisibleText(visibleText);
		
	}
}
