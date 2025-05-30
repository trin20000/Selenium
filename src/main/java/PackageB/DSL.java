package PackageB;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {

	
	
	/************************* TextField TextAlert  ***************************/
	
	
	
	
	public void escreve(By by, String texto ) {
		
		DriverFactory.getDriver().findElement(by).clear();
		DriverFactory.getDriver().findElement(by).sendKeys(texto);
		
	}
	

	public void escreve(String id_campo, String texto ) {	
	
	escreve(By.id(id_campo), texto);
	
	}	
	
	
	public String obterValorCampo(String id_campo) {		
		return DriverFactory.getDriver().findElement(By.id(id_campo)).getDomProperty("value");
		
	}
	
	/******************** Radio & Check *****************/
	public void clicarRadio(By by) {
		DriverFactory.getDriver().findElement(by).click();	
	}
		
	
	public void clicarRadio(String id) {
		clicarRadio(By.id(id));	
	}
	
	public boolean isRadioMarcado(String id) {
		return DriverFactory.getDriver().findElement(By.id(id)).isSelected();
	}
	
	

	public void clicarBotao(String id) {
	
	DriverFactory.getDriver().findElement(By.id(id)).click();
	
	}
	
	
	/************************* link ****************/
	
		
	public void clicarLink(String link) {
		
		DriverFactory.getDriver().findElement(By.linkText(link)).click();
	}
	
	
	/****************** obter texto **************************/
	
    public String obterTexto(By by) {
		
		return DriverFactory.getDriver().findElement(by).getText();
	}
	
	
	public String obterTexto(String id) {
		
		return obterTexto(By.id(id));
		
	}	
	
	
	/************************ interação com combo **********************/
	
	
	
	public void selecionarComboPrime(String radical, String valor) {
	clicarRadio(By.xpath("//form[@id='"+radical+"']//span[@id='j_idt248:option_label']"));
	clicarRadio(By.xpath("//*[@id='"+valor+"']"));
	
	}
	
	public String obterValorComboPrime(String id) {
		
		WebElement element = DriverFactory.getDriver().findElement(By.xpath(id));	
		return element.getText();
	}
	
	
public void selecionarCombo(String id, String valor) {
		
		WebElement element = DriverFactory.getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
		
	}
	
	
	public String obterValorCombo(String id) {
		
		WebElement element = DriverFactory.getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();
	}
	
	
	public int obterQuantidadeOpcoesCombo(String id) {
		
		WebElement element = DriverFactory.getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		return options.size();		
	}
		
	public boolean verificarOpcaoCombo(String id, String opcao) {
	
	WebElement element = DriverFactory.getDriver().findElement(By.id(id));
	Select combo = new Select(element);
	List<WebElement> options = combo.getOptions();
		for(WebElement option: options) {
		if (option.getText().equals(opcao)) {
		return true;
		
			}
		
		}
		return false;
	}
	
	
	public int obterQuantidadeOpcoesMarcadas(String id) {
		
		WebElement element = DriverFactory.getDriver().findElement(By.id(id));
		Select combo = new Select(element);		
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		
		return allSelectedOptions.size();
	}
	
	public void deselectComboOptions(String id, String visibleText) {
		
		WebElement element = DriverFactory.getDriver().findElement(By.id(id));
		Select combo = new Select(element);	
		combo.deselectByVisibleText(visibleText);
		
	}
	
	
	public List<String> obterOpcoesMarcadas(String id) {
		
		WebElement element = DriverFactory.getDriver().findElement(By.id(id));
		Select combo = new Select(element);			
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		List<String> valores = new ArrayList<String>();
		
		for(WebElement opcoes: allSelectedOptions){
			
			valores.add(opcoes.getText());			
		}
		
		return valores;		
		
	}

	
	/******************* obter button value *****************/
	
	public String obterValueElemento(String id) {
		
		return DriverFactory.getDriver().findElement(By.id(id)).getDomAttribute("value");
		
	}

	
	/**************** alerts ******************/
	
	public void alertEscreve(String texto) {
	
	Alert alert = DriverFactory.getDriver().switchTo().alert();
	alert.sendKeys(texto);
	alert.accept();
	
	}
	
	public String alertaObterTexto() {
		
		Alert alert = DriverFactory.getDriver().switchTo().alert();		
		return alert.getText();
		
		}	
	
	
	public String alertaObterTextoCancel() {
		
		Alert alert = DriverFactory.getDriver().switchTo().alert();
		String valor = alert.getText();
		alert.dismiss();
		return  valor;
		
		}	
	
	
	public String alertaObterTextoEAceita() {
		
		Alert alert = DriverFactory.getDriver().switchTo().alert();
		String valor = alert.getText();
		alert.accept();
		return  valor;		
				
	}	
	
	/************************ frame  janela **********************/
	
	public void changeToFrame(String framename) {
	
	DriverFactory.getDriver().switchTo().frame(framename);
	
	}
	
	
	
	public void switchToWindowPopUp(String janelaName) {
		
		DriverFactory.getDriver().switchTo().window(janelaName);
	}
	
	
	
	/******************** JS ******************************/
	
	public Object executarJS(String cmd, Object... param) {
	
		
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		return js.executeScript(cmd, param);
		
 }
	
	/******************** Tabela ******************************/
	
	public void clicarBotaoTabela(String colunaBusca, String valor, String colunaBotao, String idTabela) {
		//procurar coluna do registro
		WebElement tabela = DriverFactory.getDriver().findElement(By.xpath("//*[@id='elementosForm:tableUsuarios']"));
		int idColuna = obterIndiceColuna(colunaBusca, tabela);
		
		//encontrar linha do registro
		int idLinha = obterIndiceLinha(valor, tabela, idColuna);
		
		
		//procurar coluna do botao
		int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);
		
		
		//clicar no botao da celula 
		WebElement celula = tabela.findElement(By.xpath(".//tr["+idLinha+"]/td["+idColunaBotao+"]"));
		celula.findElement(By.xpath(".//input")).click();
		
		
		//table[@id='elementosForm:tableUsuarios']//th
	}


	private int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
		List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td["+idColuna+"]"));
		int idLinha = -1;
		for(int i=0; i < linhas.size(); i++) {
			if(linhas.get(i).getText().equals(valor)) {
				idLinha = i+1;
				break;
			}			
		}
		return idLinha;
	}


	private int obterIndiceColuna(String coluna, WebElement tabela) {
		List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
		int idColuna = -1;
		for(int i=0; i < colunas.size(); i++) {
			if(colunas.get(i).getText().equals(coluna)) {
				idColuna = i+1;
				break;
			}
			
		}
	return idColuna;
	}
	
	
}
