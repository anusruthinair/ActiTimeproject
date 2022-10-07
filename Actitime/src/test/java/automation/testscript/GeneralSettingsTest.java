package automation.testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import automation.genericLib.BaseClass;

public class GeneralSettingsTest extends BaseClass{
	@Test
	public void dropDownHandling()
	{
		driver.findElement(By.className("popup_menu_button_settings")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Manage system settings')]/..")).click();
		WebElement toplevel=driver.findElement(By.id("firstHierarchyLevelCodeSelect"));
		cu.getSelectbyVisibleText(toplevel,"Product");
		String msg=driver.findElement(By.id("FormModifiedTextCell")).getText();
		System.out.println(msg);
	}

}
