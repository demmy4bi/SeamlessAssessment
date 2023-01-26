package LoginTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class invalidLogin_TC002 {
	@Test
	public void Test2() {
		
		
		// Create driver 
		  System.setProperty("webdriver.chrome.driver",
		  "src/main/resources/chromedriver.exe"); WebDriver driver = new
		  ChromeDriver();

		  // open test page
		   String url = "http://the-internet.herokuapp.com/";
		  driver.get(url); System.out.println("Page is opened.");
	
	
		// Click on Form Authentication link
			driver.findElement(By.linkText("Form Authentication")).click();
			
			// enter username and password
						driver.findElement(By.id("username")).sendKeys("thomas");
						driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

						WebDriverWait wait = new WebDriverWait(driver, 10);
						
				
						sleep(3000);
				
						
						// push log in button
						WebElement logInButton = driver.findElement(By.className("radius"));
						wait.until(ExpectedConditions.elementToBeClickable(logInButton));
						logInButton.click();

						sleep(3000);
						
						// Error Message Validation
						 
						  WebElement errorMessage = driver.findElement(By.id("flash"));
						  String expectedErrorMessage = "Your username is invalid!"; String
						  actualErrorMessage = errorMessage.getText();
						  
						  Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
						  "Actual message does not contain expected message.\nActual Message: " +
						  actualErrorMessage + "\nExpected Message: " + expectedErrorMessage);
						  
						  System.out.println("Actual Error Messagae ="  + (expectedErrorMessage));
						 
						driver.quit();
	
		
		
	}

	
	private void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
