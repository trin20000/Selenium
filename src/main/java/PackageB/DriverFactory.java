package PackageB;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	private static WebDriver driver;
	
	private DriverFactory() {}
		
	public static WebDriver getDriver()	{
		if (driver == null) {
		driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		}
		return driver;
		
	}
	
	public static void killDriver() {
		if (driver != null) {
		driver.quit();
		driver = null;
		}
	}
	
	
}
