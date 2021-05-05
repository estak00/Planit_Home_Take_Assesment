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

public class TC003_InvalideData extends BaseClass{
	
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
	
	@Test
	public void ContactWithInvalideData() throws InterruptedException
	{
		//To validate the form Submission 
		hp.Contact.click();
		Thread.sleep(3000);
		cp.Forename.sendKeys("JohanSim");
		cp.Email.sendKeys("JohanSim@gmailcom");
		String exceptedMSG = prop.getProperty("eamilalert");
		String ActualMSG = cp.email_err.getText();
		System.out.println(ActualMSG);
		Assert.assertEquals(ActualMSG, exceptedMSG);
		cp.Message.sendKeys("");
		cp.Message.sendKeys(Keys.TAB);
		String excepted_MSG = prop.getProperty("MessageError");
		String actual_MSG = cp.message_err.getText();
		Assert.assertEquals(actual_MSG, excepted_MSG);
		cp.Submit.click();
		Thread.sleep(3000);
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
