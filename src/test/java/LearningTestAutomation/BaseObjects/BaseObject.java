package LearningTestAutomation.BaseObjects;

import java.io.FileInputStream;

import pageobject.LoginPage;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
public class BaseObject {
	WebDriver driver;
	protected LoginPage loginpage;
	public WebDriver invokingBrowser() throws IOException {
		
		
		Properties prop = new Properties();
		
//		FileInputStream fis = new FileInputStream("E:\\Selenium\\Testing_Framework\\SeleniumFrameworkDesign\\src\\main\\java\\resources");
//		prop.load(fis);
//		
//		String browser = prop.getProperty("browser");
//		
//		if(browser.equalsIgnoreCase("chrome"))
//		{
//			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
//		}
//		if(browser.equalsIgnoreCase("Edge"))
//		{
//			WebDriverManager.edgedriver().setup();
//			driver = new EdgeDriver();
//		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
	return  driver;
			
	}
	
	@BeforeMethod
	public void landingApplication() throws IOException
	{
		driver=invokingBrowser();
		loginpage = new LoginPage(driver);
		loginpage.goTo();
		
	}
	
	@AfterMethod
	public void quitThebrowser() {
		driver.quit();
		
	}
	
	
	

	
	
	
	
}