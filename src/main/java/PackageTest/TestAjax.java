package PackageTest;
import java.time.Duration;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PackageB.DSL;
import PackageB.DriverFactory;

public class TestAjax {	
		
		private DSL dsl;

			
			@Before
			public void inicializa() {				
				
				DriverFactory.getDriver().get("https://www.primefaces.org/showcase/ui/ajax/basic.xhtml");
				dsl = new DSL();
				
			}
			
			@After	
			public void finaliza() {
				
				DriverFactory.killDriver();
			}		
			
			@Test
			public void testAjax() {
				dsl.escreve("j_idt248:name", "Teste");
				dsl.clicarBotao("j_idt248:j_idt252");
				WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(30));
				wait.until(ExpectedConditions.textToBe(By.id("j_idt248:display"), "Teste"));
				Assert.assertEquals("Teste", dsl.obterTexto("j_idt248:display"));
				
					
			}



}
