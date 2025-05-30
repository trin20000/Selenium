package PackageTest;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestGoogle {
	
	@Test
	public void test() {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		Assert.assertEquals("Yahoo!",driver.getTitle());
	}
}
	
