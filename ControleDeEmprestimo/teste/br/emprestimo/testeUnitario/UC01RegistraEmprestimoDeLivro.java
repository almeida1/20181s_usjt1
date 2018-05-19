package br.emprestimo.testeUnitario;
import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import br.emprestimo.modelo.Emprestimo;
import br.emprestimo.modelo.EmprestimoDAO;
import br.emprestimo.modelo.Livro;
import br.emprestimo.modelo.Usuario;
import br.emprestimo.servico.ConfiguraConexao;
import br.emprestimo.servico.FabricaDeConexoes;
import br.emprestimo.servico.ServicoEmprestimo;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class UC01RegistraEmprestimoDeLivro {
	static private Livro livro;
	static private Usuario usuario;
	static private ServicoEmprestimo servico;
	static private Emprestimo emprestimo;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//cenario
		livro = ObtemLivro.comDadosValidos();
		
		usuario = new Usuario();
		usuario.setRa("11111");
		usuario.setNome("Jose da Silva");
		servico = new ServicoEmprestimo();
		emprestimo = new Emprestimo();
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	@Test
	public void CT01UC01FB_registrar_emprestimo_com_sucesso() {
		assertNotNull(servico.empresta(livro, usuario));
	}
	@Test(expected=RuntimeException.class)
	public void CT02UC01FB_registrar_emprestimo_com_dados_invalidos() {
		servico.empresta(null, usuario);
	}
	@Test
	public void CT03UC01FB_registrar_emprestimo_com_dados_invalidos(){
		try{
			servico.empresta(null, usuario);
			fail ("deveria lançar uma exceção");
		}catch(RuntimeException e){
			assertEquals("Dados inválidos.", e.getMessage());
		}
	}
	@Test
	public void CT04UC01FB_registrar_emprestimo_com_sucesso_validacao_da_data() {
		//cenario
		DateTimeFormatter fmt = DateTimeFormat.forPattern("dd/MM/YYYY");
		String dataEsperada = new DateTime().plusDays(8).toString(fmt);
		//acao
		emprestimo = servico.empresta(livro, usuario);
		String dataObtida = emprestimo.getDataDevolucao();
		//verificacao
		assertTrue(dataEsperada.equals(dataObtida));
	}
	@Test
	public void CT05UC01FB_registrar_emprestimo_com_data_invalida() {
		assertTrue(emprestimo.validaData("29/03/2000"));
	}
	
	@Test
	public void CT06UC01FB_registrar_emprestimo_com_data_invalida() {
		Emprestimo emprestimo2 = new Emprestimo();
		try{
		emprestimo2.setDataEmprestimo("30/02/2000");
		fail ("deveria lançar uma exceção");
		} catch (Exception e){
			assertEquals("Data invalida", e.getMessage());
		}
	}
	@Test(expected = RuntimeException.class)
	public void CT07UC01RegistrarEmprestimo_com_data_invalida() {
		emprestimo.setDataEmprestimo("30/02/2000");
	}
	@Test
	public void CT08UC01RegistrarEmprestimo_obtem_data_corrente(){
		//cenario
		DateTimeFormatter fmt = DateTimeFormat.forPattern("dd/MM/YYYY");
		String dataAtual = new DateTime().toString(fmt);
		//acao
		String dataEmprestimo = emprestimo.setDataEmprestimo();
		assertTrue(dataAtual.equals(dataEmprestimo));
	}
	@Ignore
	@Test
	public void CT05_conecta_db_com_sucesso() {
		// cenario  - configuracao fateczl
		String url = "jdbc:mysql://localhost:3306/sceweb";
		String driver = "com.mysql.jdbc.Driver";
		String usuario = "root";
		String senha = "alunofatec";
		// acao
		ConfiguraConexao configuraDB = new ConfiguraConexao(url, driver, usuario, senha);
		FabricaDeConexoes fabricaDeConexoes = new FabricaDeConexoes(configuraDB);
		// verificacao
		assertNotNull(fabricaDeConexoes.getConnection());
	}

	@Test
	public void CT06QuandoInserirUmEmprestimoRetornaTrue(){
		//cenario
		Emprestimo umEmprestimo = new Emprestimo();
		Usuario umUsuario = ObtemUsuario.comDadosValidos();
		Livro umLivro = ObtemLivro.comDadosValidos();
		ServicoEmprestimo servico = new ServicoEmprestimo();
		umEmprestimo = servico.empresta(umLivro, umUsuario);
		EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
		//acao
		boolean resultadoEsperado=emprestimoDAO.adiciona(umEmprestimo);
		//verificacao
		assertTrue(resultadoEsperado);
		
	}
	@Test
	public void CT07ConsultaRegistroComSucesso(){
		//cenario
		Emprestimo umEmprestimo = new Emprestimo();
		Usuario umUsuario = ObtemUsuario.comDadosValidos();
		Livro umLivro = ObtemLivro.comDadosValidos();
		ServicoEmprestimo servico = new ServicoEmprestimo();
		umEmprestimo = servico.empresta(umLivro, umUsuario);
		EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
		emprestimoDAO.adiciona(umEmprestimo);
		//insere 2 registro
		umUsuario = ObtemUsuario.listaComDadosValidos().get(0);
		umEmprestimo = servico.empresta(umLivro, umUsuario);
		emprestimoDAO = new EmprestimoDAO();
		emprestimoDAO.adiciona(umEmprestimo);
		//insere 3 registro
		umUsuario = ObtemUsuario.listaComDadosValidos().get(1);
		umEmprestimo = servico.empresta(umLivro, umUsuario);
		emprestimoDAO = new EmprestimoDAO();
		emprestimoDAO.adiciona(umEmprestimo);
		//insere 4 registro
		umUsuario = ObtemUsuario.listaComDadosValidos().get(2);
		umEmprestimo = servico.empresta(umLivro, umUsuario);
		emprestimoDAO = new EmprestimoDAO();
		emprestimoDAO.adiciona(umEmprestimo);
        //acao
		Emprestimo resultadoObtido = emprestimoDAO.consulta(umEmprestimo);
        assertTrue(resultadoObtido.equals(umEmprestimo));		
		
	}
	
	
	
	
	
	
	
	
	
	
}
