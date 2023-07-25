package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import AbsctarorMethods.AbstractionClass;


public class confirmationPage extends AbstractionClass {
	
	WebDriver driver;
	
	public confirmationPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	
	@FindBy(css=".hero-primary")
	WebElement message;

	
	
	
	
	public String checkMessage()
	{
		return message.getText();
		
	 }
	}
	
	
	
	

