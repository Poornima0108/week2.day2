package week2.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {
	
	static ChromeDriver driver;
	
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		 driver= new ChromeDriver();
	}
	
	public void loginLeafTaps() {
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Demosalesmanager");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
	}
	
	public void deleteLead() {
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("1");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		WebElement elementLeadId = driver.findElement(By.xpath("(//div[text()='Lead ID']/following::a[@class='linktext'])[1]"));
		String leadId=elementLeadId.getText();
		elementLeadId.click();
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//label[text()='Lead ID:']/following::input[@name='id']")).sendKeys(leadId);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		WebElement elementLeadNotPresentMsg = driver.findElement(By.xpath("//div[text()='No records to display']"));
		boolean flag=elementLeadNotPresentMsg.isDisplayed();
		if(flag==true)
		{
			System.out.println("Lead deleted successfully");
		}
		else
		{
			System.out.println("Lead not deleted");
		}
	}
	
	public void closeBrowser() {
		driver.close();
	}
	
	public static void main(String[] args) {		
		DeleteLead dl=new DeleteLead();
		dl.launchBrowser();
		dl.loginLeafTaps();
		dl.deleteLead();
		dl.closeBrowser();

	}

}
