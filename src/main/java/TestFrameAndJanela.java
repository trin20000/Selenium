import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
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
	
	driver.switchTo().frame("frame1");
	dsl.clicarBotao("frameButton");
	
	Alert alert = driver.switchTo().alert();
	String msg = alert.getText();
	Assert.assertEquals("Frame OK!", msg);
	alert.accept();
	driver.switchTo().defaultContent();
	dsl.escreve("elementosForm:nome", msg);
	
	
	}
	
	
	@Test
	public void interagirComJanela()  {
		
	dsl.clicarBotao("buttonPopUpEasy");
	driver.switchTo().window("Popup");
	
	driver.findElement(By.tagName("textarea")).sendKeys("Deu certo?");
	driver.close();
    driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);	
	dsl.escreve("elementosForm:sugestoes", "e agora?");
	
	
	}
	
	
	
	@Test
	public void interagirComJanelaSemTitulo()  {
		
	dsl.clicarBotao("buttonPopUpHard");
	System.out.println(driver.getWindowHandle());
	System.out.println(driver.getWindowHandles());
	
	driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);
	driver.findElement(By.tagName("textarea")).sendKeys("Deu certo?");
	driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);
	driver.findElement(By.tagName("textarea")).sendKeys("E agora?");
	
	}

}
