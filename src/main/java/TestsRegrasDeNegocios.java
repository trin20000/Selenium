import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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
  	
  	Assert.assertEquals("Nome eh obrigatorio", dsl.alertaObterTextoEAceita());
	
	}
	
	@Test
	public void desafioRegrasDeNegocioSobrenome() {
		
	dsl.escreve("elementosForm:nome", "Gilberlei");
	dsl.clicarBotao("elementosForm:cadastrar");	
		
	Assert.assertEquals("Sobrenome eh obrigatorio", dsl.alertaObterTextoEAceita());
	
		}
	
	@Test
	public void desafioRegrasDeNegocioSexo() {
	
	dsl.escreve("elementosForm:nome", "Gilberlei");
	dsl.escreve("elementosForm:Sobrenome", "Quaresma");
	dsl.clicarBotao("elementosForm:cadastrar");	
	
	Assert.assertEquals("Sexo eh obrigatorio", dsl.alertaObterTextoEAceita());
	
	
	}
	
	
	@Test
	public void desafioRegrasDeNegocioComida() {
		
		dsl.escreve("elementosForm:nome", "Gilberlei");
		dsl.escreve("elementosForm:Sobrenome", "Quaresma");
	    dsl.clicarRadio("elementosForm:sexo:0");	
	    dsl.clicarRadio("elementosForm:comidaFavorita:0");
	    dsl.clicarRadio("elementosForm:comidaFavorita:3");
	    dsl.clicarBotao("elementosForm:cadastrar");	
	   
	   
	Assert.assertEquals("Tem certeza que voce eh vegetariano?", dsl.alertaObterTextoEAceita() );	
	
		
	}

	@Test
	public void desafioRegrasDeNegocioEsporte() {
		
		
		dsl.escreve("elementosForm:nome", "Gilberlei");
		dsl.escreve("elementosForm:Sobrenome", "Quaresma");
		dsl.clicarRadio("elementosForm:sexo:0");	
		dsl.clicarRadio("elementosForm:comidaFavorita:3");
		dsl.selecionarCombo("elementosForm:esportes", "Futebol");
		dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");	
		dsl.clicarBotao("elementosForm:cadastrar");
	
		
	Assert.assertEquals("Voce faz esporte ou nao?", dsl.alertaObterTextoEAceita());
			
	}
	

}
