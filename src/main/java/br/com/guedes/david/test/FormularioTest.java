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
import br.com.guedes.david.page.PreencherFormularioPage;
import br.com.guedes.david.page.ResultadosPublicadosPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FormularioTest {

	private WebDriver driver;
	private MenuPage menu;
	private ResultadosPublicadosPage pageEP;
	private PreencherFormularioPage pageFP;
	private String dir = "c:/Users/Guedes/driver/chromedriver.exe";

	@Before
	public void inicializa() {
		System.setProperty("webdriver.chrome.driver", dir);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		menu = new MenuPage(driver);
		pageEP = new ResultadosPublicadosPage(driver);
		pageFP = new PreencherFormularioPage(driver);
	}

	@After
	public void encerra() {
		driver.quit();
	}

	@Test
	public void teste1_DevePreencherFormularioAvaliacao_comDescricao_Enviado() {

		List<String> processoSeletivo;
		String opcao = "Processo Seletivo 010/2020";

		menu.acessarSiteCaed();
		menu.clicarProcessosSeletivos();
		menu.clicarFecharAlertaProcessosSeletivos();
		pageEP.abrirOpcaoResultadosPublicados();
		processoSeletivo = pageEP.verificarSeExisteResultadoPublicado(opcao);

		if (processoSeletivo.toString().contains(opcao)) {

			String desc = pageEP.pegarDescricaoDoEdital(opcao);
			driver.get(
					"https://forms.gle/EXLo6WubFhACspcA9");
			pageFP.preencherdescricaoProcessoSeletivoGoogleForms(desc);
			pageFP.enviarRespostaProcessoSeletivo();
			String formularioEnviado = pageFP.respostaEnviadaComSucesso();

			Assert.assertEquals("Sua resposta foi registrada.", formularioEnviado);
		} else {
			System.out.println("Edital não encontrado");
		}
	}

	@Test
	public void teste2_DevePreencherFormularioAvaliacao_semDescricao_NaoEnviado() {

		String opcao = null;

		String desc = pageEP.pegarDescricaoDoEdital(opcao);
		driver.get("https://docs.google.com/forms/d/e/1FAIpQLSd94AY1b53-ishJsyuKhoXMiRCrVE6Ai7OeNlwkhjkps6U29A/viewform");
		pageFP.preencherdescricaoProcessoSeletivoGoogleForms(desc);
		pageFP.enviarRespostaProcessoSeletivo();
		String formularioEnviado = pageFP.respostaNaoEnviada();

		Assert.assertEquals(" Esta pergunta é obrigatória", formularioEnviado);
	}

}
