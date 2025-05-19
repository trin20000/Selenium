import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestsRegrasDeNegocios {
	
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
	public void desafioRegrasDeNegocioNome() {
	
  	dsl.clicarBotao("elementosForm:cadastrar");
  	
  	Alert alert = driver.switchTo().alert();  	
  	
  	Assert.assertEquals("Nome eh obrigatorio", alert.getText());
	alert.accept();
		
	
	}
	
	@Test
	public void desafioRegrasDeNegocioSobrenome() {
		
	dsl.escreve("elementosForm:nome", "Gilberlei");
	driver.findElement(By.id("elementosForm:cadastrar")).click();	
	Alert alert = driver.switchTo().alert();	
	
	Assert.assertEquals("Sobrenome eh obrigatorio", alert.getText());
	alert.accept();
		
	}
	
	@Test
	public void desafioRegrasDeNegocioSexo() {
	
	driver.findElement(By.id("elementosForm:nome")).sendKeys("Gilberlei");
	driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Quaresma");
	driver.findElement(By.id("elementosForm:cadastrar")).click();	
	Alert alert = driver.switchTo().alert();	
	
	Assert.assertEquals("Sexo eh obrigatorio", alert.getText());
	alert.accept();
		
	}
	
	
	@Test
	public void desafioRegrasDeNegocioComida() {
		
	driver.findElement(By.id("elementosForm:nome")).sendKeys("Gilberlei");
	driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Quaresma");
	driver.findElement(By.id("elementosForm:sexo:0")).click();	
	driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
	driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
	driver.findElement(By.id("elementosForm:cadastrar")).click();
	Alert alert = driver.switchTo().alert();	
	
	Assert.assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());
	alert.accept();
		
	}

	@Test
	public void desafioRegrasDeNegocioEsporte() {
		
		
	driver.findElement(By.id("elementosForm:nome")).sendKeys("Gilberlei");
	driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Quaresma");
	driver.findElement(By.id("elementosForm:sexo:0")).click();	
	driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
	new Select(driver.findElement(By.id("elementosForm:esportes"))).selectByVisibleText("Futebol");
	new Select(driver.findElement(By.id("elementosForm:esportes"))).selectByVisibleText("O que eh esporte?");
	
	driver.findElement(By.id("elementosForm:cadastrar")).click();
	Alert alert = driver.switchTo().alert();
		
	Assert.assertEquals("Voce faz esporte ou nao?", alert.getText());
	alert.accept();
		
	}
	

}
