package br.emprestimo.testeUnitario;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.emprestimo.modelo.Livro;
public class UC06CadastrarLivro {
	
	
	@Test
	public void CT01ObtemLivroComDadosValidos(){
		try{
			//cenario
			Livro umLivro;
			//acao
			umLivro = ObtemLivro.comDadosValidos();
		}catch(RuntimeException e){
			//verificacao
			fail ("nao deve falhar");;
		}
	}
	@Test
	public void CT02verificaOestadoDoObjeto() {
		//cenario
		Livro resultadoEsperado = new Livro();
		resultadoEsperado.setIsbn("121212");
		resultadoEsperado.setTitulo("Engenharia de Software");
		resultadoEsperado.setAutor("Pressman");
		//acao
		Livro resultadoObtido = ObtemLivro.comDadosValidos();
		//verificacao
		assertTrue(resultadoEsperado.equals(resultadoObtido));
	}
	@Test
	public void CT03cadastrarLivroComISBN_em_branco(){
		//cenario
		String isbn="";
		Livro livro = new Livro();
		try{
		//acao
			livro.setIsbn(isbn);
			fail ("deveria lançar uma exceção");
		}catch(RuntimeException e){
		//verificacao
			assertEquals("ISBN invalido", e.getMessage());
		}
	}
	@Test
	public void CT04cadastrarLivroComISBN_em_nulo(){
		//cenario
		String isbn=null;
		Livro livro = new Livro();
		try{
			//acao
			livro.setIsbn(isbn);
			fail ("deveria lançar uma exceção");
		}catch(RuntimeException e){
			//verificacao
			assertEquals("ISBN invalido", e.getMessage());
		}
	}
	
}





