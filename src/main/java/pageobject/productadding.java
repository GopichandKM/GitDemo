package pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import AbsctarorMethods.AbstractionClass;


public class productadding extends AbstractionClass {
	
	WebDriver driver;
	
	public productadding(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(css=".mb-3")
	List<WebElement> prodEle;
	
	@FindBy(css=".ng-animating")
	WebElement animating;


	//driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	
	By prodName = By.xpath("//div[@class='card-body']//h5//b");
	
	By prod = By.cssSelector(".mb-3");
	
	By addTo = By.cssSelector(".card-body button:last-of-type");
	
	By toast = By.id("toast-container");
	
	
	
	public List<WebElement> productEleList()
	{
		waitUntilElementVisible(prod);
		return prodEle;
		
	}
	
	public WebElement productByName(String productName)
	{
	
		return (productEleList().stream().filter(s->s.findElement(prodName).getText().equalsIgnoreCase(productName)).findFirst().orElse(null));
	}
	
	public void addToCart(WebElement proEle)
	{
		proEle.findElement(addTo).click();
		waitUntilElementVisible(toast);
		invisiblityOfElement(animating);
		//driver.quit();
		
	}
	
	
	
	

	
	
	
	
	
}
