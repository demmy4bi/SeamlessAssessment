package LoginTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class validLogin_TC001 {

	@Test
	public void Test(){
		
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
			driver.findElement(By.id("username")).sendKeys("tomsmith");
			driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

			WebDriverWait wait = new WebDriverWait(driver, 10);
			
	
			sleep(3000);
	
			
			// push log in button
			WebElement logInButton = driver.findElement(By.className("radius"));
			wait.until(ExpectedConditions.elementToBeClickable(logInButton));
			logInButton.click();

			sleep(3000);
			
			// Successful log in message
			String expectedSuccessMessage = "You logged into a secure area!";
			String actualSuccessMessage = driver.findElement(By.id("flash")).getText();
			Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
					"actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
							+ expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);
			
			 System.out.println("Actual Success Messagae ="  + (actualSuccessMessage));
			
			// log out button is visible
			Assert.assertTrue(driver.findElement(By.xpath("//a[@class='button secondary radius']")).isDisplayed(),
					"logOutButton is not visible.");

	
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
