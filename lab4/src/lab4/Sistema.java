package lab4;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe que armazena e organiza alunos e grupos de estudo, organiza os alunos que respondem questões.
 * 
 * @author Rafaela de Amorim - 117.210.299
 *
 */
public class Sistema {
	// **************** Atributos *********************
	private HashMap<String, Aluno> alunos;

	private HashMap<String, GrupoEstudo> grupos;

	private ArrayList<String> responderam;

	// **************** Construtor *********************

	/**
	 * O Construtor não recebe nenhum parâmetro e inicializa um conjunto que mapeia Alunos
	 * a suas respectivas matrículas e outro que mapeia Grupos de Estudos a seus
	 * respectivos nomes, também inicializa a lista que guardará as informações dos
	 * Alunos que responderem questões.
	 */
	public Sistema() {
		alunos = new HashMap<>();
		grupos = new HashMap<>();
		responderam = new ArrayList<>();
	}

	// **************** Métodos *********************

	/**
	 * Verifica se a matrícula já existe no Sistema, se não existir, o Aluno é
	 * cadastrado, caso contrário, é retornada uma String contendo uma mensagem de
	 * aviso.
	 * 
	 * @param matricula
	 *            Matrícula do ALuno
	 * @param nome
	 *            Nome do Aluno
	 * @param curso
	 *            Curso do Aluno
	 * @return Retorna uma mensagem que contém uma mensagem que diz se o aluno foi
	 *         cadastrado ou se ele já existe no sistema.
	 */
	public String cadastraAluno(String matricula, String nome, String curso) {
		if (!alunos.containsKey(matricula)) {
			Aluno auxAluno = new Aluno(matricula, nome, curso);
			alunos.put(matricula, auxAluno);
			return "CADASTRO REALIZADO!";
		}
		
		return "MATRÍCULA JÁ CADASTRADA!";
	}

	/**
	 * O método verifica se não existem nenhum grupo no Sistema com o mesmo nome, se
	 * não existir nenhum, o grupo é cadastrado. Caso contrário, é retornada uma
	 * mensagem de aviso.
	 * 
	 * @param nome
	 *            Nome do Grupo
	 * @return Retorna uma mensagem que diz se o grupo foi cadastrado ou se ele já
	 *         existe no sistema.
	 */
	public String cadastraGrupo(String nome) {
		if (!(grupos.containsKey(nome))) {
			GrupoEstudo auxGrupo = new GrupoEstudo(nome);
			grupos.put(nome.toLowerCase(), auxGrupo);
			return "CADASTRO REALIZADO!";
		} 
		
		return "GRUPO JÁ CADASTRADO!";
	}

	/**
	 * O método verifica se a matrícula do parâmetro existe no Sistema, se o Aluno
	 * for encontrado então é retornada uma String com suas informações, caso
	 * contrário é retornada uma mensagem de aviso.
	 * 
	 * @param matricula
	 *            Matrícula para busca
	 * @return String com as informações do Aluno, se for encontrado. Senão, retorna
	 *         String com aviso.
	 */
	public String buscaAluno(String matricula) {
		if (alunos.containsKey(matricula)) {
			return alunos.get(matricula).toString();
		}
		return "Aluno não cadastrado.";
	}

	/**
	 * O método verifica se existe um Aluno com a mesma matrícula e um grupo de
	 * estudos com o mesmo nome dos parâmetros. Se ambos forem encontrados, o aluno
	 * é alocado no grupo. Senão, é retornada uma mensagem de aviso.
	 * 
	 * @param matricula
	 *            Matrícula do Aluno a ser alocado.
	 * @param nomeGrupo
	 *            Nome do Grupo de Estudos para alocação.
	 * @return Retorna uma String de êxito do método, ou avisando que um dos
	 *         elementos não está presente no Sistema.
	 */
	public String alocaAlunoEmGrupo(String matricula, String nomeGrupo) {

		if (!(alunos.containsKey(matricula))) {
			return "ALUNO NÃO CADASTRADO.";
		} else if (!(grupos.containsKey(nomeGrupo.toLowerCase()))) {
			return "GRUPO NÃO CADASTRADO.";
		}
		
		GrupoEstudo auxGrupo = grupos.get(nomeGrupo.toLowerCase());
		Aluno auxAluno = alunos.get(matricula);

		auxGrupo.adicionaAluno(auxAluno);
		return "ALUNO ALOCADO!";
	}

	/**
	 * Se o nome do Grupo for encontrado no Sistema, o método retorna uma
	 * representação textual de todos os integrantes do grupo. Senão, retorna uma
	 * mensagem de aviso.
	 * 
	 * @param nomeGrupo
	 *            Nome do Grupo
	 * @return Retorna uma String com os dados dos integrantes do grupo, se este
	 *         existir, senão retorna uma String com uma mensagem de aviso.
	 */
	public String imprimeGrupo(String nomeGrupo) {
		if (!(grupos.containsKey(nomeGrupo.toLowerCase()))) {
			return "GRUPO NÃO CADASTRADO.";
		}
		
		GrupoEstudo auxGrupo = grupos.get(nomeGrupo.toLowerCase());
		String integrantesGrupo = "Alunos do Grupo " + nomeGrupo + ":\n";

		return integrantesGrupo + auxGrupo.listaAlunos();
	}

	/**
	 * Se a matrícula passada existe no Sistema, o aluno é registrado na lista dos
	 * Alunos que já responderam questões, senão, é retornada uma mensagem avisando
	 * que a matrícula não está no sistema.
	 * 
	 * @param mat
	 *            Matrícula do Aluno
	 * @return Retorna uma String de êxito se o a matrícula existe no sistema, senão
	 *         retorna uma mensagem de aviso.
	 */
	public String respondeQuestao(String mat) {
		if (alunos.containsKey(mat)) {
			responderam.add(alunos.get(mat).toString());
			return "ALUNO REGISTRADO!";
		}
		
		return "ALUNO NÃO CADASTRADO.";
	}

	/**
	 * Retorna uma String em forma de lista com uma representação textual dos alunos
	 * que já responderam questões.
	 * 
	 * @return String com lista dos alunos que já responderam.
	 */
	public String listaQuemRespondeu() {
		String lista = "Alunos:" + System.lineSeparator();
		int contador = 1;

		for (String aluno : responderam) {
			lista += contador + ". " + aluno + System.lineSeparator();
			contador++;
		}

		return lista.trim();
	}

}