package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.Cart_Page;
import Pages.CheckOutPage_1;
import Pages.CheckOutPage_2;
import Pages.CheckOut_Complete_Page;
import Pages.Inventory_Page;
import Pages.LoginPage;
import Utilities.Capture_Screenshot;

public class CheckOut_Complete_Page_Test extends TestBase
{
	LoginPage login;
	Inventory_Page invent;
	Cart_Page cp;
	CheckOutPage_1 check1;
	CheckOutPage_2 check2;
	CheckOut_Complete_Page checkComplete;
	
	
	@BeforeMethod(alwaysRun = true)
	public void setup() throws Throwable
	{
		initialization();
		login = new LoginPage();
		invent = new Inventory_Page();
		cp = new Cart_Page();
		check1 = new CheckOutPage_1();
		check2 = new CheckOutPage_2();
		checkComplete = new CheckOut_Complete_Page();
		
		login.loginToApplication();
		invent.add6product();
		invent.ClickcartCount();
		cp.clickOnCheckOutBtn();
		check1.inputInformation();
		check2.clickOnFinishBtn();
	
	}
	
	@Test(enabled = true,groups = "Sanity")
	public void verifyTitleTest()
	{
		String expTitle = "Checkout: Complete!";
		String actTitle = checkComplete.verifyTitle();
		Assert.assertEquals(actTitle, expTitle);
		Reporter.log("Title of finish page = "+actTitle);
	}
	
	@Test(enabled = true,groups = "Regression")
	public void verifyThankYouMsgTest()
	{
		String expmsg = "Thank you for your order!"; 

		String actmsg = checkComplete.verifyThankYouMsg();
		Assert.assertEquals(actmsg, expmsg);
		Reporter.log("Thank you message = "+actmsg);
	}
	
	@Test(enabled = true,groups = "Retesting")
	public void verifyBackHomeBtnTest()
	{
		String expUrl = "https://www.saucedemo.com/inventory.html";
		String actUrl = checkComplete.verifyBackHomeBtn();
		Assert.assertEquals(actUrl, expUrl);
		Reporter.log("Back to the inventory Page = "+actUrl);
	}
	
	@AfterMethod(alwaysRun = true)
	public void CloseBrowser(ITestResult it) throws IOException {
		if (it.FAILURE == it.getStatus()) {
			Capture_Screenshot.screenshot(it.getName());

		}
		driver.close();
	}
	
	
	
}
