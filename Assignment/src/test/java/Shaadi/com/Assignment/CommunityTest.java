package Shaadi.com.Assignment;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class CommunityTest {
	
	public WebDriver driver;
	

  @BeforeMethod
  public void beforeMethod() {
	  
	  System.setProperty("webdriver.chrome.driver",  "chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  }
  
  @Test(dataProvider="datarprovider")
  public void VerifyCommunityTest(String domain, String community){
	  
	  //driver.get("https://www.gujaratishaadi.com/");
	  driver.get(domain);
	  driver.findElement(By.xpath("//*[@data-testid='lets_begin']")).click();
	  
	  driver.findElement(By.xpath("//*[@data-testid='email']")).clear();
	  driver.findElement(By.xpath("//*[@data-testid='email']")).sendKeys("abc@gmail.com");
	  
	  driver.findElement(By.xpath("//*[@data-testid='signup_password']")).clear();
	  driver.findElement(By.xpath("//*[@data-testid='signup_password']")).sendKeys("abc123");
	  
	   driver.findElement(By.xpath("//*[@class='Dropdown-placeholder']")).click();
	  
	    driver.findElement(By.xpath("//*[text()='Daughter']")).click();
	    
	    driver.findElement(By.xpath("//*[@data-testid='next_button']")).click();
	    
	    String Community = driver.findElement(By.xpath("(//*[@class='Dropdown-placeholder is-selected'])[2]")).getText();
	    
	   // Assert.assertEquals(Community, "Gujarati");
	    Assert.assertEquals(Community, community);
  }
  

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

  @DataProvider
  public Iterator<Object[]> datarprovider() throws Throwable {
	  ArrayList<Object[]> data = Utility.dataread();
	  return data.iterator();
  }

}
