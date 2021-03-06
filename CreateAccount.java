package week2.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAccount {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://en-gb.facebook.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//a[text()='Forgotten password?']/following::a[text()='Create New Account']")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Test");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("User");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("testuser@gmail.com");
		driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys("testuser@gmail.com");
		driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("Password@12345");
		WebElement elementDayDropDown = driver.findElement(By.xpath("//select[@name='birthday_day']"));
		Select daydd = new Select(elementDayDropDown);
		daydd.selectByIndex(5);
		WebElement elementMonthDropDown = driver.findElement(By.xpath("//select[@name='birthday_month']"));
		Select monthdd = new Select(elementMonthDropDown);
		monthdd.selectByVisibleText("Aug");
		WebElement elementYearDropDown = driver.findElement(By.xpath("//select[@name='birthday_year']"));
		Select yeardd = new Select(elementYearDropDown);
		yeardd.selectByValue("1995");
		driver.findElement(By.xpath("//label[text()='Female']/following-sibling::input[@type='radio']")).click();
		System.out.println("Account creation details provided");

	}

}
