package lab4;

/**
 * Teste da classe GrupoEstudo
 * 
 * @author Rafaela de Amorim - 117.210.299
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GrupoEstudoTest {
	
	GrupoEstudo grupo;
	
	@Before
	public void testGrupoEstudo() {
		grupo = new GrupoEstudo("BlackPink in your area");
	}

	@Test
	public void testListaAlunos() {
		Aluno pasta = new Aluno("97", "Rosé", "modelpink");
		Aluno jendeuk = new Aluno("96", "Nini", "modelpink");
		Aluno oppa = new Aluno("98", "lalisa", "modelpink");
		Aluno chichu = new Aluno("95", "I'm JISOO", "modelpink");
		
		grupo.adicionaAluno(pasta);
		grupo.adicionaAluno(jendeuk);
		grupo.adicionaAluno(oppa);
		grupo.adicionaAluno(chichu);
		
		assertEquals("* 95 - I'm JISOO - modelpink\n" + 
					 "* 96 - Nini - modelpink\n" + 
					 "* 97 - Rosé - modelpink\n" + 
					 "* 98 - lalisa - modelpink", grupo.listaAlunos());
	}

	@Test
	public void testEqualsObject() {
		GrupoEstudo oto = new GrupoEstudo("BlackPink in your area");
		GrupoEstudo maisUm = new GrupoEstudo("blackpink IN YOUR AREA");
		GrupoEstudo nope = new GrupoEstudo("4minute acabou");
		
		assertEquals(true, oto.equals(grupo));
		assertEquals(true, grupo.equals(maisUm));
		assertEquals(false, grupo.equals(nope));
		
	}

}
