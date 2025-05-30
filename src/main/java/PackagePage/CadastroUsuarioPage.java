package PackagePage;
import org.openqa.selenium.By;
import PackageB.BasePage;
public class CadastroUsuarioPage extends BasePage {	
	
	
	public void setNome(String nome) {
		
		dsl.escreve("elementosForm:nome", nome);
	}

	public void setSobrenome(String sobrenome) {
	
		dsl.escreve("elementosForm:sobrenome", sobrenome);
		
	}

	public void setSexoMasculino() {
	
		dsl.clicarRadio("elementosForm:sexo:0");
	}

	public void setComidaFavoritaCarne() {
		dsl.clicarRadio("elementosForm:comidaFavorita:0");
	}

	public void setEscolaridade(String valor) {
		dsl.selecionarCombo("elementosForm:escolaridade", valor);

	}
	
	public void setEsporte(String valor) {
		dsl.selecionarCombo("elementosForm:esportes", valor);
	}
	
	public void cadastrar() {
		dsl.clicarBotao("elementosForm:cadastrar");
	}

	public String obterResultadoCadastro() {
		return dsl.obterTexto(By.xpath("//div[@id='resultado']//span"));
	}

	public String obterNomeCadastro() {
		return dsl.obterTexto(By.xpath("//div[@id='descNome']//span"));

	}

	public String obterSobrenomeCadastro() {
		return dsl.obterTexto(By.xpath("//div[@id='descSobrenome']//span"));
	}
	
	public String obterSexoCadastro() {
		return dsl.obterTexto(By.xpath("//div[@id='descSexo']//span"));
	}
	
	public String obterComidaFavoritaCadastro() {
		return dsl.obterTexto(By.xpath("//div[@id='descComida']//span"));
	}
	
	public String obterEscolaridadeCadastro() {
		return dsl.obterTexto(By.xpath("//div[@id='descEscolaridade']//span"));
	}
	
	public String obterEsporteCadastro() {
		return dsl.obterTexto(By.xpath("//div[@id='descEsportes']//span"));
	}

}

