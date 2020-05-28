package br.com.guedes.david.test;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.guedes.david.page.MenuPage;
import br.com.guedes.david.page.ResultadosPublicadosPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ResultadosPublicadosTest {

	private WebDriver driver;
	private MenuPage menu;
	private ResultadosPublicadosPage pageEP;
	private String dir = "c:/Users/Guedes/driver/chromedriver.exe";

	@Before
	public void inicializa() {
		System.setProperty("webdriver.chrome.driver", dir);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		menu = new MenuPage(driver);
		pageEP = new ResultadosPublicadosPage(driver);
	}
	
	@After
	public void encerra() {
		driver.quit();
	}
	
	@Test
	public void teste1_DeveValidar_EditaisPublicados_Encontrado() {
		
		List<String> processoSeletivo;
		String opcao = "Processo Seletivo 010/2020";
		
		menu.acessarSiteCaed();
		menu.clicarProcessosSeletivos();
		menu.clicarFecharAlertaProcessosSeletivos();
		pageEP.abrirOpcaoResultadosPublicados();
		processoSeletivo = pageEP.verificarSeExisteResultadoPublicado(opcao);
		
		Assert.assertEquals(1,processoSeletivo.size());
		
	}
	
	@Test
	public void teste2_DeveValidar_EditaisPublicados_NaoEncontrado() {
		
		List<String> processoSeletivo;
		String opcao = "Processo Seletivo 000/2019";
		
		menu.acessarSiteCaed();
		menu.clicarProcessosSeletivos();
		menu.clicarFecharAlertaProcessosSeletivos();
		pageEP.abrirOpcaoResultadosPublicados();
		processoSeletivo = pageEP.verificarSeExisteResultadoPublicado(opcao);
		
		Assert.assertEquals(0,processoSeletivo.size());
		
	}
	
}
