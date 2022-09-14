package TestNG.testngProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelExecution {
	
	WebDriver driver;
	@Parameters("browserType")
	@BeforeMethod
	public void browserInvoke(String browserType) {
		
		if (browserType.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\VREDDYK\\eclipse-workspace\\testngProject\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\VREDDYK\\eclipse-workspace\\testngProject\\drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
			
			
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://demo.guru99.com/V4/");
	}
	@AfterMethod
	public void closer() {
		driver.close();
	}
	@Parameters({"userId","Password"})
	@Test(dataProvider = "getData" ,dataProviderClass = DataProviderTest.class)
	public void login(String username, String password) {
		driver.findElement(By.name("uid")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("btnLogin")).click();
		
	}

}

	