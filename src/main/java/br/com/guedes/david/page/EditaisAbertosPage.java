package br.com.guedes.david.page;

import java.util.List;

import org.openqa.selenium.WebDriver;

import br.com.guedes.david.core.DSL;

public class EditaisAbertosPage {

	private DSL dsl;

	public EditaisAbertosPage(WebDriver driver) {
		dsl = new DSL(driver);
	}

	public void abrirOpcaoEditaisAbertos() {
		dsl.clicarPorId("edital-aberto-tab");
	}

	public List<String> verificarSeExisteProcessoSeletivoAberto(String texto) {

		return dsl.encontrarElementosPorXpathContains(texto);
	}

}
