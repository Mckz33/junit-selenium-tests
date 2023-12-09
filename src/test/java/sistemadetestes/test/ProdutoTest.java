package sistemadetestes.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import sistemadetestes.pageObject.LoginPO;
import sistemadetestes.pageObject.ProdutoPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProdutoTest extends BaseTest{
	
	private static ProdutoPO produtoPage;
	
	@BeforeClass
	public static void prepararTestes() {
		produtoPage = new ProdutoPO(driver);
	}
	
	@Test
	public void TC006_naoDeveCadastrarProdutosComCamposVazios() {
		
		produtoPage.executarAcaoCriar();
		produtoPage.executarAcaoCriar();
		
		produtoPage.inputCodigo.sendKeys("");
		produtoPage.inputNome.sendKeys("");
		produtoPage.inputQuantidade.sendKeys("");
		produtoPage.inputValor.sendKeys("");
		produtoPage.inputData.sendKeys("");
		
		produtoPage.escrever(produtoPage.inputCodigo, "");
		produtoPage.escrever(produtoPage.inputNome, "");
		produtoPage.escrever(produtoPage.inputQuantidade, "");
		produtoPage.escrever(produtoPage.inputValor, "");
		produtoPage.escrever(produtoPage.inputData, "");
		
		produtoPage.executarAcaoSalvar();
		
		String mensagem = produtoPage.obterMensagem();
		
		assertEquals(mensagem, "Todos os campos são obrigatórios para o cadastro!");
		
		produtoPage.executarAcaoClose();
		
	}
	@Test
	public void TC007_naoDeveCadastrarProdutosComCamposVaziosECodigoPreenchido() {
		
		produtoPage.executarAcaoCriar();
		
		produtoPage.inputCodigo.sendKeys("");
		produtoPage.inputNome.sendKeys("");
		produtoPage.inputQuantidade.sendKeys("");
		produtoPage.inputValor.sendKeys("");
		produtoPage.inputData.sendKeys("");
		
		produtoPage.escrever(produtoPage.inputCodigo, "");
		produtoPage.escrever(produtoPage.inputNome, "nome");
		produtoPage.escrever(produtoPage.inputQuantidade, "");
		produtoPage.escrever(produtoPage.inputValor, "");
		produtoPage.escrever(produtoPage.inputData, "");
		
		produtoPage.executarAcaoSalvar();
		
		String mensagem = produtoPage.obterMensagem();
		
		assertEquals(mensagem, "Todos os campos são obrigatórios para o cadastro!");
		
		produtoPage.executarAcaoClose();
		
	}
	@Test
	public void TC008_naoDeveCadastrarProdutosComCamposVaziosENomePreenchido() {
		
		produtoPage.executarAcaoCriar();
		
		produtoPage.inputCodigo.sendKeys("");
		produtoPage.inputNome.sendKeys("");
		produtoPage.inputQuantidade.sendKeys("");
		produtoPage.inputValor.sendKeys("");
		produtoPage.inputData.sendKeys("");
		
		produtoPage.escrever(produtoPage.inputCodigo, "teste");
		produtoPage.escrever(produtoPage.inputNome, "");
		produtoPage.escrever(produtoPage.inputQuantidade, "");
		produtoPage.escrever(produtoPage.inputValor, "");
		produtoPage.escrever(produtoPage.inputData, "");
		
		produtoPage.executarAcaoSalvar();
		
		String mensagem = produtoPage.obterMensagem();
		
		assertEquals(mensagem, "Todos os campos são obrigatórios para o cadastro!");
		
		produtoPage.executarAcaoClose();
		
	}
	@Test
	public void TC009_deveFecharAMensagemDeErroAoClicarNoX() {
		
		produtoPage.executarAcaoCriar();
		
//		produtoPage.inputCodigo.sendKeys("");
//		produtoPage.inputNome.sendKeys("");
//		produtoPage.inputQuantidade.sendKeys("");
//		produtoPage.inputValor.sendKeys("");
//		produtoPage.inputData.sendKeys("");
//		
//		produtoPage.escrever(produtoPage.inputCodigo, "");
//		produtoPage.escrever(produtoPage.inputNome, "");
//		produtoPage.escrever(produtoPage.inputQuantidade, "");
//		produtoPage.escrever(produtoPage.inputValor, "");
//		produtoPage.escrever(produtoPage.inputData, "");
		
		produtoPage.executarAcaoSalvar();
		
		produtoPage.executarAcaoCloseAlert();
		
	}

	
}