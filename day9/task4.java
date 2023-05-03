package day9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class task4{
	WebDriver driver;
  
//  @Test

  @Test
  public void find() throws InterruptedException {
	  try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  WebElement name = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
	  WebElement pass = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));
	  WebElement login = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
	  name.sendKeys("Admin");
	  pass.sendKeys("admin123");
	  try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  login.click();
	  try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  String e_url = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
	  String a_url = driver.getCurrentUrl();
	  Assert.assertEquals(e_url, a_url);
  }
  
  @Parameters({"browser"})
  @BeforeMethod()
  public void beforeMethod(String browser1)
  {
	  if(browser1.equals("chrome"))
	  {
		  WebDriverManager.chromedriver().setup();
		  ChromeOptions co = new ChromeOptions();
		  co.addArguments("--remoote-allow-origins");
		  driver=new ChromeDriver(co);
		  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		  driver.manage().window().maximize();
		  }
	  else if (browser1.equals("edge")) {
		  WebDriverManager.edgedriver().setup();
		  EdgeOptions co=new EdgeOptions();
			co.addArguments("--remote-allow-origins=*");
			driver=new EdgeDriver(co);
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			driver.manage().window().maximize();
		  
	  }
	  }
  
  @AfterMethod
  public void teardown() {
//	  driver.close();
	  driver.close();
  }
}