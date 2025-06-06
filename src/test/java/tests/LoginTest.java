package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExcelUtils;
import utils.ExtentReportManager;
import utils.log;

public class LoginTest extends BaseTest{
	
	@DataProvider(name="LoginData")
	public Object[][] getLoginData() throws IOException{
		
		String filePath = System.getProperty("user.dir")+"/testdata/TestData.xlsx";
		ExcelUtils.loadExcel(filePath, "Sheet1");
		int rowCount = ExcelUtils.getRowCount();
		Object[][] data = new Object[rowCount-1][2];
		
		for(int i=1; i<rowCount; i++) {
			
			data[i-1][0] = ExcelUtils.getCellData(i, 0);	// email
			data[i-1][1] = ExcelUtils.getCellData(i, 1);	// Password
		}
		ExcelUtils.closeExcel();
		return data;
	}
	
	@DataProvider(name = "LoginData2")
	public Object[][] getData()
	{
		return new Object[][] {
			{"user1","pass1"},
			{"user1","pass1"},
			{"admin@yourstore.com","admin"}
		};
				
	}
	@Test(dataProvider = "LoginData2")
	public void testValidLogin(String email, String password)
	{
		log.info("Starting login test...");
		test = ExtentReportManager.createTest("LoginTest");
		
		test.info("Navigating to URL");
		LoginPage loginPage = new LoginPage(driver);
		
		test.info("Adding Credientials");
		log.info("Adding Credentials");
//		loginPage.enterEmail("admin@yourstore.com");
//		loginPage.enterPassword("admin");
		loginPage.enterEmail(email);
		loginPage.enterPassword(password);
		test.info("Clicking on Login Button");
		loginPage.clickLogin();
		
		System.out.println("Title of the page is : "+driver.getTitle());
		
		log.info("Verifying Page Title...");
		test.info("Verifying Page Title");
		Assert.assertEquals(driver.getTitle(), "Dashboard / nopCommerce administration");
		
		log.info("Login test completed...");
		test.pass("Login Successfully");
	}

}
