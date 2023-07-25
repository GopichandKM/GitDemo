package LearningTestAutomation.Tests;

import pageobject.LoginPage;
import pageobject.checkoutPage;
import pageobject.productadding;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.Assert;

import LearningTestAutomation.BaseObjects.BaseObject;

import java.io.IOException;
public class errorValidation extends BaseObject{

@Test
public void submitingOrder() throws IOException
{
		
		loginpage.loginDetails("gopich886@gmail.com", "Gopar@56789");
		//List<WebElement> productEleList = pa.productEleList();
		Assert.assertEquals("Incorrect email or password.", loginpage.getErrorMessage());
}



@Test
public void productError()
{
	String product = "ZARA COAT 3";

	productadding pa = loginpage.loginDetails("gopich886@gmail.com", "Gopimar@56789");
	//List<WebElement> productEleList = pa.productEleList();
	WebElement prodcutElement = pa.productByName(product);
	pa.addToCart(prodcutElement);
	checkoutPage checkoutpage = pa.goToCart();
	boolean match =checkoutpage.confirmProduct("ZARA COAT 33");
	Assert.assertFalse(match);
}
		
		
		
		
//		checkout.checkOutWithProduct(product);
//		pa.enterCountry(subCountry,country);
//		pa.placeOrder();
//		Assert.assertTrue(pa.successfulOrder());
//		
		

	}

