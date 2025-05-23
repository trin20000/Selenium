import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


@RunWith(Parameterized.class)
public class TestRegrasCadastro {
	
	private WebDriver driver;
	private DSL dsl;
	private TestRegraDeNegociosPage page;
	
	@Parameter
	public String nome;
	@Parameter(value=1)
	public String sobrenome;
	@Parameter(value=2)
	public String sexo;
	@Parameter(value=3)
	public ArrayList<String> comidas;
	@Parameter(value=4)
	public String[] esportes;
	@Parameter(value=5)
	public String msg;
	
	
	
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
	
	@Parameters
	public static Collection<Object[]> getCollection() {
		return Arrays.asList(new Object[][] {
			{"", "", "", new ArrayList<>(Arrays.asList()), new String[]{}, "Nome eh obrigatorio"},
			{"Gilberlei", "", "", new ArrayList<>(Arrays.asList()), new String[]{}, "Sobrenome eh obrigatorio"},
			{"Gilberlei", "Quaresma", "", new ArrayList<>(Arrays.asList()), new String[]{}, "Sexo eh obrigatorio"},
			{"Gilberlei", "Quaresma", "Masculino", new ArrayList<>(Arrays.asList("Carne", "Vegetariano")), new String[]{}, "Tem certeza que voce eh vegetariano?"},
			{"Gilberlei", "Quaresma", "Masculino", new ArrayList<>(Arrays.asList("Carne")), new String[]{"Futebol", "O que eh esporte?"}, "Voce faz esporte ou nao?"}
		});
	}
	
	@Test
	public void deveValidarRegras() {
		
		
		page.setNome(nome);
		page.setSobrenome(sobrenome);
		if (sexo.equals("Masculino")) { 		
			page.setSexoMasculino();
		}
		if (sexo.equals("Feminino")) {
			page.setSexoFeminino();
		}
		if(comidas.contains("Carne")) page.setComidaFavoritaCarne();
		if(comidas.contains("Pizza")) page.setComidaFavoritaPizza();
		if(comidas.contains("Vegetariano")) page.setComidaFavoritaVegetariano();
		
	    
	    page.setEsporte(esportes);	    		
		page.cadastrar();
		System.out.println(msg);
	
		
	Assert.assertEquals(msg, dsl.alertaObterTextoEAceita());
			
	}

}
