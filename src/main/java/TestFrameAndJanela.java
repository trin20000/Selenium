import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestFrameAndJanela {
	
	@Test
	public void interagirComAlertSimples() throws InterruptedException {
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().setSize(new Dimension(1200, 765));
	driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	
	driver.switchTo().frame("frame1");
	driver.findElement(By.id("frameButton")).click();
	
	Alert alert = driver.switchTo().alert();
	String msg = alert.getText();
	Assert.assertEquals("Frame OK!", msg);
	alert.accept();
	Thread.sleep(1000);
	driver.switchTo().defaultContent();
	driver.findElement(By.id("elementosForm:nome")).sendKeys(msg);	
	driver.quit();	
	
	}
	
	
	@Test
	public void interagirComJanela()  {
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().setSize(new Dimension(1200, 765));
	driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	
	driver.findElement(By.id("buttonPopUpEasy")).click();
	driver.switchTo().window("Popup");
	
	driver.findElement(By.tagName("textarea")).sendKeys("Deu certo?");
	driver.close();
    //driver.switchTo().window("");	   
	
	driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("e agora?");	
	
	
	}
	
	
	
	@Test
	public void interagirComJanelaSemTitulo()  {
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().setSize(new Dimension(1200, 765));
	driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	
	
	driver.findElement(By.id("buttonPopUpHard")).click();
	System.out.println(driver.getWindowHandle());
	System.out.println(driver.getWindowHandles());
	
	}

}
