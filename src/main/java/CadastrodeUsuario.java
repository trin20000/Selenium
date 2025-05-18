import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CadastrodeUsuario {
	
	@Test
	public void interagirComAlertSimples() {
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().setSize(new Dimension(1200, 765));
	driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	
	driver.findElement(By.id("elementosForm:nome")).sendKeys("Gilberlei");
	driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Quaresma");
	driver.findElement(By.id("elementosForm:sexo:0")).click();
	driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();

	new Select(driver.findElement(By.id("elementosForm:escolaridade"))).selectByVisibleText("1o grau incompleto");	
	new Select(driver.findElement(By.id("elementosForm:esportes"))).selectByVisibleText("Futebol");	
	
	driver.findElement(By.id("elementosForm:cadastrar")).click();
	
	Assert.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));
	Assert.assertTrue(driver.findElement(By.id("descNome")).getText().endsWith("Gilberlei"));
	Assert.assertEquals("Sobrenome: Quaresma", driver.findElement(By.id("descSobrenome")).getText());
	Assert.assertEquals("Sexo: Masculino", driver.findElement(By.id("descSexo")).getText());
	Assert.assertEquals("Escolaridade: 1grauincomp", driver.findElement(By.id("descEscolaridade")).getText());
	Assert.assertEquals("Esportes: Futebol", driver.findElement(By.id("descEsportes")).getText());	
	
	driver.quit();	
		
	
	}
	
	

}
