package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbsctarorMethods.AbstractionClass;

public class LoginPage extends AbstractionClass {
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
@FindBy(css="[class*='toast-message']")
WebElement errorMessage;

@FindBy(id="userEmail")
WebElement username;

@FindBy(id="userPassword")
WebElement pass;

@FindBy(id="login")
WebElement submit;

public productadding loginDetails(String name, String Password)
{
	username.sendKeys(name);
	pass.sendKeys(Password);
	submit.click();
	return new productadding(driver);
}
public void goTo()
{
	driver.get("https://rahulshettyacademy.com/client");
	

}
public String getErrorMessage()
{
	return errorMessage.getText();
}




	}

