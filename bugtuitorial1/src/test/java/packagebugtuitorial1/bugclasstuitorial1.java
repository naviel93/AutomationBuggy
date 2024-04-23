package packagebugtuitorial1;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class bugclasstuitorial1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//Web Driver Initialization
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//Web page declaration
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		
		//login
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		Thread.sleep(4000);
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		//Title match using if-else
		String ExpectedTitle = "Swag Labs";
		String ActualTitle = driver.getTitle();
				
		if(ExpectedTitle.equals(ActualTitle)) {
				System.out.println("Title macth");
			}
		else {
				System.out.println("Title don't macth");
			}
		// check Url
		String ExpectedUrl = "https://www.saucedemo.com/inventory.html";
		String ActualUrl = driver.getCurrentUrl();
		
		if(ExpectedUrl.equals(ActualUrl)) {
			System.out.println("url macth");
		}
		else {
			System.out.println("url don't macth");
		}
		
		// navigate commands
		Thread.sleep(3000);
		driver.navigate().refresh();
		driver.navigate().back();
		driver.navigate().forward();
		
		// netlify
		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to("https://trytestingthis.netlify.app/");
		
		//selecting element
		WebElement radiobutton = driver.findElement(By.id("male"));
		WebElement submitbutton = driver.findElement(By.className("btn-success"));
		radiobutton.click();
		assert radiobutton.isSelected();
		System.out.println(radiobutton.isSelected());
		System.out.println(submitbutton.isEnabled());
		
		//DropDown
		WebElement testdropdown = driver.findElement(By.id("option"));
		Select dropdown = new Select(testdropdown);
		
		//select by Index
		dropdown.selectByIndex(1);
		//select by value
		Thread.sleep(2000);
		dropdown.selectByValue("option 3");
		//select by visible text
		Thread.sleep(2000);
		dropdown.selectByVisibleText("Option 2");
		
		
		//select and de-select check list
		driver.findElement(By.name("option1")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("option1")).click();
		Thread.sleep(2000);
		List <WebElement> clickboxes = driver.findElements(By.id("moption"));
		for ( WebElement element : clickboxes ) {
			 if ( !element.isSelected() ) {
				        element.click();
				  }
			}
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		//login
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		Thread.sleep(4000);
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		Thread.sleep(1000);
		driver.findElement(By.id("login-button")).click();
		// using xpath
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='remove-sauce-labs-backpack']")).click();
		
		//using css
		driver.findElement(By.cssSelector("button#add-to-cart-sauce-labs-backpack")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button#remove-sauce-labs-backpack")).click();
		
	}

}
