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

import br.com.guedes.david.page.EditaisAbertosPage;
import br.com.guedes.david.page.MenuPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EditaisAbertosTest {

	private WebDriver driver;
	private MenuPage menu;
	private EditaisAbertosPage pageEA;
	private String dir = "c:/Users/Guedes/driver/chromedriver.exe";

	@Before
	public void inicializa() {
		System.setProperty("webdriver.chrome.driver", dir);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		menu = new MenuPage(driver);
		pageEA = new EditaisAbertosPage(driver);
	}

	@After
	public void encerra() {
		driver.quit();
	}

	@Test
	public void teste1_DeveValidar_EditaisAbertos_Encontrado() {

		List<String> processoSeletivo;
		String opcao = "Processo Seletivo 002/2020";

		menu.acessarSiteCaed();
		menu.clicarProcessosSeletivos();
		menu.clicarFecharAlertaProcessosSeletivos();
		pageEA.abrirOpcaoEditaisAbertos();
		processoSeletivo = pageEA.verificarSeExisteProcessoSeletivoAberto(opcao);

		Assert.assertEquals(1, processoSeletivo.size());

	}

	@Test
	public void teste2_DeveValidar_EditaisAbertos_NaoEncontrado() {

		List<String> processoSeletivo;
		String opcao = "Processo Seletivo 010/2020";

		menu.acessarSiteCaed();
		menu.clicarProcessosSeletivos();
		menu.clicarFecharAlertaProcessosSeletivos();
		pageEA.abrirOpcaoEditaisAbertos();
		processoSeletivo = pageEA.verificarSeExisteProcessoSeletivoAberto(opcao);

		Assert.assertEquals(0, processoSeletivo.size());

	}

}
