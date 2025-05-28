import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestPrime {
	
	private WebDriver driver;
	private DSL dsl;
	
		@Before
		public void inicializa() {
			
			driver = new FirefoxDriver();
			driver.manage().window().setSize(new Dimension(1200, 765));
			driver.get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml?jfwid=9288a");
			dsl = new DSL(driver);
			
		}
		
		@After	
		public void finaliza() {
			
			driver.quit();
		}
	
	@Test
	public void deveInteragirComRadioPrime() {
		dsl.clicarRadio(By.xpath("//input[@id='j_idt249:line:0']/../..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt249:line:0"));
		dsl.clicarRadio(By.xpath("//input[@value='Option2']/../..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt249:line:1"));
		
		}	
		
}
