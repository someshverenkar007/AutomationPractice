import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class BaseClass {

			
	public static void main(String[] args) throws InterruptedException {

		//Creating pre-defined class
		System.setProperty("webdriver.chrome.driver","chromedriver");
		WebDriver driver = new ChromeDriver();//Creating object of new Chromedriver
		
//		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://webp-gcp.classplusapp.com/");
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//p[@class='accountLogin-heading']"));
		String heading = driver.getTitle();
		Assert.assertEquals(heading, "Login to your account");
	
		driver.findElement(By.xpath("//input[@class='accountLogin-input']")).sendKeys("learn");
		driver.findElement(By.xpath("//input[@data-cy='login_number']")).sendKeys("7696380800");
//		Thread.sleep(3000);
//		driver.findElement(By.id("Proceed Securely")).click();
//		
		
	}

}
