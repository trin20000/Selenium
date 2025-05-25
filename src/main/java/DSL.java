import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {

	private WebDriver driver;
	
	
	public DSL(WebDriver driver) {
		
		this.driver = driver;
	}
	
	
	/************************* TextField TextAlert  ***************************/
	
	
	
	
	public void escreve(By by, String texto ) {
		
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(texto);
		
	}
	

	public void escreve(String id_campo, String texto ) {	
	
	escreve(By.id(id_campo), texto);
	
	}	
	
	
	public String obterValorCampo(String id_campo) {		
		return driver.findElement(By.id(id_campo)).getDomProperty("value");
		
	}
	
	/******************** Radio & Check *****************/
	
		
	
	public void clicarRadio(String id) {
		driver.findElement(By.id(id)).click();	
	}
	
	public boolean isRadioMarcado(String id) {
		return driver.findElement(By.id(id)).isSelected();
	}
	
	

	public void clicarBotao(String id) {
	
	driver.findElement(By.id(id)).click();
	
	}
	
	
	/************************* link ****************/
	
		
	public void clicarLink(String link) {
		
		driver.findElement(By.linkText(link)).click();
	}
	
	
	/****************** obter texto **************************/
	
    public String obterTexto(By by) {
		
		return driver.findElement(by).getText();
	}
	
	
	public String obterTexto(String id) {
		
		return obterTexto(By.id(id));
		
	}	
	
	
	/************************ interação com combo **********************/
	
	
public void selecionarCombo(String id, String valor) {
		
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
		
	}
	
	
	public String obterValorCombo(String id) {
		
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();
	}
	
	
	public int obterQuantidadeOpcoesCombo(String id) {
		
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		return options.size();		
	}
		
	public boolean verificarOpcaoCombo(String id, String opcao) {
	
	WebElement element = driver.findElement(By.id(id));
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
		
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);		
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		
		return allSelectedOptions.size();
	}
	
	public void deselectComboOptions(String id, String visibleText) {
		
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);	
		combo.deselectByVisibleText(visibleText);
		
	}
	
	
	public List<String> obterOpcoesMarcadas(String id) {
		
		WebElement element = driver.findElement(By.id(id));
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
		
		return driver.findElement(By.id(id)).getDomAttribute("value");
		
	}

	
	/**************** alerts ******************/
	
	public void alertEscreve(String texto) {
	
	Alert alert = driver.switchTo().alert();
	alert.sendKeys(texto);
	alert.accept();
	
	}
	
	public String alertaObterTexto() {
		
		Alert alert = driver.switchTo().alert();		
		return alert.getText();
		
		}	
	
	
	public String alertaObterTextoCancel() {
		
		Alert alert = driver.switchTo().alert();
		String valor = alert.getText();
		alert.dismiss();
		return  valor;
		
		}	
	
	
	public String alertaObterTextoEAceita() {
		
		Alert alert = driver.switchTo().alert();
		String valor = alert.getText();
		alert.accept();
		return  valor;		
				
	}	
	
	/************************ frame  janela **********************/
	
	public void changeToFrame(String framename) {
	
	driver.switchTo().frame(framename);
	
	}
	
	
	
	public void switchToWindowPopUp(String janelaName) {
		
		driver.switchTo().window(janelaName);
	}
	
	
	
	/******************** JS ******************************/
	
	public Object executarJS(String cmd, Object... param) {
	
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript(cmd, param);
		
 }
	
	/******************** Tabela ******************************/
	
	public void clicarBotaoTabela(String colunaBusca, String valor, String colunaBotao, String idTabela) {
		//procurar coluna do registro
		WebElement tabela = driver.findElement(By.xpath("//*[@id='elementosForm:tableUsuarios']"));
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
		List<WebElement> linhas = tabela.findElements(By.xpath(".//tr/td["+idColuna+"]"));
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
