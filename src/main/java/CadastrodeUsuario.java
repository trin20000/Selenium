import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CadastrodeUsuario {
	
private WebDriver driver;
//private DSL dsl;
private CadastroUsuarioPage page;
	@Before
	public void inicializa() {
		
		driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		//dsl = new DSL(driver);
		page = new CadastroUsuarioPage(driver);
	}
	
	@After	
	public void finaliza() {
		
		driver.quit();
	}
	
	@Test
	public void interagirComAlertSimples() {
		
	page.setNome("Gilberlei");
	page.setSobrenome("Quaresma");
	page.setSexoMasculino();
	page.setComidaFavoritaCarne();
	page.setEscolaridade("1o grau incompleto");
	page.setEsporte("Futebol");
	page.cadastrar();
	
	
	Assert.assertEquals("Cadastrado!", page.obterResultadoCadastro());
	Assert.assertEquals("Gilberlei", page.obterNomeCadastro());
	Assert.assertEquals("Quaresma", page.obterSobrenomeCadastro());
	Assert.assertEquals("Masculino", page.obterSexoCadastro());
	Assert.assertEquals("Carne", page.obterComidaFavoritaCadastro());
	Assert.assertEquals("1grauincomp", page.obterEscolaridadeCadastro());
	Assert.assertEquals("Futebol", page.obterEsporteCadastro());
	
	}
	
	
	
	
}
