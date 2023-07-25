package LearningTestAutomation.Tests;
import pageobject.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
//import java.util.stream.Collectors;

import org.openqa.selenium.By;   //ZARA COAT 3 ZARA COAT 3

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;
public class StandaloneTest1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//WebDriverManaer is for the replacement of SetProperties. This needs dependencies to be added 
		//And need to import org.io.github.boniarica.wdm.webdrivermanager
		WebDriverManager.chromedriver().setup();
		String product = "ZARA COAT 3";
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		LoginPage loginpage = new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		driver.findElement(By.id("userEmail")).sendKeys("gopich886@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Gopimar@56789");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> items = driver.findElements(By.cssSelector(".mb-3"));
		WebElement zara= items.stream().filter(s-> s.findElement(By.xpath("//div[@class='card-body']//h5//b")).getText().equals(product)).findFirst().orElse(null);
		//items.stream().filter(s-> s.findElement(By.xpath("//div[@class='card-body']//h5//b")).getText().equals("ZARA COAT 3")).forEach(s->System.out.println(s.findElement(By.xpath("//div[@class='card-body']//h5//b")).getText()));
		zara.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cartSection h3")));
		////div[@class='infoWrap']//div[@class='cartSection']//h3jjhkbgmnmngkhlggopip got be
		List<WebElement> cart = driver.findElements(By.cssSelector(".infoWrap"));
		cart.stream().filter(s->s.findElement(By.cssSelector(".cartSection h3")).getText().equalsIgnoreCase(product)).forEach(s->System.out.println(s.findElement(By.cssSelector(".cartSection h3")).getText()));
		Boolean match=cart.stream().anyMatch(a->a.findElement(By.cssSelector(".cartSection h3")).getText().equalsIgnoreCase(product));
		Assert.assertTrue(match);
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		driver.findElement(By.cssSelector("input[placeholder='Select Country'")).sendKeys("ind");
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".form-group section button")));
		List<WebElement> country =driver.findElements(By.cssSelector(".form-group section button"));
		country.stream().forEach(s->System.out.println(s.getText()));
	    (country.stream().filter(s->s.getText().equalsIgnoreCase("India")).findFirst().orElse(null)).click();
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,300)");
	    Thread.sleep(1000);
	    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".actions a")));
		driver.findElement(By.cssSelector(".actions a")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector(".hero-primary")).getText(), "THANKYOU FOR THE ORDER.");
	    //ZARA COAT 3
		Thread.sleep(3000);
        driver.quit();
		
		
		
		

	}

}
