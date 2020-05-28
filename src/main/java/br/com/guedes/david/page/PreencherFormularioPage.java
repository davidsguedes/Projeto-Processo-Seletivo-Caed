package br.com.guedes.david.page;

import org.openqa.selenium.WebDriver;

import br.com.guedes.david.core.DSL;

public class PreencherFormularioPage {
	
	private DSL dsl;

	public PreencherFormularioPage(WebDriver driver) {
		dsl = new DSL(driver);
	}
	
	public void preencherdescricaoProcessoSeletivoGoogleForms(String descricao) {
		dsl.escreverXpath("//*[@class='quantumWizTextinputPaperinputInput exportInput']", descricao);
	}
	
	public void enviarRespostaProcessoSeletivo() {
		dsl.clicarPorXpath("//*[@class='appsMaterialWizButtonPaperbuttonContent exportButtonContent']");
	}
	
	public String respostaEnviadaComSucesso() {
		return dsl.obterValorCampoPorXpath("//*[@class='freebirdFormviewerViewResponseConfirmationMessage']");
	}

	public String respostaNaoEnviada() {
		return dsl.obterValorCampoPorXpath("//*[@id='i.err.655824198']");
	}
}
