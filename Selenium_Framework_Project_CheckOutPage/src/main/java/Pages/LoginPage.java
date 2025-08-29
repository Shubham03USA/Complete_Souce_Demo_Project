package Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;
import Utilities.ReadData;

public class LoginPage extends TestBase
{
	
	// Object Repository fined out by @Findby annotation
	
	@FindBy(xpath = "//input[@name='user-name']") private WebElement userTxtBox;
	@FindBy(xpath = "//input[@name='password']") private WebElement passwordTxtBox;
	@FindBy(xpath = "//input[@name='login-button']") private WebElement loginbtn;
		
	public LoginPage()
	{
		super();
		PageFactory.initElements(driver,this);
	}
	
	public String loginToApplication() throws IOException
	{
		userTxtBox.sendKeys(ReadData.readPropertyFile("UserName"));
		passwordTxtBox.sendKeys(ReadData.readPropertyFile("Password"));
		loginbtn.click();;
		return driver.getCurrentUrl();
		
	}

	public String verifyTitleofApplication()
	{
		return driver.getTitle();
	}
	
	public String verifyURLofApplication()
	{
		return driver.getCurrentUrl();
	}

}
