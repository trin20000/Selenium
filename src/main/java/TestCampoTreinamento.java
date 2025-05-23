import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;
import java.util.Arrays;

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
	
	dsl.clicarRadio("elementosForm:comidaFavorita:0");	
	Assert.assertTrue(dsl.isRadioMarcado("elementosForm:comidaFavorita:0"));
	
	}
	
	
	@Test
	public void deveInteragirComCombo() {
	
	dsl.selecionarCombo("elementosForm:escolaridade", "2o grau incompleto");
	Assert.assertEquals("2o grau incompleto", dsl.obterValorCombo("elementosForm:escolaridade"));

	}
	
	
	@Test
	public void verificarValoresCombo() {
	
	
	Assert.assertEquals(8, dsl.obterQuantidadeOpcoesCombo("elementosForm:escolaridade"));
	Assert.assertTrue(dsl.verificarOpcaoCombo("elementosForm:escolaridade", "Mestrado"));
		
		}

	
	
	@Test
	public void deveVerificarValoresCombo() {
	
	dsl.selecionarCombo("elementosForm:esportes", "Natacao");
	dsl.selecionarCombo("elementosForm:esportes", "Corrida");
	dsl.selecionarCombo("elementosForm:esportes", "Karate");
	
	Assert.assertEquals(3, dsl.obterQuantidadeOpcoesMarcadas("elementosForm:esportes"));
	
	dsl.deselectComboOptions("elementosForm:esportes", "Karate");	
	Assert.assertEquals(2, dsl.obterQuantidadeOpcoesMarcadas("elementosForm:esportes"));
	
	List<String> opcoesMarcadas = dsl.obterOpcoesMarcadas("elementosForm:esportes");
	Assert.assertTrue(opcoesMarcadas.containsAll(Arrays.asList("Natacao", "Corrida")));
		
	}	
	
	@Test
	public void deveInteragirComBotoes() {	
	
	dsl.clicarBotao("buttonSimple");
		
	Assert.assertEquals("Obrigado!", dsl.obterValueElemento("buttonSimple"));    
	
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
	
	
	@Test
	public void testTextFieldDuplo() {
		
		dsl.escreve(By .id("elementosForm:nome"),"Cunhambebe");
		Assert.assertEquals("Cunhambebe", dsl.obterValorCampo("elementosForm:nome"));		
		
		dsl.escreve(By .id("elementosForm:nome"),"Piquerobi");
		Assert.assertEquals("Piquerobi", dsl.obterValorCampo("elementosForm:nome"));
		
	}
}
