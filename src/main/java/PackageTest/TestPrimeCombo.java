package PackageTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import PackageB.DSL;
import PackageB.DriverFactory;

public class TestPrimeCombo {	
	
	private DSL dsl;
	
		@Before
		public void inicializa() {			
			
			DriverFactory.getDriver().get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml?jfwid=34db6");
			dsl = new DSL();
			
		}
		
		@After	
		public void finaliza() {
			
			DriverFactory.killDriver();
		}
		
	
	
	
	@Test
	public void deveInteragirComComboPrime() {
	dsl.selecionarComboPrime("j_idt248", "j_idt248:option_1");
	Assert.assertEquals("Option1", dsl.obterValorComboPrime("//form[@id='j_idt248']//span[@id='j_idt248:option_label']"));
	
	}

}
