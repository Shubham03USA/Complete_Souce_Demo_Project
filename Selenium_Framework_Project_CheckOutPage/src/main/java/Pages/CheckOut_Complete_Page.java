package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class CheckOut_Complete_Page extends TestBase
{
	@FindBy(xpath = "//span[text()='Checkout: Complete!']")private WebElement CheckoutComplete;
	@FindBy(xpath = "//h2[text()='Thank you for your order!']")private WebElement Thankyoumsg;
	@FindBy(xpath = "//button[@id='back-to-products']")private WebElement BackToHomeBtn;
	
	public CheckOut_Complete_Page() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyTitle()
	{
		return CheckoutComplete.getText();
	}
	
	public String verifyThankYouMsg()
	{
		return Thankyoumsg.getText();
	}
	
	public String verifyBackHomeBtn()
	{
		BackToHomeBtn.click();
		return driver.getCurrentUrl();
	}


}
