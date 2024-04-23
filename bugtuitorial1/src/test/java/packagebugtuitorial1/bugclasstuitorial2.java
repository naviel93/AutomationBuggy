package packagebugtuitorial1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
public class bugclasstuitorial2 {

	WebDriver driver;
	@BeforeTest
	public void Init() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		//Web page declaration
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
	}
	@Test
	public void login() throws InterruptedException {
		//login
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		Thread.sleep(4000);
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(2000);
				

		
	}
	@Test
	public void page1() {
		driver.quit();
	}

}
