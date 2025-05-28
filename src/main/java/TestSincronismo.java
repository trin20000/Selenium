import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSincronismo {
	
	private WebDriver driver;
	private DSL dsl;

		
		@Before
		public void inicializa() {
			
			driver = new FirefoxDriver();
			driver.manage().window().setSize(new Dimension(1200, 765));
			driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
			dsl = new DSL(driver);
			
		}
		
		@After	
		public void finaliza() {
			
			//driver.quit();
		}	
		
		@Test
		public void deveUtilizarEsperaFixa() throws InterruptedException{
			dsl.clicarBotao("buttonDelay");
			Thread.sleep(5000);
			dsl.escreve("novoCampo", "Deu certo?");
						
		}
		
		@Test
		public void deveUtilizarEsperaImplicita() throws InterruptedException{
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			dsl.clicarBotao("buttonDelay");			
			dsl.escreve("novoCampo", "Deu certo?");
			driver.manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS);			
		}

}
