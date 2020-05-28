package br.com.guedes.david.page;

import org.openqa.selenium.WebDriver;

import br.com.guedes.david.core.DSL;

public class MenuPage {
	
	private DSL dsl;

	public MenuPage(WebDriver driver) {
		dsl = new DSL(driver);
	}
	
	public void acessarSiteCaed() {
		dsl.acessarUrl("http://fundacaocaed.org.br/#!/pagina-inicial");
	}
	
	public void clicarProcessosSeletivos() {
		dsl.clicarPorXpath("//*[@id='navbarSupportedContent']/ul/li[4]/a");
	}
	
	public void clicarFecharAlertaProcessosSeletivos() {
		dsl.esperarElementoVisivel("//*[@id='msg']/div/div/div[3]/button").click();
	}

}
