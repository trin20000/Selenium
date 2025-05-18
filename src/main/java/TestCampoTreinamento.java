import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

public class TestCampoTreinamento {
	
	@Test
	public void testeTextField() {
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().setSize(new Dimension(1200, 765));
	driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	driver.findElement(By.id("elementosForm:nome")).sendKeys("TestedeEscrita");
	Assert.assertEquals("TestedeEscrita", driver.findElement(By.id("elementosForm:nome")).getDomProperty("value"));	
	driver.quit();
	
	}
	
	@Test
	public void deveInteragirComTextArea() {
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().setSize(new Dimension(1200, 765));
	driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("campo texto\ncampo texto");
	Assert.assertEquals("campo texto\ncampo texto", driver.findElement(By.id("elementosForm:sugestoes")).getDomProperty("value"));	
	driver.quit();
	}
	
	@Test
	public void deveInteragirComRadioButton() {
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().setSize(new Dimension(1200, 765));
	driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	driver.findElement(By.id("elementosForm:sexo:0")).click();
	Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());	
	driver.quit();
	}
	
	@Test
	public void deveInteragirComCheckBox() {
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().setSize(new Dimension(1200, 765));
	driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
	Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:0")).isSelected());	
	driver.quit();
	}
	
	
	@Test
	public void deveInteragirComCombo() {
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().setSize(new Dimension(1200, 765));
	driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
	Select combo = new Select(element);
	//combo.selectByIndex(3);
	//combo.selectByValue("mestrado");
	combo.selectByVisibleText("2o grau incompleto");
	Assert.assertEquals("2o grau incompleto", combo.getFirstSelectedOption().getText());
	driver.quit();
	}
	
	
	@Test
	public void verificarValoresCombo() {
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().setSize(new Dimension(1200, 765));
	driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
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
	driver.quit();
	}
	
	
	@Test
	public void deveVerificarValoresCombo() {
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().setSize(new Dimension(1200, 765));
	driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
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
	driver.quit();
	
	
	}	
	
	@Test
	public void deveInteragirComBotoes() {
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().setSize(new Dimension(1200, 765));
	driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	
	WebElement buton = driver.findElement(By.id("buttonSimple"));
	buton.click();
	
	Assert.assertEquals("Obrigado!", buton.getDomAttribute("value"));
    driver.quit();
	
	}
	
	@Test	
	public void deveInteragirComLinks() {
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().setSize(new Dimension(1200, 765));
	driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	
	driver.findElement(By.linkText("Voltar")).click();
	
	Assert.assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText());
	driver.quit();
	
	}
	
	@Test	
	public void deveBuscarTestosNaPagina() {
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().setSize(new Dimension(1200, 765));
	driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	
	Assert.assertEquals("Campo de Treinamento", driver.findElement(By.tagName("h3")).getText());
	Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", driver.findElement(By.className("facilAchar")).getText());
	
	}
	
}
