package AutomationPractice;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.bouncycastle.asn1.ASN1Object;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BatchesModuleTest extends BaseClass{
	
	 WebDriver driver = null;
	
	@BeforeMethod
	public void openBrowser() throws IOException, InterruptedException{
		this.setup();
		this.Login();
	}
	
	
	@Test(priority=1)
	public void batchesModuleNavigation() throws InterruptedException {
	try{	
		driver.findElement(By.xpath("//div[contains(@class,'ui blue borderless fluid')]"
				+ "//a//div//following-sibling::p[text()='Batches']")).click();
	Assert.assertTrue(driver.findElement(By.xpath("//input[@placeholder='Search for Batches']")).isDisplayed());
	}
		catch(Exception e){
			Assert.fail("Invalid Search+ e.getMessage()");
		}
	}
	
	
	@Test(priority=2, dataProvider="SearchBatch")
	public void BatchClick(String value) throws InterruptedException {
		driver.findElement(By.xpath("//input[@placeholder='Search for Batches']")).sendKeys(value);
		Thread.sleep(5000);
	}
	
	
	@DataProvider(name="SearchBatch")
	public Object[][] SearchBatch(){
		return new Object[][] {{"some"},{"some2131"},{"som6565%$#^%$^"},{"@%&^%&$$"},{"56758"},{"बै"},{"habdsk😊😀"}};
	}
	
	
	@Test(priority=3)
	public void filterBatchByRecentlyCreated() throws InterruptedException {
		Thread.sleep(2000);
        driver.findElement(By.xpath("//p[text()='Sort']")).click();
        driver.findElement(By.xpath("//div[@class='menu transition visible']//div[1]//input")).click();
        Thread.sleep(2000);
        System.out.println("Recently added batches will be displayed");	
	}
	
	
	@Test(priority=4)
	public void filterBatchByBatchName() throws InterruptedException {
        driver.findElement(By.xpath("//p[text()='Sort']")).click();
        driver.findElement(By.xpath("//div[@class='menu transition visible']//div[2]//input")).click();
        Thread.sleep(2000);
        System.out.println("Batches with Alphabetical order will be displayed");	
	}
	
	
	@Test(priority=5)
	public void totalBatchesCount() throws InterruptedException {
		String batchCount = driver.findElement(By.xpath("//span[@data-cy='batch_listing']")).getText();
		Assert.assertEquals(batchCount, "BATCHES");
        System.out.println("Total batches count will be displayed");		
	}
	
	
	@Test(priority=6)
	public void createNewBatch() throws InterruptedException {
        driver.findElement(By.xpath("//div[text()='Create Batch']")).click();
        System.out.println("User will navigate to create new batch screen which will "
        		+ "have batch name,batch code and batch start date");	
	}
	
	
	@Test(priority=7)
	public void todaysDateIsByDefault() throws InterruptedException {
		this.createNewBatch();
		System.out.println("user is getting today's date by default for batch start date in new create batch");	
	}
	
	
	@Test(priority=8)
	public void selectFutureDate() throws InterruptedException {
		this.createNewBatch();
		Thread.sleep(1000);
        WebElement futureDate =  driver.findElement(By.xpath("//i[@class='calendar icon']//following-sibling::div//input"));
        futureDate.sendKeys("20231010");
        futureDate.sendKeys(Keys.TAB);
        System.out.println("User is able to select future date");
        
		String toastTitle= driver.findElement(By.xpath("//div[@class='rrt-title']")).getText();
		String toastMessage= driver.findElement(By.xpath("//div[@class='rrt-text']")).getText();
        Thread.sleep(3000);
        
        System.out.println("Title of the Toast message is: "+toastTitle);
        System.out.println("Message of the Toast message is: "+toastMessage);
        
		Assert.assertEquals(toastTitle, "Success");
		Assert.assertEquals(toastMessage, "Batch Edited Successfully");
		Thread.sleep(5000);
	}
	
	
    @Test(priority=9)
    public void pastDatesDisabled () throws InterruptedException {
    	this.createNewBatch();
    	WebElement previousDate = driver.findElement(By.xpath("//i[@class='calendar icon']//following-sibling::div//input]"));
    	previousDate.sendKeys("20230201");
    	previousDate.sendKeys(Keys.TAB);
    	String disabled= driver.findElement(By.xpath("//div[@class='rdtDay rdtOld rdtDisabled']")).getText();
    	Assert.assertEquals(disabled, "Cannot select past dates");		
    }
    
	
    @Test(priority=10)
    public void batchCodeAutoFetch() throws InterruptedException {
	   	this.createNewBatch();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//input[@name='batchName']")).sendKeys("Practice123");
	    Thread.sleep(2000);
	    System.out.println("batch code will be fetched automatically");
    }
	
	
    @Test(priority=11)
    public void editBatchCode() throws InterruptedException {
	    this.createNewBatch();
		driver.findElement(By.xpath("//input[@name='batchName']")).sendKeys("Practice123");
	    Thread.sleep(3000);
	    
	    driver.findElement(By.xpath("//input[@name='batchCode']")).clear();
	    driver.findElement(By.xpath("//input[@name='batchCode']")).sendKeys("heyBuddy");
	    Thread.sleep(3000);
	    
		String toastMessage= driver.findElement(By.xpath("//div[@class='rrt-text']")).getText();
		Assert.assertEquals(toastMessage, "Batch code updated Successfully");
    }
	
    
    @Test(priority=12)
    public void screenNavigatesToOverview() throws InterruptedException {
	    this.createNewBatch();
		driver.findElement(By.xpath("//input[@name='batchName']")).sendKeys("heyBuddy");
	    driver.findElement(By.xpath("//button[text()='Create Batch']")).click();
	    System.out.println("User navigates to overview screen");
	}
    
    
    @Test(priority=13)
    public void addFacultyToBatch() throws InterruptedException {
    	this.screenNavigatesToOverview();
    	Thread.sleep(2000);
    
	    driver.findElement(By.xpath("//button[@data-cy='add-faculty-button']")).click();
	    driver.findElement(By.xpath("//input[@name='members[0].name']")).sendKeys("NewFaculty");
	    driver.findElement(By.xpath("//input[@name='members[0].mobile']")).sendKeys("9876769876");
	    driver.findElement(By.xpath("//div[@class='row']//button[text()='Add']")).click();
	    Thread.sleep(3000);
    
	    String toastTitle= driver.findElement(By.xpath("//div[@class='rrt-title']")).getText();
		String toastText= driver.findElement(By.xpath("//div[@class='rrt-text']")).getText();
	    Thread.sleep(3000);
    
		Assert.assertEquals(toastTitle, "Success");
		Assert.assertEquals(toastText, "Faculty added Successfully");
	}
 
   
	@Test(priority=14)
	public void addStudentManually() throws InterruptedException {
	    this.screenNavigatesToOverview();
	    Thread.sleep(2000);
	   
	    driver.findElement(By.xpath("//div[@class='ui grid']//button[@class='addStudentButton']")).click();
	    driver.findElement(By.xpath("//p[text()='Add Students Manually']")).click();
	    driver.findElement(By.xpath("//input[@placeholder='Enter Student Name']")).sendKeys("Dude");
	    driver.findElement(By.xpath("//input[@placeholder='Enter Student Number']")).sendKeys("9876545454");
	    driver.findElement(By.xpath("//input[@name='members[0].email']")).sendKeys("dude@hey.co");
	    driver.findElement(By.xpath("//button[text()='Verify']")).click();
	    driver.findElement(By.xpath("//button[text()='Add Student']")).click();
	    Thread.sleep(2000);
	   
	    String toastTitle = driver.findElement(By.xpath("//div[@class='rrt-title']")).getText();
	    String toastMessage = driver.findElement(By.xpath("//div[@class='rrt-text']")).getText();
	    Thread.sleep(3000);
	   
	    Assert.assertEquals(toastTitle, "Success");
	    Assert.assertEquals(toastMessage, "Student added Successfully");
    }


    @Test(priority=15)
    public void addStudentsManuallyFromAppDownloads() throws InterruptedException {
	    this.screenNavigatesToOverview();
	    Thread.sleep(2000);
    
	    driver.findElement(By.xpath("//div[@class='ui grid']//button[@class='addStudentButton']")).click();
	    driver.findElement(By.xpath("//p[text()='Add students from app downloads']")).click();
	    driver.findElement(By.xpath("//input[@placeholder='Enter Student Name']")).sendKeys("pqrs");
	    driver.findElement(By.xpath("//input[@placeholder='Enter Student Number']")).sendKeys("8077297214");
	    driver.findElement(By.xpath("//input[@name='members[0].email']")).sendKeys("pqrs@hey.co");
	    driver.findElement(By.xpath("//button[text()='Verify']")).click();
	    driver.findElement(By.xpath("//button[text()='Add Student']")).click();
	    Thread.sleep(2000);
    
	    String toastTitle= driver.findElement(By.xpath("//div[@class='rrt-title']")).getText();
		String toastText= driver.findElement(By.xpath("//div[@class='rrt-text']")).getText();
	    Thread.sleep(3000);
    
	    Assert.assertEquals(toastTitle, "Success");
	    Assert.assertEquals(toastText, "Student added Successfully");  
    }
     
		
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
		
	public void readData() throws IOException {
		try {
			Properties p = new Properties();	//Creating an object for properties class
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/Users/someshverenkar/"
						+ "git/repository10/CP_Practice/src/main/resources/data.properties");
			p.load(fis); //to load the data file
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
	}
}		