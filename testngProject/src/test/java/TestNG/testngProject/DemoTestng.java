package TestNG.testngProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DemoTestng {
	
	WebDriver driver;
	@BeforeMethod
	public void browserInvoke() {
		
		//String basePath = System.getProperty("user.dir");
		
		//if (browserType.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver","C:\\Users\\VREDDYK\\eclipse-workspace\\testngProject\\drivers\\chromedriver.exe");
			
			driver = new ChromeDriver();
			
		//}
		//else {
			//System.setProperty("webdriver.edge.driver", basePath+ "/msedgedriver");
			
			//driver = new EdgeDriver();
	//	}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		driver.get("https://demo.guru99.com/V4/");
		
		
	}
	@Parameters({"userId", "Password"})
	@Test
	public void login(String username, String password) {
		driver.findElement(By.name("uid")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("btnLogin")).click();
	}
	
	@AfterMethod
	public void closer() {
		driver.close();
	}

}
