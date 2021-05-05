package ShopTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObjects.ContactPage;
import PageObjects.HomePage;
import PageObjects.ShopPage;
import configuration.BaseClass;

public class TC001_validateCart extends BaseClass {
	
	ContactPage cp;
	HomePage hp;
	ShopPage sp;
	SoftAssert softassert = new SoftAssert();
	@BeforeTest
	public void BrowserLaunch() throws IOException
	{
		DriverManager();
		driver.get(prop.getProperty("url"));
		cp = new ContactPage(driver);
		hp = new HomePage(driver);
		sp = new ShopPage(driver);
	}
	
	@Test
	public void validateCart() throws InterruptedException
	{
		hp.Shop.click();
		Thread.sleep(3000);
		sp.FunnyCow.click();
		sp.FunnyCow.click();
		sp.FluffyBunny.click();
		Thread.sleep(2000);
		sp.Cart.click();
		Thread.sleep(2000);
		String count=sp.Get_cart_count();
		softassert.assertEquals(count,"3");
		sp.Item1.getText();
		System.out.println(sp.Item1.getText());
		System.out.println(sp.item1_quantity.getAttribute("value"));
		softassert.assertEquals(sp.Item1.getText(), "Funny Cow");
		Thread.sleep(2000);
		sp.Item2.getText();
		System.out.println(sp.Item2.getText());
		System.out.println(sp.item2_quantity.getAttribute("value"));
		softassert.assertEquals(sp.Item2.getText(), "Fluffy Bunny");
		softassert.assertAll();
		
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
