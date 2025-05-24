import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestFrameAndJanela {
	
private WebDriver driver;
private DSL dsl;
	
	@Before
	public void inicializa() {
		
		driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		dsl = new DSL(driver);
	}
	
	@After	
	public void finaliza() {
		
		driver.quit();
	}
	
	
	
	@Test
	public void interagirComAlertSimples() {
	
	
	dsl.changeToFrame("frame1");
	dsl.clicarBotao("frameButton");	
		
	String msg = dsl.alertaObterTexto();
	Assert.assertEquals("Frame OK!", dsl.alertaObterTextoEAceita());
	
	driver.switchTo().defaultContent();
	dsl.escreve("elementosForm:nome", msg);	
	
	}
	
	@Test
	public void deveInteragirComFrameEscondido() {
		WebElement frame = driver.findElement(By.id("frame2"));
		dsl.executarJS("window.scrollBy(0, arguments[0])", frame.getLocation().y);
		dsl.changeToFrame("frame2");
		dsl.clicarBotao("frameButton");
		
		//String msg = dsl.alertaObterTexto();
		Assert.assertEquals("Frame OK!", dsl.alertaObterTextoEAceita());
	}
	
	
	@Test
	public void interagirComJanela()  {
	//String originalWindow = driver.getWindowHandle();	
	dsl.clicarBotao("buttonPopUpEasy");
	//driver.switchTo().window("Popup");
	dsl.switchToWindowPopUp("Popup");
	
	//driver.findElement(By.tagName("textarea")).sendKeys("Deu certo?");
	dsl.escreve(By.tagName("textarea"), "Deu certo?");
	driver.close();
	//dsl.switchToWindowPopUp(originalWindow);
    dsl.switchToWindowPopUp((String) driver.getWindowHandles().toArray()[0]);
	dsl.escreve(By.tagName("textarea"), "e agora?");
	
	
	}
	
	
	
	@Test
	public void interagirComJanelaSemTitulo()  {
		
	dsl.clicarBotao("buttonPopUpHard");
	System.out.println(driver.getWindowHandle());
	System.out.println(driver.getWindowHandles());
	
	dsl.switchToWindowPopUp((String) driver.getWindowHandles().toArray()[1]);
	dsl.escreve(By.tagName("textarea"), "Deu certo?");
	dsl.switchToWindowPopUp((String) driver.getWindowHandles().toArray()[0]);
	dsl.escreve(By.tagName("textarea"), "e agora?");
	
	}

}
