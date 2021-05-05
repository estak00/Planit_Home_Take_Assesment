package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	
	public WebDriver driver;
	
	public ContactPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='forename']")
	public WebElement Forename;
	
	@FindBy(xpath="//input[@id='surname']")
    public WebElement Surname;
	
	@FindBy(xpath="//input[@id='email']")
	public WebElement Email;
	
	@FindBy(xpath="//input[@id='telephone']")
	public WebElement Telephone;
	
	@FindBy(xpath="//*[@id='message']")
	public WebElement Message;
	
	@FindBy(xpath="//a[@class='btn-contact btn btn-primary']")
	public WebElement Submit;
	
	@FindBy(xpath="//*[@id='forename-err']")
	public WebElement forename_err;
	
	@FindBy(xpath="//*[@id='email-err']")
	public WebElement email_err;
	
	@FindBy(xpath="//*[@id='message-err']")
	public WebElement message_err;
	
	@FindBy(xpath="//*[@class='alert alert-success']")
	public WebElement alertSuccess;
	
}
