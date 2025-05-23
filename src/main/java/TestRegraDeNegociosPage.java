import org.openqa.selenium.WebDriver;
public class TestRegraDeNegociosPage {
	
	private DSL dsl;
	
	public TestRegraDeNegociosPage(WebDriver driver) {
		dsl = new DSL(driver);
		
	}
	
	public void cadastrar() {
		dsl.clicarBotao("elementosForm:cadastrar");
	}
	
	public void setNome(String nome) {
		
		dsl.escreve("elementosForm:nome", nome);
	}
	
	public void setSobrenome(String sobrenome) {
		
		dsl.escreve("elementosForm:sobrenome", sobrenome);
		
	}
	
	public void setSexoMasculino() {
		
		dsl.clicarRadio("elementosForm:sexo:0");
	}
	
	
	public void setSexoFeminino() {
		
		dsl.clicarRadio("elementosForm:sexo:1");
	}
	
	
	public void setComidaFavoritaCarne() {
		dsl.clicarRadio("elementosForm:comidaFavorita:0");
	}
	
	public void setComidaFavoritaVegetariano() {
		dsl.clicarRadio("elementosForm:comidaFavorita:3");
	}
	
	public void setComidaFavoritaPizza() {
		dsl.clicarRadio("elementosForm:comidaFavorita:2");
	}
	
		
	public void setEsporte(String... valores) {
		for(String valor: valores) {
			dsl.selecionarCombo("elementosForm:esportes", valor);
		}
	}	
}
