package br.emprestimo.testeUnitario;

import java.util.ArrayList;
import java.util.List;

import br.emprestimo.modelo.Usuario;

public class ObtemUsuario {
	public static Usuario comDadosValidos() {
		Usuario usuario = new Usuario();
		usuario.setRa("121212");
		usuario.setNome("Carlos Xavier");
		
		return usuario;
	}
	public static List<Usuario> listaComDadosValidos(){
		List<Usuario> lista = new ArrayList<Usuario>();
		Usuario usuario = new Usuario();
		usuario.setRa("222222");
		usuario.setNome("Jose da Silva");
		lista.add(usuario);
		usuario = new Usuario();
		usuario.setRa("333333");
		usuario.setNome("Maria da Silva");
		lista.add(usuario);
		usuario = new Usuario();
		usuario.setRa("444444");
		usuario.setNome("Carlos Miranda");
		lista.add(usuario);
		return lista;
	}
}
