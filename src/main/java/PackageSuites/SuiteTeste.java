package PackageSuites;
import org.junit.runners.Suite;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;
import PackageB.DriverFactory;
import PackageTest.CadastrodeUsuario;
import PackageTest.TestRegrasCadastro;


@RunWith(Suite.class)
@SuiteClasses({
	
	CadastrodeUsuario.class,
	TestRegrasCadastro.class,		
})

public class SuiteTeste {
	
	@AfterClass
	public static void finalizaTudo() {
		DriverFactory.killDriver();
	}
	

}
