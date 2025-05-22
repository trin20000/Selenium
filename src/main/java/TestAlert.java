import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class TestAlert {
	
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
		
		driver.quit();
	}
	
	
	@Test
	public void interagirComAlertSimples() {
	
	
	dsl.clicarBotao("alert");
	
	String texto =  dsl.alertaObterTextoEAceita();
	Assert.assertEquals("Alert Simples", texto );	
	
	dsl.escreve("elementosForm:nome", texto);
	
	}
	
	
	@Test
	public void interagirComAlertConfirm() {
		
		dsl.clicarBotao("confirm");
		Assert.assertEquals("Confirm Simples",  dsl.alertaObterTextoEAceita());
		Assert.assertEquals("Confirmado",  dsl.alertaObterTextoEAceita());
	}
	
	
	@Test
	public void interagirComAlertConfirmCancelar() {
		
		dsl.clicarBotao("confirm");	
		Assert.assertEquals("Confirm Simples",  dsl.alertaObterTextoCancel());	
		Assert.assertEquals("Negado",  dsl.alertaObterTextoCancel());	
	
	}
	
	
	@Test
	public void interagirComAlertPrompt() {
		
    dsl.clicarBotao("prompt");
			
	Assert.assertEquals("Digite um numero", dsl.alertaObterTexto());
	
	dsl.alertEscreve("12");
	
	Assert.assertEquals("Era 12?", dsl.alertaObterTextoEAceita());		
	Assert.assertEquals(":D", dsl.alertaObterTextoEAceita());
	
	
	}
	
	
	@Test
	public void interagirComAlertPromptCanceling() {
		
	dsl.clicarBotao("prompt");
	
	Assert.assertEquals("Digite um numero", dsl.alertaObterTextoCancel());	
	Assert.assertEquals("Era null?", dsl.alertaObterTextoCancel());	
	Assert.assertEquals(":(", dsl.alertaObterTextoCancel());
			
	}	
	
	
	}
