package br.com.guedes.david.page;

import java.util.List;

import org.openqa.selenium.WebDriver;

import br.com.guedes.david.core.DSL;

public class EditaisEncerradosPage {
	
	private DSL dsl;

	public EditaisEncerradosPage(WebDriver driver) {
		dsl = new DSL(driver);
	}
	
	public void abrirOpcaoEditaisEncerrados(String texto) {
		dsl.clicarPorXpath("//*[contains(text(),'"+texto+"')]");
	}
	
	public void abrirOpcaoEditaisEncerrados() {
		dsl.clicarPorId("v-pills-messages-tab");
	}
	
	public List<String> verificarSeExisteEditalEncerrado(String texto) {
		return dsl.encontrarElementosPorXpathContains(texto);
	}

}
