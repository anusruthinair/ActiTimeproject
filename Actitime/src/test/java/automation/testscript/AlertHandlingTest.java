package automation.testscript;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import automation.genericLib.BaseClass;
import automation.genericLib.CommonUtility;

@Listeners(automation.genericLib.ListenerImplementation.class)
public class AlertHandlingTest extends BaseClass {
	@Test
	public void typeOfwork()
	{
		driver.findElement(By.className("popup_menu_button_settings")).click();
		driver.findElement(By.linkText("Types of Work")).click();
		driver.findElement(By.xpath("//span[text()='Create Type of Work']")).click();
		driver.findElement(By.id("name")).sendKeys("qspider");
		driver.findElement(By.xpath("//td[@id='ButtonPane']/input[2]")).click();
		cu.alertCancel(driver);
		System.out.println(driver.getTitle());
	}

}
