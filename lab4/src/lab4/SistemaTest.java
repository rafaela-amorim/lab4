package lab4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SistemaTest {
	
	Sistema sis;

	
	@Test
	public void testImprimeGrupo() {
		sis = new Sistema();
		
		sis.cadastraGrupo("oi", "tema");
		System.out.println(sis.cadastraGrupo("oi", "tema"));
		
		System.out.println(sis.cadastraAluno("123", "rafa", "comp"));
		sis.cadastraAluno("456", "ela", "comp");
		sis.cadastraAluno("789", "eu", "comp");
		sis.cadastraAluno("24", "nosotros", "comp");

		
		
		sis.alocaAlunoEmGrupo("123", "oi");
		sis.alocaAlunoEmGrupo("456", "oi");
		sis.alocaAlunoEmGrupo("789", "oi");
		sis.alocaAlunoEmGrupo("24", "oi");
		
		System.out.println(sis.imprimeGrupo("oi"));
	}

}
