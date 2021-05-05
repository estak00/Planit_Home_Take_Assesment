package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='nav-contact']/a")
	public WebElement Contact;
	
	@FindBy(xpath="//li[@id='nav-shop']/a")
	public WebElement Shop;
	//*[@id='nav-contact']/a
}
