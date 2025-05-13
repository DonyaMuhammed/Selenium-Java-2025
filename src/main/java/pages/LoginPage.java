package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.log;

public class LoginPage {
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(id = "Email")
	private WebElement emailTxtBox;
	
	@FindBy(id = "Password")
	private WebElement passwordTxtBox;
	
	@FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div/form/div[3]/button")
	private WebElement submitBtn;
	
//	private By emailTxtBox = By.id("Email");
//	private By passwordTxtBox =By.id("Password");
//	private By submitBtn = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div/form/div[3]/button");
	
	
	public void enterEmail(String email)
	{
		emailTxtBox.clear();
		emailTxtBox.sendKeys(email);
//		driver.findElement(emailTxtBox).clear();
//		driver.findElement(emailTxtBox).sendKeys(email);
	}
	
	public void enterPassword(String password)
	{
		passwordTxtBox.clear();
		passwordTxtBox.sendKeys(password);
//		driver.findElement(passwordTxtBox).clear();
//		driver.findElement(passwordTxtBox).sendKeys(password);
	}
	
	public void clickLogin()
	{
		log.info("Clicking Login Button...");
		submitBtn.click();
//		driver.findElement(submitBtn).click();
	}
}
