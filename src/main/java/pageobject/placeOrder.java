package pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;

import AbsctarorMethods.AbstractionClass;


public class placeOrder extends AbstractionClass {
	
	WebDriver driver;
	
	public placeOrder(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	
	
	
	@FindBy(css="input[placeholder='Select Country']")
	WebElement countrySelector;
	
	@FindBy(css=".form-group section button")
	List<WebElement> countrychooser;
	
	@FindBy(css=".actions a")
	WebElement confirm;
	

	//driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	
	By prodName = By.xpath("//div[@class='card-body']//h5//b");
	
	
	By section =By.cssSelector(".cartSection h3");
	
	By countryVisible = By.cssSelector(".form-group section button");
	
	By placeorder = By.cssSelector(".actions a");
	
	
	
	
	public List<WebElement> countryElements(String subCountry)
	{
		countrySelector.sendKeys(subCountry);
		waitUntilElementVisible(countryVisible);
		return countrychooser;
		
	}
	
	public void enterCountry(String subCountry,String country )
	{
		List<WebElement> countryList =countryElements(subCountry);
		WebElement myCountry=countryList.stream().filter(s->s.getText().equalsIgnoreCase(country)).findFirst().orElse(null);
	    myCountry.click();
	    
	
	}
	
	public confirmationPage placeTheOrder() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,300)");
	    Thread.sleep(3000);
	    waitUntilElementVisible(placeorder);
	    elementToClick(placeorder);
	    confirm.click();
	    return new confirmationPage(driver);
	}
	
	
	
	
	
	
	
}
