package sistemadetestes.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProdutoPO extends BasePO{
	
	@FindBy(id = "codigo")
	public WebElement inputCodigo;
	
	@FindBy(id = "nome")
	public WebElement inputNome;
	
	@FindBy(id = "quantidade")
	public WebElement inputQuantidade;
	
	@FindBy(id = "valor")
	public WebElement inputValor;
	
	@FindBy(id = "data")
	public WebElement inputData;

	@FindBy(id = "btn-adicionar")
	public WebElement buttonCriar;
	
	@FindBy(id = "btn-salvar")
	public WebElement buttonSalvar;//padrão da variável: nome do elemento html + o que ele representa
	
	@FindBy(css = "div.modal-content>div.modal-header>button.close")
	public WebElement buttonClose;
	
	@FindBy(css = "div.alert>div.close")
	public WebElement buttonCloseAlert;
	
	//document.querySelector('form>div.alert>span')
	//document.querySelector('form.form-login>div.alert>span').textContent
	@FindBy(id = "mensagem")
	public WebElement spanMensagem;
	//capturar a mensagem funciona por id também
	
	/**
	 * Construtor padrão para criação de uma nova instância da página de login
	 * @param driver Driver da página de login
	 * */
	public ProdutoPO(WebDriver driver) {
		super(driver);
	}
	
	public String obterMensagem() {
		return this.spanMensagem.getText();
	}
	
	public void escrever(WebElement input, String texto) {
		input.clear();
		input.sendKeys(texto + Keys.TAB);
	}
	
	public String obterTituloPagina() {
		return driver.getTitle();
	}
	
	/**
	 * Método que tenta executar a ação no sistema
	 * @param email Email para tentativa de login
	 * @param senha Senha para tentativa de login
	 * */
	public void executarAcaoCriar() {
		buttonCriar.click();
		
	}
	public void executarAcaoSalvar() {
		buttonSalvar.click();
	}
	public void executarAcaoClose() {
		buttonClose.click();
	}
	public void executarAcaoCloseAlert() {
		buttonCloseAlert.click();
	}
	
	public String obterTituloDaPagina() {
		return driver.getTitle();
	}

}
