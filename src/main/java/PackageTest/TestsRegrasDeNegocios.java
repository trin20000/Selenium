package PackageTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import PackageB.DSL;
import PackageB.DriverFactory;

public class TestsRegrasDeNegocios {	

	private DSL dsl;
	private TestRegraDeNegociosPage page;
	
	@Before
	public void inicializa() {		
		
		DriverFactory.getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		dsl = new DSL();
		page = new TestRegraDeNegociosPage (DriverFactory.getDriver());
	}
	
	@After	
	public void finaliza() {
		
		DriverFactory.killDriver();
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
