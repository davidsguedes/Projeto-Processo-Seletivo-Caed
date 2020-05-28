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

import br.com.guedes.david.page.EditaisEncerradosPage;
import br.com.guedes.david.page.MenuPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EditaisEncerradosTest {

	private WebDriver driver;
	private MenuPage menu;
	private EditaisEncerradosPage pageER;
	private String dir = "c:/Users/Guedes/driver/chromedriver.exe";

	@Before
	public void inicializa() {
		System.setProperty("webdriver.chrome.driver", dir);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		menu = new MenuPage(driver);
		pageER = new EditaisEncerradosPage(driver);
	}

	@After
	public void encerra() {
		driver.quit();
	}

	@Test
	public void teste1_DeveValidar_EditaisEncerrados_Encontrado() {

		List<String> processoSeletivo;
		String opcao = "Processo Seletivo 020/2019";

		menu.acessarSiteCaed();
		menu.clicarProcessosSeletivos();
		menu.clicarFecharAlertaProcessosSeletivos();
		pageER.abrirOpcaoEditaisEncerrados();
		processoSeletivo = pageER.verificarSeExisteEditalEncerrado(opcao);

		Assert.assertEquals(1, processoSeletivo.size());

	}

	@Test
	public void teste2_DeveValidar_EditaisEncerrados_NaoEncontrado() {

		List<String> processoSeletivo;
		String opcao = "Processo Seletivo 000/2019";

		menu.acessarSiteCaed();
		menu.clicarProcessosSeletivos();
		menu.clicarFecharAlertaProcessosSeletivos();
		pageER.abrirOpcaoEditaisEncerrados();
		processoSeletivo = pageER.verificarSeExisteEditalEncerrado(opcao);

		Assert.assertEquals(0, processoSeletivo.size());

	}

}
