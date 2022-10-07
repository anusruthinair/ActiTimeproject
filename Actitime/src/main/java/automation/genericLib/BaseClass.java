package automation.genericLib;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import automation.elementRepository.LoginLocators;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver listenerdriver;
	public DataUtility du=new DataUtility();
	public CommonUtility cu=new CommonUtility();
	
	
	@BeforeClass(alwaysRun=true)
	public void launchBrowser()
	{
		
		System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
		driver=new ChromeDriver();
		listenerdriver=driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@BeforeMethod(alwaysRun=true)
	public void login() throws IOException
	{ 
		driver.get(du.getDatafromproperties("Url"));
		LoginLocators ll=new LoginLocators(driver);
		ll.loginApp(du.getDatafromproperties("username"),du.getDatafromproperties("password"));
	}
	@AfterMethod(alwaysRun=true)
	public void logout()
	{
		driver.findElement(By.id("logoutLink")).click();
	}
	@AfterClass(alwaysRun=true)
	public void closeBrowser()
	{
		driver.close();
	}

}








