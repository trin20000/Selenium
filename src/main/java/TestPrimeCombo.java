import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestPrimeCombo {
	
	private WebDriver driver;
	private DSL dsl;
	
		@Before
		public void inicializa() {
			
			driver = new FirefoxDriver();
			driver.manage().window().setSize(new Dimension(1200, 765));
			driver.get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml?jfwid=34db6");
			dsl = new DSL(driver);
			
		}
		
		@After	
		public void finaliza() {
			
			//driver.quit();
		}
	
	
	
	@Test
	public void deveInteragirComCombo() {
		dsl.selecionarCombo1("//form[@id='j_idt248']//span[@id='j_idt248:option_label']", "//*[@id='j_idt248:option_1']");	
		
		
	}

}
