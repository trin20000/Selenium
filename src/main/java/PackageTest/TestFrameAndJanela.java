package PackageTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import PackageB.DSL;
import PackageB.DriverFactory;


public class TestFrameAndJanela {	
	
	private DSL dsl;
	
	@Before
	public void inicializa() {		
		
		DriverFactory.getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		dsl = new DSL();
	}
	
	@After	
	public void finaliza() {
		
		DriverFactory.killDriver();
	}
	
	
	
	@Test
	public void interagirComAlertSimples() {
	
	
	dsl.changeToFrame("frame1");
	dsl.clicarBotao("frameButton");	
		
	String msg = dsl.alertaObterTexto();
	Assert.assertEquals("Frame OK!", dsl.alertaObterTextoEAceita());
	
	DriverFactory.getDriver().switchTo().defaultContent();
	dsl.escreve("elementosForm:nome", msg);	
	
	}
	
	@Test
	public void deveInteragirComFrameEscondido() {
		WebElement frame = DriverFactory.getDriver().findElement(By.id("frame2"));
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
	DriverFactory.getDriver().close();
	//dsl.switchToWindowPopUp(originalWindow);
    dsl.switchToWindowPopUp((String) DriverFactory.getDriver().getWindowHandles().toArray()[0]);
	dsl.escreve(By.tagName("textarea"), "e agora?");
	
	
	}
	
	
	
	@Test
	public void interagirComJanelaSemTitulo()  {
		
	dsl.clicarBotao("buttonPopUpHard");
	System.out.println(DriverFactory.getDriver().getWindowHandle());
	System.out.println(DriverFactory.getDriver().getWindowHandles());
	
	dsl.switchToWindowPopUp((String) DriverFactory.getDriver().getWindowHandles().toArray()[1]);
	dsl.escreve(By.tagName("textarea"), "Deu certo?");
	dsl.switchToWindowPopUp((String) DriverFactory.getDriver().getWindowHandles().toArray()[0]);
	dsl.escreve(By.tagName("textarea"), "e agora?");
	
	}

}
