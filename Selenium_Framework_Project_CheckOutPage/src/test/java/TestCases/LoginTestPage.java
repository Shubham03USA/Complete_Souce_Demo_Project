package TestCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;
import Utilities.Capture_Screenshot;
import Utilities.ReadData;

public class LoginTestPage extends TestBase
{
	LoginPage login;
	
	@BeforeMethod
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		login = new LoginPage();
		
	}
	@Test
	public void verifyTitleofApplication() throws EncryptedDocumentException, IOException
	{
		String expTitle = ReadData.readExcel(0, 0); // Swag Labs(0,0)  
		String actTitle = login.verifyTitleofApplication();
		Assert.assertEquals(expTitle,actTitle);
	}
	
	@Test
	public void verifyURLofApplication() throws EncryptedDocumentException, IOException
	{
		String expURL = ReadData.readExcel(0, 1); // (0,1)
		String actURL = login.verifyURLofApplication();
		Assert.assertEquals(expURL, actURL);
	}
	
	@Test
	public void loginToApplication() throws IOException
	{
		String expURL = ReadData.readExcel(0, 2); //(0,2) 
		String actURL = login.loginToApplication();
		Assert.assertEquals(expURL, actURL);
	}
	
		
	@AfterMethod(alwaysRun = true)
	public void CloseBrowser(ITestResult it) throws IOException
	{
		if(it.FAILURE==it.getStatus())
		{
			Capture_Screenshot.screenshot(it.getName());
			
		}
		driver.close();
	}
	
	

}
