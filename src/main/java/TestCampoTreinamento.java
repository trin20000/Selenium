import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

public class TestCampoTreinamento {
	
	@Test
	public void testeTextField() {
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().setSize(new Dimension(1200, 765));
	driver.get("file:///D:\\Leonardo_Files_D\\Course_Selenium_webdriver/componentes.html");
	driver.findElement(By.id("elementosForm:nome")).sendKeys("TestedeEscrita");
	
	
	
	//driver.quit();
	
	}

}
