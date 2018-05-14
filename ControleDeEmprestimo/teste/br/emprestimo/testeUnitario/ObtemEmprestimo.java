package br.emprestimo.testeUnitario;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import br.emprestimo.modelo.Emprestimo;
import br.emprestimo.modelo.Livro;

public class ObtemEmprestimo {
	
	public static Emprestimo comDadosValidos() {
		Emprestimo emprestimo = new Emprestimo();
		emprestimo.setLivro(ObtemLivro.comDadosValidos());
		emprestimo.setUsuario(ObtemUsuario.comDadosValidos());
		emprestimo.setDataEmprestimo(comDataValida());
		//emprestimo.setDataEmprestimo("28/04/2018");
		emprestimo.setDataDevolucao(comDataDevolucaoValida());
		return emprestimo;
	}
	public static String comDataValida() {
		DateTime dataAtual = new DateTime();
		DateTimeFormatter fmt = DateTimeFormat.forPattern("dd/MM/YYYY");
		return dataAtual.toString(fmt);
	}
	public static String comDataDevolucaoValida() {
		DateTimeFormatter fmt = DateTimeFormat.forPattern("dd/MM/YYYY");
		DateTime dataDevolucao = fmt.parseDateTime(comDataValida());
		return dataDevolucao.plusDays(8).toString(fmt);
	}

}
