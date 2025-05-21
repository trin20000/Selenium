import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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
	
	//driver.findElement(By.id("alert")).click();
	dsl.clicarBotao("alert");
	//Alert alert = driver.switchTo().alert();
	String texto =  alert.getText();
	Assert.assertEquals("Alert Simples", texto);
	alert.accept();
	
	driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
	
	}
	
	
	@Test
	public void interagirComAlertConfirm() {
		
	driver.findElement(By.id("confirm")).click();
	Alert confirm = driver.switchTo().alert();
	Assert.assertEquals("Confirm Simples", confirm.getText());
	confirm.accept();
	String msg = confirm.getText();
	Assert.assertEquals("Confirmado", msg);
	confirm.accept();
	
	}
	
	
	@Test
	public void interagirComAlertConfirmCancelar() {
		
	driver.findElement(By.id("confirm")).click();
	Alert confirm = driver.switchTo().alert();	
	confirm.dismiss();
	String msg = confirm.getText();
	Assert.assertEquals("Negado", msg);
	confirm.dismiss();
	
	}
	
	
	@Test
	public void interagirComAlertPrompt() {
		
	driver.findElement(By.id("prompt")).click();
	Alert alert = driver.switchTo().alert();	
	Assert.assertEquals("Digite um numero", alert.getText());	
	alert.sendKeys("12");
	alert.accept();
	Assert.assertEquals("Era 12?", alert.getText());
	alert.accept();	
	Assert.assertEquals(":D", alert.getText());
	alert.accept();
	
	}
	
	
	@Test
	public void interagirComAlertPromptCanceling() {
		
	driver.findElement(By.id("prompt")).click();
	Alert alert = driver.switchTo().alert();	
	Assert.assertEquals("Digite um numero", alert.getText());	
	alert.dismiss();	
	Assert.assertEquals("Era null?", alert.getText());
	alert.dismiss();	
	Assert.assertEquals(":(", alert.getText());
	alert.dismiss();
		
	}	
	
	
	}
