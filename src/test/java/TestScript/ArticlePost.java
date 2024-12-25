package TestScript;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.ArticleCreation;
import Pages.EditDlt;
import Pages.HomePage;
import Pages.LoginPage;

public class ArticlePost {
	
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	ArticleCreation articleCreation;
	EditDlt editDelete;
	
	public ArticlePost(){
		TestBase.initDriver();
		driver= TestBase.getDriver();
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		articleCreation = new ArticleCreation(driver);
		editDelete = new EditDlt(driver);
	}
	
	@BeforeTest
	public void setup() {
		TestBase.openUrl("https://conduit-realworld-example-app.fly.dev/#/login");
	}
	
	@Test(priority =1)
	  public void loginTest() {
		  loginPage.ValidLogin("abcd@gmail", "abcdef");
		  Assert.assertTrue(homePage.isLoginSuccess());
		  homePage.ArticleBtn();
	  }
	

	@Test(priority=2)
	
	public void articleNew() {
		articleCreation.ArtCreation("Selenium1","Selenium Tutorial","Course details","assignment");
		Assert.assertTrue(articleCreation.isArticleCreated());

		
	}
	
	@Test(priority=3)
	
	public void viewArticle() {
		homePage.HomeBtn();
		homePage.ViewArticle();
		homePage.DetailedView();
		Assert.assertTrue(articleCreation.isDetailsDisplayed());
	}
	@Test(priority=4)
	
	public void EditArticle() {
		editDelete.EditArticle();
		articleCreation.ArtEdit("Selenium2", "selenium details", "Follow the required courses");
		Assert.assertTrue(articleCreation.isArticleUpdated());
	}
	
	@Test(priority=5)
	
	public void DeleteArticle() {
		editDelete.DltArticle();
		driver.switchTo().alert().accept();
		Assert.assertTrue(homePage.isArticleDeleted());
		
	}
	 
	@Test(priority=6)
	
	public void MessageDisplayed() {
		Assert.assertEquals(homePage.message(), "Articles not available.");
	}

}
