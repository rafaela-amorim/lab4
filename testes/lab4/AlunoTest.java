package lab4;

/**
 * Teste da classe Aluno
 * 
 * @author Rafaela de Amorim - 117.210.299
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AlunoTest {
	
	Aluno alumn;
	
	@Before
	public void inicializaAluno() {
		alumn = new Aluno("42", "Rafaela", "Computação");
	}

	@Test
	public void testToString() {
		assertEquals("42 - Rafaela - Computação", alumn.toString());
	}
	
	@Test (expected=NullPointerException.class)
	public void nomeNull() {
		Aluno nulo = new Aluno("20", null, "oi");
	}
	
	@Test (expected=NullPointerException.class)
	public void matriculaNull() {
		Aluno nulo = new Aluno(null, "pessoa", "oi");
	}
	
	@Test (expected=NullPointerException.class)
	public void cursoNull() {
		Aluno nulo = new Aluno("20", "pessoa", null);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void nomeInvalido() {
		Aluno nulo = new Aluno("20", "", "oi");
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void matInvalida() {
		Aluno nulo = new Aluno("         ", "j", "qwertyuiop");
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void Invalidx() {
		Aluno nulo = new Aluno("", "bcvcv", "    ");
	}
	
	@Test
	public void equalsTest() {
		Aluno fumiga = new Aluno("42", "viada", "procrastinação");
		assertEquals(true, alumn.equals(fumiga));
		
		Aluno otaFumiga = new Aluno("24", "viada", "procrastinação");
		assertEquals(false, fumiga.equals(otaFumiga));
	}
	
	// eu n sei nem como o hashcode funciona licença
}
