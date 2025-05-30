package PackageTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import PackageB.DSL;
import PackageB.DriverFactory;

public class TestPrime {	
	
	private DSL dsl;
	
		@Before
		public void inicializa() {			
			
			DriverFactory.getDriver().get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml?jfwid=9288a");
			dsl = new DSL();
			
		}
		
		@After	
		public void finaliza() {
			
			DriverFactory.killDriver();
		}
	
	@Test
	public void deveInteragirComRadioPrime() {
		dsl.clicarRadio(By.xpath("//input[@id='j_idt249:line:0']/../..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt249:line:0"));
		dsl.clicarRadio(By.xpath("//input[@value='Option2']/../..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt249:line:1"));
		
		}	
		
}
