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
	private TestRegraDeNegociosPage page;
	
	@Before
	public void inicializa() {
		
		driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		dsl = new DSL(driver);
		page = new TestRegraDeNegociosPage (driver);
	}
	
	@After	
	public void finaliza() {
		
		driver.quit();
	}
	
	
	
	@Test
	public void desafioRegrasDeNegocioNome() {
	
	page.cadastrar();
  	Assert.assertEquals("Nome eh obrigatorio", dsl.alertaObterTextoEAceita());
	
	}
	
	@Test
	public void desafioRegrasDeNegocioSobrenome() {
	
	page.setNome("Gilberlei");
	page.cadastrar();	
		
	Assert.assertEquals("Sobrenome eh obrigatorio", dsl.alertaObterTextoEAceita());
	
		}
	
	@Test
	public void desafioRegrasDeNegocioSexo() {
	
	page.setNome("Gilberlei");
	page.setSobrenome("Quaresma");
	page.cadastrar();
	
	Assert.assertEquals("Sexo eh obrigatorio", dsl.alertaObterTextoEAceita());
	
	
	}
	
	
	@Test
	public void desafioRegrasDeNegocioComida() {
		
		page.setNome("Gilberlei");
		page.setSobrenome("Quaresma");
		page.setSexoMasculino();	
	    page.setComidaFavoritaCarne();
	    page.setComidaFavoritaVegetariano();
	    page.cadastrar();
	   
	   
	Assert.assertEquals("Tem certeza que voce eh vegetariano?", dsl.alertaObterTextoEAceita() );	
	
		
	}

	@Test
	public void desafioRegrasDeNegocioEsporte() {
		
		
		page.setNome("Gilberlei");
		page.setSobrenome("Quaresma");
		page.setSexoMasculino();	
	    page.setComidaFavoritaCarne();
	    page.setEsporte("Futebol", "O que eh esporte?");	    		
		page.cadastrar();
	
		
	Assert.assertEquals("Voce faz esporte ou nao?", dsl.alertaObterTextoEAceita());
			
	}
	

}
