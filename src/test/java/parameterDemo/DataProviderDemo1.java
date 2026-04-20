package parameterDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo1 {
	
  private static final ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
  
  @BeforeMethod
  public void setUp() {
	  
	  driver.set(new ChromeDriver());
	  WebDriver chromeDriver=driver.get();
	  
	  chromeDriver.get("https://www.google.com/");
	  chromeDriver.manage().window().maximize();
	 
  }
  
  @Test(dataProvider="testData", dataProviderClass=DataProviderClass.class)
  public void test(String keyword) {
	  
	  WebElement textBox=driver.get().findElement(By.name("q"));
	  
	  textBox.sendKeys(keyword);
	  textBox.sendKeys(Keys.ENTER);
	  
	  System.out.println("Searched : "+keyword);
  }
  
  @AfterMethod
  public void teardown() {
	  driver.get().quit();
  }
  
}
