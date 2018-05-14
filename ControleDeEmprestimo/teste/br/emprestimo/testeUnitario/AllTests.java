package br.emprestimo.testeUnitario;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ UC01RegistraEmprestimoDeLivro.class, UC06CadastrarLivro.class })
public class AllTests {

}
