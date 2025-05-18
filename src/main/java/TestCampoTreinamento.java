import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

public class TestCampoTreinamento {
	
	
private WebDriver driver;
	
	@Before
	public void inicializa() {
		
		driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	}
	
	@After	
	public void finaliza() {
		
		driver.quit();
	}
	
	
	
	
	@Test
	public void testeTextField() {
	
	driver.findElement(By.id("elementosForm:nome")).sendKeys("TestedeEscrita");
	Assert.assertEquals("TestedeEscrita", driver.findElement(By.id("elementosForm:nome")).getDomProperty("value"));	
		
	}
	
	@Test
	public void deveInteragirComTextArea() {
	
	driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("campo texto\ncampo texto");
	Assert.assertEquals("campo texto\ncampo texto", driver.findElement(By.id("elementosForm:sugestoes")).getDomProperty("value"));	
	
	}
	
	@Test
	public void deveInteragirComRadioButton() {
	
	driver.findElement(By.id("elementosForm:sexo:0")).click();
	Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());	
	
	}
	
	@Test
	public void deveInteragirComCheckBox() {
	
	driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
	Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:0")).isSelected());	
	
	}
	
	
	@Test
	public void deveInteragirComCombo() {
	
	WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
	Select combo = new Select(element);
	//combo.selectByIndex(3);
	//combo.selectByValue("mestrado");
	combo.selectByVisibleText("2o grau incompleto");
	Assert.assertEquals("2o grau incompleto", combo.getFirstSelectedOption().getText());
	
	}
	
	
	@Test
	public void verificarValoresCombo() {
	
	WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
	Select combo = new Select(element);
	List<WebElement> options = combo.getOptions();
	Assert.assertEquals(8, options.size());
		
	boolean encontrou = false;
	for(WebElement option: options) {
		if (option.getText().equals("Mestrado")) {
			encontrou = true;
			break;	
		}
	}
	Assert.assertTrue(encontrou);
	
	}
	
	
	@Test
	public void deveVerificarValoresCombo() {
	
	WebElement element = driver.findElement(By.id("elementosForm:esportes"));
	Select combo = new Select(element);
	
	combo.selectByVisibleText("Natacao");
	combo.selectByVisibleText("Corrida");
	combo.selectByVisibleText("Karate");
	
	List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
	Assert.assertEquals(3, allSelectedOptions.size());
	
	combo.deselectByVisibleText("Corrida");
	allSelectedOptions = combo.getAllSelectedOptions();
	Assert.assertEquals(2, allSelectedOptions.size());
		
	}	
	
	@Test
	public void deveInteragirComBotoes() {	
	
	WebElement buton = driver.findElement(By.id("buttonSimple"));
	buton.click();
	
	Assert.assertEquals("Obrigado!", buton.getDomAttribute("value"));
    
	
	}
	
	@Test	
	public void deveInteragirComLinks() {
		
	driver.findElement(By.linkText("Voltar")).click();
	
	Assert.assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText());
		
	}
	
	@Test	
	public void deveBuscarTestosNaPagina() {
		
	Assert.assertEquals("Campo de Treinamento", driver.findElement(By.tagName("h3")).getText());
	Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", driver.findElement(By.className("facilAchar")).getText());
	
	}
	
}
