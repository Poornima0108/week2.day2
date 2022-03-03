package week2.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Create Contact")).click();
		driver.findElement(By.id("firstNameField")).sendKeys("Poornima");
		driver.findElement(By.id("lastNameField")).sendKeys("K");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Poorni");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("MK");
		driver.findElement(By.name("departmentName")).sendKeys("IT");
		driver.findElement(By.name("description")).sendKeys("Sample description");
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("testuser@gmail.com");
		WebElement elementStateDropDown = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select dd = new Select(elementStateDropDown);
		dd.selectByVisibleText("New York");
		driver.findElement(By.className("smallSubmit")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateContactForm_description")).clear();
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Important note:Description has been cleared");
		driver.findElement(By.xpath("//input[@name='submitButton' and @value='Update']")).click();
		System.out.println("The title of the page is: "+driver.getTitle());

	}

}
