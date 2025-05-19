import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CadastrodeUsuario {
	
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
		
	dsl.escreve("elementosForm:nome", "Gilberlei");
	dsl.escreve("elementosForm:sobrenome", "Quaresma");
	dsl.clicarRadio("elementosForm:sexo:0");
	dsl.clicarRadio("elementosForm:comidaFavorita:0");

	dsl.selecionarCombo("elementosForm:escolaridade", "1o grau incompleto");	
	dsl.selecionarCombo("elementosForm:esportes", "Futebol");
	
	dsl.clicarBotao("elementosForm:cadastrar");
	
	Assert.assertTrue(dsl.obterTexto("resultado").startsWith("Cadastrado!"));
	Assert.assertTrue(dsl.obterTexto("descNome").endsWith("Gilberlei"));
	Assert.assertEquals("Sobrenome: Quaresma", dsl.obterTexto("descSobrenome"));
	Assert.assertEquals("Sexo: Masculino", dsl.obterTexto("descSexo"));
	Assert.assertEquals("Escolaridade: 1grauincomp", dsl.obterTexto("descEscolaridade"));
	Assert.assertEquals("Esportes: Futebol",dsl.obterTexto("descEsportes"));
	
	}
	
	
	
	
}
