package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class task_4 {
	WebDriver driver;
	
	@BeforeSuite
	
	void init() {
		WebDriverManager.chromedriver().setup();
		 ChromeOptions co=new ChromeOptions();
		  co.addArguments("--remote-allow-origins=*");
		  driver=new ChromeDriver(co);
	}
  @Test
  public void f() throws InterruptedException {
	  
	  
	 
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  Thread.sleep(3000);
	  WebElement user=driver.findElement(By.name("username"));
	  user.sendKeys("Admin");
	  
	  WebElement pass=driver.findElement(By.name("password"));
	  pass.sendKeys("admin123");
	  
	  WebElement login=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
	  login.click();
	  
	  
  }
  @Test(dependsOnMethods = "f")
  public void Test2() throws InterruptedException{
	  
	  WebElement acc=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span"));
	  acc.click();
	  
	  Thread.sleep(3000);
	  
	  WebElement log=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul/li[4]/a"));
	  log.click();
	  
  }
}
