package AbsctarorMethods;

import java.time.Duration;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageobject.checkoutPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AbstractionClass {
	WebDriver driver;
	
	//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	
	public AbstractionClass(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//
	
	//By inv = By.cssSelector(".ng-animating");
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cart;
	
	public void waitUntilElementVisible(By vis)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(vis));
	}
	
	public void invisiblityOfElement(WebElement inv) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(inv));
	}
	
	public checkoutPage goToCart()
	{
		cart.click();
		return new checkoutPage(driver);
	}

	
	public void elementToClick(By ele)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	

}
