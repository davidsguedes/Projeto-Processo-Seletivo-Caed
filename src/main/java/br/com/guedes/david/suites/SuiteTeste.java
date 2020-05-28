package br.com.guedes.david.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.guedes.david.test.EditaisAbertosTest;
import br.com.guedes.david.test.EditaisEncerradosTest;
import br.com.guedes.david.test.FormularioTest;
import br.com.guedes.david.test.ResultadosPublicadosTest;

@RunWith(Suite.class)
@SuiteClasses({ 
	EditaisAbertosTest.class,
	ResultadosPublicadosTest.class,
	EditaisEncerradosTest.class,
	FormularioTest.class

})

public class SuiteTeste {
}
