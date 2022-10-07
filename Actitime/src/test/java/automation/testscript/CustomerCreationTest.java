package automation.testscript;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import automation.genericLib.BaseClass;
import automation.genericLib.CommonUtility;
import automation.genericLib.DataUtility;

public class CustomerCreationTest extends BaseClass {
	@Test
	public void createCustomer() throws EncryptedDocumentException, IOException
	{
		CommonUtility cu=new CommonUtility();
		String expectedcustname=du.getDatafromExcelsheet("Sheet1", 0, 0);
		expectedcustname=expectedcustname+cu.getRandom();
		driver.findElement(By.id("container_tasks")).click();
		driver.findElement(By.cssSelector(".title.ellipsis")).click();
		driver.findElement(By.className("createNewCustomer")).click();
		driver.findElement(By.className("newNameField")).sendKeys(expectedcustname);
		driver.findElement(By.cssSelector("[placeholder='Enter Customer Description']")).sendKeys("done");
		driver.findElement(By.xpath("//div[text()='Create Customer']")).click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElementLocated
				(By.cssSelector(".titleEditButtonContainer>.title"), expectedcustname));
		String actualcustname=driver.findElement(By.cssSelector(".titleEditButtonContainer>.title")).getText();
		System.out.println(actualcustname);
		
		
	}


}
