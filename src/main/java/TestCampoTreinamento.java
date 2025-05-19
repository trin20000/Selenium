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
	public void testeTextField() {
	dsl.escreve("elementosForm:nome", "TestedeEscrita");	
	Assert.assertEquals("TestedeEscrita", dsl.obterValorCampo("elementosForm:nome"));	
		
	}
	
	@Test
	public void deveInteragirComTextArea() {
	
	dsl.escreve("elementosForm:sugestoes", "campo texto\ncampo texto");
	Assert.assertEquals("campo texto\ncampo texto", dsl.obterValorCampo("elementosForm:sugestoes"));
	
	}
	
	@Test
	public void deveInteragirComRadioButton() {
	dsl.clicarRadio("elementosForm:sexo:0");
	Assert.assertTrue(dsl.isRadioMarcado("elementosForm:sexo:0"));
	
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
	dsl.selecionarCombo("elementosForm:escolaridade", "2o grau incompleto");
	Assert.assertEquals("2o grau incompleto", dsl.obterValorCombo("elementosForm:escolaridade"));
	
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
	
	dsl.selecionarCombo("elementosForm:esportes", "Natacao");
	dsl.selecionarCombo("elementosForm:esportes", "Corrida");
	dsl.selecionarCombo("elementosForm:esportes", "Karate");
	
	WebElement element = driver.findElement(By.id("elementosForm:esportes"));
	Select combo = new Select(element);
	
	List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
	Assert.assertEquals(3, allSelectedOptions.size());
	
	combo.deselectByVisibleText("Corrida");
	allSelectedOptions = combo.getAllSelectedOptions();
	Assert.assertEquals(2, allSelectedOptions.size());
		
	}	
	
	@Test
	public void deveInteragirComBotoes() {	
	
	dsl.clicarBotao("buttonSimple");
	
	WebElement buton = driver.findElement(By.id("buttonSimple"));	
	Assert.assertEquals("Obrigado!", buton.getDomAttribute("value"));
    
	
	}
	
	@Test	
	public void deveInteragirComLinks() {
		
	dsl.clicarLink("Voltar");
		
	Assert.assertEquals("Voltou!", dsl.obterTexto("resultado"));
		
	}
	
	@Test	
	public void deveBuscarTestosNaPagina() {
		
	Assert.assertEquals("Campo de Treinamento", dsl.obterTexto(By .tagName("h3")));
	Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", dsl.obterTexto(By.className("facilAchar")));
	
	}
	
}
