package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopPage {
	
	public WebDriver driver;
	
	public ShopPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	// Items
	@FindBy(xpath="//*[@id='product-6']/div/p/a")
	public WebElement FunnyCow;
	
	@FindBy(xpath="//*[@id='product-4']/div/p/a")
	public WebElement FluffyBunny;
	
	@FindBy(xpath="//*[@id='nav-cart']/a")
	public WebElement Cart;
	
	//Cart Items
	
	@FindBy(xpath="(//*[@class='cart-item ng-scope']//td)[1]")
	public WebElement Item1;
	
	@FindBy(xpath="(//*[@class='cart-item ng-scope']//td)[6]")
	public WebElement Item2;
	
	@FindBy(xpath="(//input[@name='quantity'])[1]")
	public WebElement item1_quantity;
	
	@FindBy(xpath="(//input[@name='quantity'])[2]")
	public WebElement item2_quantity;
	
	@FindBy(xpath="//span[@class='cart-count ng-binding']")
	public WebElement cart_count;
	
	public String Get_cart_count()
	  {
		  return cart_count.getText();
	  }
	
}
