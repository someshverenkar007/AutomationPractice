import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;

import io.github.bonigarcia.wdm.WebDriverManager;

public class loginUI {
		
	
	
//		public static String browser = "chrome";
//		
//		static WebDriver driver;
//		static Logger log = Logger.getLogger(loginUI.class);
//		
//		@BeforeTest
//		public void launchBrowser() {
//			
//			if (browser.equals("chrome")) {
//				WebDriverManager.chromedriver().setup();
//				driver = new ChromeDriver();
//				driver.manage().window().maximize();
//		}   else if(browser.equals("safari")) {
//				WebDriverManager.chromedriver().setup();
//				driver = new ChromeDriver();
//				driver.manage().window().maximize();
//		}   else if(browser.equals("firefox")) {
//				WebDriverManager.chromedriver().setup();
//				driver = new ChromeDriver();
//				driver.manage().window().maximize();
//		}   else if(browser.equals("edge")) {
//				WebDriverManager.chromedriver().setup();
//				driver = new ChromeDriver();
//				driver.manage().window().maximize();		
//		}		
//				
//			driver.get("https://webp-gcp.classplusapp.com");
//			String expectedUrl = "Login"; //print URL
//			String actualUrl = driver.getTitle();
//			SoftAssert s = new SoftAssert();
//			s.assertEquals(actualUrl, expectedUrl);
//			s.assertAll();
//			
//		}
//		
//		
//		@Test(priority = 0)
//		public void loginUI() {
//			
//			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//			driver.findElement(By.xpath("//p[contains(text() , 'Login to your account')]"));
//			System.out.println("Login to your account");
//			log.info("Login to your account");
//			
//			
//			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//			driver.findElement(By.xpath("//p[contains(text(),'Login to your account')]"));
//			System.out.println("Login to your account");
//			log.info("login to your account");
//			driver.findElement(By.xpath("//input[@placeholder='Enter org code']")).sendKeys("learn");
//			System.out.println("Org code field");
//			driver.findElement(By.xpath("//div[contains(text(),'+91')]"));
//			System.out.println("Country code : +91");
//			driver.findElement(By.xpath("//input[@placeholder='Enter your mobile number']")).click();
//			System.out.println("Mobile number field");
//			driver.findElement(By.xpath("//p[contains(text(),' Use your email instead')]")).click();
//			System.out.println("Use email");
//			driver.findElement(By.xpath("//input[@placeholder= 'eg. harshsrivastava@gmail.com']"));
//			System.out.println("Email field");
//			driver.findElement(By.xpath("//p[contains(text(),'Use your mobile number instead')]"));
//			System.out.println("Use mobile number link");
//			driver.findElement(By.xpath("//button[contains(text(),'Proceed Securely')]")).isDisplayed();
//			System.out.println("Proceed Securely button is disable");
//			driver.findElement(By.linkText("terms and conditions"));
//			System.out.println("terms and conditions link");
//
//		}
//
//		@Test(priority=1)
//		public void loginScreenValidation() throws InterruptedException{
//			
//			WebElement proceedSecurelyBtn = driver.findElement(By.xpath("//button[contains(text(),'Proceed Securely')]"));
//			WebElement orgCode = driver.findElement(By.xpath("//input[@placeholder='Enter org code']"));
//
//			if(proceedSecurelyBtn.isEnabled())
//				System.out.println("Fail : Procedd securely button is enable");
//			else
//				System.out.println("Pass : Proceed Securely button is disable");
//			
//			orgCode.clear();
//			orgCode.sendKeys("hello");
//			System.out.println("Enter org code : hello");
//			
//			driver.findElement(By.xpath("//p[contains(text(),'Use your mobile number instead')]")).click();
//
//			driver.findElement(By.xpath("//div[contains(text(),'Invalid org code.')]"));
////			driver.findElement(By.xpath("//div[contains(text(),'Invalid org code.')]"));
//			System.out.println("User get error message : \"Invalid org code. Please check & try again\" ");
//			orgCode.clear();
//			orgCode.sendKeys("learn");
//			System.out.println("Enter org code : learn");
//			
//			WebElement mobileNumber = driver.findElement(By.xpath("//input[@placeholder='Enter your mobile number']"));
//
//			if(proceedSecurelyBtn.isEnabled())
//				System.out.println("Fail : Procedd securely button is enable for blank mobile number");
//			else
//				System.out.println("Pass : Proceed Securely button is disable for blank mobile number");
//			
//			mobileNumber.sendKeys("9");
//			if(proceedSecurelyBtn.isEnabled())
//				System.out.println("Fail : Procedd securely button is enable for 1 digit mobile number");
//			else
//				System.out.println("Pass : Proceed Securely button is disable for 1 digit mobile number");
//			
//			mobileNumber.clear();
//			mobileNumber.sendKeys("97");
//			if(proceedSecurelyBtn.isEnabled())
//				System.out.println("Fail : Procedd securely button is enable for 2 digit mobile number");
//			else
//				System.out.println("Pass : Proceed Securely button is disable for 2 digit mobile number");
//			
//			mobileNumber.clear();
//			mobileNumber.sendKeys("971");
//			if(proceedSecurelyBtn.isEnabled())
//				System.out.println("Fail : Procedd securely button is enable for 3 digit mobile number");
//			else
//				System.out.println("Pass : Proceed Securely button is disable for 3 digit mobile number");
//			
//			mobileNumber.clear();
//			mobileNumber.sendKeys("9711");
//			if(proceedSecurelyBtn.isEnabled())
//				System.out.println("Fail : Procedd securely button is enable for 4 digit mobile number");
//			else
//				System.out.println("Pass : Proceed Securely button is disable for 4 digit mobile number");
//			
//			mobileNumber.clear();
//			mobileNumber.sendKeys("97111");
//			if(proceedSecurelyBtn.isEnabled())
//				System.out.println("Fail : Procedd securely button is enable for 5 digit mobile number");
//			else
//				System.out.println("Pass : Proceed Securely button is disable for 5 digit mobile number");
//			
//			mobileNumber.clear();
//			mobileNumber.sendKeys("971115");
//			if(proceedSecurelyBtn.isEnabled())
//				System.out.println("Fail : Procedd securely button is enable for 6 digit mobile number");
//			else
//				System.out.println("Pass : Proceed Securely button is disable for 6 digit mobile number");
//			
//			mobileNumber.clear();
//			mobileNumber.sendKeys("97153");
//			if(proceedSecurelyBtn.isEnabled())
//				System.out.println("Fail : Procedd securely button is enable for 7 digit mobile number");
//			else
//				System.out.println("Pass : Proceed Securely button is disable for 7 digit mobile number");
//			
//			mobileNumber.clear();
//			mobileNumber.sendKeys("971530");
//			if(proceedSecurelyBtn.isEnabled())
//				System.out.println("Fail : Procedd securely button is enable for 8 digit mobile number");
//			else
//				System.out.println("Pass : Proceed Securely button is disable for 8 digit mobile number");
//			
//			mobileNumber.clear();
//			mobileNumber.sendKeys("971115307");
//			if(proceedSecurelyBtn.isEnabled())
//				System.out.println("Fail : Procedd securely button is enable for 9 digit mobile number");
//			else
//				System.out.println("Pass : Proceed Securely button is disable for 9 digit mobile number");
//			
//			mobileNumber.clear();
//			mobileNumber.sendKeys("97111530799");
//			if(proceedSecurelyBtn.isEnabled())
//				System.out.println("Fail : Procedd securely button is enable for more than 10 digit mobile number");
//			else
//				System.out.println("Pass : Proceed Securely button is disable for more than 10 digit mobile number");
//			
//			mobileNumber.clear();
//			mobileNumber.sendKeys("1711153079");
//			if(proceedSecurelyBtn.isEnabled())
//				System.out.println("Fail : Procedd securely button is enable for mobile number starting with 1");
//			else
//				System.out.println("Pass : Proceed Securely button is disable for mobile number starting with 1");
//			
//			mobileNumber.clear();
//			mobileNumber.sendKeys("2711153079");
//			if(proceedSecurelyBtn.isEnabled())
//				System.out.println("Fail : Procedd securely button is enable for mobile number starting with 2");
//			else
//				System.out.println("Pass : Proceed Securely button is disable for mobile number starting with 2");
//			
//			mobileNumber.clear();
//			mobileNumber.sendKeys("39711153079");
//			if(proceedSecurelyBtn.isEnabled())
//				System.out.println("Fail : Procedd securely button is enable for mobile number starting with 3");
//			else
//				System.out.println("Pass : Proceed Securely button is disable for mobile number starting with 3");
//			
//			mobileNumber.clear();
//			mobileNumber.sendKeys("49711153079");
//			if(proceedSecurelyBtn.isEnabled())
//				System.out.println("Fail : Procedd securely button is enable for mobile number starting with 4");
//			else
//				System.out.println("Pass : Proceed Securely button is disable for mobile number starting with 4");
//			
//			mobileNumber.clear();
//			mobileNumber.sendKeys("59711153079");
//			if(proceedSecurelyBtn.isEnabled())
//				System.out.println("Fail : Procedd securely button is enable for mobile number starting with 5");
//			else
//				System.out.println("Pass : Proceed Securely button is disable for mobile number starting with 5");
//			
//			
//			mobileNumber.clear();
//			Thread.sleep(1000);
//			driver.findElement(By.xpath("//p[contains(text(),' Use your email instead')]")).click();
//			
//			WebElement email = driver.findElement(By.xpath("//input[@placeholder= 'eg. harshsrivastava@gmail.com']"));
//			
//			if(proceedSecurelyBtn.isEnabled())
//				System.out.println("Fail : Procedd securely button is enable for blank email");
//			else
//				System.out.println("Pass : Proceed Securely button is disable for blank email");
//			
//
//			email.sendKeys("email");
//			System.out.println("Enter email id : email");
//			proceedSecurelyBtn.click();
//			
//			WebElement emailValidation = driver.findElement(By.xpath("//label[contains(text(),' Please enter a valid email address')]"));
//			if(emailValidation.isDisplayed())
//				System.out.println("Pass : User get error message : Please enter a valid email address");
//			else 
//				System.out.println("Fail : User isn't getting error message");
//			
//			
//			email.clear();
//			email.sendKeys("email@hey");
//			System.out.println("Enter email id : email@hey");
//			proceedSecurelyBtn.click();
////			WebElement emailValidation = driver.findElement(By.xpath("//label[contains(text(),' Please enter a valid email address')]"));
//			if(driver.findElement(By.xpath("//label[contains(text(),' Please enter a valid email address')]")).isDisplayed())
//				System.out.println("Pass : User get error message : Please enter a valid email address");
//			else 
//				System.out.println("Fail : User isn't getting error message");
//			
//			email.clear();
//			email.sendKeys("email@hey@hey");
//			System.out.println("Enter email id : email@hey@hey");
//			proceedSecurelyBtn.click();
//			if(driver.findElement(By.xpath("//label[contains(text(),' Please enter a valid email address')]")).isDisplayed())
//				System.out.println("Pass : User get error message : Please enter a valid email address");
//			else 
//				System.out.println("Fail : User isn't getting error message");
//			
//			email.clear();
//			email.sendKeys("email.com");
//			System.out.println("Enter email id : email.com");
//			proceedSecurelyBtn.click();
//			if(driver.findElement(By.xpath("//label[contains(text(),' Please enter a valid email address')]")).isDisplayed())
//				System.out.println("Pass : User get error message : Please enter a valid email address");
//			else 
//				System.out.println("Fail : User isn't getting error message");
//			
//			driver.findElement(By.linkText("terms and conditions")).click();
//			System.out.println("User click on terms and conditions link");
//			Set<String> windowIds = driver.getWindowHandles();
//			Iterator<String> iterator = windowIds.iterator();
//			String firstWindow = iterator.next();
//			String secondWindow = iterator.next();
//			driver.switchTo().window(secondWindow);
//			String expectedTitle = "Terms and Conditions";
//			String actualTitle = driver.getTitle();
//			SoftAssert softAssert = new SoftAssert();
//			AssertJUnit.assertEquals(actualTitle, expectedTitle);
//			driver.close();
//			driver.switchTo().window(firstWindow);
//
//		}
//		
//		@Test(priority=2)
//		public void otpScreenValidation () throws InterruptedException{
//			
//			driver.navigate().refresh();
//			System.out.println("Refresh page");
//			Thread.sleep(1000);
//			driver.findElement(By.xpath("//input[@placeholder='Enter org code']")).sendKeys("learn");
//			System.out.println("Enter org code : learn");
//			driver.findElement(By.xpath("//input[@placeholder='Enter your mobile number']")).sendKeys("9711153079");
//			System.out.println("Enter mobile number : 9711153079");
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("//button[contains(text(),'Proceed Securely')]")).click();
//			
//			driver.findElement(By.xpath("//span[contains(text(), '+91-9711153079')]"));
//			System.out.println("Pass : User get message at otp screen : Please enter the 4-digit verification code sent to you a +91-971115307");
//			WebElement otp = driver.findElement(By.xpath("//input[@id='otp_input']"));
//			System.out.println("Pass : User get OTP field");
//			WebElement verifyOtpBtn = driver.findElement(By.xpath("//button[contains(text(), 'Verify OTP')]"));
//			if(verifyOtpBtn.isEnabled())
//				System.out.println("Fail : Verify OTP button is enable for blank OTP field");
//			else
//				System.out.println("Pass : Verify OTp buttin is disable for blank OTP field");
//			
//			driver.findElement(By.xpath("//div[contains(text(), 'Resend otp in')]"));
//			System.out.println("User get messaeg : Resend otp in n seconds");
//			Thread.sleep(15000);
//			driver.findElement(By.xpath("//div[contains(text(), 'Send OTP again')]"));
//			System.out.println("User get Send OTP again link after 15 seconds");
//			driver.findElement(By.xpath("//div[contains(text(), 'Send OTP again')]")).click();
//			driver.findElement(By.xpath("//div[contains(text(), 'Resend otp in')]"));
//			System.out.println("User get 15 seconds timer again to send OTP");
//			
//			otp.sendKeys("1");
//			System.out.println("Enter OTP : 1");
//			if(verifyOtpBtn.isEnabled())
//				System.out.println("Fail : Verify OTP button is enable for 1 digit OTP");
//			else
//				System.out.println("Pass : Verify OTp buttin is disable for 1 digit OTP");
//			
//			otp.clear();
//			otp.sendKeys("11");
//			System.out.println("Enter OTP : 11");
//			if(verifyOtpBtn.isEnabled())
//				System.out.println("Fail : Verify OTP button is enable for 2 digit OTP");
//			else
//				System.out.println("Pass : Verify OTp buttin is disable for 2 digit OTP");
//			
//			otp.clear();
//			otp.sendKeys("111");
//			System.out.println("Enter OTP : 111");
//			if(verifyOtpBtn.isEnabled())
//				System.out.println("Fail : Verify OTP button is enable for 3 digit OTP");
//			else
//				System.out.println("Pass : Verify OTp buttin is disable for 3 digit OTP");
//			
//			otp.clear();
//			otp.sendKeys("1111");
//			System.out.println("Enter OTP : 1111");
//			if(verifyOtpBtn.isEnabled())
//				System.out.println("Pass : Verify OTP button is enable for 4 digit OTP");
//			else
//				System.out.println("Fail : Verify OTp buttin is disable for 4 digit OTP");
//			
//			otp.clear();
//			otp.sendKeys("11111");
//			System.out.println("Enter OTP : 11111");
//			if(verifyOtpBtn.isEnabled())
//				System.out.println("Fail : Verify OTP button is enable for more than 4 digit OTP");
//			else
//				System.out.println("Pass : Verify OTp buttin is disable for more than 4 digit OTP");
//			
//			driver.findElement(By.xpath("//label[contains(text(), 'Back')]")).click();
//			System.out.println("User click on back button");
//			Thread.sleep(5000);
//			driver.findElement(By.xpath("//p[contains(text(),'Login to your account')]"));
//			driver.findElement(By.xpath("//input[@value='learn']"));
//			driver.findElement(By.xpath("//input[@value='9711153079']"));
//			System.out.println("User navigate to login screen from Verify OTP screen with org code : learn and mobile : 9711153079");
//			
//	
//			
//			
//		}
//
//		public void login() {
//
//			driver.findElement(By.xpath("//input[@placeholder='Enter org code']")).sendKeys("learn");
//			driver.findElement(By.xpath("//input[@placeholder='Enter your mobile number']")).sendKeys("9711153079");
//			driver.findElement(By.xpath("//button[contains(text(),'Proceed Securely')]")).click();
//		
//		}
//

		@AfterTest
		public void closeBrowser() {
		
//			driver.close();
		}
		
	}


