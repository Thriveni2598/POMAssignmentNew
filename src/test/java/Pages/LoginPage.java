package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
	@FindBy(name = "email")
	WebElement email;
	
	@FindBy(name ="password")
	WebElement pwd;
	
	@FindBy(xpath="//button[text()='Login']")
	WebElement Btn;
	
	
	
public LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
		
	}
public void ValidLogin(String strEmail, String strPwd) {
	
	
	email.sendKeys(strEmail);
	pwd.sendKeys(strPwd);
	Btn.click();

	
	
}
	

}
