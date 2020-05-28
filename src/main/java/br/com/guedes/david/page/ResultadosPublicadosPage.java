package br.com.guedes.david.page;

import java.util.List;

import org.openqa.selenium.WebDriver;

import br.com.guedes.david.core.DSL;

public class ResultadosPublicadosPage {
	
	private DSL dsl;

	public ResultadosPublicadosPage(WebDriver driver) {
		dsl = new DSL(driver);
	}
	
	public void abrirOpcaoResultadosPublicados(String texto) {
		dsl.clicarPorXpath("//*[contains(text(),'"+texto+"')]");
		
	}
	
	public void abrirOpcaoResultadosPublicados() {
		dsl.clicarPorId("v-pills-profile-tab");
	}
	
	public String pegarDescricaoDoEdital(String texto) {
		
		String descricao = "";
		
		try{
		descricao = dsl.obterValorCampoPorXpath("//*[@class='title ng-binding'][contains(text(),'"+texto+"')]/..//*[@class='descricao ng-binding']");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return descricao;
	}
	
	
	public List<String> verificarSeExisteResultadoPublicado(String texto) {
		return dsl.encontrarElementosPorXpathContains(texto);
	}
	
	
}
