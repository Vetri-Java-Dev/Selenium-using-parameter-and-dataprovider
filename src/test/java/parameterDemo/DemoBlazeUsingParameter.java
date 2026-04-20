package parameterDemo;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class DemoBlazeUsingParameter {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @Test
    @Parameters({"correctUsername", "correctPassword"})
    public void validLoginTest(@Optional("vetri1734") String username,@Optional("1234")  String password) {

        driver.get().findElement(By.id("login2")).click();

        WebDriverWait wait=new WebDriverWait(driver.get(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("loginusername")));
        
        driver.get().findElement(By.id("loginusername")).sendKeys(username);
        driver.get().findElement(By.id("loginpassword")).sendKeys(password);

        driver.get().findElement(By.xpath("//button[text()='Log in']")).click();
        
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("nameofuser")));
        
        Assert.assertTrue(driver.get().findElement(By.id("nameofuser")).getText().contains("Welcome"));
        
    }

    @Test(dataProvider = "testData", dataProviderClass = DemoBlazeDataProvider.class)
    public void invalidPassword(String username, String password) {

        driver.get().findElement(By.id("login2")).click();

        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
        
        driver.get().findElement(By.id("loginusername")).sendKeys(username);
        driver.get().findElement(By.id("loginpassword")).sendKeys(password);

        driver.get().findElement(By.xpath("//button[text()='Log in']")).click();

        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.get().switchTo().alert();

        String message = alert.getText();
        System.out.println(message);

        alert.accept();

        Assert.assertTrue(message.contains("Wrong")||message.contains("User"),("Exception : "+message));  
    }
    
    @BeforeMethod(alwaysRun=true)
    public void setup() {
    	driver.set(new ChromeDriver());
        driver.get().manage().window().maximize();
        driver.get().get("https://www.demoblaze.com/");
    }

    @AfterMethod(alwaysRun=true)
    public void teardown() {
        driver.get().quit();
    }
}