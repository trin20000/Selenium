import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class TestAlert {
	
	@Test
	public void interagirComAlertSimples() {
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().setSize(new Dimension(1200, 765));
	driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

	driver.findElement(By.id("alert")).click();
	Alert alert = driver.switchTo().alert();
	String texto =  alert.getText();
	Assert.assertEquals("Alert Simples", texto);
	alert.accept();
	
	driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
	driver.quit();
	}
	
	
	@Test
	public void interagirComAlertConfirm() {
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().setSize(new Dimension(1200, 765));
	driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	
	driver.findElement(By.id("confirm")).click();
	Alert confirm = driver.switchTo().alert();
	Assert.assertEquals("Confirm Simples", confirm.getText());
	confirm.accept();	
	Assert.assertEquals("Confirmado", confirm.getText());
	confirm.accept();
	driver.quit();
	}
	
	
	@Test
	public void interagirComAlertConfirmCancelar() {
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().setSize(new Dimension(1200, 765));
	driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	
	driver.findElement(By.id("confirm")).click();
	Alert confirm = driver.switchTo().alert();	
	confirm.dismiss();
	Assert.assertEquals("Negado", confirm.getText());
	confirm.dismiss();
	driver.quit();
	}
	
	
	@Test
	public void interagirComAlertPrompt() {
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().setSize(new Dimension(1200, 765));
	driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	
	driver.findElement(By.id("prompt")).click();
	Alert alert = driver.switchTo().alert();	
	Assert.assertEquals("Digite um numero", alert.getText());	
	alert.sendKeys("12");
	alert.accept();	
	Assert.assertEquals("Era 12?", alert.getText());
	alert.accept();	
	Assert.assertEquals(":D", alert.getText());
	alert.accept();
	driver.quit();
	
	
	}
	
	
	@Test
	public void interagirComAlertPromptCanceling() {
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().setSize(new Dimension(1200, 765));
	driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	
	driver.findElement(By.id("prompt")).click();
	Alert alert = driver.switchTo().alert();	
	Assert.assertEquals("Digite um numero", alert.getText());	
	alert.dismiss();	
	Assert.assertEquals("Era null?", alert.getText());
	alert.dismiss();	
	Assert.assertEquals(":(", alert.getText());
	alert.dismiss();
	driver.quit();
	
	}
	
	
	
	
	}
