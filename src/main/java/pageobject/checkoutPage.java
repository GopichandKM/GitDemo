package pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import AbsctarorMethods.AbstractionClass;


public class checkoutPage extends AbstractionClass {
	
	WebDriver driver;
	
	public checkoutPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(css=".infoWrap")
	List<WebElement> info;
	
	@FindBy(css=".totalRow button")
	WebElement checkout;
	
	
	@FindBy(css=".form-group section button")
	List<WebElement> countrychooser;
	
	@FindBy(css=".actions a")
	WebElement confirm;
	

	//driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	
	By prodName = By.xpath("//div[@class='card-body']//h5//b");
	
	
	By section =By.cssSelector(".cartSection h3");
	
	By countryVisible = By.cssSelector(".form-group section button");
	
	By placeorder = By.cssSelector(".actions a");
	
	
	
	
	public List<WebElement> cartElements()
	{
		waitUntilElementVisible(section);
		return info;
	}
	
	public boolean confirmProduct(String productName)
	{
		
		Boolean match=cartElements().stream().anyMatch(a->a.findElement(section).getText().equalsIgnoreCase(productName));
	    return match;
	    
		//WebElement checkOut = cartElements().stream().filter(s->s.findElement(section).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
		//checkOut.click();
	}
	
	public placeOrder checkout() {
      checkout.click();
      return new placeOrder(driver);
		
	}
	

	
	
	
	
}
