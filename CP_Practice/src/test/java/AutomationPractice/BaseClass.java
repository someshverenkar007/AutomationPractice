package AutomationPractice;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
//	public static Properties prop = new Properties();
//	 //Creating new object to read the properties file
//	public static FileReader fr;
//	
//	
//	public void setUp() throws IOException, InterruptedException {
//	
//		//instantiating the browser	
//		if(driver==null) {//initiallly its null
//			FileReader fr = new FileReader(prop.getProperty("/Users/someshverenkar/git/repository10/"
//					+ "CP_Practice/src/main/resources/data.properties"));//check the value that is passed from properties file || specify the path of properties file
//			prop.load(fr);
//		}
//		
//		if(prop.getProperty("browser").equalsIgnoreCase("chrome")); //ignore statement if the value is case sensitive
//		WebDriverManager.chromedriver().setup();
//		ChromeOptions ops= new ChromeOptions();
//		ops.addArguments("--remote-allow-origins=*");
//		driver = new ChromeDriver(ops);
//		
////		else if(prop.getProperty("browser").equalsIgnoreCase("firefox")); //ignore statement if the value is case sensitive
////		WebDriverManager.firefoxdriver().setup();
////		driver = new FirefoxDriver();
//	
//		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		
//		driver.get(prop.getProperty("url"));
//		System.out.println(driver.getTitle());
//		
//		driver.findElement(By.xpath("//p[@class='accountLogin-heading']"));
//		String heading = driver.getTitle();
//		Assert.assertEquals(heading, "Login to your account");
//	
//		driver.findElement(By.xpath("//input[@class='accountLogin-input']")).sendKeys("learn");
//		driver.findElement(By.xpath("//input[@data-cy='login_number']")).sendKeys("7696380800");
//		Thread.sleep(3000);
//		driver.findElement(By.id("Proceed Securely")).click();
//		
//	}
//}

	
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops= new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(ops);
		driver.get("https://webp-gcp.classplusapp.com/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize(); 
}
	
	public void Login() throws InterruptedException {
		
	    driver.findElement(By.xpath("//input[@data-cy='login_orgCode']")).sendKeys("learn");
	    Thread.sleep(3000);
	    
        driver.findElement(By.xpath("//input[@data-cy='login_number']")).sendKeys("7607984444");
        Thread.sleep(3000);
        
        driver.findElement(By.xpath("//button[text()='Proceed Securely']")).click();
	    Thread.sleep(3000);
	    
	    driver.findElement(By.id("otp_input")).sendKeys("7777");
	    
	    driver.findElement(By.xpath("//button[@data-cy='login_verify']")).click();
	    System.out.println(" user login successfully");
	    Thread.sleep(5000);
}
}

