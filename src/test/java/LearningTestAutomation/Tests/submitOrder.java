package LearningTestAutomation.Tests;

import pageobject.LoginPage;
import pageobject.checkoutPage;
import pageobject.confirmationPage;
import pageobject.placeOrder;
import pageobject.productadding;

import org.testng.Assert;
import org.testng.annotations.Test;

import LearningTestAutomation.BaseObjects.BaseObject;

import java.io.IOException;

import org.openqa.selenium.WebElement;
public class submitOrder extends BaseObject{

@Test
public void submitingOrder() throws IOException, InterruptedException
{
		
		String product = "ZARA COAT 3";
		
		String subCountry = "ind";
		
		String country ="India";
		productadding pa = loginpage.loginDetails("gopich886@gmail.com", "Gopimar@56789");
		//List<WebElement> productEleList = pa.productEleList();
		WebElement prodcutElement = pa.productByName(product);
		pa.addToCart(prodcutElement);
		checkoutPage checkoutpage = pa.goToCart();
		boolean match =checkoutpage.confirmProduct(product);
		Assert.assertTrue(match);
		placeOrder placeorder =checkoutpage.checkout();
		placeorder.enterCountry(subCountry, country);
		confirmationPage confirmation =placeorder.placeTheOrder();
		String finalMessage =confirmation.checkMessage();
		Assert.assertEquals(finalMessage,"THANKYOU FOR THE ORDER.");
}
		
		
		
		
//		checkout.checkOutWithProduct(product);
//		pa.enterCountry(subCountry,country);
//		pa.placeOrder();
//		Assert.assertTrue(pa.successfulOrder());
//		
		

	}

