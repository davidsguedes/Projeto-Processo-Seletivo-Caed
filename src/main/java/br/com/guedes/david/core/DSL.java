package br.com.guedes.david.core;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DSL {

	private WebDriver driver;

	public DSL(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void acessarUrl(String url) {
		driver.get(url);
	}

	// --------------------------Clicar
	public void clicar(By by) {
		driver.findElement(by).click();

	}

	public void clicarPorXpath(String xpath) {
		clicar(By.xpath(xpath));
	}

	public void clicarPorId(String idCampo) {
		clicar(By.id(idCampo));
	}

	// --------------------------Escrever
	public void escrever(By by, String texto) {
		driver.findElement(by).sendKeys(texto);
	}

	public void escreverXpath(String xpath, String texto) {
		escrever(By.xpath(xpath), texto);
	}

	// --------------------------Obtenção de campos
	public String obterValorCampo(By by) {
		return driver.findElement(by).getText();
	}

	public String obterValorCampoPorXpath(String xpath) {
		return obterValorCampo(By.xpath(xpath));
	}

	public String obterValorCampoPorXpathContains(String texto) {
		return obterValorCampo(By.xpath("//*[contains(text(),'" + texto + "')]"));
	}

	// --------------------------Encontrar campo
	public void encontrarCampo(By by) {
		driver.findElement(by);
	}

	public WebElement encontrarCampoPorXpath(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}

	// --------------------------Encontrar campos
	public List<WebElement> encontrarElementos(By by) {
		List<WebElement> elements = driver.findElements(by);
		return elements;
	}

	public List<WebElement> encontrarElementosPorXpath(String xpath) {
		List<WebElement> elements = encontrarElementos(By.xpath(xpath));
		return elements;
	}

	public List<String> encontrarElementosPorXpathContains(String texto) {
		List<WebElement> aux = new ArrayList<>();
		ListIterator<WebElement> iterator = null;
		List<String> processo = new ArrayList<>();

		String prefixo = swicthMenu();
		
		aux = driver.findElements(By.xpath("//*[@id='"+prefixo+"']//*[@ng-if='!loading']//*[@class='collapsed']//*[@class='title ng-binding']"));
		iterator = aux.listIterator();

		System.out.println(iterator);

		while (iterator.hasNext()) {
			String values = iterator.next().getText();

			if (values.equals(texto)) {
				processo.add(values);
			} else {
			}
			iterator.remove();
		}
		System.out.println(processo);

		aux.clear();
		return processo;

	}

	// -------------------------identifica a divClass do menu
	public String swicthMenu() {

		/***************************************/
		// Editais abertos: //*[@id='edital-aberto']//*[@ng-if='!loading']//*[@class='collapsed']//*[@class='title ng-binding']
		// Resultados publicados: //*[@id='v-pills-profile']//*[@ng-if='!loading']//*[@class='collapsed']//*[@class='title ng-binding']
		// Editais Encerrados: //*[@id='v-pills-messages']//*[@ng-if='!loading']//*[@class='collapsed']//*[@class='title ng-binding']
		/***************************************/

		String menu = encontrarCampoPorXpath("//*[@aria-selected='true']").getText();

		switch (menu) {
		case "EDITAIS ABERTOS":
			menu = "edital-aberto";
			break;
		case "RESULTADOS PUBLICADOS":
			menu = "v-pills-profile";
			break;
		case "EDITAIS ENCERRADOS":
			menu = "v-pills-messages";
			break;
		}

		return menu;
	}

	// --------------------------Aguardar elemento visivel
	public WebElement esperarElementoVisivel(String xpath) {

		WebElement e = encontrarCampoPorXpath(xpath);
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(e));
		return e;

	}

}
