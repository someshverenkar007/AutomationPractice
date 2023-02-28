package AutomationPractice;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AutomationPractice {
	
	 WebDriver driver = null;;
	
	@BeforeMethod
	public void openBrowser()
	{
		System.setProperty("webdriver.chromedriver","chromedriver");
	    driver = new ChromeDriver();
		driver.get("https://webp-gcp.classplusapp.com/newApp/batches");
		
		String expectedUrl = "Login"; //print URL
		String actualUrl = driver.getTitle();
		SoftAssert s = new SoftAssert();
		AssertJUnit.assertEquals(actualUrl, expectedUrl);
		s.assertAll();
	}
	
		@Test(priority = 0)
		public  void loginUI()  {		
			
			driver.findElement(By.xpath("//input[@class='accountLogin-input']")).sendKeys("learn");
			driver.findElement(By.xpath("//input[@data-cy='login_number']")).sendKeys("7696380800");
			driver.findElement(By.id("Proceed Securely")).click();
		
			driver.findElement(By.id("otp_input")).sendKeys("1234");	
			driver.findElement(By.xpath("//button[text()= ' Verify OTP']")).click();
	}		

		@Test
		public void lessThan10DigitMobileNumber () throws InterruptedException {
			driver.findElement(By.xpath("//input[@placeholder='Enter org code']")).sendKeys("learn");
			driver.findElement(By.xpath("//input[@placeholder='Enter your mobile number']")).sendKeys("7696380");
		  
			Thread.sleep(2000);
			String disable= driver.findElement(By.xpath("//button[text()='Proceed Securely']")).getAttribute("class");
			System.out.println("disable" + disable);
			AssertJUnit.assertTrue(disable.contains("disabled"));
	}
	
		@Test 
		public void fifteenSecondTimer() throws InterruptedException  {
			driver.findElement(By.xpath("//input[@placeholder='Enter org code']")).sendKeys("learn");
        	
			Thread.sleep(2000);
        	driver.findElement(By.xpath(" //input[@placeholder='Enter your mobile number']")).click();
        	
        	Thread.sleep(2000);
    		driver.findElement(By.xpath("//p[@class='accountLogin-type-text']")).click();
    		driver.findElement(By.xpath("data-cy=\"login_email\"")).sendKeys("hey@hey.co");
    		driver.findElement(By.xpath("//button[text()='Proceed Securely']")).click();
    		
    	    Thread.sleep(50000);
    		driver.findElement(By.xpath("//div[text()='Send OTP again']")).click();
	}
		
		@Test
		public void ErrorMsgForInvalidOTP() throws InterruptedException {
		driver.findElement(By.xpath("//input[@placeholder='Enter org code']")).sendKeys("learn");
		driver.findElement(By.xpath("//input[@placeholder='Enter your mobile number']")).sendKeys("7696380800");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Proceed Securely']")).click();
	  
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='otp_input']")).sendKeys("1234");
		driver.findElement(By.xpath("//button[@data-cy='login_verify']")).click();
	}
		
		@Test
		public void searchBatchWithAlphabets () throws InterruptedException {
			driver.findElement(By.xpath("//input[@class='accountLogin-input']")).sendKeys("learn");
			driver.findElement(By.xpath("//input[@data-cy='login_number']")).sendKeys("7696380800");
			driver.findElement(By.id("Proceed Securely")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.id("otp_input")).sendKeys("1234");	
			driver.findElement(By.xpath("//button[text()= ' Verify OTP']")).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//input[@placeholder='Search for Batches']")).click();
			driver.findElement(By.xpath("//input[@placeholder='Search for Batches']")).sendKeys("Buddy");
	}
		
		@Test
		public void searchBatchWithDigits () throws InterruptedException {
			driver.findElement(By.xpath("//input[@class='accountLogin-input']")).sendKeys("learn");
			driver.findElement(By.xpath("//input[@data-cy='login_number']")).sendKeys("7696380800");
			driver.findElement(By.id("Proceed Securely")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.id("otp_input")).sendKeys("1234");	
			driver.findElement(By.xpath("//button[text()= ' Verify OTP']")).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//input[@placeholder='Search for Batches']")).click();
			driver.findElement(By.xpath("//input[@placeholder='Search for Batches']")).sendKeys("172647366662636");
	}
		
		@Test
		public void searchBatchWithWlphanumeric () throws InterruptedException{
			driver.findElement(By.xpath("//input[@class='accountLogin-input']")).sendKeys("learn");
			driver.findElement(By.xpath("//input[@data-cy='login_number']")).sendKeys("7696380800");
			driver.findElement(By.id("Proceed Securely")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.id("otp_input")).sendKeys("1234");	
			driver.findElement(By.xpath("//button[text()= ' Verify OTP']")).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//input[@placeholder='Search for Batches']")).click();
			driver.findElement(By.xpath("//input[@placeholder='Search for Batches']")).sendKeys("buddy@3124");
	}
		
		@Test
		public void searchBatchWithSpecialCharacters () throws InterruptedException{
			driver.findElement(By.xpath("//input[@class='accountLogin-input']")).sendKeys("learn");
			driver.findElement(By.xpath("//input[@data-cy='login_number']")).sendKeys("7696380800");
			driver.findElement(By.id("Proceed Securely")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.id("otp_input")).sendKeys("1234");	
			driver.findElement(By.xpath("//button[text()= ' Verify OTP']")).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//input[@placeholder='Search for Batches']")).click();
			driver.findElement(By.xpath("//input[@placeholder='Search for Batches']")).sendKeys("@%$#%&*!!");
	}
		
		@Test
		public void searchBatchInHindiLanguage() throws InterruptedException {
			driver.findElement(By.xpath("//input[@class='accountLogin-input']")).sendKeys("learn");
			driver.findElement(By.xpath("//input[@data-cy='login_number']")).sendKeys("7696380800");
			driver.findElement(By.id("Proceed Securely")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.id("otp_input")).sendKeys("1234");	
			driver.findElement(By.xpath("//button[text()= ' Verify OTP']")).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//input[@placeholder='Search for Batches']")).click();
			driver.findElement(By.xpath("//input[@placeholder='Search for Batches']")).sendKeys("हिंदी");
	}
		
		@Test
		public void zeroBatchesFound () throws InterruptedException {
			driver.findElement(By.xpath("//input[@class='accountLogin-input']")).sendKeys("learn");
			driver.findElement(By.xpath("//input[@data-cy='login_number']")).sendKeys("7696380800");
			driver.findElement(By.id("Proceed Securely")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.id("otp_input")).sendKeys("1234");	
			driver.findElement(By.xpath("//button[text()= ' Verify OTP']")).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//input[@placeholder='Search for Batches']")).click();
			driver.findElement(By.xpath("//input[@placeholder='Search for Batches']")).sendKeys("0");
	}
		
		@Test
		public void sortUsingRecentlyCreated () throws InterruptedException {
			driver.findElement(By.xpath("//input[@class='accountLogin-input']")).sendKeys("learn");
			driver.findElement(By.xpath("//input[@data-cy='login_number']")).sendKeys("7696380800");
			driver.findElement(By.id("Proceed Securely")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.id("otp_input")).sendKeys("1234");	
			driver.findElement(By.xpath("//button[text()= ' Verify OTP']")).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//p[text()='Sort']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//p[text()='Recently Created']")).click();
	}
		
		@Test
		public void sortUsingBatchName () throws InterruptedException {
			driver.findElement(By.xpath("//input[@class='accountLogin-input']")).sendKeys("learn");
			driver.findElement(By.xpath("//input[@data-cy='login_number']")).sendKeys("7696380800");
			driver.findElement(By.id("Proceed Securely")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.id("otp_input")).sendKeys("1234");	
			driver.findElement(By.xpath("//button[text()= ' Verify OTP']")).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//p[text()='Sort']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@class='batchListSort_option']//following-sibling::div")).click();
	}
		
		@Test
		public void createNewBatch () throws InterruptedException {
			driver.findElement(By.xpath("//input[@class='accountLogin-input']")).sendKeys("learn");
			driver.findElement(By.xpath("//input[@data-cy='login_number']")).sendKeys("7696380800");
			driver.findElement(By.id("Proceed Securely")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.id("otp_input")).sendKeys("1234");	
			driver.findElement(By.xpath("//button[text()= ' Verify OTP']")).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//div[@class='btn btn-primary']")).click();
	}
		
		@Test
		public void defaultBatchStartDate () throws InterruptedException {
			driver.findElement(By.xpath("//input[@class='accountLogin-input']")).sendKeys("learn");
			driver.findElement(By.xpath("//input[@data-cy='login_number']")).sendKeys("7696380800");
			driver.findElement(By.id("Proceed Securely")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.id("otp_input")).sendKeys("1234");	
			driver.findElement(By.xpath("//button[text()= ' Verify OTP']")).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//div[@class='btn btn-primary']")).click();
	}
		@Test
		public void previousBatchStartDate () throws InterruptedException {
			driver.findElement(By.xpath("//input[@class='accountLogin-input']")).sendKeys("learn");
			driver.findElement(By.xpath("//input[@data-cy='login_number']")).sendKeys("7696380800");
			driver.findElement(By.id("Proceed Securely")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.id("otp_input")).sendKeys("1234");	
			driver.findElement(By.xpath("//button[text()= ' Verify OTP']")).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//div[@class='btn btn-primary']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@class='form-control']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//td[@class='rdtDay rdtDisabled']")).click();
	}
		
		@Test
		public void futureBatchStartDate () throws InterruptedException {
			driver.findElement(By.xpath("//input[@class='accountLogin-input']")).sendKeys("learn");
			driver.findElement(By.xpath("//input[@data-cy='login_number']")).sendKeys("7696380800");
			driver.findElement(By.id("Proceed Securely")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.id("otp_input")).sendKeys("1234");	
			driver.findElement(By.xpath("//button[text()= ' Verify OTP']")).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//div[@class='btn btn-primary']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@class='form-control']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//td[@class='rdtDay rdtNew']")).click();
	}
		
		@Test
		public void batchNameTextfield () throws InterruptedException {
			driver.findElement(By.xpath("//input[@class='accountLogin-input']")).sendKeys("learn");
			driver.findElement(By.xpath("//input[@data-cy='login_number']")).sendKeys("7696380800");
			driver.findElement(By.id("Proceed Securely")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.id("otp_input")).sendKeys("1234");	
			driver.findElement(By.xpath("//button[text()= ' Verify OTP']")).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//div[@class='btn btn-primary']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@placeholder='e.g. Physics Batch']")).sendKeys("Hey buddy");
			Thread.sleep(10000);
	}
		
		@Test
		public void invalidBatchCode () throws InterruptedException {
			driver.findElement(By.xpath("//input[@class='accountLogin-input']")).sendKeys("learn");
			driver.findElement(By.xpath("//input[@data-cy='login_number']")).sendKeys("7696380800");
			driver.findElement(By.id("Proceed Securely")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.id("otp_input")).sendKeys("1234");	
			driver.findElement(By.xpath("//button[text()= ' Verify OTP']")).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//div[@class='btn btn-primary']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@placeholder='e.g. Physics Batch']")).sendKeys("Hey buddy");
			Thread.sleep(6000);
			driver.findElement(By.xpath("//input[@placeholder='e.g. Phy123']")).sendKeys("#^%$^%$@@");
	}
	
		@Test
		public void verifybatchCount () throws InterruptedException {
			driver.findElement(By.xpath("//input[@class='accountLogin-input']")).sendKeys("learn");
			driver.findElement(By.xpath("//input[@data-cy='login_number']")).sendKeys("7696380800");
			driver.findElement(By.id("Proceed Securely")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.id("otp_input")).sendKeys("1234");	
			driver.findElement(By.xpath("//button[text()= ' Verify OTP']")).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//div[@class='btn btn-primary']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@placeholder='e.g. Physics Batch']")).sendKeys("Hey buddy");
			Thread.sleep(6000);
			driver.findElement(By.xpath("//button[@class='ui mini primary right floated button']")).click();	
	}
		
		@Test
		public void Addfaculty () throws InterruptedException {
			driver.findElement(By.xpath("//input[@class='accountLogin-input']")).sendKeys("learn");
			driver.findElement(By.xpath("//input[@data-cy='login_number']")).sendKeys("7696380800");
			driver.findElement(By.id("Proceed Securely")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.id("otp_input")).sendKeys("1234");	
			driver.findElement(By.xpath("//button[text()= ' Verify OTP']")).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//div[@class='btn btn-primary']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@placeholder='e.g. Physics Batch']")).sendKeys("Hey dudee");
			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[@class='ui mini primary right floated button']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@class='Header_Button']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='members[0].name']")).sendKeys("FacultyGuy");
			driver.findElement(By.xpath("//input[@name='members[0].mobile']")).sendKeys("9012390121");
			driver.findElement(By.xpath("//input[@name='members[0].email']")).sendKeys("facultyguy@hey.co");
			driver.findElement(By.xpath("//button[@class='ui primary right floated button']")).click();
	}
	
		@Test
		public void addStudentManually () throws InterruptedException {
			driver.findElement(By.xpath("//input[@class='accountLogin-input']")).sendKeys("learn");
			driver.findElement(By.xpath("//input[@data-cy='login_number']")).sendKeys("7696380800");
			driver.findElement(By.id("Proceed Securely")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.id("otp_input")).sendKeys("1234");	
			driver.findElement(By.xpath("//button[text()= ' Verify OTP']")).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//div[@class='btn btn-primary']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@placeholder='e.g. Physics Batch']")).sendKeys("Hey buddy1");
			Thread.sleep(6000);
			driver.findElement(By.xpath("//button[@class='ui mini primary right floated button']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@class='addStudentButton']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@style='display: flex; flex-direction: column; align-items: center;']")).click();
			driver.findElement(By.xpath("//input[@placeholder='Enter Student Name']")).sendKeys("Student01");
			driver.findElement(By.xpath("//input[@placeholder='Enter Student Email']")).sendKeys("student01@hey.co");
			driver.findElement(By.xpath("//input[@placeholder='Enter Student Number']")).sendKeys("9012390122");
			driver.findElement(By.xpath("//button[@class='ui primary button']")).click();
	}
	
		@Test
		public void goLiveNow () throws InterruptedException {
			driver.findElement(By.xpath("//input[@class='accountLogin-input']")).sendKeys("learn");
			driver.findElement(By.xpath("//input[@data-cy='login_number']")).sendKeys("7696380800");
			driver.findElement(By.id("Proceed Securely")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.id("otp_input")).sendKeys("1234");	
			driver.findElement(By.xpath("//button[text()= ' Verify OTP']")).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//div[@class='btn btn-primary']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@placeholder='e.g. Physics Batch']")).sendKeys("Hey buddy2");
			Thread.sleep(6000);
			driver.findElement(By.xpath("//button[@class='ui mini primary right floated button']")).click();
			Thread.sleep(4000);
			driver.findElement(By.xpath("//div[@class='LiveVideo_GoliveButton__327DR LiveVideo_GoLiveTutorHeaderButton__1DbQj']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@class='LiveVideo_goLiveModalButton__J3Uk4']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//p[text()='Start Session']")).click();
			Thread.sleep(5000);
	}		
}		