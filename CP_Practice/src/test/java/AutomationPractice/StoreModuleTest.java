package AutomationPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import AutomationPractice.BaseClass;


	public class StoreModuleTest extends BaseClass {
	
	@BeforeMethod
	public void openBrowser() throws IOException, InterruptedException{
			this.setup();
			this.Login();
	}
	
	 @Test(priority = 16)
	 public void createCourse() throws InterruptedException {
		    driver.findElement(By.xpath("//p[text()='Store']")).click();
		    driver.findElement(By.xpath("//div[text()='Create Course']")).click();		    
		    driver.findElement(By.xpath("//input[@placeholder='Enter Course Name']")).sendKeys("Hel");
		    driver.findElement(By.xpath("//div[@class='ui fitted checkbox']")).click();
		    driver.findElement(By.xpath("//button[text()='Add Content']")).click();
		    Thread.sleep(2000);
		    
			String toastTitle= driver.findElement(By.xpath("//div[@class='rrt-title']")).getText();				
		    Thread.sleep(3000);
			Assert.assertEquals(toastTitle, "Minimum 4 non space characters required for Course name");
	 }
	 
	
	 @Test(priority = 17)
	 public void createCourse1() throws InterruptedException {
		     driver.findElement(By.xpath("//p[text()='Store']")).click();
             driver.findElement(By.xpath("//div[text()='Create Course']")).click();	 
			 driver.findElement(By.xpath("//input[@placeholder='Enter Course Name']")).sendKeys("hello");
			 driver.findElement(By.xpath("//textarea[@placeholder='Description goes here']")).sendKeys("HeyBuddy");
			 driver.findElement(By.xpath("//div[@class='ui fitted checkbox']")).click();
		     driver.findElement(By.xpath("//button[text()='Add Content']")).click();
    		 Thread.sleep(2000);

		     String toastTitle= driver.findElement(By.xpath("//div[@class='rrt-title']")).getText();				
			 Thread.sleep(3000);
			 Assert.assertEquals(toastTitle, "Category cannot be empty");
	}
	 
	 
	 @Test(priority = 18)
	 public void createCourse2() throws InterruptedException {
			 driver.findElement(By.xpath("//p[text()='Store']")).click();
             driver.findElement(By.xpath("//div[text()='Create Course']")).click();	
			 driver.findElement(By.xpath("//input[@placeholder='Enter Course Name']")).sendKeys("hello");
			 driver.findElement(By.xpath("//textarea[@placeholder='Description goes here']")).sendKeys("HeyBuddy");
			 driver.findElement(By.xpath("//div[text()='Pick your Categories']")).click();
			 driver.findElement(By.xpath("//div[@class='menu transition visible']//span[text()='Bank Exams']")).click();
			 driver.findElement(By.xpath("//div[text()='Pick your Subcategories']")).click();
			 driver.findElement(By.xpath("//div[@class='menu transition visible']//span[text()='IBPS']")).click();
			 driver.findElement(By.xpath("//div[@class='ui fitted checkbox']")).click();
			 driver.findElement(By.xpath("//button[text()='Add Content']")).click();
			 Thread.sleep(2000);
			 
			 String toastTitle= driver.findElement(By.xpath("//div[@class='rrt-title']")).getText();				
			 Thread.sleep(3000);
			 Assert.assertEquals(toastTitle, "Course Created Successfully");
	}
	 
	 
	 @Test(priority = 19)
			 public void coursePriceIsBlank() throws InterruptedException {
			 driver.findElement(By.xpath("//p[text()='Store']")).click();
             driver.findElement(By.xpath("//div[text()='Create Course']")).click();	
			 driver.findElement(By.xpath("//input[@placeholder='Enter Course Name']")).sendKeys("hello");
			 driver.findElement(By.xpath("//textarea[@placeholder='Description goes here']")).sendKeys("HeyBuddy");
			 driver.findElement(By.xpath("//div[text()='Pick your Categories']")).click();
			 driver.findElement(By.xpath("//div[@class='menu transition visible']//span[text()='Bank Exams']")).click();
			 driver.findElement(By.xpath("//div[text()='Pick your Subcategories']")).click();
			 driver.findElement(By.xpath("//div[@class='menu transition visible']//span[text()='IBPS']")).click();
			 driver.findElement(By.xpath("//div[@class='ui fitted checkbox']")).click();
			 driver.findElement(By.xpath("//button[text()='Add Content']")).click();
			 Thread.sleep(2000);
			 
			 String toastTitle= driver.findElement(By.xpath("//div[@class='rrt-title']")).getText();				
			 Thread.sleep(3000);
			 Assert.assertEquals(toastTitle, "Price Should be Greater than discount");
	}
	 
	 
	 @Test(priority = 20)
	 public void resellerSetting() throws InterruptedException {
			 driver.findElement(By.xpath("//p[text()='Store']")).click();
		     driver.findElement(By.xpath("//div[text()='Create Course']")).click();	
			 driver.findElement(By.xpath("//input[@placeholder='Enter Course Name']")).sendKeys("hello");
			 driver.findElement(By.xpath("//textarea[@placeholder='Description goes here']")).sendKeys("HeyBuddy");
			 driver.findElement(By.xpath("//div[text()='Pick your Categories']")).click();
			 driver.findElement(By.xpath("//div[@class='menu transition visible']//span[text()='Bank Exams']")).click();
			 driver.findElement(By.xpath("//div[text()='Pick your Subcategories']")).click();
			 driver.findElement(By.xpath("//div[@class='menu transition visible']//span[text()='IBPS']")).click();
			 Thread.sleep(3000);
			 
			 driver.findElement(By.xpath("//label[contains(text(),'Check, if you want to make')]")).click();
			 Thread.sleep(5000);
			 
		     driver.findElement(By.xpath("//div[@class='ui fitted checkbox']")).click();
			 driver.findElement(By.xpath("//button[text()='Add Content']")).click();
			 Thread.sleep(2000);
			 
			 String toastTitle= driver.findElement(By.xpath("//div[@class='rrt-title']")).getText();				
			 Thread.sleep(3000);
			 Assert.assertEquals(toastTitle, "Please enter a minimum valid course value for reseller");
	}
	 
	 
	 @Test(priority = 21)
	 public void shareValueMaximum() throws InterruptedException {
			 driver.findElement(By.xpath("//p[text()='Store']")).click();
		     driver.findElement(By.xpath("//div[text()='Create Course']")).click();	
			 driver.findElement(By.xpath("//input[@placeholder='Enter Course Name']")).sendKeys("hello");
			 driver.findElement(By.xpath("//textarea[@placeholder='Description goes here']")).sendKeys("HeyBuddy");
			 driver.findElement(By.xpath("//div[text()='Pick your Categories']")).click();
			 driver.findElement(By.xpath("//div[@class='menu transition visible']//span[text()='Bank Exams']")).click();
			 driver.findElement(By.xpath("//div[text()='Pick your Subcategories']")).click();
			 driver.findElement(By.xpath("//div[@class='menu transition visible']//span[text()='IBPS']")).click();
		     driver.findElement(By.xpath("//input[@placeholder='Enter price, ₹']")).sendKeys("123");
			 Thread.sleep(3000);
			 
			 driver.findElement(By.xpath("//label[contains(text(),'Check, if you want to make')]")).click();
			 driver.findElement(By.xpath("//input[@placeholder='Enter percentage share']")).sendKeys("1");
			 Thread.sleep(5000);
			 
		     driver.findElement(By.xpath("//div[@class='ui fitted checkbox']")).click();
			 driver.findElement(By.xpath("//button[text()='Add Content']")).click();
			 Thread.sleep(2000);
			 
			 String toastTitle= driver.findElement(By.xpath("//div[@class='rrt-title']")).getText();				
			 Thread.sleep(3000);
			 Assert.assertEquals(toastTitle, "Share Percentage cannot be less than 0 and more than 100");
	}
	 
	 
	 @Test(priority = 22)
	 public void emptyShareValue() throws InterruptedException {
			 driver.findElement(By.xpath("//p[text()='Store']")).click();
		     driver.findElement(By.xpath("//div[text()='Create Course']")).click();	
			 driver.findElement(By.xpath("//input[@placeholder='Enter Course Name']")).sendKeys("hello");
			 driver.findElement(By.xpath("//textarea[@placeholder='Description goes here']")).sendKeys("HeyBuddy");
			 driver.findElement(By.xpath("//div[text()='Pick your Categories']")).click();
			 driver.findElement(By.xpath("//div[@class='menu transition visible']//span[text()='Bank Exams']")).click();
			 driver.findElement(By.xpath("//div[text()='Pick your Subcategories']")).click();
			 driver.findElement(By.xpath("//div[@class='menu transition visible']//span[text()='IBPS']")).click();
		     driver.findElement(By.xpath("//input[@placeholder='Enter price, ₹']")).sendKeys("123");
			 Thread.sleep(3000);
			 
			 driver.findElement(By.xpath("//label[contains(text(),'Check, if you want to make')]")).click();
			 driver.findElement(By.xpath("//input[@placeholder='Enter percentage share']")).clear();
			 Thread.sleep(5000);
			 
		     driver.findElement(By.xpath("//div[@class='ui fitted checkbox']")).click();
			 driver.findElement(By.xpath("//button[text()='Add Content']")).click();
			 Thread.sleep(2000);
			 
			 String toastTitle= driver.findElement(By.xpath("//div[@class='rrt-title']")).getText();				
			 Thread.sleep(3000);
			 Assert.assertEquals(toastTitle, "Share Percentage cannot be less than 0 and more than 100");
	 }
	 
	 
	 @Test(priority=23)
		public void validResellerVlaue() throws InterruptedException {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//p[text()='Store']")).click();
			driver.findElement(By.xpath("//div[text()='Create Course']")).click();
			driver.findElement(By.xpath("//input[@placeholder='Enter Course Name']")).sendKeys("hello");
			driver.findElement(By.xpath("//textarea[@placeholder='Description goes here']")).sendKeys("HeyBuddy");
			driver.findElement(By.xpath("//div[text()='Pick your Categories']")).click();
			driver.findElement(By.xpath("//div[@class='menu transition visible']//span[text()='Bank Exams']")).click();
			driver.findElement(By.xpath("//div[text()='Pick your Subcategories']")).click();
			driver.findElement(By.xpath("//div[@class='menu transition visible']//span[text()='IBPS']")).click();
			driver.findElement(By.xpath("//label[contains(text(),'Check, if you want to make')]")).click();
			driver.findElement(By.xpath("//span[text()='I have read and agree to the']")).click();
			driver.findElement(By.xpath("//button[text()='Add Content']")).click();
			Thread.sleep(2000);
			
			String message = driver.findElement(By.xpath("//div[text()='Please enter a minimum valid course value for reseller']")).getText();
			Thread.sleep(3000);
			Assert.assertEquals(message,"Please enter a minimum valid course value for reseller");	
	}
	 
	 
	 @Test(priority=24)
	 public void clickOnStoreModule() {
			driver.findElement(By.xpath("//p[text()='Store']")).click();
			Assert.assertTrue(driver.findElement(By.xpath("//input[@placeholder='Search for a course']")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.xpath("//div[text()='CATEGORIES/SUB-CATEGORIES']")).isDisplayed());
	}
	
	 
	@Test(priority=25)
	public void validatePublishButton() throws InterruptedException {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//p[text()='Store']")).click();
			driver.findElement(By.xpath("//div[text()='Create Course']")).click();
			driver.findElement(By.xpath("//input[@placeholder='Enter Course Name']")).sendKeys("hello");
			driver.findElement(By.xpath("//textarea[@placeholder='Description goes here']")).sendKeys("HeyBuddy");
			driver.findElement(By.xpath("//div[text()='Pick your Categories']")).click();
			driver.findElement(By.xpath("//div[@class='menu transition visible']//span[text()='Bank Exams']")).click();
			driver.findElement(By.xpath("//div[text()='Pick your Subcategories']")).click();
			driver.findElement(By.xpath("//div[@class='menu transition visible']//span[text()='IBPS']")).click();
			driver.findElement(By.xpath("//span[text()='I have read and agree to the']")).click();
			driver.findElement(By.xpath("//button[text()='Add Content']")).click();
			Thread.sleep(3000);
			Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Publish Course']")).isDisplayed());	
	}
		
	
	@Test(priority=26)
	public void unablePublishCourse() throws InterruptedException {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//p[text()='Store']")).click();
			driver.findElement(By.xpath("//div[text()='Create Course']")).click();
			driver.findElement(By.xpath("//input[@placeholder='Enter Course Name']")).sendKeys("hello");
			driver.findElement(By.xpath("//textarea[@placeholder='Description goes here']")).sendKeys("HeyBuddy");
			driver.findElement(By.xpath("//div[text()='Pick your Categories']")).click();
			driver.findElement(By.xpath("//div[@class='menu transition visible']//span[text()='Bank Exams']")).click();
			driver.findElement(By.xpath("//div[text()='Pick your Subcategories']")).click();
			driver.findElement(By.xpath("//div[@class='menu transition visible']//span[text()='IBPS']")).click();
			driver.findElement(By.xpath("//span[text()='I have read and agree to the']")).click();
			driver.findElement(By.xpath("//button[text()='Add Content']")).click();
			Thread.sleep(3000);
			
			String message = driver.findElement(By.xpath("//div[text()='Unable to Publish']")).getText();
			Assert.assertEquals(message, "Unable to Publish");	
	}
	
	
	@Test(priority=27)
	public void getBackContentScreen() throws InterruptedException {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//p[text()='Store']")).click();
			driver.findElement(By.xpath("//div[text()='Create Course']")).click();
			driver.findElement(By.xpath("//input[@placeholder='Enter Course Name']")).sendKeys("hello");
			driver.findElement(By.xpath("//textarea[@placeholder='Description goes here']")).sendKeys("HeyBuddy");
			driver.findElement(By.xpath("//div[text()='Pick your Categories']")).click();
			driver.findElement(By.xpath("//div[@class='menu transition visible']//span[text()='Bank Exams']")).click();
			driver.findElement(By.xpath("//div[text()='Pick your Subcategories']")).click();
			driver.findElement(By.xpath("//div[@class='menu transition visible']//span[text()='IBPS']")).click();
			driver.findElement(By.xpath("//span[text()='I have read and agree to the']")).click();
			driver.findElement(By.xpath("//button[text()='Add Content']")).click();
			driver.findElement(By.xpath("//span[text()='Publish Course']")).click();
			driver.findElement(By.xpath("//button[text()='Okay']")).click();
			Thread.sleep(3000);
			
			Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'ui blue pointing secondary')]//div//span[text()='Content']")).isDisplayed());		
	}
	
	
	@Test(priority=28)
	public void displayPublishCourseButton() throws InterruptedException {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//p[text()='Store']")).click();
			driver.findElement(By.xpath("//div[text()='Create Course']")).click();
			driver.findElement(By.xpath("//input[@placeholder='Enter Course Name']")).sendKeys("hello");
			driver.findElement(By.xpath("//textarea[@placeholder='Description goes here']")).sendKeys("HeyBuddy");
			driver.findElement(By.xpath("//div[text()='Pick your Categories']")).click();
			driver.findElement(By.xpath("//div[@class='menu transition visible']//span[text()='Bank Exams']")).click();
			driver.findElement(By.xpath("//div[text()='Pick your Subcategories']")).click();
			driver.findElement(By.xpath("//div[@class='menu transition visible']//span[text()='IBPS']")).click();
			driver.findElement(By.xpath("//span[text()='I have read and agree to the']")).click();
			driver.findElement(By.xpath("//button[text()='Add Content']")).click();
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//div[text()='Subjective Test']")).click();
			driver.findElement(By.xpath("(//div[@class='SubjectivePaper__AddSub'])[1]")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//span[text()='Publish Course']")).click();
			driver.findElement(By.xpath("//button[text()='Cancel']")).click();
			
			if(driver.findElement(By.xpath("//span[text()='Publish Course']")).isDisplayed()) {
			Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Publish Course']")).isDisplayed());	
		}
	}
	
	
	@Test(priority=29)
	public void displayUnpublishCourseButtonAfterPublishing() throws InterruptedException {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//p[text()='Store']")).click();
			driver.findElement(By.xpath("//div[text()='Create Course']")).click();
			driver.findElement(By.xpath("//input[@placeholder='Enter Course Name']")).sendKeys("hello");
			driver.findElement(By.xpath("//textarea[@placeholder='Description goes here']")).sendKeys("HeyBuddy");
			driver.findElement(By.xpath("//div[text()='Pick your Categories']")).click();
			driver.findElement(By.xpath("//div[@class='menu transition visible']//span[text()='Bank Exams']")).click();
			driver.findElement(By.xpath("//div[text()='Pick your Subcategories']")).click();
			driver.findElement(By.xpath("//div[@class='menu transition visible']//span[text()='IBPS']")).click();
			driver.findElement(By.xpath("//span[text()='I have read and agree to the']")).click();
			driver.findElement(By.xpath("//button[text()='Add Content']")).click();
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//div[text()='Subjective Test']")).click();
			driver.findElement(By.xpath("(//div[@class='SubjectivePaper__AddSub'])[1]")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//span[text()='Publish Course']")).click();
			driver.findElement(By.xpath("//button[text()='Publish Course']")).click();
			driver.findElement(By.xpath("//img[@alt='✖']")).click();
			
			if(driver.findElement(By.xpath("//span[text()='Unpublish Course']")).isDisplayed()) {
				Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Unpublish Course']")).isDisplayed());	
		}
	}
			
	
	@Test(priority=30)
	public void displayCourseUnpublish() throws InterruptedException {
				Thread.sleep(2000);
				driver.findElement(By.xpath("//p[text()='Store']")).click();
				driver.findElement(By.xpath("//div[text()='Create Course']")).click();
				driver.findElement(By.xpath("//input[@placeholder='Enter Course Name']")).sendKeys("hellllloooo");
				driver.findElement(By.xpath("//textarea[@placeholder='Description goes here']")).sendKeys("dudessss");
				driver.findElement(By.xpath("//div[text()='Pick your Categories']")).click();
				driver.findElement(By.xpath("//div[@class='menu transition visible']//span[text()='Bank Exams']")).click();
				driver.findElement(By.xpath("//div[text()='Pick your Subcategories']")).click();
				driver.findElement(By.xpath("//div[@class='menu transition visible']//span[text()='IBPS']")).click();
				driver.findElement(By.xpath("//span[text()='I have read and agree to the']")).click();
				driver.findElement(By.xpath("//button[text()='Add Content']")).click();
				Thread.sleep(3000);
				
				driver.findElement(By.xpath("//div[text()='Subjective Test']")).click();
				driver.findElement(By.xpath("(//div[@class='SubjectivePaper__AddSub'])[1]")).click();
				Thread.sleep(2000);
				
				driver.findElement(By.xpath("//span[text()='Publish Course']")).click();
				driver.findElement(By.xpath("//button[text()='Publish Course']")).click();
				driver.findElement(By.xpath("//img[@alt='✖']")).click();
				driver.findElement(By.xpath("//span[text()='Unpublish Course']")).click();
				driver.findElement(By.xpath("//button[text()='Unpublish']")).click();
				
				Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Status updated successfully.']")).isDisplayed());			 
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
//	public void readData() throws IOException {
//		try {
//			Properties p = new Properties();	//Creating an object for properties class
//			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/Users/someshverenkar/"
//						+ "git/repository10/CP_Practice/src/main/resources/data.properties");
//			p.load(fis); //to load the data file
//				
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
	
//		}
	}