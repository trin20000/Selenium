package PackageTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import PackageB.BaseTest;
import PackageB.DriverFactory;
import PackagePage.CadastroUsuarioPage;

public class CadastrodeUsuario extends BaseTest {
	


private CadastroUsuarioPage page;
	@Before
	public void inicializa() {		
		
		DriverFactory.getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		page = new CadastroUsuarioPage();
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
