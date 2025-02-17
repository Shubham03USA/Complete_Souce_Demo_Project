package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class CheckOutPage_2 extends TestBase
{
	@FindBy(xpath = "//span[@class='title']")private WebElement checkOutpage2lable;
	
	@FindBy(xpath = "//div[@class='cart_desc_label']")private WebElement Description;
	
	@FindBy(xpath = "//div[text()='Payment Information:']")private WebElement PaymentInfo;
	@FindBy(xpath = "//div[text()='Shipping Information:']")private WebElement ShippingInfo;
	@FindBy(xpath = "//div[text()='Price Total']")private WebElement PriceTotalTag;
	@FindBy(xpath = "//div[@class='summary_total_label']")private WebElement finalPrice;
	
	@FindBy(xpath = "//button[@name='finish']")private WebElement finishBtn;
	@FindBy(xpath = "//button[@name='cancel']")private WebElement cancelBtn;
	
	public CheckOutPage_2()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyLable()
	{
		return checkOutpage2lable.getText();
	}

	public String verifyDescriptionoifItems()
	{
		
		return Description.getText();
	}
	
	public String verifyPaymentInformation()
	{
		return PaymentInfo.getText();
	}
	
	public String verifyShippingInformation()
	{
		return ShippingInfo.getText();
	}
	
	public String verifyPriceTotal()
	{
		return PriceTotalTag.getText();		
	}
	
	public String verifyFinalPrice()
	{
		return finalPrice.getText();
	}
	
	public String clickOnFinishBtn()
	{
		 finishBtn.click();
		 return driver.getCurrentUrl();
	}
	
	public void ClickOnCancelBtn()
	{
		cancelBtn.click();
	}

}
