package ContactpageTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.ContactPage;
import PageObjects.HomePage;
import configuration.BaseClass;

public class TC001_ValidateContactpage extends BaseClass {
	
	ContactPage cp;
	HomePage hp;
	@BeforeTest
	public void BrowserLaunch() throws IOException
	{
		DriverManager();
		driver.get(prop.getProperty("url"));
		cp = new ContactPage(driver);
		hp = new HomePage(driver);
	}
	
	@Test(priority=1)
	public void validateErrorsContactpage() throws InterruptedException
	{
		hp.Contact.click();
		Thread.sleep(3000);
		// To Check the valdate errors of the form with blank data
		cp.Forename.sendKeys("");
		cp.Forename.sendKeys(Keys.TAB);
		String exceptedMessage = prop.getProperty("ForeNameErrorMSG");
		String ActualMessage = cp.forename_err.getText();
		Assert.assertEquals(ActualMessage, exceptedMessage);
		cp.Email.sendKeys("");
		cp.Email.sendKeys(Keys.TAB);
		String exceptedMSG = prop.getProperty("EmailErrorMSG");
		String ActualMSG = cp.email_err.getText();
		Assert.assertEquals(ActualMSG, exceptedMSG);
		cp.Message.sendKeys("");
		cp.Message.sendKeys(Keys.TAB);
		String excepted_MSG = prop.getProperty("MessageError");
		String actual_MSG = cp.message_err.getText();
		Assert.assertEquals(actual_MSG, excepted_MSG);
		cp.Submit.click();
	}
	
	@Test(priority=2)
	public void validateContactpage() throws InterruptedException
	{
		hp.Contact.click();
		Thread.sleep(3000);
		// To Check the valdate errors of the form with blank data
		cp.Forename.sendKeys("Smith");
		cp.Email.sendKeys("smith.john@gmail.com");
		cp.Message.sendKeys("Test message");
		Thread.sleep(3000);
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
