import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

class CURAHealthcareServiceSelenium {

	@Test
	void TC1001MakeAppointment_Success()  {
		WebDriver driver = null;
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://katalon-demo-cura.herokuapp.com/");
		driver.findElement(By.xpath("//*[@id=\"btn-make-appointment\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"txt-username\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"txt-username\"]")).sendKeys("John Doe");
        driver.findElement(By.xpath("//*[@id=\"txt-password\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"txt-password\"]")).sendKeys("ThisIsNotAPassword");
        driver.findElement(By.xpath("//*[@id=\"btn-login\"]")).click();
        
//        option Code
        Select option1 = new Select(driver.findElement(By.xpath("//*[@id=\"combo_facility\"]")));
		option1.selectByVisibleText("Seoul CURA Healthcare Center");
		driver.findElement(By.xpath("//*[@id=\"chk_hospotal_readmission\"]")).click();
		WebElement radio1 = driver.findElement(By.xpath("//*[@id=\"radio_program_medicare\"]"));
		radio1.click();
		driver.findElement(By.xpath("//*[@id=\"txt_visit_date\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"txt_visit_date\"]")).sendKeys("18/01/2023");
		driver.findElement(By.xpath("//*[@id=\"txt_comment\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"txt_comment\"]")).sendKeys("gif me 75% ");
		driver.findElement(By.xpath("//*[@id=\"btn-book-appointment\"]")).click();
		
		String result = driver.findElement(By.id("comment")).getText();
//		if(result.equalsIgnoreCase("gif me 75%"))
//			System.out.print("pass");
//		else
//			System.out.print("flase");
		assertEquals("gif me 75%", result);
		//        driver.close();
	}
	
}
