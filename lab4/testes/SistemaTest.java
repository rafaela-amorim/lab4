package lab4;

/**
 * Teste da classe Sistema
 * 
 * @author Rafaela de Amorim - 117.210.299
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SistemaTest {
	
	Sistema sis;
	
	@Before
	public void inicializaSistema() {
		sis = new Sistema();
	}

	@Test
	public void testCadastraAluno() {
		assertEquals("CADASTRO REALIZADO!", sis.cadastraAluno("123", "Rafa", "Computação"));
		assertEquals("CADASTRO REALIZADO!", sis.cadastraAluno("894", "Lisa Oppa", "lindezura"));
		assertEquals("MATRÍCULA JÁ CADASTRADA!", sis.cadastraAluno("123", "não deve ser cadastrado", "tbm nao"));
	}

	@Test
	public void testCadastraGrupo() {
		assertEquals("CADASTRO REALIZADO!", sis.cadastraGrupo("girl crush é legal"));
		assertEquals("CADASTRO REALIZADO!", sis.cadastraGrupo("BlackPink"));
		assertEquals("GRUPO JÁ CADASTRADO!", sis.cadastraGrupo("blackpink"));
	}

	@Test
	public void testBuscaAluno() {
		sis.cadastraAluno("95", "Jimin", "lindoso");
		assertEquals("95 - Jimin - lindoso", sis.buscaAluno("95"));
		
		assertEquals("Aluno não cadastrado.", sis.buscaAluno("matrícula inexistente, tipo minha vida social"));
	}

	@Test
	public void testAlocaAlunoEmGrupo() {
		sis.cadastraGrupo("You in Me - Kard");
		sis.cadastraAluno("75", "Somin", "nha");
		assertEquals("ALUNO ALOCADO!", sis.alocaAlunoEmGrupo("75", "You in Me - Kard"));
		
		assertEquals("ALUNO NÃO CADASTRADO.", sis.alocaAlunoEmGrupo("24", "You in Me - Kard"));
		assertEquals("GRUPO NÃO CADASTRADO.", sis.alocaAlunoEmGrupo("75", "Lo Siento"));
		assertEquals("ALUNO NÃO CADASTRADO.", sis.alocaAlunoEmGrupo("24", "Lo Siento"));
		
		// aloca o mesmo aluno 2 vezes
		assertEquals("ALUNO ALOCADO!", sis.alocaAlunoEmGrupo("75", "You in Me - Kard"));
	}

	@Test
	public void testImprimeGrupo() {
		sis.cadastraGrupo("demonho");
		sis.cadastraAluno("96", "queria comida", "mas cabou a gasolina p/ ir na cozinha");
		sis.cadastraAluno("6666", "tem uns esprito", "no meu quarto");
		
		sis.alocaAlunoEmGrupo("96", "demonho");
		sis.alocaAlunoEmGrupo("6666", "demonho");
		
		assertEquals("Alunos do Grupo demonho:\n" + 
					 "* 6666 - tem uns esprito - no meu quarto\n" + 
					 "* 96 - queria comida - mas cabou a gasolina p/ ir na cozinha", 
					 sis.imprimeGrupo("demonho"));
		
		assertEquals("GRUPO NÃO CADASTRADO.", sis.imprimeGrupo("todo mundo sabe que programador bom usa tema escuro, mas meu eclipse ta claro ;-;"));
		
	}

	@Test
	public void testRespondeQuestao() {
		sis.cadastraAluno("12", "eu", "tenho q começar a reaproveitar testes anteriores");
		assertEquals("ALUNO REGISTRADO!", sis.respondeQuestao("12"));
		
		assertEquals("ALUNO NÃO CADASTRADO.", sis.respondeQuestao("taehyung"));
	}

	@Test
	public void testListaQuemRespondeu() {
		sis.cadastraAluno("12", "eu", "tenho q começar a reaproveitar testes anteriores");
		sis.cadastraAluno("75", "Somin", "nha");
		sis.cadastraAluno("89", "Lisa Oppa", "lindezura");
		
		sis.respondeQuestao("12");
		sis.respondeQuestao("75");
		sis.respondeQuestao("89");
		sis.respondeQuestao("75");
		sis.respondeQuestao("89");
		
		assertEquals("Alunos:\n" + 
					 "1. 12 - eu - tenho q começar a reaproveitar testes anteriores\n" + 
					 "2. 75 - Somin - nha\n" + 
					 "3. 89 - Lisa Oppa - lindezura\n" + 
					 "4. 75 - Somin - nha\n" + 
					 "5. 89 - Lisa Oppa - lindezura", sis.listaQuemRespondeu());
	}

}
