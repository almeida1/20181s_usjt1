package br.emprestimo.testeUnitario;

import br.emprestimo.modelo.Usuario;

public class ObtemUsuario {
	public static Usuario comDadosValidos() {
		Usuario usuario = new Usuario();
		usuario.setRa("121212");
		usuario.setNome("Carlos Xavier");
		
		return usuario;
	}
}
