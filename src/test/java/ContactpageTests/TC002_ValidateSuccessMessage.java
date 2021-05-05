package ContactpageTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObjects.ContactPage;
import PageObjects.HomePage;
import configuration.BaseClass;

public class TC002_ValidateSuccessMessage extends BaseClass{

	ContactPage cp;
	HomePage hp;
	SoftAssert softassert = new SoftAssert();
	@BeforeTest
	public void BrowserLaunch() throws IOException
	{
		DriverManager();
		driver.get(prop.getProperty("url"));
		cp = new ContactPage(driver);
		hp = new HomePage(driver);
	}
	
	@Test
	public void validateContactSubmission() throws InterruptedException
	{
		//To validate the form Submission 
		hp.Contact.click();
		Thread.sleep(3000);
		cp.Forename.sendKeys("JohanSim");
		cp.Email.sendKeys("JohanSim@gmail.com");
		cp.Message.sendKeys("Please note my contact details");
		cp.Submit.click();
		Thread.sleep(8000);
		String exceptedMSG = prop.getProperty("SuccessMSG");
		String actualMSG = cp.alertSuccess.getText();
		softassert.assertEquals(actualMSG, exceptedMSG);
		System.out.println(actualMSG);
		softassert.assertAll();
		Thread.sleep(3000);
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}
