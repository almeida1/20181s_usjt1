package br.emprestimo.testeUnitario;

import org.joda.time.DateTime;

public class Principal {

	public static void main(String[] args) {
		DateTime dateTime = new DateTime();
		// Imprimindo a data no formato YYYY-MM-dd
		System.out.println("dateTime.toString() = " + dateTime.toString("YYYY-MM-dd"));
		System.out.println(dateTime.dayOfWeek().getAsText());


	}

}
