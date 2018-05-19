package br.emprestimo.servico;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import br.emprestimo.modelo.Emprestimo;
import br.emprestimo.modelo.Livro;
import br.emprestimo.modelo.Usuario;

public class ServicoEmprestimo {

	public Emprestimo empresta(Livro livro, Usuario usuario) {
		if (livro == null | usuario == null) {
			throw new RuntimeException("Dados inválidos.");
		} else {
			Emprestimo emprestimo = new Emprestimo();
			emprestimo.setEmprestimoNumero();
			emprestimo.setUsuario(usuario);
			emprestimo.setLivro(livro);
			// data do emprestimo - data atual do sistema
			DateTime dataAtual = new DateTime();
			//DateTimeFormatter fmt = DateTimeFormat.forPattern("dd/MM/YYYY");
			DateTimeFormatter fmt = DateTimeFormat.forPattern("YYYY/MM/dd");
			emprestimo.setDataEmprestimo(dataAtual.toString(fmt));
			// prazo de devolucao 8 dias
			DateTime dataDevolucao = fmt.parseDateTime(emprestimo.getDataEmprestimo());
			emprestimo.setDataDevolucao(dataDevolucao.plusDays(8).toString(fmt));
			return emprestimo;
		}
	}

}


