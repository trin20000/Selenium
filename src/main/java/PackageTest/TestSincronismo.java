package PackageTest;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PackageB.DSL;
import PackageB.DriverFactory;

import java.time.Duration;

public class TestSincronismo {
	
	private WebDriver driver;
	private DSL dsl;

		
		@Before
		public void inicializa() {			
			
			DriverFactory.getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
			dsl = new DSL();
			
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

		@Test
		public void deveUtilizarEsperaExplicita() throws InterruptedException{
			dsl.clicarBotao("buttonDelay");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("novoCampo")));
			dsl.escreve("novoCampo", "Deu certo?");
						
		}
		
		
		
}
