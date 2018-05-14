package br.emprestimo.modelo;

public class Usuario {
	private String ra;
	private String nome;

	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		if (ra == "" | ra == null){
			throw new RuntimeException("RA invalido");
		}
		this.ra = ra;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome == "" | nome == null){
			throw new RuntimeException("Nome invalido");
		}
		this.nome = nome;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (ra == null) {
			if (other.ra != null)
				return false;
		} else if (!ra.equals(other.ra))
			return false;
		return true;
	}
	
}
