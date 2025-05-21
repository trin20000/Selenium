import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {

	private WebDriver driver;
	
	
	public DSL(WebDriver driver) {
		
		this.driver = driver;
	}

	public void escreve(String id_campo, String texto ) {	
	driver.findElement(By.id(id_campo)).sendKeys(texto);

	}
	
	public String obterValorCampo(String id_campo) {		
		return driver.findElement(By.id(id_campo)).getDomProperty("value");
		
	}
	
	public void clicarRadio(String id) {
		driver.findElement(By.id(id)).click();	
	}
	
	public boolean isRadioMarcado(String id) {
		return driver.findElement(By.id(id)).isSelected();
	}
	
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

	public void clicarBotao(String id) {
	
	driver.findElement(By.id(id)).click();
	
	}
	
		
	public void clicarLink(String link) {
		
		driver.findElement(By.linkText(link)).click();
	}
	
	
    public String obterTexto(By by) {
		
		return driver.findElement(by).getText();
	}
	
	
	public String obterTexto(String id) {
		
		return obterTexto(By.id(id));
		
	}	
	
	
	public int obterQuantidadeOpçoesCombo() {
		
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
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

	public String obterValueElemento(String id) {
		
		WebElement buton = driver.findElement(By.id(id));
		
		return buton.getDomAttribute("value");
	}

	
	public void switchToAlert() {
		
		
	}


}
